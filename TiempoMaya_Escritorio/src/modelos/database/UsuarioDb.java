/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import modelos.objetos.Usuario;

/**
 *
 * @author jose_
 */
public class UsuarioDb {

    public static String VALIDACION_LOGEO = "SELECT * FROM Usuario WHERE email = ? AND password = ?";

    private Mensaje mensajes = new Mensaje();

    public void crearUsuario(Usuario usuarioACrear) {//creamos un nuevo usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO Usuario "
                    + "(username,password,email,nombre,apellido,nacimiento,telefono,rol) "
                    + "VALUES (?,?,?,?,?,?,?,?);");
            statement.setString(1, usuarioACrear.getUsername());
            statement.setString(2, usuarioACrear.getPassword());
            statement.setString(3, usuarioACrear.getEmail());
            statement.setString(4, usuarioACrear.getNombre());
            statement.setString(5, usuarioACrear.getApellido());
            statement.setDate(6, usuarioACrear.getNacimiento());
            statement.setString(7, usuarioACrear.getTelefono());
            statement.setInt(8, usuarioACrear.getRolId());
            statement.executeUpdate();
            mensajes.informacion("Se ha creado el usuario con exito.");
        } catch (SQLException ex) {
            mensajes.error("Ingrese otro usuario, asegurese que el nombre de usuario '" + usuarioACrear.getUsername() + "' no se repita");
        }
    }

    public void actualizarUsuario(Usuario usuarioActualizar, String userNameAntiguo) {//actualizamos usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Usuario SET "
                    + "userName=? , password =? , email=?,  "
                    + "nombre=? ,  apellido=? , nacimiento= ? , "
                    + "telefono = ? , rol=?  "
                    + "WHERE username=?;");
            statement.setString(1, usuarioActualizar.getUsername());
            statement.setString(2, usuarioActualizar.getPassword());
            statement.setString(3, usuarioActualizar.getEmail());
            statement.setString(4, usuarioActualizar.getNombre());
            statement.setString(5, usuarioActualizar.getApellido());
            statement.setDate(6, usuarioActualizar.getNacimiento());
            statement.setString(7, usuarioActualizar.getTelefono());
            statement.setInt(8, usuarioActualizar.getRolId());

            statement.setString(9, userNameAntiguo);
            statement.executeUpdate();
            mensajes.informacion("Se ha modificado el usuario con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se actualizo el usuario. Asegurese que el usuario '" + userNameAntiguo + "' exista");
        }

    }

    public Image actualizarImagen(FileInputStream foto, Usuario usuario) {//actualizamos usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Usuario SET "
                    + "imagen=?  "
                    + "WHERE username=?;");
            statement.setBlob(1, foto);
            statement.setString(2, usuario.getUsername());
            statement.executeUpdate();
            mensajes.informacion("Se ha modificado la imagen con exito.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mensajes.error("No se actualizo la imagen. Asegurese que el usuario '" + usuario.getUsername() + "' exista");
        }
        return leerUsuario(usuario).getImagen();
    }

    public void eliminarUsuario(Usuario usuarioAEliminar) {//eliminamos usuario
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM Usuario WHERE username=?;");
            statement.setString(1, usuarioAEliminar.getUsername());
            statement.executeUpdate();
            mensajes.informacion("Se ha eliminado el usuario con exito.");
        } catch (SQLException ex) {
            mensajes.error("No se elimino el usuario " + usuarioAEliminar.getUsername() + " . Asegurese que el usuario exista");
        }
    }

    public LinkedList<Usuario> leerUsuarios() { //mostramos todos los usuarios y devolvemos en una lista
        LinkedList<Usuario> listaUsuarios = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM usuario;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Usuario usuario = convertirAUsuario(resultado, obtenerRol(resultado.getInt(8)));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron los usuarios de la DB");
        }
        return listaUsuarios;
    }

    public Usuario leerUsuario(Usuario usuarioABuscar) {//leemos un usuario en especifico y lo devolvemos
        Usuario usuario = null;
        System.out.println( usuarioABuscar.getUsername());
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Usuario WHERE username= ? ;");
            statement.setString(1, usuarioABuscar.getUsername());
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                usuario = convertirAUsuario(resultado, obtenerRol(resultado.getInt(8)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro el usuario");
        }
        return usuario;
    }

    public Usuario convertirAUsuario(ResultSet resultado, String rol) throws SQLException {//del resultado de la busqueda obtener el usuario

        Usuario usuarioDevolver = null;
        try {
            Blob blob = resultado.getBlob(9);
            byte[] data = null;
            BufferedImage img = null;
            try {
                if (blob != null) {
                    data = blob.getBytes(1, (int) blob.length());
                    img = ImageIO.read(new ByteArrayInputStream(data));
                }
            } catch (IOException ex) {
                System.out.println("error obteniendo imagen");
            }
            usuarioDevolver = new Usuario(resultado.getString(1), resultado.getString(2), resultado.getString(3),
                    resultado.getString(4), resultado.getString(5), resultado.getString(7),
                    resultado.getDate(6), resultado.getInt(8), rol, img);
        } catch (SQLException ex) {
            System.out.println("error en conversion de usuario");
        }

        return usuarioDevolver;
    }

    //Verificacion durante logeo de un usuario
    public Usuario validacionUsuario(String correo, String password) {
        Usuario aDevolver = null;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement(VALIDACION_LOGEO);
            statement.setString(1, correo);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                    aDevolver = convertirAUsuario(result, obtenerRol(result.getInt(8)));
                if (result.next()) {
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aDevolver;
    }

    public String obtenerRol(int rol) throws SQLException {
        String miRol = "";
        PreparedStatement statement2 = ConexionDb.conexion.prepareStatement("SELECT tipo FROM Rol Where idRol = ?");
        try {
            statement2.setInt(1, rol);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet result2 = statement2.executeQuery();
        while (result2.next()) {
            miRol = result2.getString("tipo");
        }
        return miRol;
    }
}

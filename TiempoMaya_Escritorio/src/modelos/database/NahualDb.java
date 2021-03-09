/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelos.objetos.Nahual;

/**
 *
 * @author jose_
 */
public class NahualDb {

    public void crear(Nahual nahual) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO nahual "
                    + "(nombre,idImagen,signficado,descripcion,fechaInicio,fechaFinalizacion,nombreYucateco,nombreSp) VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, nahual.getNombre());
            statement.setString(3, nahual.getSignificado());
            statement.setString(4, nahual.getDescripcion());
            statement.setDate(5, nahual.getFechaInicio());
            statement.setDate(6, nahual.getFechaFinalizacion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*    public void modificar(Nahual nahual){
        FileInputStream fis ;
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE nahual SET "
                    + "nombre=?, significado=?, descripcion=?,"
                    + "imagen=?, animal=? WHERE id=?;");
            statement.setString(1, nahual.getNombre());
            statement.setString(3, nahual.getSignificado());
            statement.setString(4, nahual.getDescripcion());
            statement.setBlob(2, fis);
            statement.setString(9, nahual.getAnimal());
        } catch (SQLException ex) {
            ex.printStackTrace();
        
    }*/
    public void eliminar(Nahual nahual) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM nahual WHERE id=?;");
            statement.setInt(1, nahual.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Nahual> getNahuales() {
        List<Nahual> nahuales = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Nahual ORDER BY orden ASC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                nahuales.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nahuales;
    }

    public Nahual getNahual(int id) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Nahual WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return instanciarDeResultSet(resultado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Nahual instanciarDeResultSet(ResultSet resultado) throws SQLException {
        ImagenDb accesoImagen = new ImagenDb();
        Blob blob = resultado.getBlob("imagen");
        byte[] data = blob.getBytes(1, (int) blob.length());
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException ex) {
            System.out.println("error obteniendo imagen");
        }
        return new Nahual(
                resultado.getInt("orden"),
                resultado.getString("nombre"),
                resultado.getString("significado"),
                resultado.getString("descripcion"),
                img,
                 resultado.getString("animal")
        );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import modelos.objetos.FechaCholqij;

/**
 *
 * @author jose_
 */
public class CholqijDb {

    public CholqijDb() {
    }
    
    

    public void crear(FechaCholqij fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO calendariocholqij "
                    + "(nahual,energia,fecha,descripcion) VALUES (?,?,?,?);");
            statement.setInt(1,fecha.getNahual().getId());
            statement.setInt(2, fecha.getEnergia().getId());
            //statement.setDate(3, fecha.getFecha());
            statement.setString(4, fecha.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
       public List<InfoCalendario> EscribirInfoCholquij() {
        List<InfoCalendario> infoCholquij = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("CALL mostrarCalendarioCholquij;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                infoCholquij.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return infoCholquij;
    }
    
    private InfoCalendario instanciarDeResultSet(ResultSet resultado) throws SQLException {
        Blob blob = resultado.getBlob("imagen");
        byte[] data = null;
        BufferedImage img = null;
        try {
            if(blob!=null){
                data = blob.getBytes(1, (int) blob.length());
                img = ImageIO.read(new ByteArrayInputStream(data));
            }
        } catch (IOException ex) {
            System.out.println("error obteniendo imagen");
        }
        InfoCalendario info = new InfoCalendario(resultado.getString("titulo"), resultado.getString("descripcion"), img, data);
        return info;
    }
}

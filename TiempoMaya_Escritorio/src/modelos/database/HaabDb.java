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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import modelos.objetos.FechaCholqij;
import modelos.objetos.FechaHaab;
import modelos.objetos.Informacion;

/**
 *
 * @author jose_
 */
public class HaabDb {

    public List<InfoCalendario> EscribirInfoHaab() {
        List<InfoCalendario> infoHaab = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("CALL mostrarCalendarioHaab;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                infoHaab.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return infoHaab;
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

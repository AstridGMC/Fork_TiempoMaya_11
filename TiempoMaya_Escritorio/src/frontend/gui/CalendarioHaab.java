/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDate;
import java.time.Month;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelos.database.HaabDb;
import modelos.database.InfoCalendario;
import modelos.database.Utilidades;
import modelos.objetos.FechaHaab;

/**
 *
 * @author jose_
 */
public class CalendarioHaab extends javax.swing.JFrame {

    private Date fechac = Utilidades.LocalDateToDate(LocalDate.now());
    HaabDb acceso = new HaabDb();
    Calendar fecha = new GregorianCalendar();
    private String fechaStr;

    /**
     * Creates new form CalendarioHaab
     */
    public CalendarioHaab() {
        initComponents();

        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fecha.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(fecha.get(Calendar.YEAR));
        fechaStr = annio + "-" + mes + "-" + dia;
        date.setDate(fechac);
        escribirFecha();
        panelInfo.setText(Info());
        this.setLocationRelativeTo(null);
    }

    public void escribirFecha() {
        System.out.println(fechaStr);
        FechaHaab fechaHaab = new FechaHaab();
        lblFecha.setText(fechaHaab.obtenerFecha(fechaStr));
    }

    public void fechaSiguiente() {
        LocalDate temp = Utilidades.DateToLocalDate(fechac);
        temp = temp.plusDays(2);
        System.out.println("antes: " + fecha.toString());
        fechac = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        date.setDate(fechac);
        escribirFecha();
    }

    public void fechaAnterior() {
        LocalDate temp = Utilidades.DateToLocalDate(fechac);
        temp = temp.minusDays(0);
        System.out.println("antes: " + fecha.toString());
        fechac = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        date.setDate(fechac);
        escribirFecha();
    }

    public void mesSiguiente() {
        LocalDate temp = Utilidades.DateToLocalDate(fechac);
        if (temp.getDayOfYear() > 360) {
            temp = LocalDate.of(temp.getYear() + 1, Month.JANUARY, temp.getDayOfYear() - 360);
        } else if (temp.getDayOfYear() > 345) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 31);
        } else {
            temp = temp.plusDays(21);
        }
        System.out.println("antes: " + fecha.toString());
        fechac = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        date.setDate(fechac);
        escribirFecha();
    }

    public void mesAnterior() {
        LocalDate temp = Utilidades.DateToLocalDate(fechac);
        if (temp.getDayOfYear() <= 5) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 26 + temp.getDayOfYear());
        } else if (temp.getDayOfYear() <= 20) {
            temp = LocalDate.of(temp.getYear(), Month.DECEMBER, 31);
        } else {
            temp = temp.minusDays(19);
        }
        System.out.println("antes: " + fecha.toString());
        fechac = Utilidades.LocalDateToDate(temp);
        System.out.println("despues: " + fecha.toString());
        date.setDate(fechac);
        escribirFecha();
    }

    public String Info() {
        String info = "";
        int con = 0;
        HaabDb haab = new HaabDb();
        List<InfoCalendario> calendario = haab.EscribirInfoHaab();
        for (int i = 0; i < calendario.size(); i++) {
            if (!calendario.get(i).getTitulo().equals("segundaParte Informacion")) {
                info = info + "<h3 class=\"section-title\" style=\"  color: #2dc997;\"> " + calendario.get(i).getTitulo() + " </h3>";
            }
            info = info + "<div class=\"row about-container\">\n"
                    + "            <div class=\"col-lg-6 content order-lg-1 order-2\">\n"
                    + calendario.get(i).getTexto()
                    + "</div>\n";
            if (calendario.get(i).getImgData() != null) {
                String img2 = "data:image/png;base64," + Base64.getEncoder().encodeToString(calendario.get(i).getImgData());

                info = info
                        + "            <div class=\"col-lg-6 background order-lg-2 order-1 wow fadeInRight\">\n"
                        + "              <br>\n"
                        + "              <img src = \"" + img2 + "\" alt='img' width=\"80%\" alt=\"Imagen del calendario habb\" style=\"margin-left: 150px;\">\n"
                        + "            </div>\n";
            }
            info = info + "</div>";
            if (con == 0) {
                con = 1;
                imagenHaab.setIcon(getIconCalendario(calendario.get(i), imagenHaab));
            }
            if (i == 1) {
                imagenHaab.setIcon(getIconCalendario(calendario.get(i), imagenHaab));
            }
        }
        return info;
    }

    private Icon getIconCalendario(InfoCalendario calendario, JLabel label) {
        ImageIcon imIcon = new ImageIcon(calendario.getImagen());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelInfo = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();
        buscarFecha = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imagenHaab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        panelInfo.setContentType("text/html"); // NOI18N
        panelInfo.setToolTipText("");
        panelInfo.setFocusable(false);
        jScrollPane1.setViewportView(panelInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("ConvertirFecha"));

        buscarFecha.setText("Buscar");
        buscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFechaActionPerformed(evt);
            }
        });

        jLabel2.setText("La fecha Es:");

        lblFecha.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(buscarFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarFecha)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("URW Palladio L", 1, 48)); // NOI18N
        jLabel1.setText("Calendario Haab");

        imagenHaab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(imagenHaab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imagenHaab, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Cargador2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFechaActionPerformed
        fechac = date.getDate();
        Calendar cal = date.getCalendar();
        fechaStr = Integer.toString(cal.get(Calendar.YEAR)) + "-" + Integer.toString(cal.get(Calendar.MONTH) + 1) + "-"
                + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        //System.out.println(fechaStr);
        escribirFecha();
    }//GEN-LAST:event_buscarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarFecha;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel imagenHaab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JEditorPane panelInfo;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/images/Fondo Calendario Haab.png")).getImage();
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelos.database.HechoHistoricoDb;
import modelos.objetos.HechoHistorico;
import modelos.objetos.Usuario;

/**
 *
 * @author sergio
 */
public class LineaDeTiempo extends javax.swing.JFrame {

    private ArrayList<EventoDeTiempo> eventos;
    private Usuario usuario;
    public final static ImageIcon BG = new ImageIcon("Imagenes/fondoLineaTiempo.jpg");
    private int index = 0;

    /**
     * Creates new form LineaDeTiempo
     */
    public LineaDeTiempo(Usuario usuario) {
        initComponents();
        HechoHistoricoDb hechoHistoricoDb = new HechoHistoricoDb();
        obtenerHechos();
        setLocationRelativeTo(null);
        this.usuario = usuario;
        this.eventos = eventos;
        verificarUsuario();
        addPrimerHecho();
        setBackground();

    }

    public void obtenerHechos() {
        HechoHistoricoDb hechoHistoricoDb = new HechoHistoricoDb();
        LinkedList<HechoHistorico> hechoHistoricos = hechoHistoricoDb.leerHechosHistoricos();
        eventos = new ArrayList<>();

        for (int i = 0; i < hechoHistoricos.size(); i++) {

            eventos.add(new EventoDeTiempo(hechoHistoricos.get(i)));

        }
    }

    private void setBackground() {

        JLabel backgroundLbl = new JLabel();
        backgroundLbl.setSize(1001, 411);
        backgroundLbl.setLocation(0, 0);
        backgroundLbl.setIcon(BG);
        this.add(backgroundLbl);
        backgroundLbl.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        navMenu4 = new javax.swing.JPanel();
        agregarEvento = new javax.swing.JButton();
        btnCholqij4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Linea De Tiempo");

        jPanel1.setPreferredSize(new java.awt.Dimension(735, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        navMenu4.setBackground(new java.awt.Color(75, 229, 197));

        agregarEvento.setBackground(new java.awt.Color(124, 243, 219));
        agregarEvento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        agregarEvento.setForeground(new java.awt.Color(0, 0, 0));
        agregarEvento.setText("Agregar Evento");
        agregarEvento.setBorderPainted(false);
        agregarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEventoActionPerformed(evt);
            }
        });

        btnCholqij4.setBackground(new java.awt.Color(124, 243, 219));
        btnCholqij4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCholqij4.setForeground(new java.awt.Color(0, 0, 0));
        btnCholqij4.setText("Eliminar Evento");
        btnCholqij4.setBorderPainted(false);
        btnCholqij4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCholqij4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navMenu4Layout = new javax.swing.GroupLayout(navMenu4);
        navMenu4.setLayout(navMenu4Layout);
        navMenu4Layout.setHorizontalGroup(
            navMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navMenu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarEvento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCholqij4)
                .addContainerGap(582, Short.MAX_VALUE))
        );
        navMenu4Layout.setVerticalGroup(
            navMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCholqij4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(agregarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setOpaque(false);

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jButton1.setText("<");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        index++;
        jPanel1.removeAll();
        jPanel1.add(eventos.get(index));
        eventos.get(index).setVisible(true);
        jPanel1.validate();
        jPanel1.repaint();
        if (index == eventos.size() - 1) {
            btnSiguiente.setEnabled(false);

        } else {
            btnSiguiente.setEnabled(true);
        }
        jButton1.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        index--;
        jPanel1.removeAll();
        jPanel1.add(eventos.get(index),jPanel1.getHeight(),jPanel1.getWidth());
        eventos.get(index).setVisible(true);
        jPanel1.validate();
        jPanel1.repaint();
        if (index == 0) {
            jButton1.setEnabled(false);

        } else {
            jButton1.setEnabled(true);
        }
        btnSiguiente.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEventoActionPerformed
        AgregarEvento ae= new AgregarEvento();
        ae.setLinea(this);
        ae.setVisible(true);
    }//GEN-LAST:event_agregarEventoActionPerformed

    private void btnCholqij4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCholqij4ActionPerformed

    }//GEN-LAST:event_btnCholqij4ActionPerformed
    private void addPrimerHecho() {
        System.out.println(eventos.size());
        if (eventos.size() > 0) {
            jPanel1.add(eventos.get(0));
            eventos.get(0).setVisible(true);
            jPanel1.validate();
            jPanel1.repaint();
        }

    }

    /**
     * @param args the command line arguments
     */
    private void verificarUsuario() {
        System.out.println("id rol "+ usuario.getRolId());
        if (usuario.getRolId() == 1||usuario.getRolId() == 3 ) {
            navMenu4.setVisible(true);
        } else {
            navMenu4.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarEvento;
    private javax.swing.JButton btnCholqij4;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel navMenu4;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.menu;

import api.login.ArchivoLogin;
import frontend.gui.CalendarioHaab;
import gui.infonahuales.VentanaInfoNahuales;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import modelos.objetos.Usuario;
import principal.backend.perfil_usuario.Informacion;
import principal.frontend.gui.calendari_cholquij.FrameCalendario;
import principal.frontend.gui.perfil_usuario.FramePerfil;
import principal.ui.EventoDeTiempo;
import principal.ui.LineaDeTiempo;

/**
 *
 * @author luisGonzalez
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private Informacion info = new Informacion();
    public final static ImageIcon BG = new ImageIcon("Imagenes/BackGroundMainMenu.jpg");
    private Usuario user;
    private ArchivoLogin archivoLogin = new ArchivoLogin();
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Usuario user) {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);       
        
        setBackground();
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        pnlMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnCholqij = new javax.swing.JButton();
        btnCholqij1 = new javax.swing.JButton();
        btnCholqij2 = new javax.swing.JButton();
        btnNahuales = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);

        pnlMenu.setBackground(new java.awt.Color(51, 153, 255));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Calendario Maya");

        btnCholqij.setBackground(new java.awt.Color(204, 204, 204));
        btnCholqij.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCholqij.setForeground(new java.awt.Color(0, 0, 0));
        btnCholqij.setText("Calendario Cholqij");
        btnCholqij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCholqijActionPerformed(evt);
            }
        });

        btnCholqij1.setBackground(new java.awt.Color(204, 204, 204));
        btnCholqij1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCholqij1.setForeground(new java.awt.Color(0, 0, 0));
        btnCholqij1.setText("Calendario Haab");
        btnCholqij1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCholqij1ActionPerformed(evt);
            }
        });

        btnCholqij2.setBackground(new java.awt.Color(204, 204, 204));
        btnCholqij2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCholqij2.setForeground(new java.awt.Color(0, 0, 0));
        btnCholqij2.setText("Rueda Calendarica");
        btnCholqij2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCholqij2ActionPerformed(evt);
            }
        });

        btnNahuales.setBackground(new java.awt.Color(204, 204, 204));
        btnNahuales.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnNahuales.setForeground(new java.awt.Color(0, 0, 0));
        btnNahuales.setText("Nahuales");
        btnNahuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNahualesActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(204, 204, 204));
        btnPerfil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(0, 0, 0));
        btnPerfil.setText("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnLinea.setBackground(new java.awt.Color(204, 204, 204));
        btnLinea.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnLinea.setForeground(new java.awt.Color(0, 0, 0));
        btnLinea.setText("Linea de Tiempo");
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCholqij)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCholqij1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCholqij2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNahuales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLinea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCholqij)
                    .addComponent(btnCholqij1)
                    .addComponent(btnCholqij2)
                    .addComponent(btnNahuales)
                    .addComponent(btnPerfil)
                    .addComponent(btnLinea))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        btnCerrarSesion.setBackground(new java.awt.Color(204, 204, 204));
        btnCerrarSesion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCholqijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCholqijActionPerformed
   try {
            // TODO code application logic here
        javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
   } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        JOptionPane.showMessageDialog(null, "No se encuentra el estilo, por lo tanto se utlizara por defecto...");
   }
    FrameCalendario calendarioCholquij = new FrameCalendario();
    calendarioCholquij.setVisible(true);
    }//GEN-LAST:event_btnCholqijActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        //cambiar el parametro nombre por el indicado
        Usuario user2 = info.buscarDatos(user.getUsername());
        if(user2 != null){
            FramePerfil perfil = new FramePerfil(null, true, user);
            perfil.setVisible(true);
        } 
    }//GEN-LAST:event_btnPerfilActionPerformed
    private void setBackground() {
        
        JLabel backgroundLbl = new JLabel();
        backgroundLbl.setSize(996, 559);
        backgroundLbl.setLocation(0, 0);
        backgroundLbl.setIcon(BG);
        this.add(backgroundLbl);
        backgroundLbl.setVisible(true);

    }
    private void btnCholqij1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCholqij1ActionPerformed
        CalendarioHaab calendario = new CalendarioHaab();
        calendario.setVisible(true);
    }//GEN-LAST:event_btnCholqij1ActionPerformed

    private void btnCholqij2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCholqij2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCholqij2ActionPerformed

    private void btnNahualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNahualesActionPerformed
        VentanaInfoNahuales ventanaInfoNahuales = new VentanaInfoNahuales();
        ventanaInfoNahuales.setVisible(true);
    }//GEN-LAST:event_btnNahualesActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        
        LineaDeTiempo linea = new LineaDeTiempo(user);
        linea.setVisible(true);
    }//GEN-LAST:event_btnLineaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        archivoLogin.escribirArchivo(null);
        System.exit(0);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCholqij;
    private javax.swing.JButton btnCholqij1;
    private javax.swing.JButton btnCholqij2;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnNahuales;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}

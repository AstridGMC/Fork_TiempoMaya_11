package gui.infonahuales;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import modelos.database.ConexionDb;
import modelos.database.NahualDb;
import modelos.objetos.Nahual;
import principal.backend.calendari_cholquij.calcular_fecha.CalcularFechaCholquij;

public class VentanaInfoNahuales extends javax.swing.JFrame {

    //ManejadorNahualGUI manejadorNahualGUI = new ManejadorNahualGUI();
    private NahualDb nahualDb = new NahualDb();
    private ArrayList<Nahual> listaNahuales = null;
    private ConexionDb conexionDb = new ConexionDb();
    private int indice = 0;
    private JLabel labelDescripcion = new JLabel("Descripcion");
    private FondoPanel fondoPanel = new FondoPanel();

    public VentanaInfoNahuales() {
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);

        panelInfo.getViewport().setOpaque(false);
        panelInfo.setBorder(null);
        labelDescripcion.setFont(labelSignificado.getFont());
        labelDescripcion.setBackground(labelSignificado.getBackground());
        labelDescripcion.setForeground(labelSignificado.getForeground());
        panelInfo.add(labelDescripcion);

        ImageIcon imIconAnterior = new ImageIcon("./src/gui/imagenes/anterior.png");
        Icon iconoAnterior = new ImageIcon(imIconAnterior.getImage().getScaledInstance(botonAnterior.getWidth(), botonAnterior.getHeight(), Image.SCALE_DEFAULT));
        botonAnterior.setIcon(iconoAnterior);
        ImageIcon imIconSiguiente = new ImageIcon("./src/gui/imagenes/siguiente.png");
        Icon iconoSiguiente = new ImageIcon(imIconSiguiente.getImage().getScaledInstance(botonSiguiente.getWidth(), botonSiguiente.getHeight(), Image.SCALE_DEFAULT));
        botonSiguiente.setIcon(iconoSiguiente);
        
        botonSiguiente.setOpaque(true);
        botonSiguiente.setBorder(null);
        Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        botonSiguiente.setIcon(new ImageIcon(getClass().getResource("../imagenes/siguiente.png")));
         botonAnterior.setIcon(new ImageIcon(getClass().getResource("../imagenes/anterior.png")));
        //Levantamos el listado de nahuales en la db y lo agragamos y lista ya estaria fucionando al 100
        listaNahuales = (ArrayList<Nahual>) nahualDb.getNahuales();
        pintar();
        setPosiciones();
    }

    public void setPosiciones() {

//        int lineas = textPaneSig.set
        //String texto = textPaneDes.getText();
        //System.out.println("Tamanio: "+texto.length());
        //System.out.println("TamanioM: "+texto.substring(0, 143));
        //scrollPane.repaint();
        panelInfo.repaint();
        panelInfo.updateUI();
        //scrollPane.repaint();

        //System.out.println(texto);
    }

    private boolean verificarNahuales() {
        if (listaNahuales != null && listaNahuales.size() > 2) {
            return true;
        }
        return false;
    }

    public int calcularFilas(String texto) {
        int total = (int) texto.length() / 143;
        if (total > 0) {
            total += 1;
            return total;
        }

        return 1;
    }

    private Icon getIconNahual(Nahual nahual, JLabel label) {
        ImageIcon imIcon = new ImageIcon(nahual.getImagen());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }

    public void pintarNahuales() {
        // JScrollPane jsp = new JScrollPane(txt);
        if (indice == 0) {
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(listaNahuales.size() - 1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice + 1), labelDerecha));
        } else if (indice == listaNahuales.size() - 1) {
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice - 1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(0), labelDerecha));
        } else {
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice - 1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice + 1), labelDerecha));
        }
        panelDescripcion.setText(listaNahuales.get(indice).getDescripcion());
        lblSignificado.setText(listaNahuales.get(indice).getSignificado());
        lblAnimal.setText(listaNahuales.get(indice).getAnimal());
        labelNombre.setText(listaNahuales.get(indice).getId() + ". " + listaNahuales.get(indice).getNombre());
    }

    private void pintar() {
        if (verificarNahuales()) {
            pintarNahuales();

        }
    }

    private void anterior() {
        if (indice == 0) {
            indice = listaNahuales.size() - 1;
        } else {
            indice--;
        }
    }

    private void siguiente() {
        if (indice == (listaNahuales.size() - 1)) {
            indice = 0;
        } else {
            indice++;
        }
    }

    public int nahual(int cont) {
        //System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = 6;
        if (contador < 0) {
            while (contador != 0) {
                if (contadorNahual == 20) {
                    contadorNahual = 1;
                } else {
                    contadorNahual++;
                }
                contador++;
            }
            return contadorNahual;
        }
        while (contador != 0) {
            if (contadorNahual == 1) {
                contadorNahual = 20;
            } else {
                contadorNahual--;
            }
            contador--;
        }
        return contadorNahual;

    }

    private void calcularFecha() {
        int numNahual = nahual(timeCholqij(date.getCalendar().getTime().getTime()));
        indice = numNahual;
        pintarNahuales();
        setPosiciones();
    }

    public int timeCholqij(long date) {
        try {
            String string = "Nov 15, 2020 00:00:00 AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ROOT);
            Date datePivote = sdf.parse(string);
//            System.out.println("DATE PIVOTE " + datePivote);
            long regresar = TimeUnit.DAYS.convert(datePivote.getTime() - date, TimeUnit.MILLISECONDS);
            return (int) regresar;
        } catch (ParseException ex) {
            Logger.getLogger(CalcularFechaCholquij.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNav = new javax.swing.JPanel();
        labelDerecha = new javax.swing.JLabel();
        labalIzquierda = new javax.swing.JLabel();
        labelPrincipal = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        botonSiguiente = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        btnCalcular = new javax.swing.JButton();
        panelInfo = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        labelSignificado = new javax.swing.JLabel();
        labelSignificado1 = new javax.swing.JLabel();
        lblAnimal = new javax.swing.JLabel();
        lblSignificado = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelDescripcion = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelNav.setBackground(new java.awt.Color(254, 254, 254));
        PanelNav.setOpaque(false);

        labelDerecha.setForeground(new java.awt.Color(204, 204, 204));
        labelDerecha.setOpaque(true);

        labalIzquierda.setOpaque(true);

        labelNombre.setBackground(new java.awt.Color(0, 0, 0));
        labelNombre.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelNombre.setOpaque(true);

        botonSiguiente.setBackground(new java.awt.Color(93, 156, 157));
        botonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/siguiente.png"))); // NOI18N
        botonSiguiente.setBorder(null);
        botonSiguiente.setBorderPainted(false);
        botonSiguiente.setOpaque(true);
        botonSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSiguienteMouseClicked(evt);
            }
        });
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAnterior.setForeground(new java.awt.Color(93, 156, 157));
        botonAnterior.setOpaque(true);
        botonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnteriorMouseClicked(evt);
            }
        });

        date.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnCalcular.setText("Calcular Nahual de la Fecha");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        panelInfo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelInfo.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        labelSignificado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSignificado.setForeground(new java.awt.Color(0, 0, 255));
        labelSignificado.setText("Significado");

        labelSignificado1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSignificado1.setForeground(new java.awt.Color(0, 0, 255));
        labelSignificado1.setText("Animal");

        lblAnimal.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblAnimal.setForeground(new java.awt.Color(73, 215, 179));

        lblSignificado.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblSignificado.setForeground(new java.awt.Color(73, 215, 179));

        panelDescripcion.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(panelDescripcion);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelSignificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSignificado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSignificado, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSignificado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelSignificado)
                        .addGap(18, 18, 18)
                        .addComponent(labelSignificado1)))
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelInfo.setViewportView(jPanel1);

        javax.swing.GroupLayout PanelNavLayout = new javax.swing.GroupLayout(PanelNav);
        PanelNav.setLayout(PanelNavLayout);
        PanelNavLayout.setHorizontalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(labelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        PanelNavLayout.setVerticalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addGap(49, 49, 49)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNav, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnteriorMouseClicked
        if (verificarNahuales()) {
            anterior();
            pintarNahuales();
            setPosiciones();
            date.setDate(null);
        }
    }//GEN-LAST:event_botonAnteriorMouseClicked

    private void botonSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSiguienteMouseClicked
        if (verificarNahuales()) {
            siguiente();
            pintarNahuales();
            setPosiciones();
            date.setDate(null);
        }
    }//GEN-LAST:event_botonSiguienteMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (date.getDate() != null) {
            calcularFecha();
        } else {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar o ingresar una fecha");
        }


    }//GEN-LAST:event_btnCalcularActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNav;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton btnCalcular;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labalIzquierda;
    private javax.swing.JLabel labelDerecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel labelSignificado;
    private javax.swing.JLabel labelSignificado1;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JLabel lblSignificado;
    private javax.swing.JPanel panel;
    private javax.swing.JEditorPane panelDescripcion;
    private javax.swing.JScrollPane panelInfo;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("../imagenes/fondoNahuales.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}

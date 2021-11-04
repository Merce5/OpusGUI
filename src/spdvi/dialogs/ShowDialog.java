/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi.dialogs;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import spdvi.MainForm;
import spdvi.objects.ArtWork;

/**
 *
 * @author merce
 */
//El ShowDialog es donde el usuario va a poder acceder a los datos tanto para insertarlos como para actualizarlos
public class ShowDialog extends javax.swing.JDialog {
    //Declaramos el acceso al mainForm que ha llamado a este dialog
    private final MainForm mainForm = (MainForm) this.getParent();
    //Inicializamos el JFileChooser
    private JFileChooser fileChooser = new JFileChooser();

    public ShowDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //El label de error siempre va a ser rojo así que ya le declaramos el color aquí y no va a ser visible hasta que haya algún problema
        lblError.setForeground(Color.red);
        lblError.setVisible(false);
        //Comprobamos si cuando se ha abierto el ShowDialog ha sido para actualizar o para insertar
        if (mainForm.update) {
            btnEnter.setText("Update");
            //Si estamos actualizando tendremos que cargar los datos del objeto que vamos a actualizar
            loadArtwork();
        } else {
            //Si no estamos actualizando al iniciarse solo tendrá que cambiar el texto del botón y poner la foto por defecto
            btnEnter.setText("Insert");
            mainForm.imagePath = "src/spdvi/icons/no_image.jpg";
            try {
                BufferedImage image = ImageIO.read(new File("src/spdvi/icons/no_image.jpg"));
                lblImage.setIcon(resizImageIcon(image));
            } catch (IOException ioe) {
                System.err.println("Error in ShowDialog");
                System.err.println(ioe);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReference = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        lblAuthor = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblText = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        lblFormat = new javax.swing.JLabel();
        txtFormat = new javax.swing.JTextField();
        lblImage = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        btnSelectImage = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblReference.setText("Reference");

        txtRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRefKeyReleased(evt);
            }
        });

        lblAuthor.setText("Author");

        lblText.setText("Title");

        lblYear.setText("Year");

        lblFormat.setText("Format");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnEnter.setText("Update");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btnSelectImage.setText("Select Image");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("The reference already exists");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReference, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReference)
                            .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblText))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAuthor)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYear)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormat)
                            .addComponent(txtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelectImage)
                        .addGap(34, 34, 34)))
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnter)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //El btnEnter es el botón que se utilizará tanto para actualizar como para introducir datos
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        //Si estamos actualizando tendrá que volver a recorrer la lista con los cambios realizados
        if (mainForm.update) {
            btnEnter.setEnabled(true);
            String ref = txtRef.getText();
            //ListModel para poder actualizar la lista del main form a la vez
            DefaultListModel<ArtWork> lstModel = new DefaultListModel<ArtWork>();

            for (ArtWork a : mainForm.artworks) {
                if (a.getRegistre().equals(ref)) {
                    a.setTitol(txtTitle.getText());
                    a.setAny(txtYear.getText());
                    a.setFormat(txtFormat.getText());
                    a.setAutor(txtAuthor.getText());
                    a.setImatge(mainForm.imagePath);
                }
                lstModel.addElement(a);
            }
            //Actualizamos también el artworksLstModel para no tener conflictos con otra acción que pueda pasar
            mainForm.artworksLstModel = lstModel;
            mainForm.lstArtWork.setModel(mainForm.artworksLstModel);
            //Al actualizar o insertar el dialog se cerrará
            this.setVisible(false);
        } else {
            //Cuando insertamos no hace falta recorrer el array, solo introducir los datos y añadirlos al final
            ArtWork a = new ArtWork(txtRef.getText(), txtTitle.getText(), txtYear.getText(), txtFormat.getText(), txtAuthor.getText(), mainForm.imagePath);
            mainForm.artworksLstModel.addElement(a);
            mainForm.artworks.add(a);
            mainForm.lstArtWork.setModel(mainForm.artworksLstModel);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        //Añadimos un filtro para que solo se puedan añadir fotos de formato jpg
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "JPG", "jpg", "jpeg"));
        //Quitamos la opción donde acepta todo tipo de archivos ya que solo queremos fotos jpg
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnOption = fileChooser.showOpenDialog(this);
        //Le damos el valor al imagePath del archivo selecionado, si se cierra se le dará un valor por defecto
        //El imagePath es lo que utilizamos en todo momento para manejar las fotos
        if (returnOption == JFileChooser.APPROVE_OPTION) {
            mainForm.imagePath = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            mainForm.imagePath = "src/spdvi/icons/no_image.jpg";
        }
        try {
            BufferedImage image = ImageIO.read(new File(mainForm.imagePath));
            lblImage.setIcon(resizImageIcon(image));
        } catch (IOException ioe) {
            System.err.println("Error in btnSelectImage");
            System.err.println(ioe);
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void txtRefKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefKeyReleased
        try {
            //Añadimos como restricción de la referencia que tenga que empezar por IB y que tenga que tener 10 caràcteres en total de longitud
            if ((String.valueOf(txtRef.getText().charAt(0) + txtRef.getText().charAt(1)).equals(String.valueOf('I' + 'B'))) && txtRef.getText().length() == 10) {
                    lblError.setVisible(false);
                    btnEnter.setEnabled(true);
                    //Cuando se esté insertando comprobaremos que la referencia no exista ya
                if (!mainForm.update) {
                    for (ArtWork a : mainForm.artworks) {
                        if (txtRef.getText().equals(a.getRegistre())) {
                            btnEnter.setEnabled(false);
                            lblError.setText("The reference already exists");
                            lblError.setVisible(true);
                            return;
                        } else {
                            btnEnter.setEnabled(true);
                            lblError.setVisible(false);
                        }
                    }
                } else {
                    //Cuando se esté actualizando comprobaremos que la referencia ya exista
                    for (ArtWork a : mainForm.artworks) {
                        if (!txtRef.getText().equals(a.getRegistre())) {
                            btnEnter.setEnabled(false);
                            lblError.setText("The current reference does not exist, please insert before update");
                            lblError.setVisible(true);
                        } else {
                            btnEnter.setEnabled(true);
                            lblError.setVisible(false);
                            return;
                        }
                    }
                }  
            } else {
                lblError.setVisible(true);
                btnEnter.setEnabled(false);
                lblError.setText("The reference must start with \"IB\" and his length must be 10");
            }
        } catch (StringIndexOutOfBoundsException siobe) {

        }

    }//GEN-LAST:event_txtRefKeyReleased

    //Método que va a cargar en el label de la imagen y en los textFields los datos del objeto que se va a actualizar
    private void loadArtwork() {
        try {
            //Comprobamos si la actualización es mediante doble click o mediante el menu item update
            if (mainForm.dobleclick) {
                //Si es por doble click solo tenemos que obtener el valor del objeto selecionado y como el dialog es focuseable
                //No se va a poder cambiar los datos mediante el getSelectedValue
                ArtWork a = (ArtWork) mainForm.lstArtWork.getSelectedValue();

                txtRef.setText(a.getRegistre());
                txtTitle.setText(a.getTitol());
                txtAuthor.setText(a.getAutor());
                txtYear.setText(a.getAny());
                txtFormat.setText(a.getFormat());
                
                BufferedImage image = ImageIO.read(new File(a.getImatge()));
                mainForm.imagePath = a.getImatge();
                lblImage.setIcon(resizImageIcon(image));
            } else { 
                //Si no es mediante el doble click tendremos que recorrer el array en busca de la referencia que nos han dado en el UpdateDialg
                for (ArtWork a : mainForm.artworks) {
                    if (mainForm.up.reference.equals(a.getRegistre())) {
                        txtRef.setText(a.getRegistre());
                        txtTitle.setText(a.getTitol());
                        txtAuthor.setText(a.getAutor());
                        txtYear.setText(a.getAny());
                        txtFormat.setText(a.getFormat());
                        BufferedImage image = ImageIO.read(new File(a.getImatge()));
                        lblImage.setIcon(resizImageIcon(image));
                        return;
                    }
                }
            }
        } catch (IOException ioe) {
            System.err.println("Error in loadArtwork (ShowDialog)");
            System.err.println(ioe);
        }
    }

    //Método para reescalar la foto al tamaño del label
    private ImageIcon resizImageIcon(BufferedImage originalImage) {
        int desiredHeight = 0;
        int desiredWidth = 0;
        float aspectRatio = (float) originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() < originalImage.getHeight()) {
            desiredWidth = Math.round(lblImage.getHeight() * aspectRatio);
            desiredHeight = lblImage.getHeight();
        } else {
            desiredHeight = Math.round(lblImage.getWidth() / aspectRatio);
            desiredWidth = lblImage.getWidth();
        }

        Image resultingImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        ImageIcon icon = new ImageIcon(outputImage);
        return icon;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowDialog dialog = new ShowDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFormat;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblReference;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtFormat;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}

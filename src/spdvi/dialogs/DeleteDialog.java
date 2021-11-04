/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi.dialogs;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import spdvi.MainForm;
import spdvi.objects.ArtWork;

/**
 *
 * @author merce
 */
public class DeleteDialog extends javax.swing.JDialog {
    //Declaramos el MainForm para poder acceder a él
    private final MainForm mainForm;
    //Declaramos el comboBox a mano para que sea de ArtWork y no de String
    private JComboBox<ArtWork> cmbArtwork;
    public DeleteDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Inicializamos el mainForm
        mainForm = (MainForm) this.getParent();
        //Inicializamos el cmbArtwork
        cmbArtwork = new JComboBox<ArtWork>();
        //Hacemos que el scrollPane sea el que detecte las acciones que se producen para el cmbArtwork
        scrArtworks.setViewportView(cmbArtwork);
        //Le añadimos el listener al cmbArtwork
        cmbArtwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbArtworkActionPerformed(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        scrArtworks = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel Light", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select the files that you want to delete.");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(scrArtworks, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(scrArtworks, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        ArtWork a = (ArtWork) cmbArtwork.getSelectedItem();   
        //Este ArrayList nos hará de soporte para que a la hora de hacer el add no nos de un changingValueException (o algo así se llamaba el error)
        ArrayList<ArtWork> auxList = new ArrayList<>();
        //Creamos un nuevo lstModel sobre el que trabajaremos para después asignarlo al lstModel principal
        DefaultListModel<ArtWork> lstModel = new DefaultListModel<ArtWork>();
        //Creamos un nuevo cmbModel para poder actualizar el scrArtworks en tiempo real
        DefaultComboBoxModel<ArtWork> cmbModel = new DefaultComboBoxModel<>();
        mainForm.artworks.remove(a);
        //Actualizamos el model y la lista de refuerzo con todos los objetos menos los borrados
        for(ArtWork art: mainForm.artworks) {
            auxList.add(art);
            lstModel.addElement(art);
            cmbModel.addElement(art);
        }
        //Actualitzamos las variables principales del mainForm con las auxiliares que hemos utilizado
        mainForm.artworks = auxList;
        mainForm.artworksLstModel = lstModel;
        mainForm.lstArtWork.setModel(mainForm.artworksLstModel);
        //Actualitzam el cmbArtwork
        cmbArtwork.setModel(cmbModel);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultListModel<ArtWork> newList = new DefaultListModel<>();
        DefaultComboBoxModel<ArtWork> cmbModel = new DefaultComboBoxModel<>();
        for(ArtWork art : mainForm.artworks) {
            cmbModel.addElement(art);
            newList.addElement(art);
        }
        mainForm.lstArtWork.setModel(newList);
        cmbArtwork.setModel(cmbModel);
    }//GEN-LAST:event_formWindowOpened
    //Action listener para cuando cambiamos de objeto seleccionado (para cambiar el icono del label)
    private void cmbArtworkActionPerformed(java.awt.event.ActionEvent evt) {                                           
        for(ArtWork a: mainForm.artworks) {
            if(a.toString().equals(cmbArtwork.getSelectedItem().toString())) {
                try {
                    BufferedImage image = ImageIO.read(new File(a.getImatge()));
                    lblImage.setIcon(resizImageIcon(image));
                } catch(IOException ioe) {
                    System.err.println("Error in cmbArtworkActionPerformed");
                    System.err.println(ioe);
                }
            }   
        }
    }      
    
    //Método que reescala la imagen dependiendo del tamaño del label
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
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeleteDialog dialog = new DeleteDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JScrollPane scrArtworks;
    // End of variables declaration//GEN-END:variables
}

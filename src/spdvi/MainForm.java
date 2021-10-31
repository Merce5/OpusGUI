/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spdvi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import spdvi.dialogs.ShowDialog;
import spdvi.dialogs.UpdateDialog;
import spdvi.objects.*;

/**
 *
 * @author merce
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    private static final java.lang.reflect.Type LIST_OF_ARTWORK_TYPE = new TypeToken<List<ArtWork>>() {}.getType();
    
    public ArrayList<ArtWork> artworks;
    public JList<ArtWork> lstArtWork;
    public boolean dobleclick = false;
    public boolean update = false;
    public UpdateDialog up = new UpdateDialog(this, true);
    public DefaultListModel<ArtWork> artworksLstModel = new DefaultListModel<ArtWork>();
    public String imagePath = "src/spdvi/icons/no_image.jpg";
    public String imagesDirectory = System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\images\\";
    
    public MainForm() {
        initComponents();
        lstArtWork = new JList<>();
        scrArtWork.setViewportView(lstArtWork);
        lstArtWork.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstArtworksValueChanged(evt);
            }
        });
        
        lstArtWork.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    doubleClick();
                }
            }
        });
        loadArtworks();
        
        try {
            BufferedImage image = ImageIO.read(new File("src\\spdvi\\icons\\no_image.jpg"));
            lblImage.setIcon(resizImageIcon(image));
        } catch(IOException ioe) {
            System.err.println("Error in ShowDialog");
            System.err.println(ioe);
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

        lblTitle = new javax.swing.JLabel();
        scrArtWork = new javax.swing.JScrollPane();
        lblImage = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniCreate = new javax.swing.JMenuItem();
        mniUpdate = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opos Manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1100, 450));
        setPreferredSize(new java.awt.Dimension(817, 400));

        lblTitle.setFont(new java.awt.Font("Georgia", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Artwork manager");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mniCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spdvi/icons/createIcon.jpg"))); // NOI18N
        mniCreate.setText("Create");
        mniCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCreateActionPerformed(evt);
            }
        });
        jMenu1.add(mniCreate);

        mniUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spdvi/icons/updateIcon.jpg"))); // NOI18N
        mniUpdate.setText("Update");
        mniUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateActionPerformed(evt);
            }
        });
        jMenu1.add(mniUpdate);

        mniDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spdvi/icons/deleteIcon.jpg"))); // NOI18N
        mniDelete.setText("Delete");
        jMenu1.add(mniDelete);
        jMenu1.add(jSeparator1);

        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spdvi/icons/exitIcon.jpg"))); // NOI18N
        mniExit.setText("Exit");
        jMenu1.add(mniExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(scrArtWork, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrArtWork, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCreateActionPerformed
        ShowDialog sd = new ShowDialog(this, true);
        sd.setVisible(true);
    }//GEN-LAST:event_mniCreateActionPerformed

    private void mniUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateActionPerformed
        update = true;
        up.setVisible(true);
    }//GEN-LAST:event_mniUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (JsonWriter writer = new JsonWriter(new FileWriter(System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres1.json"))){
            
            writer.setIndent("    ");
            writeArtworks(writer);
            writer.close();
        } catch (IOException ioe) {
            System.err.println("Error in mniCreateActionPerformed");
            System.err.println(ioe);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    private void lstArtworksValueChanged(javax.swing.event.ListSelectionEvent evt) {
        try {
            ArtWork a = (ArtWork) lstArtWork.getSelectedValue();
            BufferedImage image = ImageIO.read(new File(a.getImatge()));
            lblImage.setIcon(resizImageIcon(image));
        } catch(IOException ioe) {
            System.err.println("Error in lstArtworksValueChanged");
            System.err.println(ioe);
        } catch (NullPointerException npe) {
            
        }
    }
    
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
    
    private void doubleClick() {
        dobleclick = true;
        update = true;
        ShowDialog sd = new ShowDialog(this, true);
        sd.setVisible(true);
    }
    
    private void loadArtworks() {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.home") + "\\AppData\\Local\\OpusList\\data\\obres.json"));
            
            artworks = gson.fromJson(reader, LIST_OF_ARTWORK_TYPE);
            
            for(ArtWork a: artworks) {
                a.setImatge(imagesDirectory + a.getImatge());
                artworksLstModel.addElement(a);
            }
            lstArtWork.setModel(artworksLstModel);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error loading artworks");
        }
    }
    
    private void writeArtworks(JsonWriter writer) {
        try {
            writer.beginArray();
            artworks.forEach(a -> {
                writeArtwork(writer, a);
            });
            writer.endArray();
        } catch (IOException ioe) {
            System.err.println("Error in writeArtworks");
            System.err.println(ioe);
        }
    }
    
    private void writeArtwork(JsonWriter writer, ArtWork a) {
        try {
            String userFolder = System.getProperty("user.home");
            writer.beginObject();
            writer.name("registre").value(a.getRegistre());
            writer.name("titol").value(a.getTitol());
            writer.name("any").value(a.getAny());
            writer.name("format").value(a.getFormat());
            writer.name("autor").value(a.getAutor());
            String absolutePath = userFolder + "\\AppData\\Local\\OpusList\\images\\" + a.getRegistre()+ ".jpg";
            BufferedImage bufferedImage = ImageIO.read(new File(a.getImatge()));
            a.setImatge(a.getRegistre()+ ".jpg");
            File outputImage = new File(absolutePath);
            ImageIO.write(bufferedImage, "jpg", outputImage);
            //File folder = new File(userFolder + "\\AppData\\Local\\OpusList\\images\\");
            //findAllFilesInFolder(folder);
            writer.name("imatge").value(a.getImatge());
            writer.endObject();
        } catch (IOException ioe) {
            System.err.println("Error in writeArtwork");
            System.err.println(ioe);
        }
    }
    
    /*public void findAllFilesInFolder(File folder) {
        for (File file : folder.listFiles()) {
            for (File f : deletedUsers) {
                if (file.getName().equals(f.getName())) {
                    f.delete();
                }
            }
        }
    }*/
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuItem mniCreate;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniUpdate;
    private javax.swing.JScrollPane scrArtWork;
    // End of variables declaration//GEN-END:variables
}
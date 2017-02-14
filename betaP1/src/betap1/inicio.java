/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betap1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Denissebr
 */
public class inicio extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArchivo = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArchivo.setText("CARGAR ARCHIVO ");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnPlay.setText("JUGAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68)
                .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnArchivo)
                    .addComponent(btnPlay))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        String texto;
        JFileChooser fc = new JFileChooser();
       int select = fc.showOpenDialog(fc);
       if(select ==JFileChooser.APPROVE_OPTION){
           FileReader lector =null;
            try {
                //archivo
                File archivo =fc.getSelectedFile();
                System.out.println(archivo.getAbsolutePath());
                //parseo
                DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbfact.newDocumentBuilder();
                Document d = db.parse(archivo);
                d.getDocumentElement().normalize();
                System.out.println("RAIZ: "+d.getDocumentElement().getNodeName());
                NodeList dimension = d.getElementsByTagName("dimension");
                NodeList diccionario = d.getElementsByTagName("diccionario");
                
                
                for(int i=0; i<diccionario.getLength();i++){
                    Node nodo = diccionario.item(i);  
                    if (nodo instanceof Element){  
                    System.out.println(nodo.getTextContent());  
                    }                    
                        
                    
                }
                //lectura
                lector = new FileReader(archivo);
                BufferedReader lectorb = new BufferedReader(lector);
                while((texto =  lectorb.readLine())!= null){
                    System.out.println(texto);
                     
                }
                
                
                lectorb.close();
                lector.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    lector.close();
                } catch (IOException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
       }
       else if(select == JFileChooser.CANCEL_OPTION){
           JOptionPane.showMessageDialog(null,"Se cancelo la seleccion",   "Error", 0);
       }
    }//GEN-LAST:event_btnArchivoActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnPlay;
    // End of variables declaration//GEN-END:variables
}

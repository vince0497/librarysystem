/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import javax.swing.JFrame;
import java.awt.Color;
/**
 *
 * @author Biben
 */
public class HomeForm extends javax.swing.JPanel {

    /**
     * Creates new form HomeForm
     */
    public HomeForm(LibrarySystem frm) {
        initComponents();
        this.setSize(775, 331);
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel1.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 180, 200, 0);

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(224, 236, 248));
        jLabel3.setText("LoveU Library System");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 190, 510, 100);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 236, 248));
        jLabel2.setText("Welcome To");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 40, 520, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mainlaman.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-5, 0, 780, 330);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 780, 390);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
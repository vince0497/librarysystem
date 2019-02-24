/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.security.MessageDigest;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Biben
 */

public class ViewBookPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewBookPanel
     */
    
    DefaultTableModel mod;
    MySQLAPI api;
   LibrarySystem ugat;
    public ViewBookPanel(LibrarySystem root) {
        initComponents();
  this.ugat = root;
        this.setSize(540, 283);
       this.setLocation(230, 5);
       this.setBackground(new Color(0,0,0,0));
       mod = (DefaultTableModel)this.tblSearchBook.getModel();
       
       //scr.setBackground(new Color(0,0,0,0));
       tblSearchBook.setSelectionBackground(new Color(51,153,255));
       tblSearchBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       tblSearchBook.getTableHeader().setReorderingAllowed(false);
     
       //code for diabling editing column
       for(int x=0;x<tblSearchBook.getColumnCount();x++){
       Class<?> colClass = tblSearchBook.getColumnClass(x);
       tblSearchBook.setDefaultEditor(colClass, null);
       }
       
     api = new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");

     //  mod.setNumRows(0);
    this.refreshTable("*","*");
   
    }
    
    public void refreshTable(String field, String ref){
    mod.setRowCount(0);
         ArrayList<Book> book=api.getPackedBook(field,ref);
   for(int x=0;x<book.size();x++){
       Book b = (Book)book.get(x);
   mod.addRow(new Object[]{b.getISBN(),b.getTitle(),b.getAuthor(),b.getPublisher(),b.getCategory()});
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

        scr = new javax.swing.JScrollPane();
        tblSearchBook = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cboSearchBook = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnArchive = new javax.swing.JButton();
        btnAlter = new javax.swing.JButton();
        btnBorrow = new javax.swing.JButton();

        setLayout(null);

        scr.setBackground(new java.awt.Color(102, 102, 255));

        tblSearchBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Category"
            }
        ));
        tblSearchBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSearchBookMouseEntered(evt);
            }
        });
        scr.setViewportView(tblSearchBook);

        add(scr);
        scr.setBounds(0, 28, 540, 230);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch);
        txtSearch.setBounds(110, 2, 290, 29);

        cboSearchBook.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Title", "ISBN", "Author", "Publisher", "Year", "Category" }));
        add(cboSearchBook);
        cboSearchBook.setBounds(396, 1, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/viewBook.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 30);

        btnArchive.setText("Archive");
        btnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveActionPerformed(evt);
            }
        });
        add(btnArchive);
        btnArchive.setBounds(440, 260, 75, 25);

        btnAlter.setText("Alter");
        btnAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterActionPerformed(evt);
            }
        });
        add(btnAlter);
        btnAlter.setBounds(360, 260, 59, 25);

        btnBorrow.setText("Borrow");
        btnBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowActionPerformed(evt);
            }
        });
        add(btnBorrow);
        btnBorrow.setBounds(280, 260, 73, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void tblSearchBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchBookMouseClicked
        // TODO add your handling code here:
         
     //  if(tblSearchBook.)
        if(evt.getClickCount()==2){
            int ito=tblSearchBook.getSelectedRow();
           String isbn =  mod.getValueAt(ito, 0).toString();
            System.out.println("Val "+isbn);
           DialogLarge dlg= new DialogLarge(this.ugat,"as",true);
           dlg.coverFrame(this.ugat.getCoverBlur());
           Book b = api.getBook(isbn);
          ViewBookSolo solo = new ViewBookSolo(dlg,b);
          
          
          if(LibrarySystem.logged.getPosition().equals(Librarian.LIBRARIAN)){
    //meaninglibrarian lg un nkalog in idisable uing tab alter
        solo.tabBook.setEnabledAt(1,false);
            }
          
           dlg.addPanel(solo);
           
           dlg.executeDialog();
           dlg.hideCoverFrame(this.ugat.getCoverBlur());
           this.refreshTable("*", "*");
        }
    }//GEN-LAST:event_tblSearchBookMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
      // this.api.getPackedBook(cboSearchBook.getSelectedItem().toString(), txtSearch.getText());
        this.refreshTable(cboSearchBook.getSelectedItem().toString(), txtSearch.getText());
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblSearchBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchBookMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSearchBookMouseEntered

    private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed
        // TODO add your handling code here:
        
        if(this.tblSearchBook.getSelectedRow()==-1){
        LibrarySystem.showError("Select a book first", "Borrow Book", this);
        }else{
        showDialog(ViewBookSolo.BORROW);
        }
    }//GEN-LAST:event_btnBorrowActionPerformed

    private void btnAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterActionPerformed
        // TODO add your handling code here:
          if(this.tblSearchBook.getSelectedRow()==-1){
        LibrarySystem.showError("Select a book first", "Alter Book", this);
        }else{
        showDialog(ViewBookSolo.ALTER);
        }
    }//GEN-LAST:event_btnAlterActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed
        // TODO add your handling code here:
        
          if(this.tblSearchBook.getSelectedRow()==-1){
        LibrarySystem.showError("Select a book first", "Archive Book", this);
        }else{
        showDialog(ViewBookSolo.ARCHIVE);
        }
    }//GEN-LAST:event_btnArchiveActionPerformed

    public void showDialog(int alin){
    
          int ito=tblSearchBook.getSelectedRow();
           String isbn =  mod.getValueAt(ito, 0).toString();
            System.out.println("Val "+isbn);
           DialogLarge dlg= new DialogLarge(this.ugat,"as",true);
           dlg.coverFrame(this.ugat.getCoverBlur());
           Book b = api.getBook(isbn);
          ViewBookSolo sol = new ViewBookSolo(dlg,b);
          
          switch(alin){
         
              case ViewBookSolo.BORROW:{
                 sol.setShow(ViewBookSolo.BORROW);
              break;}
              
              case ViewBookSolo.ALTER:{
             sol.setShow(ViewBookSolo.ALTER);
                  break;}
              
              case ViewBookSolo.ARCHIVE:{
              sol.setShow(ViewBookSolo.ARCHIVE);
              break;}
          
          }
          
           dlg.addPanel(sol);
           dlg.executeDialog();
           dlg.hideCoverFrame(this.ugat.getCoverBlur());
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAlter;
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnBorrow;
    private javax.swing.JComboBox cboSearchBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblSearchBook;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
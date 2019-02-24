/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biben
 */
public class ReturnBookPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReturnBookPanel
     */
    DefaultTableModel mod;
    MySQLAPI api;
    LibrarySystem ugat;
    public ReturnBookPanel(LibrarySystem m) {
        initComponents();
        this.ugat = m;
         api = new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
           this.setSize(540, 283);
       this.setLocation(230, 5);
       this.setBackground(new Color(0,0,0,0));
         mod = (DefaultTableModel)this.tblBorrowed.getModel();
       //scr.setBackground(new Color(0,0,0,0));
       tblBorrowed.setSelectionBackground(new Color(51,153,255));
       tblBorrowed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       tblBorrowed.getTableHeader().setReorderingAllowed(false);
     
       //code for diabling editing column
       for(int x=0;x<tblBorrowed.getColumnCount();x++){
       Class<?> colClass = tblBorrowed.getColumnClass(x);
       tblBorrowed.setDefaultEditor(colClass, null);
       }
       
      
       this.refreshReturn("*","*");
       
    }
    
    public void refreshReturn(String cat,String val){
    ArrayList<Borrowed> arr = api.getBorrowedBooks(cat ,val);
    mod.setRowCount(0);
    for(int x=0;x<arr.size();x++){
    Borrowed b = (Borrowed)arr.get(x);
    String dt = new Date(Long.parseLong(b.getDateBorrow())).toLocaleString();
    mod.addRow(new Object[]{b.getBorrower(),b.getISBN(),b.getCopyNumber(),dt});
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

        txtReturnSearch = new javax.swing.JTextField();
        cboRet = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBorrowed = new javax.swing.JTable();

        setLayout(null);

        txtReturnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReturnSearchKeyReleased(evt);
            }
        });
        add(txtReturnSearch);
        txtReturnSearch.setBounds(110, 2, 290, 29);

        cboRet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student No.", "ISBN", "Copy Number" }));
        add(cboRet);
        cboRet.setBounds(396, 1, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/viewBook.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 30);

        tblBorrowed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Borrower's ID", "ISBN", "Copy Number", "Date Borrowed"
            }
        ));
        tblBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBorrowedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBorrowed);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 28, 540, 240);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBorrowedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBorrowedMouseClicked
        // TODO add your handling code here:
       if(evt.getClickCount()==2){
           int sel = tblBorrowed.getSelectedRow();
      String stud =  mod.getValueAt(sel, 0).toString();
      String isbn = mod.getValueAt(sel, 1).toString();
      String copyNum = mod.getValueAt(sel, 2).toString();
      
     Student st= api.getSpecificStudent(Integer.parseInt(stud));
     int bukIdIndiv=api.getBookId(isbn, Integer.parseInt(copyNum));
     Borrowed borro = api.getSpecificBorrowedBooks(bukIdIndiv);
    Book bookSingle = api.getSpecificBook( bukIdIndiv);
           DialogLarge dlg = new DialogLarge(ugat,"as",true);
           
           dlg.addPanel(new ReturnBookConfirm(dlg,st,bookSingle,borro));
           dlg.coverFrame(ugat.getCoverBlur());
           dlg.executeDialog();
           dlg.hideCoverFrame(ugat.getCoverBlur());
           //suupoosed to be na hhinto
           this.refreshReturn("*","*");
          // System.out.println("asasasasasasasasasasas");
       } 
       
    }//GEN-LAST:event_tblBorrowedMouseClicked

    private void txtReturnSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnSearchKeyReleased
        // TODO add your handling code here:
        this.refreshReturn(cboRet.getSelectedItem().toString(),txtReturnSearch.getText());
    }//GEN-LAST:event_txtReturnSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboRet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBorrowed;
    private javax.swing.JTextField txtReturnSearch;
    // End of variables declaration//GEN-END:variables
}

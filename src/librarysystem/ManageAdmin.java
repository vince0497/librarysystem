/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biben
 */
public class ManageAdmin extends javax.swing.JPanel {

    /**
     * Creates new form ManageAdmin
     */
    DialogLarge dlg;
    MySQLAPI api;
    DefaultTableModel mod;
    public ManageAdmin(DialogLarge d) {
        initComponents();
        this.dlg = d;
           dlg.setUndecorated(true);
        dlg.setSize(630,340);
        dlg.setLocation(300, 300);
        
        api = new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
        
         mod = (DefaultTableModel)this.tblGrade.getModel();
       //scr.setBackground(new Color(0,0,0,0));
       tblGrade.setSelectionBackground(new Color(51,153,255));
       tblGrade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       tblGrade.getTableHeader().setReorderingAllowed(false);
     
       //code for diabling editing column
       for(int x=0;x<tblGrade.getColumnCount();x++){
       Class<?> colClass = tblGrade.getColumnClass(x);
       tblGrade.setDefaultEditor(colClass, null);
       }
        this.refreshSection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtLibUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUnblock = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cboGrade = new javax.swing.JComboBox();
        txtSection = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrade = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblCloseAdmin = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/studBig.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(40, 80, 130, 140);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 127));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome Administrator!");
        add(jLabel5);
        jLabel5.setBounds(194, 40, 420, 14);

        jPanel1.setLayout(null);

        txtLibUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLibUsernameKeyPressed(evt);
            }
        });
        jPanel1.add(txtLibUsername);
        txtLibUsername.setBounds(140, 20, 170, 30);

        jLabel1.setForeground(new java.awt.Color(0, 0, 127));
        jLabel1.setText("Librarian Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(2, 30, 130, 16);

        btnUnblock.setText("Unblock");
        btnUnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnblockActionPerformed(evt);
            }
        });
        jPanel1.add(btnUnblock);
        btnUnblock.setBounds(320, 20, 80, 30);

        jTabbedPane1.addTab("Unblock Staff", jPanel1);

        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 127)), "Add Grade-Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(0, 0, 127))); // NOI18N
        jPanel3.setLayout(null);

        cboGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Grade --", "7", "8", "9", "10" }));
        jPanel3.add(cboGrade);
        cboGrade.setBounds(20, 20, 100, 30);

        txtSection.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSectionKeyPressed(evt);
            }
        });
        jPanel3.add(txtSection);
        txtSection.setBounds(180, 20, 70, 30);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd);
        btnAdd.setBounds(290, 20, 80, 30);

        jLabel2.setForeground(new java.awt.Color(0, 0, 127));
        jLabel2.setText("Section");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(130, 30, 60, 16);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 160, 410, 60);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);
        btnDelete.setBounds(350, 130, 73, 25);

        tblGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Grade - Section", "Occufied Students"
            }
        ));
        jScrollPane1.setViewportView(tblGrade);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 420, 120);

        jTabbedPane1.addTab("Grade - Sections", jPanel2);
        jTabbedPane1.addTab("tab3", jPanel4);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(190, 60, 430, 250);

        lblCloseAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dialogClose.png"))); // NOI18N
        lblCloseAdmin.setText("jLabel2");
        lblCloseAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCloseAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseAdminMouseClicked(evt);
            }
        });
        add(lblCloseAdmin);
        lblCloseAdmin.setBounds(600, 5, 20, 16);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/emptyPopup.png"))); // NOI18N
        BG.setText("jLabel1");
        add(BG);
        BG.setBounds(0, 0, 630, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLibUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLibUsernameKeyPressed
        // TODO add your handling code here:
//        if((Character.isDigit(evt.getKeyChar()))||(evt.getKeyCode()==8)){
//        txtLibId.setEditable(true);
//        }else{
//        txtLibId.setEditable(false);
//        }
    }//GEN-LAST:event_txtLibUsernameKeyPressed

    private void btnUnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnblockActionPerformed
        // TODO add your handling code here:
         String username = txtLibUsername.getText();
         if(username.isEmpty()){
         LibrarySystem.showError("Username is blank!", "Failed to unblock",this);
         }
         else if(!api.isExist("TblLibrarian", "username", username)){
         LibrarySystem.showError("Librarian not exist!", "Failed to unblock",this);
         
         }else{
          int ch = LibrarySystem.showConfirmation("Are you sure to unblock?", "Unblock", this);
        //if(ch==0)
       if(ch==0){
         int id =api.getIdOfUsername(username);
        api.updateData("TblLibrarian", "attempts","0", "librarian_id", id+"");
        LibrarySystem.showMessage("Successfully unblock the user.", "Success", this);
        txtLibUsername.setText("");
       }
        
      
         
         
         }
       
    }//GEN-LAST:event_btnUnblockActionPerformed

    private void lblCloseAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseAdminMouseClicked
        // TODO add your handling code here:
        this.dlg.dispose();
    }//GEN-LAST:event_lblCloseAdminMouseClicked

    private void txtSectionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSectionKeyPressed
        // TODO add your handling code here:
        if(((Character.isLetter(evt.getKeyChar())) && (txtSection.getText().length()==0))||(evt.getKeyCode()==8)) {
            txtSection.setEditable(true);
        }else{
        txtSection.setEditable(false);
        }
    }//GEN-LAST:event_txtSectionKeyPressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
      String grade=  cboGrade.getSelectedItem().toString();
      String sec = this.txtSection.getText().toUpperCase();
      String complete = "Grade-"+grade+":Section-"+sec;
      if(cboGrade.getSelectedIndex()==0){
      LibrarySystem.showError("Select specific grade", "Failed add section", this);
      }else if(sec.isEmpty()){
      LibrarySystem.showError("Input a section level", "Failed add section", this);
      }else if(api.isExist("TblGradeSec", "grade_sec", complete)){
            System.out.println(complete);
            LibrarySystem.showError("This section is already exist !", "Failed add section", this);
      }else{
        int pili = LibrarySystem.showConfirmation("Are you sure to add this section?\n"+complete, "Add section", this);
        if(pili==0){
        api.insertSection(complete);
        LibrarySystem.showMessage("Section successfully added!", "Add section", this);
        this.refreshSection();
        this.clearAddForm();
        }
      }
               
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(this.tblGrade.getSelectedRow()==-1){
        LibrarySystem.showError("Select a grade-section", "Failed to delete", this);
        }else{
        String sect = mod.getValueAt(tblGrade.getSelectedRow(), 0).toString();
        if(api.getCountStudentInSection(sect)>0){
        LibrarySystem.showError("Cannot delete the occufied section!", "Failed to delete",this);
        }else{
            int ch = LibrarySystem.showConfirmation("Are you sure to delete this section?", "Delete section", this);
        if(ch==0){
            
        api.deleteDataStrComp("TblGradeSec", "grade_sec", sect);
        LibrarySystem.showMessage("Succesfully deleted!", "Delete section", this);
        this.refreshSection();
             }
        }//end of klese ag wala ng lamang studnt
        }//ed of else
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void clearAddForm(){
    this.cboGrade.setSelectedIndex(0);
    this.txtSection.setText("");
    }
    public void refreshSection(){
   ArrayList lst = this.api.getAllGradeSection();
   mod.setRowCount(0);
   for(int x=0;x<lst.size();x++){
      String sec =  lst.get(x).toString();
      int bilang = api.getCountStudentInSection(sec);
  if (!((sec.equals(Student.GRADUATED))||(sec.equals(Student.FACULTY)))){
   mod.addRow(new Object[]{ sec ,bilang});
  }
   }//ed of for
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUnblock;
    private javax.swing.JComboBox cboGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCloseAdmin;
    private javax.swing.JTable tblGrade;
    private javax.swing.JTextField txtLibUsername;
    private javax.swing.JTextField txtSection;
    // End of variables declaration//GEN-END:variables
}
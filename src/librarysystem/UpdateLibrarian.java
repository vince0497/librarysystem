/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;

/**
 *
 * @author Biben
 */
public class UpdateLibrarian extends javax.swing.JPanel {

    /**
     * Creates new form UpdateLibrarian
     */
    DialogLarge d;
    Librarian l;
    ButtonGroup bgp;
    FormValidations valid;
    MySQLAPI api;
    LibrarySystem ugat;
    public UpdateLibrarian(LibrarySystem m,DialogLarge dlg,Librarian lib) {
        initComponents();
        this.d = dlg;
        this.l = lib;
        this.ugat = m;
        api =new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
        valid = new FormValidations();
        dlg.setSize(635 , 340);
        dlg.setUndecorated(true);
        dlg.setLocation(300, 300);
        bgp = new ButtonGroup();
        bgp.add(rdoMale);
        bgp.add(rdoFemale);
        this.lblFullName.setText(l.getFullName());
        txtUsername.setText(l.getUsername());
        
        txtFName.setText(l.getFName());
        txtMName.setText(l.getMName());
        txtLName.setText(l.getLName());
        
        String hati[]=l.getBirthdate().split("/");
       
        if(l.getGender().equals(Librarian.FEMALE)){
        rdoFemale.setSelected(true);
        }else{
        rdoMale.setSelected(true);
        }
        
        
          Calendar cal = new GregorianCalendar();
     int curYear = cal.getWeekYear()-18;
     
      
     for(int x=curYear;(curYear-10)<x;x--){
         cboYear.addItem(x);
     }
     //setter ng bdat
      cboMonth.setSelectedIndex(Integer.parseInt(hati[0]));
        cboDay.setSelectedItem(hati[1]);
        cboYear.setSelectedItem(Integer.parseInt(hati[2]));
      
       // System.out.println(hati[2]);
    }

    /**ad
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        cboMonth = new javax.swing.JComboBox();
        cboDay = new javax.swing.JComboBox();
        cboYear = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNew = new javax.swing.JPasswordField();
        txtNewConfirm = new javax.swing.JPasswordField();
        txtOld = new javax.swing.JPasswordField();
        txtMName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        btnUsernameSave = new javax.swing.JButton();
        txtLName = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        lblClose = new javax.swing.JLabel();
        btnSavePersonal = new javax.swing.JButton();
        lblFullName = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setLayout(null);

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Middle Name : ");
        add(jLabel2);
        jLabel2.setBounds(320, 120, 90, 14);

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Last Name : ");
        add(jLabel4);
        jLabel4.setBounds(330, 160, 80, 14);

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("First Name : ");
        add(jLabel6);
        jLabel6.setBounds(330, 80, 80, 14);

        jPanel1.setBackground(new java.awt.Color(219, 232, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Gender", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        rdoMale.setText("Male");
        jPanel1.add(rdoMale);
        rdoMale.setBounds(40, 20, 60, 23);

        rdoFemale.setText("Female");
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(rdoFemale);
        rdoFemale.setBounds(130, 20, 110, 23);

        add(jPanel1);
        jPanel1.setBounds(310, 190, 300, 50);

        jPanel2.setBackground(new java.awt.Color(200, 221, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 157), 1, true), "Birthdate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel2.setLayout(null);

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Month --", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel2.add(cboMonth);
        cboMonth.setBounds(10, 20, 90, 30);

        cboDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Day --", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel2.add(cboDay);
        cboDay.setBounds(110, 20, 70, 30);

        cboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Year --" }));
        jPanel2.add(cboYear);
        cboYear.setBounds(190, 20, 80, 30);

        add(jPanel2);
        jPanel2.setBounds(310, 250, 300, 60);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel3.setLayout(null);

        jLabel1.setText("Current");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 30, 60, 14);

        jLabel7.setText("Confirm");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 110, 60, 14);

        btnChangePass.setText("Save");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        jPanel3.add(btnChangePass);
        btnChangePass.setBounds(143, 140, 80, 23);

        jLabel8.setText("New ");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(10, 70, 50, 14);

        txtNew.setEchoChar('\u2022');
        jPanel3.add(txtNew);
        txtNew.setBounds(90, 60, 150, 30);

        txtNewConfirm.setEchoChar('\u2022');
        txtNewConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewConfirmActionPerformed(evt);
            }
        });
        jPanel3.add(txtNewConfirm);
        txtNewConfirm.setBounds(90, 100, 150, 30);

        txtOld.setEchoChar('\u2022');
        jPanel3.add(txtOld);
        txtOld.setBounds(90, 20, 150, 30);

        add(jPanel3);
        jPanel3.setBounds(10, 160, 250, 170);

        txtMName.setBackground(new Color(0,0,0,20));
        add(txtMName);
        txtMName.setBounds(420, 110, 150, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);
        jPanel4.add(txtUsername);
        txtUsername.setBounds(10, 20, 150, 30);

        btnUsernameSave.setText("Save");
        btnUsernameSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsernameSaveActionPerformed(evt);
            }
        });
        jPanel4.add(btnUsernameSave);
        btnUsernameSave.setBounds(160, 20, 70, 30);

        add(jPanel4);
        jPanel4.setBounds(10, 60, 250, 70);

        txtLName.setBackground(new Color(0,0,0,20));
        add(txtLName);
        txtLName.setBounds(420, 150, 150, 30);

        txtFName.setBackground(new Color(0,0,0,20));
        add(txtFName);
        txtFName.setBounds(420, 70, 150, 30);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dialogClose.png"))); // NOI18N
        lblClose.setText("jLabel3");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        add(lblClose);
        lblClose.setBounds(600, 5, 20, 15);

        btnSavePersonal.setText("Save");
        btnSavePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePersonalActionPerformed(evt);
            }
        });
        add(btnSavePersonal);
        btnSavePersonal.setBounds(530, 310, 80, 23);

        lblFullName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(0, 0, 153));
        lblFullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFullName.setText("FullName");
        add(lblFullName);
        lblFullName.setBounds(194, 40, 420, 14);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/emptyPopup.png"))); // NOI18N
        BG.setText("jLabel1");
        add(BG);
        BG.setBounds(0, 0, 630, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoFemaleActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        d.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void btnSavePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePersonalActionPerformed
        // TODO add your handling code here:
        String fname = txtFName.getText();
        String mname = txtMName.getText();
        String lname = txtLName.getText();
        String gender = Librarian.MALE;
        if(rdoFemale.isSelected()){
        gender = Librarian.FEMALE;
        }
        valid = new FormValidations();
        if(!valid.isValidName(fname)){
        LibrarySystem.showError("First name is invalid!", this);
        }else if(!valid.isValidName(mname)){
            LibrarySystem.showError("Middle name is invalid!", this);
        }else if(!valid.isValidName(lname)){
        LibrarySystem.showError("Last name is invalid!", this);
        }else if(cboMonth.getSelectedIndex()==0){
        LibrarySystem.showError("Select specific month!", this);
        }else if(cboDay.getSelectedIndex()==0){
        LibrarySystem.showError("Select specific day!", this);
        }else if(cboYear.getSelectedIndex()==0){
        LibrarySystem.showError("Select specific year!", this);
        }else{
            
            String month = cboMonth.getSelectedItem().toString();
        String day = cboDay.getSelectedItem().toString();
        String year = cboYear.getSelectedItem().toString();
        
        
        
        String que = "**** New Data *****";
        que+="\nFirst Name: "+fname;
        que+="\nMiddle Name: "+mname;
        que+="\nLast Name: "+lname;
        que+="\nGender: "+gender;
        que+="\nBirthdate: "+month+"/"+day+"/"+year;
        int mon = cboMonth.getSelectedIndex();
        String strMon = "";
        if(mon<10){
        strMon = "0"+mon;
        }else{
        strMon = mon+"";
        }
      //  LibrarySystem.showConfirmation(this,que, TOOL_TIP_TEXT_KEY, d)
                int choice=LibrarySystem.showConfirmation(que, "Librarian", this);
                
        if(choice==0){
            api.updateData("TblLibrarian", "f_name", fname, "librarian_id", l.getId());
            api.updateData("TblLibrarian", "m_name", mname, "librarian_id", l.getId());
            api.updateData("TblLibrarian", "l_name", lname, "librarian_id", l.getId());
            api.updateData("TblLibrarian", "gender", fname, "librarian_id", l.getId());
            api.updateData("TblLibrarian", "birthdate", strMon+"/"+day+"/"+year, "librarian_id", l.getId());
           
        LibrarySystem.showMessage("Successfully Updated!", "Update", this);
        this.d.dispose();
        }
       
             
        }
        
                
    }//GEN-LAST:event_btnSavePersonalActionPerformed

    private void btnUsernameSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsernameSaveActionPerformed
        // TODO add your handling code here:
        String un=txtUsername.getText();
        if(valid.validationUsername(un)==1){
        LibrarySystem.showError("Username is required!", this);
        }else if(valid.validationUsername(un)==2){
        LibrarySystem.showError("Username is atleast 6 characters!", this);
        }
        else if(api.isExist("TblLibrarian", "username", un)){
        LibrarySystem.showError("This username is already used !", this);

        }else if(api.isExist("TblProposedLib", "username", un)){
        LibrarySystem.showError("This username is already used !", this);

        }else{
        int choice =LibrarySystem.showConfirmation("Are you sure to alter your username?", "Username", this);
        if(choice==0){
        api.updateData("TblLibrarian", "username", un, "librarian_id", l.getId());
        LibrarySystem.showMessage("Successfully updated", "Librarian", this);
        d.dispose();
        ugat.logoutFunc();
        }
        }
        
    }//GEN-LAST:event_btnUsernameSaveActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        MyCrypt crypt = new MyCrypt();
        String old = txtOld.getText();
        String bago = txtNew.getText();
        String confirm = txtNewConfirm.getText();
        FormValidations val = new FormValidations();
        if(old.isEmpty()){
        LibrarySystem.showError("Must enter the old password!", this);
        }else if(bago.isEmpty()){
        LibrarySystem.showError("Must enter the new password!", this);
        }else if(confirm.isEmpty()){
        LibrarySystem.showError("Must enter the confirmation password!", this);
        }else if(crypt.confirmPassword(LibrarySystem.logged.getPassword(), old)==false){
        LibrarySystem.showError("This is not your current password!", this);
        }else if(!bago.equals(confirm)){
        LibrarySystem.showError("Password not match!", this);
        }else if(val.validatePassword(bago, confirm)==3){
        LibrarySystem.showError("Password must atleast 6 characters!", this);
        }else if(val.validatePassword(bago, confirm)==4){
         LibrarySystem.showError("Password musst contain numeric characters!", this);
        }else{
       int pili= LibrarySystem.showConfirmation("Are you sure to update your password?", "Password", this);
      if(pili==0){
       
      api.updateData("TblLibrarian", "password", crypt.cryptWithMD5(bago), "librarian_id", LibrarySystem.logged.getId());
      LibrarySystem.showMessage("Successfully updated.", "Password", this);
      this.d.dispose();
      this.ugat.logoutFunc();
      
      }
        }
        //if(crypt.confirmPassword(, old))
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void txtNewConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnSavePersonal;
    private javax.swing.JButton btnUsernameSave;
    private javax.swing.JComboBox cboDay;
    private javax.swing.JComboBox cboMonth;
    private javax.swing.JComboBox cboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMName;
    private javax.swing.JPasswordField txtNew;
    private javax.swing.JPasswordField txtNewConfirm;
    private javax.swing.JPasswordField txtOld;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
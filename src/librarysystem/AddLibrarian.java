/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Biben
 */
public class AddLibrarian extends javax.swing.JPanel {

    /**
     * Creates new form AddLibrarian
     */
    public DialogLarge dialogLarge;
    ButtonGroup grp;
    MySQLAPI api;
    
    public AddLibrarian(DialogLarge lrg) {
      //  JOptionPane.showMessageDialog(this, "sasasas");
        grp =  new ButtonGroup();  
        initComponents();
        this.dialogLarge = lrg;
        this.dialogLarge.setSize(630, 340);
        this.dialogLarge.setLocation(300, 140);
       this.dialogLarge.setUndecorated(true);
       this.dialogLarge.setBackground(new Color(0,0,0,0));
       this.setBackground(new Color(0,0,0,100));
     //  this.dialogLarge.setBackground(new Color(0,0,0,0));
      Date dNow = new Date();
      Calendar cal = new GregorianCalendar();
     int curYear = cal.getWeekYear()-18;
     
      
     for(int x=curYear;(curYear-10)<x;x--){
         cboYear.addItem(x);
     }
     
     api =new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
    ArrayList<PersonalQuestion> arr = api.getAllQuestion();
    for(int x=0;x<arr.size();x++){
    cboQuestion.addItem(arr.get(x).getQuestion());
    } 
    
 // this.validationForm();
     
    }
    
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCloseAddLib = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        txtMName = new javax.swing.JTextField();
        txtPassword2 = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        cboMonth = new javax.swing.JComboBox();
        cboDay = new javax.swing.JComboBox();
        cboYear = new javax.swing.JComboBox();
        btnAddLib = new javax.swing.JButton();
        btnCancelAddLib = new javax.swing.JButton();
        cboQuestion = new javax.swing.JComboBox();
        txtAnswer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new Color(255,255,255,0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        setOpaque(false);
        setLayout(null);

        lblCloseAddLib.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dialogClose.png"))); // NOI18N
        lblCloseAddLib.setText("jLabel2");
        lblCloseAddLib.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCloseAddLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseAddLibMouseClicked(evt);
            }
        });
        add(lblCloseAddLib);
        lblCloseAddLib.setBounds(605, 5, 20, 15);

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Last Name");
        add(jLabel2);
        jLabel2.setBounds(200, 140, 70, 14);

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Username");
        add(jLabel3);
        jLabel3.setBounds(200, 170, 60, 14);

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Password");
        add(jLabel4);
        jLabel4.setBounds(200, 200, 60, 14);

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Confirm Password");
        add(jLabel5);
        jLabel5.setBounds(200, 230, 110, 14);

        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Librarian Information");
        add(jLabel7);
        jLabel7.setBounds(360, 40, 160, 14);

        txtFName.setBackground(new Color(0,0,0,20));
        txtFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNameActionPerformed(evt);
            }
        });
        add(txtFName);
        txtFName.setBounds(330, 70, 150, 30);

        txtMName.setBackground(new Color(0,0,0,20));
        add(txtMName);
        txtMName.setBounds(330, 100, 150, 30);

        txtPassword2.setBackground(new Color(0,0,0,20));
        txtPassword2.setEchoChar('\u2022');
        add(txtPassword2);
        txtPassword2.setBounds(330, 220, 150, 30);

        txtPassword.setBackground(new Color(0,0,0,20));
        txtPassword.setEchoChar('\u2022');
        add(txtPassword);
        txtPassword.setBounds(330, 190, 150, 30);

        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("First Name");
        add(jLabel8);
        jLabel8.setBounds(200, 80, 80, 14);

        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Middle Name");
        add(jLabel9);
        jLabel9.setBounds(200, 110, 100, 14);

        txtUsername.setBackground(new Color(0,0,0,20));
        add(txtUsername);
        txtUsername.setBounds(330, 160, 150, 30);

        txtLName.setBackground(new Color(0,0,0,20));
        add(txtLName);
        txtLName.setBounds(330, 130, 150, 30);

        jPanel1.setBackground(new java.awt.Color(222, 234, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Gender", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        grp.add(rdoMale);
        rdoMale.setForeground(new java.awt.Color(0, 0, 153));
        rdoMale.setText("Male");
        jPanel1.add(rdoMale);
        rdoMale.setBounds(20, 50, 80, 23);

        grp.add(rdoFemale);
        rdoFemale.setForeground(new java.awt.Color(0, 0, 153));
        rdoFemale.setSelected(true);
        rdoFemale.setText("Female");
        jPanel1.add(rdoFemale);
        rdoFemale.setBounds(20, 20, 80, 23);

        add(jPanel1);
        jPanel1.setBounds(500, 60, 110, 90);

        jPanel2.setBackground(new java.awt.Color(222, 234, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Birthdate", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 153)));
        jPanel2.setLayout(null);

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel2.add(cboMonth);
        cboMonth.setBounds(10, 20, 100, 30);

        cboDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel2.add(cboDay);
        cboDay.setBounds(10, 50, 100, 30);

        cboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year" }));
        jPanel2.add(cboYear);
        cboYear.setBounds(10, 80, 100, 30);

        add(jPanel2);
        jPanel2.setBounds(500, 160, 120, 120);

        btnAddLib.setBackground(new java.awt.Color(220, 234, 244));
        btnAddLib.setForeground(new java.awt.Color(0, 0, 127));
        btnAddLib.setText("OK");
        btnAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLibActionPerformed(evt);
            }
        });
        add(btnAddLib);
        btnAddLib.setBounds(520, 280, 90, 23);

        btnCancelAddLib.setBackground(new java.awt.Color(220, 234, 244));
        btnCancelAddLib.setForeground(new java.awt.Color(0, 0, 127));
        btnCancelAddLib.setText("Cancel");
        btnCancelAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAddLibActionPerformed(evt);
            }
        });
        add(btnCancelAddLib);
        btnCancelAddLib.setBounds(520, 310, 90, 23);

        add(cboQuestion);
        cboQuestion.setBounds(330, 250, 150, 30);

        txtAnswer.setBackground(new Color(0,0,0,20));
        txtAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswerActionPerformed(evt);
            }
        });
        add(txtAnswer);
        txtAnswer.setBounds(330, 280, 150, 30);

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Personal questions");
        add(jLabel6);
        jLabel6.setBounds(200, 260, 110, 14);

        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Answer");
        add(jLabel10);
        jLabel10.setBounds(240, 290, 60, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addLib.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseAddLibMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseAddLibMouseClicked
        // TODO add your handling code here:
        this.dialogLarge.dispose();
    }//GEN-LAST:event_lblCloseAddLibMouseClicked

    public void showError(String mess){
           JOptionPane.showMessageDialog(this,mess ,"Error",JOptionPane.ERROR_MESSAGE);

    }
    private void txtFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNameActionPerformed

    private void btnAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLibActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
      
 FormValidations valid = new FormValidations();
      JOptionPane pane = new  JOptionPane();
     String pass1 =  this.txtPassword.getText();
     String pass2 = this.txtPassword2.getText();
     
       if(valid.isValidName( this.txtFName.getText())==false){
          this.showError("First Name must be required");
       }else if(valid.isValidName(this.txtMName.getText())==false){
         this.showError("Middle Name must be required");
       }else if(valid.isValidName(this.txtLName.getText())==false){
         this.showError("Last Name must be required");
       }else if(valid.validationUsername(this.txtUsername.getText())==1){
       this.showError("Username is required");
       }else if(valid.validationUsername(this.txtUsername.getText())==2){
       this.showError("Username must atleast 6 characters");
       }else if(api.isExist("TblLibrarian", "username", txtUsername.getText())){
       this.showError("Username is already exist!");
       }else if(api.isExist("TblProposedLib", "username", txtUsername.getText())){
        this.showError("Username is already exist!");
       
       }else if(valid.validatePassword(pass1, pass2)==1){
           this.showError("Password is required");
       }else if(valid.validatePassword(pass1, pass2)==2){
           this.showError("Password not match");
       }else if(valid.validatePassword(pass1, pass2)==3){
           this.showError("Password must atleast 6 characters");
       }else if(valid.validatePassword(pass1, pass2)==4){
           this.showError("Password must contain special character\nor numeric characters");
       }else if(this.txtAnswer.getText().equals("")){
       this.showError("Personal question is required");
       }
       else if(cboMonth.getSelectedItem().toString().equals("Month")){
       this.showError("Select a specified month");
       }else if(cboDay.getSelectedItem().toString().equals("Date")){
       this.showError("Select a specified day");
       }else if(cboYear.getSelectedItem().toString().equals("Year")){
       this.showError("Select a specified year");
       }else{
       //meaning ok state and flterized
           Date now = new Date();
           String okPass = this.txtPassword.getText();
          Librarian newbie =  new Librarian();
          newbie.setFName(this.txtFName.getText());
          newbie.setMName(this.txtMName.getText());
          newbie.setLName(this.txtLName.getText());
        
         newbie.setPassword(new MyCrypt().cryptWithMD5(okPass));
          newbie.setUsername(this.txtUsername.getText());
          int sel =cboMonth.getSelectedIndex();
          String dag="";
          if(sel<=9){
          dag = "0"+sel;
          }else{
          dag = sel+"";
          }
          String bday = dag+"/"+cboDay.getSelectedItem()+"/"+cboYear.getSelectedItem().toString();
           //System.out.println("ANG bdiy "+bday);
          newbie.setBirthdate(bday);String gend="";
          newbie.setAddress("");
          Calendar cal = new GregorianCalendar();
        //  SimpleDateFormat df = new SimpleDateFormat("mmm/dd/yyyy");
          newbie.setDateHired(System.currentTimeMillis()+"");
          newbie.setPosition("LIBRARIAN");
          newbie.setQuestion(cboQuestion.getSelectedItem()+"");
          newbie.setAnswer(this.txtAnswer.getText());
          
          if(rdoMale.isSelected()){
              gend = "Male";
          }else{
          gend = "Female";
          }
          newbie.setGender(gend);
          
            
            
            String mes="*** Are you sure with this data ***\nFull name : "+newbie.getFullName()+"\n";
            mes += "Username : "+newbie.getUsername();
            mes += "\nBirthdate : "+newbie.getBirthdate();
            mes += "\nPosition : "+newbie.getPosition();
            mes += "\nPersonal Question : "+newbie.getQuestion();
            mes += "\nPersonal Answer : "+newbie.getAnswer();
            //JOptionPane.sh
            int a=JOptionPane.showConfirmDialog(this.dialogLarge.getRootPaneDialog(), mes, "New Librarian", JOptionPane.YES_NO_OPTION);
          if(a==0){
          clearForm();
          //String que = "INSERT INTO TblProposedLib('',username,password,f_name,m_name,l_name,address,gender,position)";
            String ques = api.convertLibrarianIntoInsert(newbie);
            api.insertToTable(ques);
          }
            //JOptionPane.showMessageDialog(dialogLarge.getRootPaneDialog(), "Welcome to our library!");
       }//eend of ok state
    
       
        
    }//GEN-LAST:event_btnAddLibActionPerformed

    public void clearForm(){
    txtFName.setText("");
    txtLName.setText("");
    txtMName.setText("");
    txtUsername.setText("");
    txtPassword.setText("");
    txtPassword2.setText("");
    this.cboQuestion.setSelectedIndex(0);
   txtAnswer.setText("");
   cboMonth.setSelectedIndex(0);
   cboDay.setSelectedIndex(0);
   cboYear.setSelectedIndex(0);
   
    }
    
    private void btnCancelAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAddLibActionPerformed
        // TODO add your handling code here:
        this.dialogLarge.dispose();
    }//GEN-LAST:event_btnCancelAddLibActionPerformed

    private void txtAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLib;
    private javax.swing.JButton btnCancelAddLib;
    private javax.swing.JComboBox cboDay;
    private javax.swing.JComboBox cboMonth;
    private javax.swing.JComboBox cboQuestion;
    private javax.swing.JComboBox cboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCloseAddLib;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

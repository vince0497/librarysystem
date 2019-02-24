/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Biben
 */

class Watch extends Thread{
JLabel lblGlob;
    public Watch(JLabel n){
        this.lblGlob = n;
    }

    @Override
    public void run(){
    try{
    while(true){
    this.lblGlob.setText(new Date().toLocaleString());
    Thread.sleep(1000);
    
    }
    }catch(Exception e){
        System.out.println("pag kuha oras thread "+e.getMessage());
    }
    }


}

public class LibrarySystem extends javax.swing.JFrame {

    /**
     * Creates new form LibrarySystem
     */
    public static HomeForm home;
    public static LoginForm login;
    public static BookManipulate bookSide;
    public static MySQLAPI apis;
    public static StudentManipulate stud;
    public static Librarian logged;
    public static ReportManipulate rep;
     
    
    public MySQLAPI getSQL(){
    return apis;
    }
    
    public HomeForm getHomeForm(){
    return home;
    }
    
    public LoginForm getLoginForm(){
    return login;
    }
    
    public StudentManipulate getStudentManipulate(){
    return stud;
    }
    
    
     public BookManipulate getBookForm(){
    return bookSide;
    }
     public ReportManipulate getReportManipulate(){
     return this.rep;
     }
     
    //the label header fo rtaas
    public JPanel getTakip(){
  return  this.pnlTakip;
    }
    
    public JPanel getCoverBlur(){
    return this.pnlBlur;
    }
    
    public JLabel getLabelLog(){
    return this.lblWhoLog;
    }
    
    public JLabel getLogoutKey(){
    return this.lblLogout;
    }
    
    public JLabel getAdminKey(){
    return this.lblManage;
    }
    
    public Librarian getLogged(){
    return this.logged;
    }
    
    
    
    public static boolean isInteger(String specimen ){
    boolean f=true;
    
    try{
    Integer.parseInt(specimen);
    }catch(Exception e){
    f=false;
    }
    
    return f;
    
    }
    
    public static void showError(String mess,Component com){
           JOptionPane.showMessageDialog(com,mess ,"Error",JOptionPane.ERROR_MESSAGE);
//JOptionPane.showConfirmDialog(this, "asas");
    }
    
     public static void showError(String mess,String header,Component com){
           JOptionPane.showMessageDialog(com,mess ,header,JOptionPane.ERROR_MESSAGE);
//JOptionPane.showConfirmDialog(this, "asas");
    }
    
    public static int showConfirmation(String mess,String header,Component com){
    
   int pili = JOptionPane.showConfirmDialog(com, mess, header, JOptionPane.YES_NO_OPTION);
   return pili;
    }
    
    public static void showMessage(String mess,String head,Component com){
               JOptionPane.showMessageDialog(com,mess ,head,JOptionPane.INFORMATION_MESSAGE);

    }
    
    
    
    
    public LibrarySystem() {
        
    apis =new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
      
      if(apis.isDatabaseHaveProblem()){
         JOptionPane.showMessageDialog(this, "The Database is closed! \nSystem will force to shutdown.", "System Message", JOptionPane.ERROR_MESSAGE);
         System.exit(0);
      }
        
      
      
        this.login = new LoginForm(this);
        this.home = new HomeForm(this);
        this.bookSide = new BookManipulate(this);
        this.stud = new StudentManipulate(this);
      this.rep = new ReportManipulate(this);
       // new ReportManipulate(this);
     login.setLocation(13, 160);
     home.setLocation(13, 160);
     bookSide.setLocation(13, 160);
     stud.setLocation(13, 160);
     rep.setLocation(13, 160);
     
     this.add(login);
     this.add(home);
     this.add(bookSide);
     this.add(stud);
     this.add(rep);
     
     
     home.hide();
     bookSide.hide();
     stud.hide();
     rep.hide();
      
        initComponents();
    this.getCoverBlur().hide();//blur
    this.getLogoutKey().setText("");//logut key wala
   this.getAdminKey().setText("");
    
       ArrayList<Image> icons = new ArrayList<Image>();
      icons.add(getImage("/icons/libraryIcon16x16.png"));
      icons.add(getImage("/icons/libraryIcon32x32.png"));
     // icons.add(getImage("/icons/libraryIcon256x256.png"));
      
   
      this.setIconImages(icons);
   
        this.setSize(810, 510);
        this.setLocation(200, 50);
      this.setBackground(new Color(0,0,0,0));
      
      
    //orasan construction
      new Watch(this.lblOras).start();
      
      
     //this part set the the window into draggeabe
      MyDragger drag = new MyDragger(this,true);
      this.addMouseListener(drag); 
      this.addMouseMotionListener(drag);
    }//end of costurctor
    
    public Image getImage(String path){
     URL imgPath = getClass().getResource(path);
        return Toolkit.getDefaultToolkit().getImage(imgPath.getPath());
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
        pnlBlur = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlTakip = new javax.swing.JPanel();
        lblOras = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblWhoLog = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblBookTrans = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        lblReports = new javax.swing.JLabel();
        lblManage = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();
        lblHeadTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        pnlBlur.setBackground(new Color(0,0,0,80));
        getContentPane().add(pnlBlur);
        pnlBlur.setBounds(650, 0, 60, 30);

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(null);

        pnlTakip.setBackground(new Color(0,0,0,50));
        pnlTakip.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTakip.setLayout(null);
        jPanel2.add(pnlTakip);
        pnlTakip.setBounds(12, 51, 774, 110);

        lblOras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOras.setForeground(new java.awt.Color(255, 255, 255));
        lblOras.setText("Date");
        jPanel2.add(lblOras);
        lblOras.setBounds(490, 140, 160, 14);

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        lblHome.setText("jLabel2");
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });
        jPanel2.add(lblHome);
        lblHome.setBounds(70, 70, 60, 50);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel2.add(lblClose);
        lblClose.setBounds(740, 10, 29, 30);

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mini.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        jPanel2.add(lblMinimize);
        lblMinimize.setBounds(710, 10, 29, 30);

        lblTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("LuvU Library System");
        jPanel2.add(lblTitle);
        lblTitle.setBounds(20, 20, 210, 18);

        lblWhoLog.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWhoLog.setForeground(new java.awt.Color(255, 255, 255));
        lblWhoLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblWhoLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWhoLogMouseClicked(evt);
            }
        });
        jPanel2.add(lblWhoLog);
        lblWhoLog.setBounds(70, 137, 200, 20);

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Log-out");
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        jPanel2.add(lblLogout);
        lblLogout.setBounds(725, 140, 50, 14);

        lblBookTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libro.png"))); // NOI18N
        lblBookTrans.setText("shot");
        lblBookTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBookTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBookTransMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBookTransMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBookTransMouseExited(evt);
            }
        });
        jPanel2.add(lblBookTrans);
        lblBookTrans.setBounds(240, 70, 60, 50);

        lblStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/student.png"))); // NOI18N
        lblStudent.setText("jLabel2");
        lblStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStudentMouseExited(evt);
            }
        });
        jPanel2.add(lblStudent);
        lblStudent.setBounds(450, 70, 60, 50);

        lblReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reports.png"))); // NOI18N
        lblReports.setText("jLabel3");
        lblReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReportsMouseExited(evt);
            }
        });
        jPanel2.add(lblReports);
        lblReports.setBounds(660, 70, 50, 50);

        lblManage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblManage.setForeground(new java.awt.Color(255, 255, 255));
        lblManage.setText("Manage");
        lblManage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageMouseClicked(evt);
            }
        });
        jPanel2.add(lblManage);
        lblManage.setBounds(660, 140, 60, 14);

        lblMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bg.png"))); // NOI18N
        lblMain.setText("jLabel3");
        jPanel2.add(lblMain);
        lblMain.setBounds(0, 0, 800, 500);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 980, 520);

        lblHeadTitle.setFont(new java.awt.Font("Tunga", 1, 18)); // NOI18N
        lblHeadTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHeadTitle.setText("Hell Library System");
        lblHeadTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHeadTitleMouseClicked(evt);
            }
        });
        getContentPane().add(lblHeadTitle);
        lblHeadTitle.setBounds(160, 360, 340, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        if(myFrame != null){
  
            MyDialog dia = new MyDialog(this,"Message",true);
            dia.addPanel(new CloseConfirmation(dia));
            dia.executeDialog();

        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        
           if(myFrame != null){
        //myFrame.dispose();
           // JOptionPane.showConfirmDialog(this, "", null, WIDTH, WIDTH);
           
                    //myFrame.toBack();
                    myFrame.setState(Frame.ICONIFIED);
                          
                    
       
        }
        
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
       if(!pnlTakip.isVisible()){
       lblHome.setLocation(lblHome.getX(), lblHome.getY()-5);
       }
        
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        // TODO add your handling code here:
        if(!pnlTakip.isVisible()){
                 lblHome.setLocation(lblHome.getX(), lblHome.getY()+5);

        }
    }//GEN-LAST:event_lblHomeMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        // TODO add your handling code heren
        if(!pnlTakip.isVisible()){
       // this.getHomeForm().setLocation(13, 160);
         // this.add(this.getHomeForm(),1);
      this.getLoginForm().hide();
      this.getBookForm().hide();
      this.getStudentManipulate().hide();
      this.getReportManipulate().hide();
      this.getHomeForm().show();
     
              this.lblTitle.setText("LoveU Library System");

      
        }
        
    
    }//GEN-LAST:event_lblHomeMouseClicked

    public void logoutFunc(){
     if(!this.getTakip().isVisible()){
       
        
        this.getHomeForm().hide();
        this.getBookForm().hide();
        this.getStudentManipulate().hide();
        this.getReportManipulate().hide();
        this.getLoginForm().show();
        this.getTakip().show();
        
        lblWhoLog.setText("");
       
        this.getLogoutKey().hide();
        this.getAdminKey().hide();
        this.lblTitle.setText("Library System");
        
        
       }
    
    }
    
    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
       if(!this.getTakip().isVisible()){
           DialogLarge dlg = new DialogLarge(this,"as",true);
           dlg.coverFrame(this.getCoverBlur());
          Confirmation conf= new Confirmation(dlg,"Are you sure to logout?");
           dlg.addPanel(conf);
           dlg.executeDialog();
          if(conf.getState()){
          this.logoutFunc();
          }
           dlg.hideCoverFrame(this.getCoverBlur());
       
       }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblBookTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookTransMouseClicked
        // TODO add your handling code here:
        if(!this.getTakip().isVisible()){
        this.getLoginForm().hide();
        this.getHomeForm().hide();
        this.getStudentManipulate().hide();
        this.getReportManipulate().hide();
        this.getBookForm().show();
        this.lblTitle.setText("Book Keeping");
        
        //disable the button when ht elibrarian is not admin
          if(LibrarySystem.logged.getPosition().equals(Librarian.LIBRARIAN)){
            getBookForm().viewBook.btnAlter.setEnabled(false);
                }
   
        
        
        }
    }//GEN-LAST:event_lblBookTransMouseClicked

    private void lblBookTransMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookTransMouseEntered
        // TODO add your handling code here:
        if(!this.getTakip().isVisible()){
        this.lblBookTrans.setLocation(lblBookTrans.getX(), lblBookTrans.getY()-5);
        }
    }//GEN-LAST:event_lblBookTransMouseEntered

    private void lblBookTransMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookTransMouseExited
        // TODO add your handling code here:
        if(!this.getTakip().isVisible()){
        this.lblBookTrans.setLocation(lblBookTrans.getX(), lblBookTrans.getY()+5);
        }
    }//GEN-LAST:event_lblBookTransMouseExited

    private void lblStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStudentMouseEntered
        // TODO add your handling code here:
        if(!this.getTakip().isVisible()){
        this.lblStudent.setLocation(lblStudent.getX(), lblStudent.getY()-5);
        }
    }//GEN-LAST:event_lblStudentMouseEntered

    private void lblStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStudentMouseExited
        // TODO add your handling code here:
         if(!this.getTakip().isVisible()){
        this.lblStudent.setLocation(lblStudent.getX(), lblStudent.getY()+5);
        }
    }//GEN-LAST:event_lblStudentMouseExited

    private void lblReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportsMouseEntered
        // TODO add your handling code here:
        if(!this.getTakip().isVisible()){
        this.lblReports.setLocation(lblReports.getX(), lblReports.getY()-5);
        }
    }//GEN-LAST:event_lblReportsMouseEntered

    private void lblReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportsMouseExited
        // TODO add your handling code here:
        
          if(!this.getTakip().isVisible()){
        this.lblReports.setLocation(lblReports.getX(), lblReports.getY()+5);
        }
        
    }//GEN-LAST:event_lblReportsMouseExited

    private void lblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStudentMouseClicked
        // TODO add your handling code here:
          if(!pnlTakip.isVisible()){
       this.getLoginForm().hide();
      this.getHomeForm().hide();
      this.getBookForm().hide();
      this.getReportManipulate().hide();
      this.getStudentManipulate().show();
              this.lblTitle.setText("Students");
           if(getLogged().getPosition().equals(Librarian.LIBRARIAN)){
            getStudentManipulate().view.btnMove.hide();
            getStudentManipulate().view.btnDrop.hide();
           }
      
        }
    }//GEN-LAST:event_lblStudentMouseClicked

    private void lblReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportsMouseClicked
        // TODO add your handling code here:
        if(!pnlTakip.isVisible()){
         this.getLoginForm().hide();
        this.getHomeForm().hide();
        this.getBookForm().hide();
        this.getStudentManipulate().hide();
        this.getReportManipulate().show();
        this.lblTitle.setText("Reports");
        }
    }//GEN-LAST:event_lblReportsMouseClicked

    private void lblHeadTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHeadTitleMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblHeadTitleMouseClicked

    private void lblWhoLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWhoLogMouseClicked
        // TODO add your handling code here:
        if(!pnlTakip.isVisible()){
            
        System.out.println(" ang log "+this.getLogged().getFullName());
        DialogLarge dlg = new DialogLarge(this,"as",true);
        dlg.coverFrame(this.getCoverBlur());
        dlg.addPanel(new UpdateLibrarian(this,dlg,this.getLogged()));
        dlg.executeDialog();
        dlg.hideCoverFrame(this.getCoverBlur());
        }
    }//GEN-LAST:event_lblWhoLogMouseClicked

    private void lblManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageMouseClicked
        // TODO add your handling code here:
        if(!pnlTakip.isVisible()){
       DialogLarge dlg = new DialogLarge(this,"as",true);
       dlg.coverFrame(this.getCoverBlur());
       dlg.addPanel(new ManageAdmin(dlg));
       dlg.executeDialog();
       dlg.hideCoverFrame(this.getCoverBlur());
        }
    }//GEN-LAST:event_lblManageMouseClicked

    
    public void hideLogin(){
        
//    pnlLogin.hide();go
//    
//    lblLib.hide();
//    lblNewLibrarian.hide();
//    
//    lblLog.hide();
//    txtUsername.hide();
//    txtPassword.hide();
//    btnLogin.hide();
//    lblUser.hide();
//    lblPass.hide();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarySystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myFrame =new LibrarySystem();
                myFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBookTrans;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblHeadTitle;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLogout;
    public javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblManage;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblOras;
    private javax.swing.JLabel lblReports;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblTitle;
    public static javax.swing.JLabel lblWhoLog;
    private javax.swing.JPanel pnlBlur;
    public static javax.swing.JPanel pnlTakip;
    // End of variables declaration//GEN-END:variables
    private static JFrame myFrame;
}

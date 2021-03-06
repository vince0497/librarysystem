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
import javafx.scene.Cursor;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 *
 * @author Biben
 */
public class AddBookPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddBookPanel
     */
    
    MySQLAPI api = null;
    LibrarySystem root;
    public AddBookPanel() {
        initComponents();
       this.setSize(540, 310);
       this.setLocation(230, 5);
       
        this.setBackground(new Color(0,0,0,0));
        api = new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
        Date dNow=new Date();
       Calendar cal = new GregorianCalendar();
      int taon=dNow.getYear()+1900;
    
      for(int x=taon;x>=(taon-10);x--){
          this.cboYear.addItem(x+"");
      }
      
    ArrayList<Category> cat = api.getAllCategory();
    for(int x=0;x<cat.size();x++){
   cboCategory.addItem(cat.get(x).getCategory());
    }
        //System.out.println("ang year "+taon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        btnAddBook = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        cboYear = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboCopies = new javax.swing.JComboBox();
        txtPublisher = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Book Information");
        add(jLabel6);
        jLabel6.setBounds(210, 10, 130, 16);

        txtISBN.setBackground(new Color(0,0,0,20));
        txtISBN.setPreferredSize(new java.awt.Dimension(150, 30));
        txtISBN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtISBNFocusLost(evt);
            }
        });
        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtISBNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtISBNKeyReleased(evt);
            }
        });
        add(txtISBN);
        txtISBN.setBounds(230, 40, 150, 30);

        txtTitle.setBackground(new Color(0,0,0,20));
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        add(txtTitle);
        txtTitle.setBounds(230, 75, 150, 30);

        btnAddBook.setText("Add");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });
        add(btnAddBook);
        btnAddBook.setBounds(270, 285, 55, 25);

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("ISBN");
        add(jLabel2);
        jLabel2.setBounds(170, 50, 50, 16);

        txtAuthor.setBackground(new Color(0,0,0,20));
        add(txtAuthor);
        txtAuthor.setBounds(230, 110, 150, 30);

        cboYear.setEditable(true);
        cboYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboYearItemStateChanged(evt);
            }
        });
        cboYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboYearKeyPressed(evt);
            }
        });
        add(cboYear);
        cboYear.setBounds(230, 180, 150, 30);

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Title");
        add(jLabel3);
        jLabel3.setBounds(170, 80, 50, 16);

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Author");
        add(jLabel4);
        jLabel4.setBounds(160, 120, 60, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/headerAddBook.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 30);

        cboCopies.setEditable(true);
        cboCopies.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cboCopies.setToolTipText("");
        add(cboCopies);
        cboCopies.setBounds(230, 250, 150, 30);

        txtPublisher.setBackground(new Color(0,0,0,20));
        add(txtPublisher);
        txtPublisher.setBounds(230, 145, 150, 30);

        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Quantity");
        add(jLabel8);
        jLabel8.setBounds(160, 260, 60, 16);

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Publisher");
        add(jLabel5);
        jLabel5.setBounds(160, 150, 60, 16);

        lblError.setForeground(new java.awt.Color(153, 0, 0));
        add(lblError);
        lblError.setBounds(390, 50, 140, 30);

        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Published");
        add(jLabel9);
        jLabel9.setBounds(160, 190, 60, 16);

        add(cboCategory);
        cboCategory.setBounds(230, 215, 150, 30);

        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Category");
        add(jLabel10);
        jLabel10.setBounds(160, 220, 60, 16);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/conAddBookForm.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(65, 26, 470, 292);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    
    public  void showError(String mess){
           JOptionPane.showMessageDialog(this,mess ,"Error",JOptionPane.ERROR_MESSAGE);

    }
    
    public boolean isInteger(String specimen ){
    boolean f=true;
    
    try{
    Integer.parseInt(specimen);
    }catch(Exception e){
    f=false;
    }
    
    return f;
    
    }
    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
        // TODO add your handling code here:
        String rawISBN =txtISBN.getText();
        String rawAuthor = txtAuthor.getText();
        String rawTitle = txtTitle.getText();
        String rawPublisher = txtPublisher.getText();
        String rawYear = cboYear.getSelectedItem().toString();
        String rawCopies = cboCopies.getSelectedItem().toString();
         String rawCat = cboCategory.getSelectedItem().toString();
        boolean meronBa = false;
        for(int x=0;x<rawISBN.length();x++){
        if(rawISBN.charAt(x)=='-'){
            meronBa=true;
        break;
        }
            
        }
        
      
        if(rawISBN.equals("")){
        showError("ISBN is required!");
        }
        else if( rawISBN.contains("--")){
      showError("Invalid format of isbn!");
      }else if(meronBa==false){
      showError("Invalid format of isbn!");
      }else if((  rawISBN.charAt(0)=='-')||(rawISBN.charAt(rawISBN.length()-1)=='-')){
      showError("Invalid format of isbn!");
      }
        else if(rawTitle.equals("")){
            showError("Title of the book is required.");
        }else if(rawAuthor.isEmpty()){
         showError("Author of the book is required.");
        }
        else if(rawPublisher.equals("")){
        showError("Publisher of the book is required.");
        }else if(!this.isInteger(cboYear.getSelectedItem().toString())){
        showError("Input a valid year!");
        }else if(Integer.parseInt(cboYear.getSelectedItem().toString())>new Date().getYear()+1900){
        showError("Input a valid year! The year you inputted is in the future.");
        }
       else if(!this.isInteger(cboCopies.getSelectedItem().toString())){
        showError("Input a valid quantity!");
        }else{
            String a = "asds";
           
            //ok state
            Date dNow = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
          String mes = "*** Book Information ***";
          mes += "\nBook ISBN : "+rawISBN;
          mes += "\nBook Title : "+rawTitle;
          mes += "\nBook Author : "+rawAuthor;
          mes += "\nBook Publisher : "+rawPublisher;
          mes += "\nBook Category : "+rawCat;
          mes += "\nCopies : "+rawCopies;
                  
        int s= JOptionPane.showConfirmDialog(this, mes, "Add book", JOptionPane.YES_NO_OPTION);
            System.out.println(s+"");
            int simula=api.getNewCopyNumber(rawISBN);
            if(s==0){
                int ilan = Integer.parseInt(rawCopies);
                ArrayList<Book> books = new ArrayList<Book>();
                for(int x=0;x<ilan;x++){
                
                        Book b =new Book();
                        b.setTitle(rawTitle);
                        b.setAuthor(rawAuthor);
                        b.setDateAdded(System.currentTimeMillis()+"");
                        b.setISBN(rawISBN);
                        b.setPublisher(rawPublisher);
                        b.setYearPublish(rawYear);
                        b.setCopyNumber(api.getNewCopyNumber(rawISBN));
                        b.setAddedBy(Integer.parseInt(LibrarySystem.logged.getId()));
                        b.setCategory(cboCategory.getSelectedItem().toString());
                        b.setStatus(Book.STORED);
                        books.add(b);
                    api.insertBook(b);
                }
               int last = api.getNewCopyNumber(rawISBN)-1;
                
                
               String q = "SELECT CONCAT('ISBN : ',isbn) as str_isbn , CONCAT('Copy Number : ',copy_number) as str_copy_num, CONCAT('Title : ',title) as str_title ";
                       q+= "FROM TblBook WHERE isbn = '"+rawISBN+"' AND  (copy_number >= "+simula+"  AND copy_number <= "+last+") "; 
               //this.setCursor();
                       new ReportProcess().generateReport("BookTag.jrxml", "Tag"+rawISBN+"Copy"+ilan+"To"+last+".pdf", q);
                System.out.println(q);
         
        clearForm();
            }
       
        }//end of else
        
       
    }//GEN-LAST:event_btnAddBookActionPerformed
public int cursor = 0;
    private void txtISBNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyPressed
        // TODO add your handling code here:
        int pindot = evt.getKeyCode();
       
       if(((pindot>=48)&&(pindot<=57))||(pindot==8)||(pindot==45)||(pindot==37)||(pindot==39)){
         //  System.out.println("tama");
          String lmn =  txtISBN.getText();
          int cur=txtISBN.getCaretPosition();
          if((cur==lmn.length())||(pindot==37)){
          cur--;
          }
          if(lmn.length()==0){
          cur = 0;
          }
           System.out.println("cur "+cur);
          
       txtISBN.setEditable(true);
       }else{
       txtISBN.setEditable(false);
       }
    }//GEN-LAST:event_txtISBNKeyPressed

    private void txtISBNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtISBNFocusLost
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_txtISBNFocusLost

    private void txtISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyReleased
        // TODO add your handling code here:
        
          String laman =txtISBN.getText();
         if(api.isExist("TblBook", "isbn", laman)){
            //System.out.println("MIRUN NA");
          Book b = api.getBook(laman);
          txtTitle.setText(b.getTitle());
          txtAuthor.setText(b.getAuthor());
          txtPublisher.setText(b.getPublisher());
          cboYear.setSelectedItem(b.getYearPublished());
          cboCategory.setSelectedItem(b.getCategory());
          
          txtTitle.setEditable(false);
          txtAuthor.setEditable(false);
          txtPublisher.setEditable(false);
          cboYear.setEnabled(false);
          cboCategory.setEnabled(false);
        }else{
     
            enableAll();
            clearNotISBN();
        }
    }//GEN-LAST:event_txtISBNKeyReleased

    private void cboYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboYearKeyPressed
        // TODO add your handling code here:
        System.out.println("oh yeah");
    }//GEN-LAST:event_cboYearKeyPressed

    private void cboYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboYearItemStateChanged
        // TODO add your handling code here:
        System.out.println("ah uh");
    }//GEN-LAST:event_cboYearItemStateChanged
   
    public void enableAll(){
        
        txtTitle.setEditable(true);
          txtAuthor.setEditable(true);
          txtPublisher.setEditable(true);
          cboYear.setEnabled(true);
          cboCategory.setEnabled(true);
          
    
    }
    
    public void disableAll(){
        
        txtTitle.setEditable(true);
          txtAuthor.setEditable(true);
          txtPublisher.setEditable(true);
          cboYear.setEnabled(true);
          cboCategory.setEnabled(true);
          
    
    }
    
    public void clearForm(){
    txtTitle.setText("");
    txtAuthor.setText("");
    txtISBN.setText("");
    txtPublisher.setText("");
    cboYear.setSelectedIndex(0);
    cboCopies.setSelectedIndex(0);
    cboCategory.setSelectedIndex(0);
    }
    
    public void clearNotISBN(){
     txtTitle.setText("");
    txtAuthor.setText("");
    //txtISBN.setText("");
    txtPublisher.setText("");
    cboYear.setSelectedIndex(0);
    cboCopies.setSelectedIndex(0);
    cboCategory.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBook;
    private javax.swing.JComboBox cboCategory;
    private javax.swing.JComboBox cboCopies;
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
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}

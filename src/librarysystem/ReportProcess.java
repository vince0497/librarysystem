/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JProgressBar;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import javax.servlet.*;

/**
 *
 * @author Biben
 */



public class ReportProcess {
    JProgressBar bar;
    public ReportProcess(){
       
    }
    
    
       public void loadPdf(String path){
     //Path p = new Path();
    
      //  System.out.println(p.getFileName().toString());
        try{
           File file = new File(path);
    if (file.exists()) 
        
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
    else {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
}
        }catch(Exception oo){
            System.out.println("Expotting pdf "+oo.getMessage());
          //  connect.Error("Nothing is Created!labas","Well");
    }
    }
       
       public boolean isFileExistDelete(String path){
       boolean flag=false;
       File f =new File(path);
      if(f.exists()){
      f.delete();
          System.out.println("dinedelete");
      }
       return flag;
       }
    
    private void load(){
    
    try{
     
                      Class.forName("com.mysql.jdbc.Driver").newInstance();
                         Connection  c = DriverManager.getConnection("jdbc:mysql://localhost/db_library", "root", "");
                        
    JasperDesign jd = JRXmlLoader.load("AddedBook.jrxml");
   
   // BufferedWriter br = new BufferedWriter();
  String que = "SELECT isbn,date_added,title,copy_number,added_by FROM TblBook";
  JRDesignQuery design = new JRDesignQuery();
  design.setText(que);
  jd.setQuery(design);
  
        System.out.println("1");
  JasperReport jr = JasperCompileManager.compileReport(jd);
   System.out.println("2");
  JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), c);
   System.out.println("3");
  String path = "AddedBook.pdf";
   this.isFileExistDelete(path);
  JasperExportManager.exportReportToPdfFile(jp,"AddedBook.pdf");
   System.out.println("4");
  this.loadPdf("AddedBook.pdf");
   System.out.println("5");
    }catch(SQLException e){
        System.out.println("ASas "+e.getMessage());
    }catch(Exception e){
        System.out.println("lahat "+e.getMessage()+" lcalize "+e.getLocalizedMessage());
    }
    
    }
    

    
    public void generateReport(String jrxml,String pdf,String que){
    
         try{
          this.isFileExistDelete(pdf);
      Connection c = getConnection();          
    JasperDesign jd = JRXmlLoader.load(jrxml);
 
  //String que = "SELECT isbn,date_added,title,copy_number,added_by FROM TblBook";
  JRDesignQuery design = new JRDesignQuery();
  design.setText(que);
 
  jd.setQuery(design);
  

        System.out.println("1");
        
  JasperReport jr = JasperCompileManager.compileReport(jd);
   System.out.println("2");
   
  JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), c);
   System.out.println("3");

  
  JasperExportManager.exportReportToPdfFile(jp,pdf);
   System.out.println("4");
  this.loadPdf(pdf);
   System.out.println("5");
   
    }catch(Exception e){
        System.out.println("lahat "+e.getMessage()+" lcalize "+e.getLocalizedMessage());
    }
        
        
        
    }
    
    
    
    public Connection getConnection(){
        Connection  c = null;
    try{
    
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         c = DriverManager.getConnection("jdbc:mysql://localhost/db_library", "root", "");
    }catch(Exception e){
        System.out.println("may mali sa pg connect --> "+e.getMessage());
    }
    
    
        return c;
    }
    
 
}

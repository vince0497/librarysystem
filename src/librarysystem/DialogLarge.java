/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Biben
 */
public class DialogLarge extends JDialog{
    public JFrame frmMain;
    public LibrarySystem ugat;
    public static boolean isOk = false;
    public DialogLarge(JFrame frm,String str, boolean mod){
        super(frm,str,mod);
        this.frmMain = frm;
      
       MyDragger my = new MyDragger(this,true);
       this.addMouseListener(my);
       this.addMouseMotionListener(my);
       // System.out.println("nag mouse lisnten");
    }
    
    public boolean getOk(){
    
    return isOk;
    }
    
    public void addPanel(Component comp){
    
        this.add(comp);
        
    }
    
    public void executeDialog(){
    this.show();
    }
    
    public JFrame getRootPaneDialog(){
    return this.frmMain;
    }
    
    public void setLibrary(LibrarySystem m){
    this.ugat = m;
    }
    public void coverFrame(JPanel pnl){
    
    pnl.setLocation(0, 0);
    pnl.setSize(800, 500);
    pnl.show();
        System.out.println("aasasasas");
    }
    
    public void hideCoverFrame(JPanel pnl){
    pnl.hide();
    }
    

    
}

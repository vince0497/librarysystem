/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Biben
 */
public class MyDialog extends JDialog {
    JFrame ugat;
    
    public MyDialog(JFrame c,String mes,boolean mod){
        super(c,mes,mod);
        this.ugat = c;
        this.setSize(242, 153);
        this.setLocation(500, 300);
        this.setUndecorated(true);
    }
    
    public void disposeDialog(){
    this.dispose();
    }
    
    public void executeDialog(){
    this.show();
    }
    
    public JFrame getRootPaneDialog(){
    return this.ugat;
    }
    
    public void addPanel(Component comp){
    this.add(comp);
    }
    
}

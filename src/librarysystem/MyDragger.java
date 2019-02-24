/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Biben
 */
public class MyDragger extends MouseInputAdapter{
    Component comp;
    int elementX,elementY,pointerX,pointerY;
   public MyDragger(final Component obj, final boolean info){
     //  super();
       this.comp = obj;
       
   }
   
   @Override
   public void mousePressed(MouseEvent e){
   
       if(SwingUtilities.isLeftMouseButton(e)){
           pointerX = e.getXOnScreen();
           pointerY = e.getYOnScreen();
           elementX = this.comp.getLocation().x;
           elementY = this.comp.getLocation().y;
           
       }
       
   }
   
   @Override
   public void mouseDragged(MouseEvent e){
       
       if(SwingUtilities.isLeftMouseButton(e)){
       
           this.comp.setLocation(elementX+(e.getXOnScreen()-pointerX), elementY+(e.getYOnScreen()-pointerY));
       }
   
   }
   
   @Override
   public void mouseReleased(MouseEvent e){
   
   }
    
    
}

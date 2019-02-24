/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author Biben
 */
public class FormValidations {
    
    public FormValidations(){
    
    }
    
    //returns 2 if not match 
    public int validatePassword(String pass1,String pass2){
    int ret = 0;
    boolean ctr=false;
    for(int x=0;x<pass1.length();x++){
      char[]a=  pass1.toCharArray();
      //char[]b = pass2.toCharArray();
      if(( Character.isDigit(a[x]))){
      ctr = true;
     break;
      }
      // Character.isSpaceChar(a);
    }
    
    if((pass1.equals(""))||(pass2.equals(""))){
    ret = 1;
    }
    else if(!pass1.equals(pass2)){
    ret=2;
    
    
    }else if((pass1.length()<=5)||(pass2.length()<=5)){
    ret = 3;
    }else if(!ctr){
    ret = 4;
    }
    
    
    return ret;
    }//end of passwrd confirm
    
    public int checkName(String name){
    int ret = 0;
    return ret;
    }
    
    public boolean isValidName(String name){
        boolean ok = false;
    if(!name.equals("")){
        ok = true;
    }
    return ok;
    }
    //return 1 if blank
    public int validationUsername(String username){
        int ret = 0; 
        
        if(username.equals("")){
        ret = 1;
        }else if(username.length()<=5){
        ret = 2;
        }
        return ret;
    }
    
    public String convertValidName(String name){
    String a = name.trim();
    String num = a.substring(0, 1).toUpperCase()+a.substring(1);
     //   System.out.println("NUM "+num);
    //name[0];
    
        
    return num;
    }
    
}

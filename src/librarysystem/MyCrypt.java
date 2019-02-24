/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Biben
 */
public class MyCrypt 
    {
     private static MessageDigest md;

public String cryptWithMD5(String pass){
  try {
md = MessageDigest.getInstance("MD5");


byte[] passBytes = pass.getBytes();
md.reset();
byte[] digested = md.digest(passBytes);
StringBuffer sb = new StringBuffer();
for(int i=0;i<digested.length;i++){
sb.append(Integer.toHexString(0xff & digested[i]));
}

return sb.toString();

} catch (NoSuchAlgorithmException ex) {

Logger.getLogger(MyCrypt.class.getName()).log(Level.SEVERE, null, ex);
}

return null;
}

public boolean confirmPassword(String encrypted,String not){
boolean flag = false;

if(this.cryptWithMD5(not).equals(encrypted)){
flag = true;
}

return flag;
}


}//my class


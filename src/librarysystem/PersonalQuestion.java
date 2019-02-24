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
public class PersonalQuestion {
    String question, dateAdded;
   public PersonalQuestion(){
   
   }
   
   public void setQuestion(String quest){
   this.question = quest;
   }
   
   public void setDateAdded(String d){
   this.dateAdded = d;
   }
   
   public String getQuestion(){
   return this.question;
   }
   
   public String getDateAdded(){
   return this.dateAdded;
   }
    
}

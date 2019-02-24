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
public class Category {
    String dateAdded,category;
    public Category(){
    
    }
    
    public void setDateAdded(String dat){
    this.dateAdded = dat;
    }
    
    public void setCategory(String cat){
    this.category = cat;
    }
    
    public String getDateAdded(){
    return this.dateAdded;
    }
    
    public String getCategory(){
    return this.category;
    }
    
}

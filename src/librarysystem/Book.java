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
public class Book {
    public static final String BORROWED = "BORROWED",STORED="STORED",ARCHIVED="ARCHIVED";
    private String isbn,title,publisher,author,yearPublish,dateAdded,category,status;
    
    private int copyNumber,addedBy,id,total;
    
    
    public Book(){
    
    }
    
    public void setTotal(int t){
    this.total = t;
    }
    
    public void setStatus(String stat){
    this.status =stat;
    }
    
    public void setISBN(String i){
    this.isbn = i;
    }
    
    public void setId(int i){
    this.id = i;
    }
    
    public void setAddedBy(int librarianId){
    this.addedBy = librarianId;
    }
    
    public void setTitle(String i){
    this.title = i;
    }
    
    public void setPublisher(String i){
    this.publisher = i;
    }
    
    public void setAuthor(String i){
    this.author = i;
    }
    
    public void setYearPublish(String i){
    this.yearPublish = i;
    }
    
    public void setCopyNumber(int i){
    this.copyNumber = i;
    }
    
    public void setDateAdded(String d){
    this.dateAdded = d;
    }
    
    public void setCategory(String cat){
    this.category = cat;
    }
    
    //accessor
    
    public int getAddedBy(){
    return this.addedBy;
    }
    
    public String getISBN(){
    return this.isbn;
    }
    
    public String getTitle(){
    return this.title;
    }
    
    public String getAuthor(){
    return this.author;
    }
    
    public String getPublisher(){
    return this.publisher;
    }
    
    public String getYearPublished(){
    return this.yearPublish;
    }
    
    public int getCopyNumber(){
    return this.copyNumber;
    }
    
    public String getDateAdded(){
    return this.dateAdded;
    }
    public int getId(){
    return this.id;
    }
    
    public String getCategory(){
    return this.category;
    }
    
    public int getTotal(){
    return this.total;
    }
    
    public String getStatus(){
    return this.status;
    }
    
}//end if classs

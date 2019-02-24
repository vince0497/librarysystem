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
public class Material {
    
    private String name,addedBy,dateAdded,status,dateBorrowed;
    private int id;
        public final static String STORED="STORED",BORROWED="BORROWED",ARCHIVE="ARCHIVED",ID = "ID", NAME = "Name",STATUS="Status",BORROWER="Borrower";

    public Material(){}
    
    public void setName(String n){name = n;}
    public void setAddedBy(String n){addedBy = n;}
    public void setDateAdded(String n){dateAdded = n;}
    public void setId(int n){id= n;}
    public void setStatus(String n){status = n;}
    public void setDateBorrow(String n){dateBorrowed = n;}
    
    public String getName(){return this.name;}
    public String getAddedBy(){return this.addedBy;}
    public String getDateAdded(){return this.dateAdded;}
    public int getId(){return this.id;}
    public String getStatus(){return this.status;}
   public String getDateBorrowed(){return this.dateBorrowed;}
}

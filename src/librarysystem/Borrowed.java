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
public class Borrowed {
    private String isbn,dateBorrow;
   private int borrowId,borrower,copyNum,assess,bookId;
    public Borrowed(){}
    
    public void setISBN(String i){this.isbn = i;}
    public void setDateBorrow(String i){this.dateBorrow = i;}
    public void setBorrowID(int i){this.borrowId = i;}
    public void setBorrower(int i){this.borrower = i;}
    public void setCopyNumber(int i){this.copyNum = i;}
    public void setAssessBy(int i){this.assess = i;}
    public void setBookId(int i){this.bookId = i;}
    
    public String getISBN(){return this.isbn;}
    public String getDateBorrow(){return this.dateBorrow;}
    public int getBorrowID(){return this.borrowId;}
    public int getBorrower(){return this.borrower;}
    public int getCopyNumber(){return this.copyNum;}
    public int getAssessBy(){return this.assess;}
    public int getBookId(){return this.bookId;}
    

}

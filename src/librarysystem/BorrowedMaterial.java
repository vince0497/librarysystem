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
public class BorrowedMaterial {
    
    int materialId,borrower,assess,missedDay;
    double penaltyCost;
    String dateBor;
    
    public BorrowedMaterial(){}
    
    public void setId(int n){materialId = n;}
    public void setBorrower(int n){borrower = n;}
    public void setAssessBy(int n){assess = n;}
    public void setDateBorrowed(String n){dateBor = n;}
    public void setPenaltyCost(double cost){this.penaltyCost = cost;}
    public void setMissedDays(int day){this.missedDay = day;}
    
    
    public int getId(){return this.materialId;}
    public int getBorrower(){return this.borrower;}
    public int getAssessBy(){return this.assess;}
    public String getDateBorrowed(){return this.dateBor;}
    public double getPenaltyCost(){return this.penaltyCost;}
    public int getMissedDay(){return this.missedDay;}
   
    
   
    
}

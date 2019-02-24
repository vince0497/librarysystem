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
public class Faculty {
    public static final String FNAME="First Name",MNAME="Middle Name",LNAME="Last Name",ID="ID";
    private String fname,mname,lname,gender,birthdate,dateAdded,id,address,gradeSec,status;
    private int addedBy;
    
    public void setFName(String n){this.fname = n;}
    public void setMName(String n){this.mname = n;}
    public void setLName(String n){this.lname = n;}
    public void setGender(String n){this.gender = n;}
    public void setBirthdate(String n){this.birthdate = n;}
    public void setDateAdded(String n){this.dateAdded = n;}
    public void setId(String n){this.id = n;}
    public void setGradeSec(String n){this.gradeSec = n;}
    public void setStatus(String n){this.status = n;}
    public void setAddedBy(int n){this.addedBy = n;}
    public void setAddress(String n){this.address = n;}
    
    
    public String getFName(){return this.fname;}
    public String getMName(){return this.mname;}
    public String getLName(){return this.lname;}
    public String getGender(){return this.gender;}
    public String getBirthdate(){return this.birthdate;}
    public String getDateAdded(){return this.dateAdded;}
    public int getAddedBy(){return this.addedBy;}
    public String getId(){return this.id;}
    public String getFullName(){return this.fname+" "+this.mname+" "+this.lname;}
    public String getAddress(){return this.address;}
    public String getGradeSec(){return this.gradeSec;}
    public String getStatus(){return this.status;}
    
}

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
public class Student {
    static final String DROPPED = "DROPPED";
    static final String ON_SCHOOL = "ON_SCHOOL";
    static final String GRADUATED = "GRADUATED",FACULTY="FACULTY";
    private String studNo,fName,mName,lName,gender,birthdate,section,address,dateAdded,status;
    private int addedBy;
    public Student(){}
    
    public void setFName(String f){this.fName = f;}
    public void setMName(String f){this.mName = f;}
    public void setLName(String f){this.lName = f;}
    public void setGender(String f){this.gender = f;}
    public void setBirthdate(String f){this.birthdate = f;}
    public void setGradeSection(String f){this.section = f;}
    public void setAddress(String f){this.address = f;}
    public void setDateAdded(String f){this.dateAdded = f;}
    public void setAddedBy(int f){this.addedBy = f;}
    public void setStudentNum(String f){this.studNo = f;}
     public void setStatus(String f){this.status = f;}
    
    public String getFName(){return this.fName;}
    public String getMName(){return this.mName;}
    public String getLName(){return this.lName;}
    public String getGender(){return this.gender;}
    public String getBirthdate(){return this.birthdate;}
    public String getGradeSection(){return this.section;}
    public String getAddress(){return this.address;}
    public String getDateAdded(){return this.dateAdded;}
    public String getStudentNo(){return this.studNo;}
    public int getAddedBy(){return this.addedBy;}
    public String getFullName(){return this.fName+" "+mName+" "+lName;}
    public String getStatus(){return this.status;}
    
}

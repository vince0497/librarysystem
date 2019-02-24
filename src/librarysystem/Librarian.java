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
public class Librarian {
    static final String MALE = "Male";
    static final String FEMALE = "Female",HEAD_LIBRARIAN = "HEAD_LIBRARIAN",LIBRARIAN = "LIBRARIAN";
   
    //final static int a=0;
    private String id,fName,mName,lName,bdate,gender,password,username,question,ans,address,position,dateHired;
    private int attempts=0;
    public Librarian(){
    
    }
    
    //mutators
    
    public void setId(String iden){
    this.id = iden;
    }
    
    public void setAttempts(int att){
    this.attempts = att;
    }
    
    public void setFName(String fname){
    this.fName = fname;
    }
    
    public void setMName(String mname){
    this.mName = mname;
    }
    
   public void setLName(String lname){
    this.lName = lname;
    }
   
   public void setGender(String gend){
    this.gender = gend;
    }
   
    public void setPassword(String pw){
    this.password = pw;
    }
 
    public void setUsername(String un){
    this.username = un;
    }
        
    public void setBirthdate(String bd){
    this.bdate = bd;
    }
    
    public void setQuestion(String quest){
    this.question  = quest; 
    }
    
    public void setAnswer(String an){
    this.ans = an;
    }
    
    public void setAddress(String add){
    this.address = add;
    }
    
    public void setPosition(String post){
    this.position = post;
    }
    
    public void setDateHired(String unix){
    this.dateHired = unix;
    }
    
    //accessors
    public String getId(){
    return this.id;
    }
    
    public String getFName(){
    return this.fName;
    }
    
    public String getMName(){
    return this.mName;
    }
    public String getLName(){
    return this.lName;
    }
    public String getGender(){
    return this.gender;
    }
    public String getBirthdate(){
    return this.bdate;
    }
    public String getUsername(){
    return this.username;
    }
    public String getPassword(){
    return this.password;
    }
    
    public String getQuestion(){
    return this.question;
    }
    
    public String getAnswer(){
    return this.ans;
    }
    
    public String getAddress(){
    return this.address;
    }
    
    public String getPosition(){
    return this.position;
    }
    
    public String getDateHired(){
    return this.dateHired;
    }
    
    public String getFullName(){
    return this.fName+" "+this.mName+" "+this.lName;
    }
    
    public int getAttempts(){
    return this.attempts;
    }
    
    
    
}//end of class

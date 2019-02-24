/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Biben
 */
public class MySQLAPI {
    Connection con = null;
    Statement stm = null;
    ResultSet rs = null;
  
    public SimpleDateFormat sdf;
    
    boolean isProblem = false;
    
    static final String DEFAULT_CONNECTION = "jdbc:mysql://localhost:3306/db_library";
    static final String DEFAULT_USERNAME = "root";
    static final String DEFAULT_PASSWORD = "";
    
    public void connect(String url,String user,String pass){
    try{
            this.con = DriverManager.getConnection(url , user, pass);
            if(this.con.isClosed()){
                System.out.println("sarado");
            }
        }catch(SQLException e){
            this.isProblem = true;
            System.out.println(e.getMessage());
        }
    sdf = new SimpleDateFormat("MM/dd/YYYY");
    }
    
    public MySQLAPI(){
     //api = new MySQLAPI("jdbc:mysql://localhost:3306/db_library","root","");
    this.connect(DEFAULT_CONNECTION, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    sdf = new SimpleDateFormat("MM/dd/YYYY");
    
    }
    
    
    
    public MySQLAPI(String url,String user,String pass){
        try{
            this.con = DriverManager.getConnection(url , user, pass);
            if(this.con.isClosed()){
                System.out.println("sarado");
            }
        }catch(SQLException e){
            this.isProblem = true;
            System.out.println(e.getMessage());
        }
        
    }//end of cosntructor
    
    
    
   public boolean isDatabaseHaveProblem(){
   
   return this.isProblem;
   }
   
   
   public String convertLibrarianIntoInsert(Librarian lib){
   String que = "INSERT INTO tblproposedlib (username,password,f_name,m_name,l_name,gender, ";
      que += " address, position_lib, date_hired, birthdate, personal_question, personal_answer,accepted) VALUES ";
      que += " ( '"+lib.getUsername()+"' , '"+lib.getPassword()+"' , '"+lib.getFName()+"' , '";
      que += lib.getMName()+"' , '"+lib.getLName()+"' ,'"+lib.getGender()+"' ";
             que += ", '"+lib.getAddress()+"' ";
      que += ", '"+lib.getPosition()+"' , '"+lib.getDateHired()+"','"+lib.getBirthdate()+"' , '"+lib.getQuestion()+"' , '"+lib.getAnswer()+"',false )";
      return que;
   }
   
   
   public void insertToTable(String que){
       
       try{
       this.stm = this.con.createStatement();
      
       this.stm.executeUpdate(que);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
   
   }//insert
   
   public ArrayList<PersonalQuestion> getAllQuestion(){
   ArrayList<PersonalQuestion> arr=new ArrayList<PersonalQuestion>();
   
   try{
       String que = "SELECT question,date_added FROM TblQuestion";
   
       this.stm = this.con.createStatement();
      this.rs = stm.executeQuery(que);
      
      while(this.rs.next()){
        PersonalQuestion q=  new PersonalQuestion();
        q.setQuestion(this.rs.getString("question"));
        q.setDateAdded(this.rs.getString("date_added"));
        arr.add(q);

      
      }
   }catch(SQLException e){
       System.out.println(e.getMessage());
   }
   return arr;
   }
   
   public ArrayList<Librarian> getLibrarian(String que){
   ArrayList<Librarian> arr = new ArrayList<Librarian>();
   
   try{
  this.stm = this.con.createStatement();
  this.rs = this.stm.executeQuery(que);
  
  while(this.rs.next()){
  Librarian lib = new Librarian();
  lib.setId(this.rs.getString("librarian_id"));
  lib.setFName(this.rs.getString("f_name"));
  lib.setMName(this.rs.getString("m_name"));
  lib.setLName(this.rs.getString("l_name"));
  lib.setUsername(this.rs.getString("username"));
  lib.setPassword(this.rs.getString("password"));
  lib.setAddress("");
  lib.setPosition(this.rs.getString("position_lib"));
  lib.setDateHired(this.rs.getString("date_hired"));
  lib.setBirthdate(this.rs.getString("birthdate"));
  lib.setQuestion(this.rs.getString("personal_question"));
  lib.setAnswer(this.rs.getString("personal_answer"));
  lib.setAttempts(this.rs.getInt("attempts"));
 arr.add(lib);
  }
  
   }catch(SQLException e){
       System.out.println(e.getMessage());
   }
   return arr;
   }
   
   public int countTable(String tblName){
   int bilang = 0;
   try{
       String que = "SELECT COUNT(*) as 'NumRow' FROM "+tblName+" ";
  this.stm = this.con.createStatement();
  this.rs = this.stm.executeQuery(que);
  this.rs.next();
  bilang=this.rs.getInt("NumRow");
   }catch(SQLException e){
       System.out.println("pgbilang ng row --> "+e.getMessage());
   }
   
   return bilang;
   }
   
   
   public ArrayList<Librarian> getLibrarianFilter(String field, String keyword){
   ArrayList<Librarian> arr = new ArrayList<Librarian>();
   String que = "";
    que += "SELECT librarian_id, f_name, m_name,l_name,  ";
     que += "username, password,address,birthdate,personal_question,personal_answer ";
    que += ",position_lib , date_hired,attempts FROM TblLibrarian ";
        
   switch(field){
       
       case "*":{
           
           break;}
       
       case "Firstname":{
           que += "WHERE f_name LIKE '%"+keyword+"%' ";
           break;}
       case "Lastname":{
           que += "WHERE l_name LIKE '%"+keyword+"%' ";
           break;}
       case "Middlename":{
           que += "WHERE m_name LIKE '%"+keyword+"%' ";
           break;}
       case "LibrarianID":{
          que += "WHERE librarian_id LIKE '%"+keyword+"%' ";
       break;}
       
       case "Position":{
              que += "WHERE position_lib LIKE '%"+keyword+"%' ";
           break;}
       case "Date_hired":{
              que += "WHERE date_hired LIKE '%"+keyword+"%' ";
           break;}
   }
   
   
   
   try{
  this.stm = this.con.createStatement();
  this.rs = this.stm.executeQuery(que);
  
  while(this.rs.next()){
  Librarian lib = new Librarian();
  lib.setId(this.rs.getString("librarian_id"));
  lib.setFName(this.rs.getString("f_name"));
  lib.setMName(this.rs.getString("m_name"));
  lib.setLName(this.rs.getString("l_name"));
  lib.setUsername(this.rs.getString("username"));
  lib.setPassword(this.rs.getString("password"));
  lib.setAddress("");
  lib.setPosition(this.rs.getString("position_lib"));
  lib.setDateHired(this.rs.getString("date_hired"));
  lib.setBirthdate(this.rs.getString("birthdate"));
  lib.setQuestion(this.rs.getString("personal_question"));
  lib.setAnswer(this.rs.getString("personal_answer"));
  lib.setAttempts(this.rs.getInt("attempts"));
 arr.add(lib);
  }
  
   }catch(SQLException e){
       System.out.println(e.getMessage());
   }
   return arr;
   }//end of array listlibrraia fileter 
   
   
   public boolean isUsernameExist(String un){
   boolean bol=false;
   
   try{
       String que = "SELECT username FROM TblLibrarian WHERE username = '"+un+"' ";
  this.stm =this.con.createStatement();
 this.rs = stm.executeQuery(que);
 if(this.rs.next()){
 bol=true;
 }
   }catch(SQLException e){
       System.out.println("username checking if exist -->"+e.getMessage());
   }
   
   return bol;
   
   
   }//end if usenam iexist
   
   
   public boolean isExist(String tableName,String field,String data){
   boolean f = false;
   
    try{
       String que = "SELECT "+field+" FROM "+tableName+" WHERE "+field+" = '"+data+"' ";
  this.stm =this.con.createStatement();
 this.rs = stm.executeQuery(que);
 if(this.rs.next()){
 f=true;
 }
   }catch(SQLException e){
       System.out.println("searching checking if exist -->"+e.getMessage());
   }
   
   return f;
   }
   
   
   
   
   public Librarian getSpecificLibrarian(int id){
    Librarian lib = new Librarian();
   try{
      String que = "SELECT librarian_id, f_name, m_name,l_name,gender,  ";
     que += "username, password,address,birthdate,personal_question,personal_answer ";
    que += ",position_lib , date_hired,attempts FROM TblLibrarian WHERE librarian_id = "+id;
  stm= con.createStatement();
  rs=stm.executeQuery(que);
  
  if(this.rs.next()){
 
  lib.setId(this.rs.getString("librarian_id"));
  lib.setFName(this.rs.getString("f_name"));
  lib.setMName(this.rs.getString("m_name"));
  lib.setLName(this.rs.getString("l_name"));
  lib.setGender(this.rs.getString("gender"));
  lib.setUsername(this.rs.getString("username"));
  lib.setPassword(this.rs.getString("password"));
  lib.setAddress("");
  lib.setPosition(this.rs.getString("position_lib"));
  lib.setDateHired(this.rs.getString("date_hired"));
  lib.setBirthdate(this.rs.getString("birthdate"));
  lib.setQuestion(this.rs.getString("personal_question"));
  lib.setAnswer(this.rs.getString("personal_answer"));
 lib.setAttempts(this.rs.getInt("attempts"));
  }
  
  
   }catch(SQLException e){
       System.out.println("specific librarian -0-> "+e.getMessage());
   }
   return lib;
   }//getSpecific
 
   
   
   public int getIdOfUsername(String username){
   int ret = -1;
   try{
       String que = "SELECT librarian_id FROM TblLibrarian WHERE username = '"+username+"' ";
  stm = con.createStatement();
 rs = stm.executeQuery(que);
  if(rs.next()){
  ret=rs.getInt("librarian_id");
  }
   }catch(SQLException e){
   }
   return ret;
   }
   
   
 
   
   
  
   public int login(String un,String pass){
   int ret = 0;
   boolean mayUsername=false,tamaPass = false;
   
   String que = "SELECT username,password FROM TblLibrarian ";
   try{
   this.stm = this.con.createStatement();
   this.rs = this.stm.executeQuery(que);
   
   while(this.rs.next()){
  String username = this.rs.getString("username");
  String password =  this.rs.getString("password");
  if(username.equals(un)){
      mayUsername = true;
      if(new MyCrypt().confirmPassword(password, pass)){
      tamaPass=true;
      break;
      }
      
  }else{
  
  }
  
   }//end of while
   
   }catch(Exception e){
       System.out.println(e.getMessage());
   }
   
   if(mayUsername==false){
       ret = 1;
   }else if(tamaPass==false){
   ret = 2;
   }
   
   return ret;
   }
   
   
   
   public void insertBook(Book b){
   String que = "INSERT INTO TblBook(isbn,copy_number,title,author,publisher,year_published,date_added,added_by,category,status) VALUES  ";
   que += "( '"+b.getISBN()+"' , "+b.getCopyNumber()+" , '"+b.getTitle()+"' ,  '"+b.getAuthor()+"' ";
   que += " , '"+b.getPublisher()+"' , '"+b.getYearPublished()+"' , '"+b.getDateAdded()+"' , "+b.getAddedBy()+", '"+b.getCategory()+"','"+b.getStatus()+"' ) ";
           
       this.insertToTable(que);
   
   }//end of insert book
   
   public void insertStudent(Student s){
   String que = "INSERT INTO TblStudent(stud_no,f_name,m_name,l_name,gender,birthdate,address,grade_sec,date_added,added_by,status)";
   que += "VALUES ("+s.getStudentNo()+", '"+s.getFName()+"' , '"+s.getMName()+"' , '"+s.getLName()+"'  ,'"+s.getGender()+"', ";
   que += " '"+s.getBirthdate()+"' ,'"+s.getAddress()+"', '"+s.getGradeSection()+"' , '"+System.currentTimeMillis()+"', "+s.getAddedBy()+", '"+s.getStatus()+"' ) ";
   
   this.insertToTable(que);
   
   }
   
   public int getNewCopyNumber(String isbn){
   int num = 0;
   
   String que = "SELECT copy_number FROM TblBook WHERE isbn = '"+isbn+"' ";
   que+=" ORDER BY copy_number ASC";
   try{
  stm = this.con.createStatement();
  rs = stm.executeQuery(que);
  
  while(rs.next()){
  num = rs.getInt("copy_number");
  }
num++;  
   }catch(SQLException e){
       System.out.println("getting last copy num -->"+e.getMessage());
   }
   return num;
   }
   
   public Book getBook(String isbn){
   Book b= new Book();
   String que = "SELECT book_id,isbn,copy_number,title,author,publisher,year_published,date_added,added_by,category,COUNT(*) as 'count_book' FROM TblBook ";
   que += "WHERE isbn = '"+isbn+"' ";
   try{
   stm = con.createStatement();
  rs= stm.executeQuery(que);
  if(rs.next()){
  b.setId(rs.getInt("book_id"));
  b.setISBN(rs.getString("isbn"));
  b.setCopyNumber(rs.getInt("copy_number"));
  b.setTitle(rs.getString("title"));
  b.setAuthor(rs.getString("author"));
  b.setPublisher(rs.getString("publisher"));
  b.setYearPublish(rs.getString("year_published"));
  b.setDateAdded(rs.getString("date_added"));
  b.setCategory(rs.getString("category"));
b.setAddedBy(rs.getInt("added_by"));
b.setTotal(rs.getInt("count_book"));
  
  }
   }catch(SQLException e){
       System.out.println("getting book by isbn --> "+e.getMessage());
   }
   
   return b;
   }

   
   
   
     public Book getSpecificBook(int id){
   Book b= new Book();
   String que = "SELECT book_id,isbn,copy_number,title,author,publisher,year_published,date_added,added_by,category,status FROM TblBook ";
   que += "WHERE book_id = "+id+" ";
   try{
   stm = con.createStatement();
  rs= stm.executeQuery(que);
  if(rs.next()){
      
  b.setId(rs.getInt("book_id"));
  b.setISBN(rs.getString("isbn"));
  b.setCopyNumber(rs.getInt("copy_number"));
  b.setTitle(rs.getString("title"));
  b.setAuthor(rs.getString("author"));
  b.setPublisher(rs.getString("publisher"));
  b.setYearPublish(rs.getString("year_published"));
  b.setDateAdded(rs.getString("date_added"));
  b.setCategory(rs.getString("category"));
b.setAddedBy(rs.getInt("added_by"));
b.setStatus(rs.getString("status"));
  
  }
   }catch(SQLException e){
       System.out.println("getting book by isbn --> "+e.getMessage());
   }
   
   return b;
   }

   
   
   
   
   
   
   public ArrayList<Book> getBooks(String isbn){
       ArrayList<Book> arr = new ArrayList<Book>();
   
   String que = "SELECT book_id,isbn,copy_number,title,author,publisher,year_published,date_added,added_by,category,status  FROM TblBook ";
   que += "WHERE isbn = '"+isbn+"' ";
   try{
   stm = con.createStatement();
  rs= stm.executeQuery(que);
  while(rs.next()){
      Book b= new Book();
  b.setId(rs.getInt("book_id"));
  b.setISBN(rs.getString("isbn"));
  b.setCopyNumber(rs.getInt("copy_number"));
  b.setTitle(rs.getString("title"));
  b.setAuthor(rs.getString("author"));
  b.setPublisher(rs.getString("publisher"));
  b.setYearPublish(rs.getString("year_published"));
  b.setDateAdded(new Date(Long.parseLong(rs.getString("date_added"))).toLocaleString());
  b.setCategory(rs.getString("category"));
b.setAddedBy(rs.getInt("added_by"));
b.setStatus(rs.getString("status"));
//b.setTotal(rs.getInt("count_book"));
  arr.add(b);
  }
   }catch(SQLException e){
       System.out.println("getting book by isbn --> "+e.getMessage());
   }
   
   return arr;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
 
   
   
   //use for searching book
   public ArrayList<Book> getPackedBook(String cat,String val){
   ArrayList<Book> book = new ArrayList<Book>();
   try{
       String que = "SELECT DISTINCT isbn,title,author,publisher,category,year_published FROM TblBook ";
       
       switch(cat){
           case "Title":{
               que+= " WHERE title LIKE '%"+val+"%' ";
               break;}
           
           case "Author":{
           que += "WHERE author LIKE '%"+val+"%'";
           break;}
           
           case "ISBN":{
               que += "WHERE isbn LIKE '%"+val+"%'";
           break;
           }
           
           case "Publisher":{
               que += "WHERE publisher LIKE '%"+val+"%'";
           break;
           }
           
           case "Category":{
               que += "WHERE category LIKE '%"+val+"%'";
           break;
           }
           
           case "Year":{
               que += "WHERE year_published LIKE '%"+val+"%'";
           break;
           }
           
           
       
       }//end of case
       
       
  stm = con.createStatement();
  rs = stm.executeQuery(que);
  while(rs.next()){
     Book b= new Book();
     b.setISBN(rs.getString("isbn"));
  b.setTitle(rs.getString("title"));
  b.setAuthor(rs.getString("author"));
  b.setPublisher(rs.getString("publisher"));
  b.setCategory(rs.getString("category"));
 book.add(b);
  }
  
   }catch(SQLException e){
       System.out.println("mali sa getpacked book--> "+e.getMessage());
   }
   return book;
   }
   
   
   
  
   
   
   
   
   
   
   public ArrayList<Student> getStudentFilter(String field,String specimen){
   ArrayList<Student> s = new ArrayList<Student>();
        String que = "SELECT stud_no,f_name,m_name,l_name,gender,birthdate,address,grade_sec,date_added,added_by,status FROM TblStudent WHERE  grade_sec != '"+Student.FACULTY+"'  ";
  
   switch(field){
       case "StudNo":{
           que += " AND stud_no LIKE '%"+specimen+"%' ";
       break;}
       
       case "FirstName":{
           que += " AND f_name LIKE '%"+specimen+"%' ";
           break;}
       
       case "MiddleName":{
       que += " AND m_name LIKE '%"+specimen+"%' ";
       break;}
       
       case "LastName":{
           que += " AND l_name LIKE '%"+specimen+"%' ";
           break;}
       
       case "Birthdate":{
           que += " AND birthdate LIKE '%"+specimen+"%' ";
           break;}
       case "Grade-Section":{
           que += " AND grade_sec LIKE '%"+specimen+"%' ";
           break;}
   
   }
   
   try{
       
   stm = con.createStatement();
   rs = stm.executeQuery(que);
   
   while(rs.next()){
   Student d = new Student();
   d.setStudentNum(rs.getInt("stud_no")+"");
   d.setFName(rs.getString("f_name"));
   d.setMName(rs.getString("m_name"));
   d.setLName(rs.getString("l_name"));
   d.setBirthdate(rs.getString("birthdate"));
   d.setAddress(rs.getString("address"));
   d.setGradeSection(rs.getString("grade_sec"));
   d.setDateAdded(rs.getString("date_added"));
   d.setAddedBy(rs.getInt("added_by"));
   d.setStatus(rs.getString("status"));
   s.add(d);
   }
   
   }catch(SQLException e){
       System.out.println("pagkuha ng student filter --> "+e.getMessage());
   }
   
   return s;
   }
   
   
   
   public ArrayList<Category> getAllCategory(){
   ArrayList<Category> cat = new ArrayList<Category>();
   String que = "SELECT category,date_added FROM TblBookCategory ";
   try{
   stm = con.createStatement();
   rs = stm.executeQuery(que);
   while(rs.next()){
   Category b = new Category();
   b.setCategory(rs.getString("category"));
   b.setDateAdded(rs.getString("date_added"));
  cat.add(b);
   
   }
   
   }catch(SQLException e){
       System.out.println("error getting all category --> "+e.getMessage());
   }
   
   return cat;
   }
   
   
   
 public ArrayList getAllGradeSection(){
 ArrayList arr = new ArrayList();
 try{
     String que = "SELECT grade_sec,date_added FROM TblGradeSec";
 stm=con.createStatement();
 rs =stm.executeQuery(que);
 while(rs.next()){
 String sec =rs.getString("grade_sec");
 arr.add(sec);
 }
 }catch(SQLException e){
     System.out.println("getting al grades sect --> "+e.getMessage());
 }
 
 return arr;
 }
 
 
 public int getCountStudentInSection(String section){
 int ilan = 0;
 String que = "SELECT COUNT(*) as bilang FROM TblStudent S WHERE S.grade_sec = '"+section+"' ";
 try{
 stm =con.createStatement();
 rs = stm.executeQuery(que);
 if(rs.next()){
 ilan = rs.getInt("bilang");
 }
 }catch(SQLException e){
     System.out.println(" kuha ilang studrnt  sa section "+e.getMessage());
 }
 return ilan;
 }
 
 
 public int getCountOf(String tblName,String field,String specimen){
 
     int bilang=0;
     
     String que = "SELECT COUNT(*) as bilang FROM "+tblName+"  WHERE "+field+" = '"+specimen+"' ";
     try{
     stm = con.createStatement();
     rs = stm.executeQuery(que);
     if(rs.next()){
     bilang = rs.getInt("bilang");
     }
     }catch(SQLException e){
         System.out.println(" pagiblang ng row mali beybe "+e.getMessage());
     }
     return bilang;
 }
 
 
  public int getCountOf(String tblName,String field,int specimen){
 
     int bilang=0;
     
     String que = "SELECT COUNT(*) as bilang FROM "+tblName+"  WHERE "+field+" = "+specimen+" ";
     try{
     stm = con.createStatement();
     rs = stm.executeQuery(que);
     if(rs.next()){
     bilang = rs.getInt("bilang");
     }
     }catch(SQLException e){
         System.out.println(" pagiblang ng row mali beybe "+e.getMessage());
     }
     return bilang;
 }
 
 
 
 public void updateBook(Book b,Book old){
 
 try{
     String que = "UPDATE TblBook SET title ='"+b.getTitle()+"',  author = '"+b.getAuthor()+"' , ";
que += "publisher = '"+b.getPublisher()+"' , year_published ='"+b.getYearPublished()+"' , ";
que += "category = '"+b.getCategory()+"' WHERE  isbn = '"+old.getISBN()+"' ";
     stm= con.createStatement();
stm.executeUpdate(que);

//que = "UPDATE TblBorrowed SET ";

 }catch(SQLException e){
     System.out.println("pag update ng buk --> "+e.getMessage());
 }
 }
 
 
 public ArrayList<Book> getAvailableBooks(Book basehan){
ArrayList<Book> b = new ArrayList<Book>();
String que = "SELECT B.book_id,B.isbn,B.copy_number,B.title,B.author,B.publisher,B.year_published,B.date_added, ";
que += "B.added_by,B.category FROM TblBook B WHERE isbn = '"+basehan.getISBN()+"' ";
 que += "AND B.status='STORED'";
           // String q = "SELECT book_id FROM TblBorrowed WHERE id != B.bookId ";
try{
stm=con.createStatement();
rs = stm.executeQuery(que);
while(rs.next()){
Book buk = new Book();

   
  
   buk.setISBN(rs.getString("isbn"));
   buk.setId(rs.getInt("book_id"));
   buk.setTitle(rs.getString("title"));
   buk.setAuthor(rs.getString("author"));
   buk.setCopyNumber(rs.getInt("copy_number"));
   buk.setPublisher(rs.getString("publisher"));
   buk.setYearPublish(rs.getString("year_published"));
   buk.setDateAdded(rs.getString("date_added"));
    b.add(buk);
}
}catch(SQLException e){
    System.out.println("mali pg kuha avail buk "+e.getMessage());
}
return b;
 }
 
 
 
 
 
 public Student getSpecificStudent(int num){
 Student st = new Student();
 try{
  String que = "SELECT stud_no,f_name,m_name,l_name,birthdate,address,grade_sec,date_added,added_by,status FROM TblStudent "; 
  que += " WHERE stud_no = "+num+" ";
 stm =con.createStatement();
 rs  = stm.executeQuery(que);
 if(rs.next()){
     st.setStudentNum(rs.getInt("stud_no")+"");
     st.setFName(rs.getString("f_name"));
     st.setMName(rs.getString("m_name"));
     st.setLName(rs.getString("l_name"));
     st.setBirthdate(rs.getString("birthdate"));
     st.setAddress(rs.getString("address"));
     st.setGradeSection(rs.getString("grade_sec"));
     st.setDateAdded(rs.getString("date_added"));
     st.setAddedBy(rs.getInt("added_by"));
     st.setStatus(rs.getString("status"));
  
 }
 }catch(SQLException e){
 }
 return st;
 }
 
 
 
 
 
 
 public Material getSpecificMaterial(int matId){
 
 Material m = new Material();
 String que = "SELECT material_id,material_name,date_added,added_by,status_mat FROM TblMaterial WHERE material_id="+matId+" ";
 try{
  stm = con.createStatement();
 rs = stm.executeQuery(que);
 if(rs.next()){
 m.setId(rs.getInt("material_id"));
 m.setName(rs.getString("material_name"));
 m.setDateAdded(rs.getString("date_added"));
 m.setAddedBy(rs.getInt("added_by")+"");
 m.setStatus(rs.getString("status_mat"));
 
 }
 }catch(SQLException e){
 
 }
 return m;
 }
 
 
 //this is for universla user
 
public String getData(String tbl,String compare,int specimen,String fieldToGet){
    
    String que = "SELECT "+fieldToGet+" FROM "+tbl+"  WHERE "+compare+" = "+specimen+" ";
    String kuha = "";
    try{
    stm = con.createStatement();
    rs =stm.executeQuery(que);
    if(rs.next()){
    kuha = rs.getString(fieldToGet);
    }
    }catch(SQLException e){
        System.out.println("get data error "+e.getMessage());
    }
    return kuha;

}



public BorrowedMaterial getSpecificBorrowedMaterial(int id){
BorrowedMaterial b= new BorrowedMaterial();

String que = "SELECT material_id,borrowed_by,assess_by,date_borrowed FROM TblBorrowedMaterial WHERE material_id = "+id+" ";
try{
stm = con.createStatement();
rs = stm.executeQuery(que);
if(rs.next()){

    b.setId(rs.getInt("material_id"));
    b.setBorrower(rs.getInt("borrowed_by"));
    b.setAssessBy(rs.getInt("assess_by"));
    b.setDateBorrowed(rs.getString("date_borrowed"));
    
    long diff=Long.parseLong(rs.getString("date_borrowed"));
    int day = this.getDiffDays(this.getMilliNow(), diff);
    double price = this.getPricePenalty(day, this.getRatePerDay());
    
    b.setMissedDays(day);
    b.setPenaltyCost(price);
   
}
}catch(SQLException e){
    System.out.println("borrowed material erro "+e.getMessage());
}
return b;

}


 
 
 public Faculty getSpecificFaculty(int id){
 Faculty f = new Faculty();
 String que = "SELECT stud_no,f_name,m_name,l_name,gender,birthdate,address,grade_sec,date_added,added_by,status  FROM TblStudent WHERE stud_no = "+id+" ";
 try{
 stm = con.createStatement();
 rs = stm.executeQuery(que);
 
 if(rs.next()){
     f.setId(rs.getString("stud_no"));
     f.setFName(rs.getString("f_name"));
     f.setMName(rs.getString("m_name"));
     f.setLName(rs.getString("l_name"));
     f.setGender(rs.getString("gender"));
     f.setAddress(rs.getString("address"));
     f.setDateAdded(rs.getString("date_added"));
     f.setBirthdate(rs.getString("birthdate"));
     f.setAddedBy(rs.getInt("added_by"));
     f.setStatus(rs.getString("status"));
     f.setGradeSec(rs.getString("grade_sec"));
     
 
 }
 }catch(SQLException e){
     System.out.println("mali beybe pagkuha fauclty "+e.getMessage());
 
 }
 
 
 return f;
 }
 
 
 
 
 
 
 
 
 
 
 
 public int getBookId(String isbn,int copyNum){
 int x=0;
 
 try{
     String que = "SELECT book_id FROM TblBook WHERE isbn='"+isbn+"' AND copy_number = "+copyNum+" ";
stm = con.createStatement();
rs = stm.executeQuery(que);
 if(rs.next()){
 x = rs.getInt("book_id");
 }
 }catch(SQLException e){
     System.out.println("kuwa book id "+e.getMessage());
 }
 return x;
 }
 
 
 public void setUpdateStatusTo(String val,int base){
 
     String que ="UPDATE TblBook SET status = '"+val+"' ";
     que += " WHERE book_id = "+base+" ";
    this.insertToTable(que);
    
     
 }
 
 
 
 public void borrowBook(int bookId,int copy,Book b,Student stud,Librarian l){
 
try{
    String que = "INSERT INTO TblBorrowed(isbn,copy_number,borrower,book_id,date_borrowed,assess_by) VALUES ";
    que += "('"+b.getISBN()+"',"+copy+","+stud.getStudentNo()+" , "+bookId+", "+System.currentTimeMillis()+", "+l.getId()+" )";

    this.setUpdateStatusTo(Book.BORROWED, bookId);
    stm = con.createStatement();
stm.executeUpdate(que);
}catch(SQLException e){
    System.out.println("pag boorow book "+e.getMessage());
}
     
 }
 
 public int getBorrowedCount(Book b){
 int x=0;
 try{
     String que = " SELECT COUNT(*) as 'bilang' FROM TblBorrowed H,TblBook B WHERE B.isbn = '"+b.getISBN()+"' ";
     que += " AND B.book_id = H.book_id";
stm =  con.createStatement();
rs=stm.executeQuery(que);
if(rs.next()){
x = rs.getInt("bilang");
}
 }catch(SQLException e){
     System.out.println("count borrowd kppya -- >"+e.getMessage());
 }
 return x;
 }
 
 
 
 
  public int getRemainingCount(Book b){
 int x=0;
 try{
     String que = " SELECT COUNT(*) as 'bilang' FROM TblBook B WHERE B.isbn = '"+b.getISBN()+"' ";
     que+= " AND status = 'STORED' ";
stm =  con.createStatement();
rs=stm.executeQuery(que);
if(rs.next()){
x = rs.getInt("bilang");
}
 }catch(SQLException e){
     System.out.println("count borrowd kppya -- >"+e.getMessage());
 }
 return x;
 }
  
  
   public int getArchivedCount(Book b){
 int x=0;
 try{
     String que = " SELECT COUNT(*) as 'bilang' FROM TblBook B WHERE B.isbn = '"+b.getISBN()+"' ";
     que+= " AND status = 'ARCHIVED' ";
stm =  con.createStatement();
rs=stm.executeQuery(que);
if(rs.next()){
x = rs.getInt("bilang");
}
 }catch(SQLException e){
     System.out.println("count borrowd kppya -- >"+e.getMessage());
 }
 return x;
 }
  
  
  
  public void archiveBook(Book b,Librarian l){
  String que="INSERT INTO TblArchived(book_id,isbn,copy_number,date_archived,archived_by) VALUES ";
  que+= "("+b.getId()+" , '"+b.getISBN()+"' , "+b.getCopyNumber()+" , '"+System.currentTimeMillis()+"', "+l.getId()+" )";
  this.insertToTable(que);
  this.setUpdateStatusTo(Book.ARCHIVED, b.getId());
 
  }
  
  
  public ArrayList<Borrowed> getBorrowedBooks(String cat,String val){
  
  ArrayList<Borrowed> bor = new ArrayList<Borrowed>();
  String que = "SELECT borrow_id,isbn,copy_number,borrower,book_id,date_borrowed,assess_by FROM TblBorrowed ";
  
  switch(cat){
      case "Student No.":{
          que += "WHERE borrower LIKE '%"+val+"%' ";
          break;}
      case "ISBN":{
          que += "WHERE isbn LIKE '%"+val+"%' ";
          break;}
      case "Copy Number":{
            que += "WHERE copy_number LIKE '%"+val+"%' ";
          break;}
      
  }
  try{
  stm = con.createStatement();
  rs=stm.executeQuery(que);
  
  while(rs.next()){
 Borrowed b = new Borrowed();
      b.setBorrowID(rs.getInt("borrow_id"));
      b.setISBN(rs.getString("isbn"));
      b.setCopyNumber(rs.getInt("copy_number"));
      b.setBorrower(rs.getInt("borrower"));
      b.setBookId(rs.getInt("book_id"));
      b.setDateBorrow(rs.getString("date_borrowed"));
      b.setAssessBy(rs.getInt("assess_by"));
      bor.add(b);
      
  
  }
  
  }catch(SQLException e){
      System.out.println("pgkuwa borrow book --> "+e.getMessage());
  }
  return bor;
  }
  
  
  
  public Borrowed getSpecificBorrowedBooks(int id){
  Borrowed b = new Borrowed();
 // ArrayList<Borrowed> bor = new ArrayList<Borrowed>();
  String que = "SELECT borrow_id,isbn,copy_number,borrower,book_id,date_borrowed,assess_by FROM TblBorrowed ";
  try{que += " WHERE book_id = "+id+" ";
  stm = con.createStatement();
  rs=stm.executeQuery(que);
  
  while(rs.next()){
 
      b.setBorrowID(rs.getInt("borrow_id"));
      b.setISBN(rs.getString("isbn"));
      b.setCopyNumber(rs.getInt("copy_number"));
      b.setBorrower(rs.getInt("borrower"));
      b.setBookId(rs.getInt("book_id"));
      b.setDateBorrow(rs.getString("date_borrowed"));
      b.setAssessBy(rs.getInt("assess_by"));
      
      
  
  }
  
  }catch(SQLException e){
      System.out.println("pgkuwa borrow book specific --> "+e.getMessage());
  }
  return b;
  }
  
  
  
  public void returnBook(Borrowed b){
  
      try{
          String que = "DELETE FROM TblBorrowed WHERE borrow_id = "+b.getBorrowID()+" ";
      stm = con.createStatement();
      stm.executeUpdate(que);
      
      this.setUpdateStatusTo(Book.STORED, b.getBookId());
      
      
      }catch(SQLException e){
          System.out.println("pagreturn book "+e.getMessage());
      }
  
  
  }
  
  
  public void returnMaterial(Material m){
  this.updateData("TblMaterial", "status_mat", Material.STORED, "material_id", m.getId()+"");
            this.deleteData("TblBorrowedMaterial", "material_id", m.getId()+"");
  
  }
  
  public void addPenaltyRecord(String stud,String librarian,int cost,int bookId){
  
      String que = "INSERT INTO TblPenaltyCollected(stud_no,cost,collect_by,date_collected,book_id) ";
      que+=" VALUES("+stud+","+cost+","+librarian+",'"+this.getMilliNow()+"',"+bookId+") ";
      this.insertToTable(que);
  }
  
  public void addPenaltyRecordMaterial(BorrowedMaterial bor,Librarian l){
  
      String que = "INSERT INTO TblPenaltyCollectedMaterial(stud_no,cost,collect_by,date_collected,material_id) VALUES ";
      que+= "( "+bor.getBorrower()+" , "+bor.getPenaltyCost()+" , "+l.getId()+" , '"+this.getMilliNow()+"', "+bor.getId()+" )";
      
      this.insertToTable(que);
  }
  
  
  //onlyy integer coparable only
  public void updateData(String tblName,String field,String laman,String compareField,String comparable){
  
      String que = "UPDATE "+tblName+" SET "+field+"='"+laman+"' ";
      que+= " WHERE "+compareField+" = "+comparable+" ";
      System.out.println(" que is "+que);
  this.insertToTable(que);
  //try{}catch(SQLExcepit)
  
  }
  
   public void updateData(String tblName,String field,int laman,String compareField,String comparable){
  
      String que = "UPDATE "+tblName+" SET "+field+"="+laman+" ";
      que+= " WHERE "+compareField+" = "+comparable+" ";
      System.out.println(" que is "+que);
  this.insertToTable(que);
  //try{}catch(SQLExcepit)
  
  }
  
  
  
  public void deleteData(String tblName,String compareField,String specimen){
  
      String que = "DELETE FROM "+tblName+" WHERE "+compareField+" = "+specimen+" ";
      System.out.println("delte the unachived");
      this.insertToTable(que);
  
  }
  
    public void deleteDataStrComp(String tblName,String compareField,String specimen){
  
      String que = "DELETE FROM "+tblName+" WHERE "+compareField+" = '"+specimen+"' ";
      System.out.println("delte the unachived");
      this.insertToTable(que);
  
  }
  
  public void insertStudentLog(Student s,Librarian l){
  
  String que = "INSERT INTO TblStudentLog(stud_no,assess_by,date_logged)VALUES ";
  que+= "('"+s.getStudentNo()+"','"+l.getId()+"', '"+System.currentTimeMillis()+"' )";
  
  this.insertToTable(que);
  
  }
  
  
  public void insertGraduatedStudent(Student s,Librarian l){
  String que = "INSERT INTO TblGraduated(stud_no,set_graduated_by,date_graduated)VALUES ";
  que+="("+s.getStudentNo()+","+l.getId()+" , '"+System.currentTimeMillis()+"' )";
  this.insertToTable(que);
  
  }
  
  public void insertSection(String sect){
  
      String que ="INSERT INTO TblGradeSec(grade_sec,date_added)VALUES('"+sect+"','"+System.currentTimeMillis()+"')";
      this.insertToTable(que);
  }
  
  public void insertMaterial(Material m){
  String que = "INSERT INTO TblMaterial(material_name,date_added,added_by,status_mat) VALUES ('"+m.getName()+"','"+m.getDateAdded()+"', "+m.getAddedBy()+",'"+Material.STORED+"' )";
  this.insertToTable(que);
  }
  
  
  public void insertArchiveMaterial(Material m,Librarian l){
  
      String que = "INSERT INTO TblArchivedMaterial(material_id,archived_by,date_archived) VALUES ("+m.getId()+","+l.getId()+",'"+System.currentTimeMillis()+"')";
      this.insertToTable(que);
  }
  
  
  public void insertBorrowedMaterial(Material m,Librarian l,Faculty f){
  
      String que="INSERT INTO TblBorrowedMaterial(material_id,borrowed_by,assess_by,date_borrowed) VALUES ("+m.getId()+" ,  "+f.getId()+", "+l.getId()+", '"+this.getMilliNow()+"' ) ";
      System.out.println(que);
      this.insertToTable(que);
  }
  
  
  public long getMilliNow(){
  return System.currentTimeMillis();
  }
  public void insertFaculty(Faculty f){
  
      String que = "INSERT INTO TblStudent(stud_no,f_name,m_name,l_name,gender,birthdate,address,grade_sec,date_added,added_by,status) VALUES ( ";
      que+= "  "+f.getId()+", '"+f.getFName()+"' , '"+f.getMName()+"' , '"+f.getLName()+"' , '"+f.getGender()+"' , '"+f.getBirthdate()+"' , '"+f.getAddress()+"' , '"+Student.FACULTY+"'   ";
      que+= " , '"+this.getMilliNow()+"' , "+f.getAddedBy()+", '"+Student.ON_SCHOOL+"' ) ";
      System.out.println(que);
//      String que = "INSERT INTO TblStudent(stud_no,f_name,m_name,l_name,gender,address,date_added,birthdate,added_by, grade_sec) VALUES ";
//      que+=" ("+f.getId()+", '"+f.getFName()+"', '"+f.getMName()+"' , '"+f.getLName()+"' , '"+f.getGender()+"' , '"+f.getAddress()+"', '"+f.getDateAdded()+"' , '"+f.getBirthdate()+"',  ";
//      que+=" "+f.getAddedBy()+",'FACULTY','ON_SCHOOL' )";
      this.insertToTable(que);
  }
 
 
  public ArrayList<Material> getAllMaterial(String cat,String val){
  
  ArrayList<Material> mat = new ArrayList<Material>();
  
  String que="SELECT material_id,material_name,date_added,added_by,status_mat  FROM TblMaterial ";
  switch(cat){
      case Material.ID:{
          que+= " WHERE material_id LIKE '%"+val+"%'";
          break;}
      case Material.NAME:{
          que+= " WHERE material_name LIKE '%"+val+"%'";
          break;}
      case Material.STATUS:{
          que+= " WHERE status_mat LIKE '%"+val+"%'";
          break;}
      case Material.BORROWER:{
      que = "SELECT M.material_id,M.material_name,M.date_added,M.added_by,M.status_mat  FROM TblMaterial M, TblBorrowedMaterial B WHERE ";
      que+="  B.material_id = M.material_id AND B.borrowed_by LIKE '%"+val+"%' ";
          System.out.println(que);
      break;
      }
      
  
  
  }
 try{
  stm = con.createStatement();
  rs = stm.executeQuery(que);
  while(rs.next()){
  Material m = new Material();
  m.setId(rs.getInt("material_id"));
  m.setName(rs.getString("material_name"));
  m.setDateAdded(rs.getString("date_added"));
  m.setAddedBy(rs.getString("added_by"));
  m.setStatus(rs.getString("status_mat"));
  mat.add(m);
  }
 }catch(SQLException e){
     System.out.println("pag kuwa material "+e.getMessage());
 }
  return mat;
  
  }  

  
  
  public ArrayList<Material> getAllDistinctMaterial(){
  
  ArrayList<Material> mat = new ArrayList<Material>();
  
  String que="SELECT DISTINCT material_name  FROM TblMaterial ";
 try{
  stm = con.createStatement();
  rs = stm.executeQuery(que);
  while(rs.next()){
  Material m = new Material();
 
  m.setName(rs.getString("material_name"));
 
  mat.add(m);
  }
 }catch(SQLException e){
     System.out.println("pag kuwa material "+e.getMessage());
 }
  return mat;
  
  }  
  
  
  
  
  public ArrayList<Faculty> getAllFaculty(String cat,String val){
    ArrayList<Faculty> fac = new  ArrayList<Faculty>();
     String que = "SELECT stud_no,f_name,m_name,l_name,gender,birthdate,address,grade_sec,date_added,added_by,status FROM TblStudent WHERE grade_sec = '"+Student.FACULTY+"'  ";
    switch(cat){
        case Faculty.FNAME:{
            que+= " AND f_name LIKE '%"+val+"%' ";
            break;}
        case Faculty.LNAME:{
            que+= " AND l_name LIKE '%"+val+"%' ";
            break;}
        
        case Faculty.MNAME:{
            que+= " AND m_name LIKE '%"+val+"%' ";
            break;}
        
        case Faculty.ID:{
            que+= " AND stud_no LIKE '%"+val+"%' ";
            
            break;}
        
    
    
    }
    
    
  
   
    try{
    stm = con.createStatement();
    rs = stm.executeQuery(que);
    while(rs.next()){
    Faculty f = new Faculty();
    f.setId(rs.getInt("stud_no")+"");
    f.setFName(rs.getString("f_name"));
    f.setMName(rs.getString("m_name"));
    f.setLName(rs.getString("l_name"));
    f.setGender(rs.getString("gender"));
    f.setAddress(rs.getString("address"));
    f.setDateAdded(rs.getString("date_added"));
    f.setBirthdate(rs.getString("birthdate"));
    f.setGradeSec(rs.getString("grade_sec"));
    f.setStatus(rs.getString("status"));
    f.setAddedBy(rs.getInt("added_by"));
    
    fac.add(f);
    
    
    
    }
    }catch(SQLException e){
        System.out.println("Erropg kuwa facutlty "+e.getMessage());
    }
    
    
  return fac;
  }
  
  public final static long ONE_DAY_MILLI = 86400000;
  
  public double getRatePerDay(){
  return 10.00;
  }
  
  public int getDayExpire(){
  return 1;
  }
  
  
  public int getDiffDays(long now,long stamp){
  int day = 0;
  
 long diff = (now-stamp);
 day = (int)(diff/ONE_DAY_MILLI);
  
  return day;
  }
  
  
  public double getPricePenalty(int days,double ratePerDay){
  
      double d = 0;
      
     d =days * ratePerDay;
      
      
  return d;
  }
  
  public final static String MONTH="%m",YEAR="%Y",FULL_DATE="%d/%m/%Y %h:%i%p";
  
  
  public String convertDateFormat(String unix,String format){
  String f = " DATE_FORMAT(FROM_UNIXTIME("+unix+"/1000),'"+format+"' ) ";
  
  return f;
  
  }
  
  

  
}//end of lass





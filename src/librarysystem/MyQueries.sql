CREATE DATABASE Library;


CREATE TABLE TblQuestion(question varchar(500) PRIMARY KEY,
date_added varchar(500)
);

INSERT INTO TblQuestion(question,date_added)
VALUES ('Pets name?','null');


INSERT INTO TblQuestion(question,date_added)
VALUES ('Elder cousin?','null');


INSERT INTO TblQuestion(question,date_added)
VALUES ('Fav Foods?','null');




CREATE TABLE TblLibrarian(librarian_id INTEGER AUTO_INCREMENT PRIMARY KEY , 
username varchar(500),
password varchar(500),


f_name varchar(500),
m_name varchar(500),
l_name varchar(500),
address varchar(500),
gender varchar(500),
position_lib varchar(500),
date_hired varchar(500),
birthdate varchar(500),
personal_question varchar(500),
personal_answer varchar(500),


CONSTRAINT position_FK FOREIGN KEY (position_lib)
REFERENCES TblPosition(position_name),

CONSTRAINT quest_FK FOREIGN KEY (personal_question)
REFERENCES TblQuestion(question)

);





CREATE TABLE TblPosition(position_name varchar(500) PRIMARY KEY,
date_added varchar(500)
);

INSERT INTO TblPosition(position_name, date_added)
VALUES ('HEAD_LIBRARIAN','4/23/16');

INSERT INTO TblPosition(position_name, date_added)
VALUES ('LIBRARIAN','4/23/16');








CREATE TABLE TblStudent(stud_no INTEGER PRIMARY KEY,
f_name varchar(500),
m_name varchar(500),
l_name varchar(500),
birthdate varchar(500),
address varchar(1000),
grade_sec varchar(500),
date_added varchar(500),
added_by INTEGER,


CONSTRAINT grade_sec_FK FOREIGN KEY (grade_sec)
REFERENCES TblGradeSec(grade_sec),

CONSTRAINT added_student_fk FOREIGN KEY (added_by)
REFERENCES TblLibrarian(librarian_id)
);



//grade section

CREATE TABLE TblGradeSec(grade_sec varchar(500) PRIMARY KEY,
date_added varchar(500)

);

INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-7:Section-A','Null');

INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-7:Section-B','Null');

INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-7:Section-C','Null');


INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-8:Section-A','Null');

INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-8:Section-B','Null');

INSERT INTO TblGradeSec(grade_sec,date_added) 
VALUES ('Year-8:Section-C','Null');











//book  category 


CREATE TABLE TblBookCategory(category varchar(500) PRIMARY KEY,
date_added varchar(500)
);

INSERT INTO TblBookCategory(category,date_added )
VALUES ('Filipino','Null');

INSERT INTO TblBookCategory(category,date_added )
VALUES ('Mathematics','Null');


INSERT INTO TblBookCategory(category,date_added )
VALUES ('Science','Null');

INSERT INTO TblBookCategory(category,date_added )
VALUES ('Social Studies','Null');

INSERT INTO TblBookCategory(category,date_added )
VALUES ('English','Null');

INSERT INTO TblBookCategory(category,date_added )
VALUES ('MAPEH','Null');

CREATE TABLE TblBook(book_id INTEGER AUTO_INCREMENT PRIMARY KEY,
isbn varchar(500),
copy_number INTEGER,
title varchar(500),
author varchar(500),
publisher varchar(500),
year_published varchar(500),
date_added varchar(500),
added_by INTEGER,
category varchar(500),

CONSTRAINT added_by_fk FOREIGN KEY (added_by)
REFERENCES TblLibrarian(librarian_id),

CONSTRAINT category_fk FOREIGN KEY (category)
REFERENCES TblBookCategory(category)
);

SELECT DISTINCT isbn,title,author,COUNT(isbn) FROM TblBook 
-- CREATE TABLE TblBook(isbn varchar(500) PRIMARY KEY,
-- title varchar(500),
-- author varchar(500),
-- publisher varchar(500),
-- copies INTEGER,
-- date_added varchar(500)
-- 
-- );

CREATE TABLE TblBookArchive(book_id INTEGER PRIMARY KEY,
archive_by INTEGER,
date_archived varchar(500),

CONSTRAINT book_id_fk FOREIGN KEY (book_id)
REFERENCES TblBook(book_id),

CONSTRAINT archive_by_fk FOREIGN KEY (archive_by)
REFERENCES TblLibrarian(librarian_id)

);




-- 
-- CREATE TABLE TblStudent(student_id INTEGER PRIMARY KEY,
-- f_name varchar(500),
-- m_name varchar(500),
-- l_name varchar(500),
-- birthdate varchar(500),
-- gender varchar(500),
-- grade_section varchar(500),
-- address varchar(500)
-- 
-- )







CREATE TABLE TblBorrowed(borrow_id INTEGER AUTO_INCREMENT PRIMARY KEY,
isbn varchar(500),
copy_num INTEGER,
borrower INTEGER,
book_id INTEGER,
date_borrowed varchar(500),
assess_by INTEGER,

CONSTRAINT borrower_FK FOREIGN KEY (borrower)
REFERENCES TblStudent(stud_no),



CONSTRAINT book_id_FK FOREIGN KEY (book_id)
REFERENCES TblBook(book_id),

CONSTRAINT assess_FK FOREIGN KEY (assess_by)
REFERENCES TblLibrarian(librarian_id)


);




CREATE TABLE TblBorrowedFaculty(borrow_id INTEGER AUTO_INCREMENT PRIMARY KEY,
isbn varchar(500),
copy_num INTEGER,
borrower INTEGER,
book_id INTEGER,
date_borrowed varchar(500),
assess_by INTEGER,

CONSTRAINT borrower_FK_fac FOREIGN KEY (borrower)
REFERENCES TblFaculty(faculty_id),



CONSTRAINT book_id_FK_fac FOREIGN KEY (book_id)
REFERENCES TblBook(book_id),

CONSTRAINT assess_FK_fac FOREIGN KEY (assess_by)
REFERENCES TblLibrarian(librarian_id)


);


















CREATE TABLE TblArchived(book_id INTEGER PRIMARY KEY,
isbn varchar(500),
copy_number INTEGER,
date_archived varchar(500),
archived_by INTEGER,

CONSTRAINT book_id_bor_fk FOREIGN KEY(book_id)
REFERENCES TblBook(book_id),

CONSTRAINT archived_by_bor_fk FOREIGN KEY(archived_by)
REFERENCES TblLibrarian(librarian_id)


)





CREATE TABLE TblStudentLog (log_id INTEGER AUTO_INCREMENT PRIMARY KEY,
stud_no INTEGER,
assess_by INTEGER,
date_logged varchar(500),

CONSTRAINT stud_no_log_fk FOREIGN KEY(stud_no)
REFERENCES TblStudent(stud_no),

CONSTRAINT assess_by_log_fk FOREIGN KEY(assess_by)
REFERENCES TblLibrarian(librarian_id)

 )



CREATE TABLE TblPenaltyCollected(collect_id INTEGER AUTO_INCREMENT PRIMARY KEY,

stud_no INTEGER,
cost varchar(500),
collect_by INTEGER,
date_collected varchar(500),
book_id INTEGER,

CONSTRAINT stud_no_penalty_fk FOREIGN KEY(stud_no)
REFERENCES TblStudent(stud_no),

CONSTRAINT assess_by_penalty_fk FOREIGN KEY(collect_by)
REFERENCES TblLibrarian(librarian_id),

CONSTRAINT book_id_penalty_fk FOREIGN KEY(book_id)
REFERENCES TblBook(book_id)

);



CREATE TABLE TblPenaltyCollectedMaterial(
collect_id INTEGER AUTO_INCREMENT PRIMARY KEY,
stud_no INTEGER,
cost varchar(500),
collect_by INTEGER,
date_collected varchar(500),
material_id INTEGER,

CONSTRAINT stud_no_fk_mat_pen FOREIGN KEY (stud_no)
REFERENCES TblStudent(stud_no),


CONSTRAINT assess_by_fk_mat_pen FOREIGN KEY (collect_by)
REFERENCES TblLibrarian(librarian_id),


CONSTRAINT material_id_fk_mat_pen FOREIGN KEY (material_id)
REFERENCES TblMaterial(material_id)

);





CREATE TABLE TblGraduated(
stud_no varchar(500) PRIMARY KEY,
set_graduated_by INTEGER,
date_graduated varchar(500),

CONSTRAINT stud_grad_fk FOREIGN KEY(stud_no)
REFERENCES TblStudent(stud_no),

CONSTRAINT lib_grad_fk FOREIGN KEY(set_graduated_by)
REFERENCES TblLibrarian(librarian_id)

);




CREATE TABLE TblMaterial(material_id INTEGER AUTO_INCREMENT PRIMARY KEY,
material_name varchar(500),
date_added varchar(500),
added_by INTEGER,
status varchar(500),

CONSTRAINT added_material_fk FOREIGN KEY(added_by)
REFERENCES TblLibrarian(librarian_id)
 );

CREATE TABLE TblArchivedMaterial(material_id INTEGER PRIMARY KEY,
archived_by INTEGER,
date_archived varchar(500),

CONSTRAINT mat_id_fk_arch FOREIGN KEY(material_id)
REFERENCES TblMaterial(material_id),

CONSTRAINT mat_arch_by FOREIGN KEY(archived_by)
REFERENCES TblLibrarian(librarian_id)
);





CREATE TABLE TblBorrowedMaterial(material_id INTEGER PRIMARY KEY,
borrowed_by INTEGER,
assess_by INTEGER,
date_borrowed varchar(500),

CONSTRAINT mat_id_fk_bor FOREIGN KEY(material_id)
REFERENCES TblMaterial(material_id),

CONSTRAINT bor_by_fk_bor FOREIGN KEY(borrowed_by)
REFERENCES TblFaculty(faculty_id),

CONSTRAINT assess_mat_fk_bor FOREIGN KEY(assess_by)
REFERENCES TblLibrarian(librarian_id)


);



CREATE TABLE TblFaculty(faculty_id varchar(500) PRIMARY KEY,
f_name varchar(500),
m_name varchar(500),
l_name varchar(500),
gender varchar(500),
address varchar(1000),
date_added varchar(500),
birthdate varchar(500),
added_by INTEGER,
 CONSTRAINT add_by_fac FOREIGN KEY(added_by)
REFERENCES TblLibrarian(librarian_id)

);


CREATE TABLE TblProposedLib(

proposed_id INTEGER AUTO_INCREMENT PRIMARY KEY,

username varchar(500),
password varchar(500),
f_name varchar(500),
m_name varchar(500),
l_name varchar(500),
address varchar(500),
gender varchar(500),
position_lib varchar(500),
date_hired varchar(500),
birthdate varchar(500),
personal_question varchar(500),
personal_answer varchar(500),
accepted boolean,

CONSTRAINT position_FK_prop FOREIGN KEY (position_lib)
REFERENCES TblPosition(position_name),

CONSTRAINT quest_FK_prop FOREIGN KEY (personal_question)
REFERENCES TblQuestion(question)



);
package common;

import java.sql.Connection;
import java.sql.Statement;

import common_use_bean.Sequence_Book_Id;
import common_use_bean.Sequence_Issue_Id;
import common_use_bean.Sequence_Student_Id;
import common_use_bean.Sequence_librepository_Id;

public class Create_Table {

		public static void call_me() {
			Connection connection=null;
			DBConnection_LMS_Portal obj_DBConnection_LMC=new DBConnection_LMS_Portal();
			connection=obj_DBConnection_LMC.getConnection();
			Statement st=null;
			try {
				st=connection.createStatement();
				Sequence_Book_Id obj_Sequence_Book_Id=new Sequence_Book_Id();
				
				obj_Sequence_Book_Id.create_table();
				Sequence_librepository_Id obj_Sequence_librepository_Id=new Sequence_librepository_Id();
				
				obj_Sequence_librepository_Id.create_table();
				
				Sequence_Student_Id obj_Sequence_Student_Id=new Sequence_Student_Id();
				
				obj_Sequence_Student_Id.create_table();
				
				 st.execute("create table admin(" +
						"id_no int(255) auto_increment," +
						"user_name varchar(100) not null," +
						"password varchar(100) not null," +
						"primary key(id_no))");
			
				st.execute("insert into admin(user_name,password) values('admin','admin123')");

				
				st.execute("create table publisher(" +
						"id_no int(255) auto_increment," +
						"publisher_name varchar(300) not null," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(id_no))");
				
				st.execute("create table author(" +
						"id_no int(255) auto_increment," +
						"author_name varchar(300) not null," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(id_no))");
		
					
				st.execute("create table category(" +
						"id_no int(255) auto_increment," +
						"category_name varchar(300) not null unique," +
						"profile varchar(100)," +
						"added_on varchar(100)," +
						"primary key(id_no))");
				

				st.execute("create table student_table(" +
						"student_id varchar(90) unique not null," +
						"admission_no varchar(90) unique not null," +
						"student_name varchar(100) not null," +
						"profile varchar(100)," + 
						"grade varchar(90)," +
						"section varchar(90)," +
						"added_by varchar(90)," +
						"added_on varchar(90)," +
						"status int(1) not null," +
						"primary key(student_id))");

				
				st.execute("create table book_table(" +
						"book_id_no varchar(100) not null," +
						"book_title varchar(100) unique not null," +
						"category_name varchar(100)," +
						"category_num varchar(10)," +
						"author_name varchar(100)," +
						"author_num varchar(10)," +
						"publisher_name varchar(100)," +
						"publisher_num varchar(10)," +
						"edition varchar(100)," +
						"volume varchar(100)," +
						"ean_code varchar(300)," +
						"isbn varchar(300)," +
						"price varchar(300)," +
						"purchase_date varchar(300)," +
						"language varchar(300)," +
						"total_book_in_library int(255)," +
						"total_book_available int(255)," +
						"description varchar(400)," +
						"added_on varchar(100)," +
						"edited_on varchar(100)," +
						"added_by varchar(100)," +
						"edited_by varchar(100)," +
						"primary key(book_id_no))");
	
					
				st.execute("create table librepository_table(" +
						"id_no varchar(300) not null," +
						"book_id_no varchar(300) not null," +
						"book_title varchar(500) not null," +
						"count int(255) not null," +
						"added_on varchar(100) not null," +
						"added_by varchar(100)," +
						"primary key(id_no),FOREIGN KEY (book_id_no) REFERENCES book_table(book_id_no))");
				
	
				
				st.execute("create table serial_number(" +
						"id_no int(255) auto_increment," +
						"invertry_id_no varchar(300) not null," +
						"book_title varchar(500)," +
						"book_id_no varchar(300) not null," +
						"bar_code varchar(300) unique not null," +
						"book_status varchar(300) not null," +
						"added_on varchar(100) not null," +
						"description varchar(400)," +
						"shelf varchar(300)," +
						"rack varchar(300)," +
						"primary key(id_no))");
				
				st.execute("create table last_librepository(" +
						"id_no int(255) auto_increment," +
						"bar_code int(255) not null," +
						"book_id_no varchar(500)," +
						
						"primary key(id_no))");
				
				
				Sequence_Issue_Id obj_Sequence_Issue_Id=new Sequence_Issue_Id();
				
				obj_Sequence_Issue_Id.create_table();
				
				
				st.execute("create table issue_book(" +
						"issue_id_no varchar(50) not null unique," +
						"student_id varchar(300) not null," +
						"admission_no varchar(300) not null," +
						"student_name varchar(300) not null," +
						"book_title varchar(100) not null," +
						"book_id_no varchar(100) not null," +
						"barcode varchar(100) not null," +
						"issue_date varchar(100) not null," +
						"renew_date1 varchar(100)," +
						"renew_date2 varchar(100)," +
						"renew_date3 varchar(100)," +
						"renew_date4 varchar(100)," +
						"renew_date5 varchar(100)," +
						"return_date varchar(100)," +
						"returned_date varchar(100)," +
						"status varchar(300) not null," +
						"description varchar(400)," +
						
						"primary key(issue_id_no))");
				
				
				
					
				} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(connection!=null){
						connection.close();
					}
				} catch (Exception e2) {
				}
				try {
					if(st!=null){
						st.close();
					}
				} catch (Exception e2) {
				}
			}
			System.out.println("all tables created");
		}
		
		
		
		public static void main(String[] args) {
			call_me();
		}
		
		
		
}

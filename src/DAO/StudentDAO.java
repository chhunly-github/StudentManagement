package DAO;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import Model.Student;

public class StudentDAO {
	
	public ArrayList<Student> getAllStudents(){
		ArrayList<Student> students=new ArrayList<>();
		Connection cnn = null;
		try {
			cnn=DbConnection.getConnection("dbstudent");
			String sql="SELECT * FROM tbstudent ORDER BY id";
			Statement st=cnn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				Date dob=(Date) rs.getObject("date_of_birth");
				students.add(new Student(id, name, sex, dob, null));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(cnn!=null)
				try {
					cnn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return students;	
	}
	public static ArrayList<Student> searchStudentById(int id){
		ArrayList<Student> students=new ArrayList<>();
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="SELECT * FROM tbstudent WHERE id=?";
			PreparedStatement st=cnn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				Date dob=(Date) rs.getObject("date_of_birth");
				students.add(new Student(id, name,sex, dob, null));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public static ArrayList<Student> searchStudentByName(String name){
		ArrayList<Student> students=new ArrayList<>();
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="SELECT * FROM tbstudent WHERE name like ? ORDER BY id";
			PreparedStatement st=cnn.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String rname=rs.getString("name");
				String sex=rs.getString("sex");
				Date dob=(Date) rs.getObject("date_of_birth");
				students.add(new Student(id, rname,sex, dob, null));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public static ArrayList<Student> searchStudentByRandom(String search){
		ArrayList<Student> sts=new StudentDAO().getAllStudents();
		ArrayList<Student> students=new ArrayList<>();
		for(Student st:sts){
			if((st.toString().replace('/', ' ')).toUpperCase().contains(search.toUpperCase())){
				students.add(st);
			}
			//System.out.println(st.toString().replace('/', ' '));
		}
		return students;
	}
	
	public static boolean insertData(Student st){
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="INSERT INTO tbstudent VALUES(?,?,?,?)";
			PreparedStatement pps=cnn.prepareStatement(sql);
			pps.setInt(1, st.getId());
			pps.setString(2, st.getName());
			pps.setString(3, st.getSex());
			pps.setDate(4, st.getDob());
			
			pps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateData(Student st){
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="UPDATE tbstudent SET name=?,sex=?,date_of_birth=? WHERE id=?;";
			PreparedStatement pps=cnn.prepareStatement(sql);
			
			pps.setString(1, st.getName());
			pps.setString(2, st.getSex());
			pps.setDate(3, st.getDob());
			pps.setInt(4, st.getId());
			pps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteDataById(int id){
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="DELETE FROM tbstudent WHERE id=?";
			PreparedStatement pps=cnn.prepareStatement(sql);
			pps.setInt(1, id);
			pps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteDataByName(String name){
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="DELETE FROM tbstudent WHERE name=?";
			PreparedStatement pps=cnn.prepareStatement(sql);
			pps.setString(1, name);
			pps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteAll(){
		try {
			Connection cnn=DbConnection.getConnection("dbStudent");
			String sql="DELETE FROM tbstudent";
			PreparedStatement pps=cnn.prepareStatement(sql);
			pps.executeUpdate();
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}

package Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.StudentDAO;
import Model.Student;
import Viewer.Viewer;

public class UI_Control {
	

	public static void AddNew(){
		System.out.println("--------------------------**************************-----------------------");
		System.out.println("-------------------------------Add new student-------------------------");
		int id=(int)Input.Floats("Input id:");
		String name=Input.string("Input name:");
		String gender=Input.string("Input gender(Male/Female):");
		Date date=Input.inputDate("Input date:");
		try{
			if(!StudentDAO.insertData(new Student(id,name,gender,date,null))){
				System.out.println("Failed to insert data.");
				return;
			}
			System.out.println("Insertion succeed");
		}catch(Exception e){
			
		}
	}
	/*----------------------------------delete data----------------------------*/
	public static void Delete(){
		String choice;
		do{
			System.out.println("--------------------------**************************-----------------------");
			System.out.println("--------------------------Student deleting data------------------------");
			System.out.println("1.)delete by id");
			System.out.println("2.)delete by name");
			System.out.println("3.)delete all record");
			System.out.println("exit.) back to menu");
			choice=Input.string("Option >");
			switch(choice){
			case "1":
				int id=(int)Input.Floats("Input delete id:");
				ArrayList<Student> idFound=StudentDAO.searchStudentById(id);
				if(idFound.size()==0){
					System.out.println("Could not find data id:"+id);
					break;
				}
				Viewer.displayData(Student.getFields(), idFound.toArray());
				System.out.println("Total found:"+idFound.size()+" students");
				if(!Confirmation("Are you sure to delete")){
					System.out.println("Deleting data cancel!");
					break;
				}
				if(StudentDAO.deleteDataById(idFound.get(0).getId())){
					System.out.println("Deleting data succeeded!");
					break;
				}
				System.out.println("Failed to delete data!");
				break;
			case "2":
				String name=Input.string("Input search name:");
				ArrayList<Student> nameFound=StudentDAO.searchStudentByName(name);
				if(nameFound.size()==0){
					System.out.println("Could not match any name:"+name);
					break;
				}
				Viewer.displayData(Student.getFields(), nameFound.toArray());
				System.out.println("Total found:"+nameFound.size()+" students");
				if(!Confirmation("Do you want to delete these data")){
					System.out.println("Deleting cancel!");
					break;
				}
				for(Student st:nameFound){
					StudentDAO.deleteDataById(st.getId());
				}
				System.out.println("Deleting data succeed!");
				break;
			case "3":
				if(!Confirmation("Are you sure to delete all data")){
					System.out.println("Deleting data cancel!");
					break;
				}
				if(!StudentDAO.deleteAll()){
					System.out.println("Deleting data failed!");
					break;
				}
				System.out.println("Delete data succeed!");
				break;
			default:
			}
			
		}while(!choice.equalsIgnoreCase("exit"));

	}
	
	/*----------------------------------update data----------------------------*/
	public static void Update(){
		String choice;
		do{
			System.out.println("--------------------------**************************-----------------------");
			System.out.println("--------------------------Student updating data------------------------");
			System.out.println("1.)update all");
			System.out.println("2.)update name");
			/*System.out.println("3.)update all record")*/;
			System.out.println("exit.) back to menu");
			choice=Input.string("Option >");
			switch(choice){
			case "1":
				int id=(int)Input.Floats("Input Update id:");
				
				ArrayList<Student> idFound=StudentDAO.searchStudentById(id);
				if(idFound.size()==0){
					System.out.println("Could not find data id:"+id);
					break;
				}
				Viewer.displayData(Student.getFields(), idFound.toArray());
				System.out.println("Total found:"+idFound.size()+" students");
				//int newid=(int)Input.Floats("Input id:");
				
				String newname=Input.string("Input name:");
				String newgender=Input.string("Input gender(Male/Female):");
				Date newdate=Input.inputDate("Input date:");
				
				if(!Confirmation("Are you sure to update")){
					System.out.println("Updating data cancel!");
					break;
				}
				if(StudentDAO.updateData(new Student(id,newname,newgender,newdate,null))){
					System.out.println("Update data succeeded!");
					break;
				}
				System.out.println("Failed to update data!");
				break;
			case "2":
				int idF=(int)Input.Floats("Input update id:");
				
				ArrayList<Student> Found=StudentDAO.searchStudentById(idF);
				if(Found.size()==0){
					System.out.println("Could not find data id:"+idF);
					break;
				}
				Viewer.displayData(Student.getFields(), Found.toArray());
				
				String name=Input.string("Input name:");
				if(!Confirmation("Are you sure to update")){
					System.out.println("Updating data cancel!");
					break;
				}
				if(StudentDAO.updateData(new Student(idF, name, Found.get(0).getSex(), Found.get(0).getDob(),null))){
					System.out.println("Update data succeeded!");
					break;
				}
				System.out.println("Failed to Update data!");
				break;

			/*case "3":
				if(!Confirmation("Are you sure to delete all data")){
					System.out.println("Deleting data cancel!");
					break;
				}
				if(!StudentDAO.deleteAll()){
					System.out.println("Deleting data failed!");
					break;
				}
				System.out.println("Delete data succeed!");
				break;*/
			default:
			}
			
		}while(!choice.equalsIgnoreCase("exit"));	
	}
	
	/*----------------------------------search data----------------------------*/
	public static void Search(){
		String choice;
		do{
			System.out.println("--------------------------**************************-----------------------");
			System.out.println("--------------------------Student searching data------------------------");
			System.out.println("1.)Search by id");
			System.out.println("2.)Search by name");
			System.out.println("3.)Search with all fields");
			System.out.println("exit.) back to menu");
			choice=Input.string("Option >");
			switch(choice){
			case "1":
				int id=(int)Input.Floats("Input search id:");
				ArrayList<Student> idFound=StudentDAO.searchStudentById(id);
				if(idFound.size()==0){
					System.out.println("Could not find data id:"+id);
					break;
				}
				
				Viewer.displayData(Student.getFields(), idFound.toArray());
				System.out.println("Total found:"+idFound.size()+" students");
				break;
			case "2":
				String name=Input.string("Input search name:");
				ArrayList<Student> nameFound=StudentDAO.searchStudentByName(name);
				if(nameFound.size()==0){
					System.out.println("Could not match any name:"+name);
					break;
				}
				Viewer.displayData(Student.getFields(), nameFound.toArray());
				System.out.println("Total found:"+nameFound.size()+" students");
				break;
			case "3":
				String rand=Input.string("Input search word:");
				ArrayList<Student> randFound=StudentDAO.searchStudentByRandom(rand);
				if(randFound.size()==0){
					System.out.println("Could not match any word:"+rand);
					break;
				}
				Viewer.displayData(Student.getFields(), randFound.toArray());
				System.out.println("Total found:"+randFound.size()+" students");
				break;
			default:
			}
			
		}while(!choice.equalsIgnoreCase("exit"));
	}
	
	
	/*----------------------------------Confirm any thing with yes no question----------------------------*/
	public static boolean Confirmation(String arg){
		///add your code here
		while(true){
			System.out.println(arg+"[y/n] ?");
			String s=new Scanner(System.in).next();
			switch(s.toUpperCase()){
			case "Y":return true;
			case "N":return false;
			default:break;
			}
		}
	}
}

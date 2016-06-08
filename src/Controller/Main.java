package Controller;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.DbConnection;
import DAO.StudentDAO;
import DTO.StudentDTO;
import Model.Student;
import Viewer.Viewer;

public class Main {
	public Main(){
		Menu();
	}
	public void Menu(){
		String choice;
		do{
			System.out.println("--------------------------**************************-----------------------");
			System.out.println("--------------------------Student Management System------------------------");
			System.out.println("1.)Display all student");
			System.out.println("2.)Add new student");
			System.out.println("3.)Delete student information");
			System.out.println("4.)Update student information");
			System.out.println("5.)Search students");
			System.out.println("exit.)Exit the program");
			choice=Input.string("Option >");
			switch(choice){
			case "1":Viewer.displayData(Student.getFields(), new StudentDAO().getAllStudents().toArray());
				break;
			case "2":
				UI_Control.AddNew();
				break;
			case "3":
				UI_Control.Delete();
				break;
			case "4":
				//UI_Control.Update();
				break;
			case "5":
				UI_Control.Search();
				break;
			case "6":
				
				break;
			default:
			}
			
		}while(!choice.equalsIgnoreCase("exit"));
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
}

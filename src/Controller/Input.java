package Controller;

import java.sql.Date;
import java.util.Scanner;

import DAO.StudentDAO;

public class Input {
	public static String string(String s){
		System.out.print(s);
		Scanner sc=new Scanner(System.in);
		String inp=sc.nextLine();
		
		return inp;
	}
	public static float Floats(String s){
		do{
			System.out.print(s);
			try{
				float f;
				f=new Scanner(System.in).nextFloat();
				return f;
			}catch(Exception e){
				System.err.println("\nCan not cast the string to number!\n");
				continue;
			}
		}while(true);
	}
	public static Date inputDate(String s){
		Date d=null;
		do{
			try{
				String date=string(s+"(year/month/day)");
				String[] arr=date.split("/");
				int year=Integer.parseInt(arr[0]);
				int month=Integer.parseInt(arr[1]);
				int day=Integer.parseInt(arr[2]);
				d=new Date(year,month,day);
				return d;
			}catch(Exception e){
				System.out.println("Invalid format!");
				
			}
		}while(true);
		
	}
}


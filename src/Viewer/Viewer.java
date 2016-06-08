package Viewer;

import DTO_Model.Student;
import fliptables.FlipTable;

public class Viewer {
	public static void displayData(String[] headers, Object[] data){
		
		for(String s:headers){
			System.out.printf("%20s",s);
		}
		System.out.println();
		
		for(Object obj:data){
			for(Object ob:((Student)obj).getData()){
				if(ob==null){
					System.out.printf("%20s","Unknown");
					break;
				}
				System.out.printf("%20s",ob.toString());
			}
			System.out.println();
		}
	}
}

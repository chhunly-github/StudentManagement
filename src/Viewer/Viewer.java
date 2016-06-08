package Viewer;

import Model.Student;
import fliptables.FlipTable;

public class Viewer {
	public static void displayData(String[] headers, Object[] data){
		
		/*String[][] dt = null;
		for(int i=0;i<headers.length;i++){
			for(int j=0;j<data.length;j++){
				dt[i][j]=((Student)data[i]).getData()[j].toString();
			}
		}*/
		//System.out.println(FlipTable.of(headers, dt));
		for(String s:headers){
			System.out.printf("%20s",s);
		}
		System.out.println();
		
		//System.err.println(data.length);
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

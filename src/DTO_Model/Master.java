package DTO_Model;

public class Master extends EducationLevel{
	
	public Master(String name, String grade){
		super(name,grade);
	}
	/*@Override
	public String toString(){
	}*/
	@Override
	protected String levelName(){
		return "Master";
	}
	
}

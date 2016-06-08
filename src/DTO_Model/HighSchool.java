package DTO_Model;

public class HighSchool extends EducationLevel{
	
	public HighSchool(String name, String grade){
		super(name,grade);
	}
	@Override
	protected String levelName(){
		return "High School";
	}
}

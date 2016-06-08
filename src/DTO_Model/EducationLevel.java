package DTO_Model;

public abstract class EducationLevel {
	
	protected String className;
	protected String grade;
	
	public EducationLevel(String className, String grade){
		this.className=className;
		this.grade=grade;
	}
	@Override
	public String toString(){
		return levelName()+";"+grade+";"+className;
	}
	protected String levelName(){
		return "Education Level";
	}
}

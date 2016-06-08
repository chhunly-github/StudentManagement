package Model;

public class Primary extends EducationLevel{
	
	public Primary(String name, String grade){
		super(name,grade);
	}
	@Override
	protected String levelName(){
		return "Primary";
	}
}

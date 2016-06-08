package Model;

public class Bachelor extends EducationLevel{

	public Bachelor(String name, String grade){
		super(name,grade);
	}
	@Override
	protected String levelName(){
		return "Bachelor";
	}
}

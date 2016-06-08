package DTO_Model;

import java.sql.Date;



public class Student {
	private Date dob;
	private String name, sex;
	private int id;
	private EducationLevel education;
	
	public Student(int id, String name,String sex, Date dob, EducationLevel ed){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.dob=dob;
		this.education=ed;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EducationLevel getEducation() {
		return education;
	}
	public void setEducation(EducationLevel education) {
		this.education = education;
	}
	public Date getDob() {
		return dob;
	}
	public int getId() {
		return id;
	}
	public String getSex(){
		return this.sex;
	}
	public void setSex(String sex){
		this.sex=sex;
		
	}
	public String idFormat(int id){
		String sid;
		if(id<10000)
			if(id<1000)
				if(id<100)
					if(id<10)
						sid="0000"+id;
					else
						sid="000"+id;
				else
					sid="00"+id;
			else sid="0"+id;
		else sid=""+id;
		return sid;
	}
	
	public static String[] getFields(){
		String[] s={"ID", "NAME", "SEX", "DATE OF BIRTH", "EDUCATION LEVEL"};
		return s;
	}
	public Object[] getData(){
		Object[] data= {this.id, this.name, this.sex, this.dob, this.education};
		return data;
	}
	@Override
	public String toString(){
		return this.id+"/"+this.name+"/"+this.sex+"/"+this.dob+"/"+this.education;
	}
	
}

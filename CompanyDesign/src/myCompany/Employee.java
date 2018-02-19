package myCompany;

public class Employee {
	private int ID;
	private int yearsAtComp;
	private String name;
	private int age;
	
	public Employee (int ID, int yearsAtComp, String name, int age) {
		this.ID = ID;
		this.yearsAtComp = yearsAtComp;
		this.name = name;
		this.age = age;
		
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getID () {
		return this.ID;
	}
	
	public int getYears() {
		return this.yearsAtComp;
	}
	
	public String getName() {
		return this.name;
	}
}

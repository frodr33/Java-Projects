package myCompany;

import java.util.ArrayList;
import java.util.HashMap;
import myCompany.Employee;

public class Company {
	ArrayList<Building> buildings;
	ArrayList<Employee> employees;
	HashMap<Employee, Building> empToBuilding;
	String companyName;
	
	
	public Company(ArrayList<Building> buildings, ArrayList<Employee> employees,
			HashMap<Employee, Building> Map, String companyName) {
		this.buildings = buildings;
		this.employees = employees;
		this.empToBuilding = Map;
		this.companyName = companyName;
	}
	
	public int sizeOfCompany() {
		return employees.size();
	}
	
	/* Builds a building by adding
	 * a building to the Building list
	 * and pushing 100 employees to the 
	 * new building
	 */
	public void addBuilding() {
		ArrayList<Employee> employeesToSwitch = new ArrayList<Employee>();
		Room[] Rooms = new Room[10];
		String color;
		ArrayList<Desk> Desks = new ArrayList<Desk>();
		if (employees.size() < 100) {
			System.out.println("NEED AT LEAST 100 EMPLOYEES");
			return;
		}
		
		// Switch 100 free Employees to this Building
		for (int i = 0; i < 100; i++) {
			Employee temp = employees.remove(employees.size() - 1);
			employeesToSwitch.add(temp);
		}
		
		// Create Rooms, Fixed size at 10
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				color = "Blue";
			} else {
				color = "Red";
			}
			Rooms[i] = new Room(color, Desks);
		}
		
		Building newBuilding = new Building(employeesToSwitch, Rooms);
		buildings.add(newBuilding);
	}
	
	public static void main (String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Building> buildings = new ArrayList<Building>();
		HashMap<Employee, Building> map = new HashMap<Employee, Building>();
		String companyName = "Franech";
		for (int i = 0; i < 200; i++) {
			int ID = 100 + i;
			int yearsAtComp = i;
			int age = i % 100;
			String name = "Frank";
			
			Employee newEmp = new Employee(ID, yearsAtComp, name, age);
			employees.add(newEmp);
		}
		Company newCompany = new Company(buildings, employees, map, companyName);
		
		//Try to add a building to newCompany
		System.out.println(newCompany.sizeOfCompany());
		newCompany.addBuilding();
		System.out.println(newCompany.sizeOfCompany());
		System.out.println(newCompany.buildings.get(0).getEmployees());
		System.out.println(newCompany.employees.get(0).getID());
		System.out.println(newCompany.buildings.get(0).getRooms());
		
	
	}
	
}

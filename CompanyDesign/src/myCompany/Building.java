package myCompany;

import java.util.ArrayList;
import myCompany.Room;
import myCompany.Employee;

public class Building {
	private ArrayList<Employee> Employees; //list to show aggregate
	private Room[] Rooms; //array to show composite rel
	 
	public Building (ArrayList<Employee> Employees, Room[] Rooms) {
		this.Employees = Employees;
		this.Rooms = Rooms;
	}
	
	public int getEmployees() {
		return Employees.size();
	}
	
	public int getRooms() {
		return Rooms.length;
	}
}

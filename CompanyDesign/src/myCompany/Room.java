package myCompany;

import java.util.ArrayList;
import myCompany.Desk;

public class Room {
	String color;
	ArrayList<Desk> Desks;
	
	public Room (String color, ArrayList<Desk> Desks) {
		this.color = color;
		this.Desks = Desks;
	}
}

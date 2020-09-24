// Activity: Use Visitor design pattern to compute the total tax income

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Object> items = new ArrayList<Object>();
		items.add(new Car(10000));
		items.add(new Alcohol(100));
		items.add(new Chocolate(10));
		items.add(new Alcohol(200));
		
		
		
		// print total tax income based on the two taxing systems
		
	}
}

class Car {
	private double price;
	
	public Car(double price){
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
}

class Alcohol {
	private double price;
	
	public Alcohol(double price){
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
}

class Chocolate {
	private double price;
	
	public Chocolate(double price){
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
}


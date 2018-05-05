package back_end;

import javafx.scene.control.DatePicker;

public class Cereal {
	private String name;
	private String image;
	private double calories;
	private double fat;
	private double carbs;
	private double protein;
	private int capacity;
	private final int DEFAULT = 100;

	public Cereal(String name,String img,double calories, double fat,double carbs,double protein) {
		this.name = name;
		this.image = img;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
		this.capacity = DEFAULT;
	}
	
	public String getName() {
		return this.name;
	} 
	
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getImage() {
		return image;
	}

	public double getCalories() {
		return calories;
	}

	public double getFat() {
		return fat;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getProtein() {
		return protein;
	}

	public void subtract(){
		if(Choice.portionChoice == 0){
			this.capacity -= 10;
			setZeroIfEmpty();
		}
		else if(Choice.portionChoice == 1){
			this.capacity -= 20;
			setZeroIfEmpty();
		}
		else{
			this.capacity -= 30;
			setZeroIfEmpty();
		}
	}

	public void setZeroIfEmpty(){
		if(this.capacity <= 0){
			this.capacity = 0;
		}
	}
	
}
package back_end;
public class Milk {
	private String type;
	private String image;
	private double calories;
	private double fat;
	private double carbs;
	private double protein;
	private int capacity;
	private final int DEFAULT = 100;

	public Milk(String type, String img, double calories, double fat, double carbs, double protein){
		this.type = type;
		this.image = img;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
	}

	public Milk(String type) {
		this.type = type;
		this.capacity = DEFAULT;
	}

	public String getType() {
		return this.type;
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
}
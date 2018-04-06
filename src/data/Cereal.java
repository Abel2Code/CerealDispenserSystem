public class Cereal {
	private String name;
	private int capacity;
	private int calories;
	private int fat;
	private int carbs;
	private int protein;
	private String cerealImg; 
	private final int DEFAULT = 100;

	public Cereal() {
	}

	public Cereal(String name, int calories, int fat, int carbs, int protein, String cerealImg) {
		this.name = name;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
		this.cerealImg = cerealImg;
		this.capacity = DEFAULT;
	}
	
	public String getName() {
		return this.name;
	}

	public int getCal() {
		return this.calories;
	}

	public int getFat() {
		return this.fat;
	}
	public int getCarbs() {
		return this.carbs;
	}
	public int getProtein() {
		return this.protein;
	}

	public String getImg() {
		return this.cerealImg;
	}
	
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
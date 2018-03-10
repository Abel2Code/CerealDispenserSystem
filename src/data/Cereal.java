public class Cereal {
	private String name;
	private int capacity;
	private final int DEFAULT = 100;

	public Cereal() {
	}

	public Cereal(String name) {
		this.name = name;
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
}
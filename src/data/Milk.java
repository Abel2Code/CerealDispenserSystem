public class Milk {
	private String type;
	private int capacity;
	private final int DEFAULT = 100;

	public Milk(){
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
}
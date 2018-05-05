package back_end;
public class Serving {
	private Cereal cereal;
	private Milk milk;
	private int size;

	public Serving() {
	}

	public void setCereal(Cereal cereal) {
		this.cereal = cereal;
	}

	public void setMilk(Milk milk) {
		this.milk = milk;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		return size + " " + cereal.getName() + " with " + milk.getName();
	}	

}
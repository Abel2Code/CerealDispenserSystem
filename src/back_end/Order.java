package back_end;

public class Order {
	private Cereal cereal;
	private Milk milk;
	private int portion;

	public Order(Cereal cereal, Milk milk, int portion) {
		this.cereal = cereal;
		this.milk = milk;
		this.portion = portion;
	}

	public Cereal getCereal() {
		return cereal;
	}

	public void setCereal(Cereal cereal) {
		this.cereal = cereal;
	}

	public Milk getMilk() {
		return milk;
	}

	public void setMilk(Milk milk) {
		this.milk = milk;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	public String toString() {
		return cereal.getName() + " with " + milk.getName() + " size: " + portion;
	}
}

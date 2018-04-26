package back_end;
import java.util.List;
import java.util.ArrayList;

public class MilkContainer {
	private List<Milk> milks;
	private final int DEFAULT_SIZE = 2;

	public MilkContainer() {
		milks = new ArrayList<Milk>();
	}

	public Milk getMilk(int index) {
		return milks.get(index);
	}

	public void addMilk(Milk milk) {
		if (milks.size() < DEFAULT_SIZE) {
			milks.add(milk);
		} 
	}

	public void delMilk(Milk milk) {
		milks.remove(milk);
	} 

	public String toString() {
		String output = "";

		for (Milk m : milks) {
			output += m.getName() + " ";
		}

		return output;
	}
}

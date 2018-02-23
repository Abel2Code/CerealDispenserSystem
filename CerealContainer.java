import java.util.List;
import java.util.ArrayList;

public class CerealContainer {
	private List<Cereal> cereals;
	private final int DEFAULT_SIZE = 4;

	public CerealContainer() {
		cereals = new ArrayList<Cereal>();
	} 

	public Cereal getCereal(int index) {
		return cereals.get(index);
	}

	public void addCereal(Cereal cereal) {
		if (cereals.size() < DEFAULT_SIZE) {
			cereals.add(cereal);
		} 
	}

	public void delCereal(Cereal cereal) {
		cereals.remove(cereal);
	} 

	public String toString() {
		String output = "";

		for (Cereal c : cereals) {
			output += c.getName() + " ";
		}

		return output;
	}
}

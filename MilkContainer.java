import java.util.List;
import java.util.ArrayList;

public class MilkContainer {
	private List<Milk> milks;
	private final int DEFAULT_SIZE = 2;

	public MilkContainer() {
		milks = new ArrayList<Milk>();
	} 

	public void addCereal(Cereal cereal) {
		if (milks.length() < DEFAULT_SIZE) {
			milks.add(milk);
		} 
	}

	public void delCereal(Cereal cereal) {
		milks.remove(milk);
	} 
}

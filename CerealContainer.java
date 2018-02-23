import java.util.List;
import java.util.ArrayList;

public class CerealContainer {
	private List<Cereal> cereals;
	private final int DEFAULT_SIZE = 4;

	public CerealContainer() {
		cereals = new ArrayList<Cereal>();
	} 

	public void addCereal(Cereal cereal) {
		if (cereals.length() < DEFAULT_SIZE) {
			cereals.add(cereal);
		} 
	}

	public void delCereal(Cereal cereal) {
		cereals.remove(cereal);
	} 
}

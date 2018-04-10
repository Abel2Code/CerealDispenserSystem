package back_end;
import java.util.List;
import java.util.ArrayList;

public class Container {
	public static List<Cereal> cereals;
	public static List<Milk> milks;
	public static List<Cereal> cerealContainer;
	public static List<Milk> milkContainer;
	private final int CEREAL_DEFAULT_SIZE = 4;
	private final int MILK_DEFAULT_SIZE = 2;

	public Container() {
		cereals = new ArrayList<Cereal>();
	} 

	public Cereal getCereal(int index) {
		return cereals.get(index);
	}

	public void addCereal(Cereal cereal) {
		if (cerealContainer.size() < CEREAL_DEFAULT_SIZE) {
			cerealContainer.add(cereal);
		} 
	}

	public void delCereal(Cereal cereal) {
		cerealContainer.remove(cereal);
	} 

	public String toString() {
		String output = "";
		for(int i = 0; i < cereals.size(); i++) {
			output += "NAME OF CEREAL: " + cereals.get(i).getName() + "\n" +
					  "CALORIES: " + cereals.get(i).getCalories() + "cals\n" + 
					  "FAT: " + cereals.get(i).getFat() + "g\n" +
					  "CARBS: " + cereals.get(i).getCarbs() + "g\n" +
					  "PROTEIN: " + cereals.get(i).getProtein() + "g\n\n";
		}
		

		return output;
	}
}

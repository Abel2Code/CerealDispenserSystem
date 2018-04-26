package back_end;
import java.util.List;
import java.util.ArrayList;

public class Container {
	public static List<Cereal> cereals = new ArrayList<Cereal>();
	public static List<Milk> milks = new ArrayList<Milk>();
	public static Cereal[] cerealContainer;
	public static Milk[] milkContainer;
	private final int CEREAL_DEFAULT_SIZE = 4;
	private final int MILK_DEFAULT_SIZE = 2;

	public Container() {

		cerealContainer = new Cereal[CEREAL_DEFAULT_SIZE];
		milkContainer = new Milk[MILK_DEFAULT_SIZE];
		for(int i = 0; i < cerealContainer.length; i++){
			if(i <= 1){
				milkContainer[i] = null;
			}
			cerealContainer[i] = null;

		}
	} 

	public Cereal getCereal(int index) {

		return cereals.get(index);
	}

	public static void addCereal(Cereal cereal) {
		for(int i = 0; i < cerealContainer.length; i++){
			if(cerealContainer[i] == null){
				cerealContainer[i] = cereal;
				break;
			}
		}
	}

	public static void addMilk(Milk milk) {
		for(int i = 0; i < milkContainer.length; i++){
			if(milkContainer[i] == null){
				milkContainer[i] = milk;
				break;
			}
		}
	}

	public void delCereal(int x) {
		cerealContainer[x] = null;
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

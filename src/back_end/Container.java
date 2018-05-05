package back_end;
import java.util.List;
import java.util.ArrayList;

public class Container {
	public static List<Cereal> cereals = new ArrayList<Cereal>();
	public static List<Milk> milks = new ArrayList<Milk>();
	public static Cereal[] cerealContainer;
	public static Milk[] milkContainer;
	private final int CEREAL_DEFAULT_SIZE = 4;
	private final int MILK_DEFAULT_SIZE = 3;

	public Container() {

		cerealContainer = new Cereal[CEREAL_DEFAULT_SIZE];
		milkContainer = new Milk[MILK_DEFAULT_SIZE];

		for(int i = 0 ; i < CEREAL_DEFAULT_SIZE ; i++){
			if(i <= 1){
				milkContainer[i] = null;
			}
		}

		milkContainer[2] = new Milk("No Milk", "milk/noMilk.png", 0, 0, 0,0 );
		milkContainer[2].setExpirationDate("N/A");
	} 

	public Cereal getCereal(int index) {

		return cereals.get(index);
	}

	public static int getCerealIndex(Cereal c) {
		for (int i = 0 ; i < cerealContainer.length ; i++) {
			if (cerealContainer[i] != null && cerealContainer[i].getName().equals(c.getName())) {
				return i;
			}
		}

		return -1;
	}

	public static int getMilkIndex(Milk m) {
		for (int i = 0 ; i < milkContainer.length ; i++) {
			if (milkContainer[i] != null && milkContainer[i].getName().equals(m.getName())) {
				return i;
			}
		}

		return -1;
	}

	public static void addCereal(Cereal cereal) {
		for(int i = 0; i < cerealContainer.length; i++){
			if(cerealContainer[i] == null){
				cerealContainer[i] = cereal;
				break;
			}
		}
	}

	public static void addMilk(Milk milk, String date) {
		milk.setExpirationDate(date);

		for(int i = 0; i < milkContainer.length; i++){
			if(milkContainer[i] == null){
				milkContainer[i] = milk;
				break;
			}
		}
	}

	public static void delCereal(int x) {
		cerealContainer[x] = null;
	}

	public static void delMilk(int x) {
		milkContainer[x] = null;
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

	public boolean checkIfAddCereal(){
		if(cerealContainer[0] != null && cerealContainer[1] != null && cerealContainer[2] != null && cerealContainer[3] != null){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean checkIfAddMilk(){
		if(milkContainer[0] != null && milkContainer[1] != null){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean checkIfRemoveCereal(){
		if(cerealContainer[0] == null && cerealContainer[1] == null && cerealContainer[2] == null && cerealContainer[3] == null){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean checkIfRemoveMilk(){
		if(milkContainer[0] == null && milkContainer[1] == null){
			return false;
		}
		else{
			return true;
		}
	}
}

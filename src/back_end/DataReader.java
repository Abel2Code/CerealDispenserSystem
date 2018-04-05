package back_end;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataReader {
	
	public static final String cerealDataBase = "resources/dataBase/cerealData.txt";
	public static final String milkDataBase = "resources/dataBase/milkData.txt";
	

	private DataReader() {
		
	}
	
	public static void readData(String file) {
		String line = null;
		
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fileReader);
			
			while((line = buffer.readLine()) != null) {
				String data[] = line.split(",");
				double calories = Double.parseDouble(data[2]);
				double fat = Double.parseDouble(data[3]);
				double carbs = Double.parseDouble(data[4]);
				double protein = Double.parseDouble(data[5]);
				
				if(file.contains("cereal")) {
					Container.cereals.add(new Cereal(data[0],data[1],calories,fat,carbs,protein));
				}
				else {
					Container.milks.add(new Milk(data[0],data[1],calories,fat,carbs,protein));
				}
			}
			
			buffer.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading Database.");
		}
	}
	
	public static void readPreferences() {
		
	}
	
	public static void writePreferences() {
		
	}
}

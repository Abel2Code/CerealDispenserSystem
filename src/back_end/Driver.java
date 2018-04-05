package back_end;
public class Driver {
	public static void main(String[] args) {
//		Container cc = new Container();
//		MilkContainer mc = new MilkContainer();
//
//		Milk milk = new Milk("Normal Milk");
//		Cereal cereal = new Cereal("Honey Bunches");
//
//		cc.addCereal(cereal);
//		mc.addMilk(milk);
//
//		System.out.println(cc.toString());
//		System.out.println(mc.toString());
//
//		Serving breakfast = new Serving();
//
//		breakfast.setCereal(cc.getCereal(0));
//		breakfast.setMilk(mc.getMilk(0));
//		breakfast.setSize(20);
//
//		System.out.println(breakfast.toString());
		
		
		//****************************************************************************************
		//*********************************TESTING DATABASE***************************************
		//****************************************************************************************
		Container c = new Container();
		DataReader.readData(DataReader.cerealDataBase);
		System.out.println(c.toString());


	}
}
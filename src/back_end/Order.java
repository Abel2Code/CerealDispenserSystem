package back_end;

public class Order {
	private static int cerealIndex = -1;
	private static int milkIndex = -1;
	private static int portion = -1;

	public Order() {
	}

	public static int getCerealIndex() {
		return cerealIndex;
	}

	public static void setCerealIndex(int cerealIndex) {
		Order.cerealIndex = cerealIndex;
	}

	public static int getMilkIndex() {
		return milkIndex;
	}

	public static void setMilkIndex(int milkIndex) {
		Order.milkIndex = milkIndex;
	}

	public static int getPortion() {
		return portion;
	}

	public static void setPortion(int portion) {
		Order.portion = portion;
	}

	public static void clearOrder() {
		setCerealIndex(-1);
		setMilkIndex(-1);
		setPortion(-1);
	}


}

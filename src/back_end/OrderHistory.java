package back_end;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    public static List<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<Order>();
    }

    public static void addOrder(int cerealIndex, int milkIndex, int portion) {
        orders.add(new Order(Container.cerealContainer[cerealIndex], Container.milkContainer[milkIndex], portion));
    }

    @Override
    public String toString() {
        String s = "";
        for (Order o : orders) {
            s += o.getCereal().getName();
            s += " with ";
            s += o.getMilk().getName();
            s += ", size: ";

            switch (o.getPortion()) {
                case 0: s += "Small";
                        break;
                case 1: s += "Medium";
                        break;
                case 2: s+= "Large";
                        break;
                default: break;
            }

            s += "\n";
        }

        return s;

    }

}

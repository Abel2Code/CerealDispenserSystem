package back_end;

public class Choice {
    public static int cerealChoice = -1;
    public static int milkChoice = -1;
    public static int portionChoice = -1;

    public Choice() {}

    public static void setCerealChoice(int cerealChoice) {
        Choice.cerealChoice = cerealChoice;
    }

    public static void setMilkChoice(int milkChoice) {
        Choice.milkChoice = milkChoice;
    }

    public static void setPortionChoice(int portionChoice) {
        Choice.portionChoice = portionChoice;
    }

    public static void clearChoice() {
        Choice.cerealChoice = -1;
        Choice.milkChoice = -1;
        Choice.portionChoice = -1;
    }

    public String toString() {
        String out = Container.cerealContainer[cerealChoice].getName();
        out += " " + Container.milkContainer[milkChoice].getName();
        out += " size: " + portionChoice;

        return out;
    }
}

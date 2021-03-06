package application;

import back_end.Milk;
import back_end.Container;
import java.util.List;

public class MilkListSorter {
    public List<Milk> milks = Container.milks;

    public MilkListSorter(String property){
        quickSort(milks, 0, milks.size() - 1, property);


    }

    private void quickSort(List<Milk> list, int x, int y, String property) {
        if (x < y) {
            int i = x, j = y;
            int midIndex = (i + j) / 2;
            Milk mid = list.get(midIndex);

            switch (property) {
                case "alphabetical":
                    do {
                        while (list.get(i).getName().compareTo(mid.getName()) < 0) {
                            i++;
                        }
                        while (mid.getName().compareTo(list.get(j).getName()) < 0) {
                            j--;
                        }

                        if (i <= j) {
                            Milk temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                            i++;
                            j--;
                        }

                    } while (i <= j);
                    break;
                case "calories":
                    do {
                        while (list.get(i).getCalories() > mid.getCalories()) {
                            i++;
                        }
                        while (mid.getCalories() > list.get(j).getCalories()) {
                            j--;
                        }

                        if (i <= j) {
                            Milk temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                            i++;
                            j--;
                        }

                    } while (i <= j);
                    break;
                case "fat":
                    do {
                        while (list.get(i).getFat() > mid.getFat()) {
                            i++;
                        }
                        while (mid.getFat() > list.get(j).getFat()) {
                            j--;
                        }

                        if (i <= j) {
                            Milk temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                            i++;
                            j--;
                        }

                    } while (i <= j);
                    break;
                case "carbs":
                    do {
                        while (list.get(i).getCarbs() > mid.getCarbs()) {
                            i++;
                        }
                        while (mid.getCarbs() > list.get(j).getCarbs()) {
                            j--;
                        }

                        if (i <= j) {
                            Milk temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                            i++;
                            j--;
                        }

                    } while (i <= j);
                    break;
                case "protein":
                    do {
                        while (list.get(i).getProtein() > mid.getProtein()) {
                            i++;
                        }
                        while (mid.getProtein() > list.get(j).getProtein()) {
                            j--;
                        }

                        if (i <= j) {
                            Milk temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                            i++;
                            j--;
                        }

                    } while (i <= j);
                    break;
                default:
                    break;
            }

            quickSort(list, x, j, property);
            quickSort(list, i, y, property);
        }
    }
}


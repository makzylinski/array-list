import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

record GroceryItem(String name) {
    public GroceryItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name.toUpperCase());
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<GroceryItem> groceries = new ArrayList<>();
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.printf("%s%n".repeat(3),
                    "0 - shutdown", "1 - add items to list (comma delimited list)", "2 - remove items (comma delimited list)");
            System.out.print("Enter a number for which action you want to do: ");
            String selectedOption = s.nextLine();

            System.out.println();

            if(Integer.parseInt(selectedOption) == 0) {
                break;
            }

            if(Integer.parseInt(selectedOption) == 1) {
                System.out.print("Add item(s): ");
                String items = s.nextLine();
                String[] itemsArray = items.split(",");
                for (String item : itemsArray) {
                    groceries.add(new GroceryItem(item));
                }

                System.out.print(sortArray(groceries));
            }


            if(Integer.parseInt(selectedOption) == 2) {
                System.out.print("Remove item(s): ");
                String items = s.nextLine();
                String[] itemsArray = items.split(",");
                for (String item : itemsArray) {
                    groceries.remove(new GroceryItem(item));
                }

                System.out.print(sortArray(groceries));

            }
        }
    }

    public static ArrayList<GroceryItem> sortArray(ArrayList<GroceryItem> groceryArr) {
        groceryArr.sort(Comparator.comparing(GroceryItem::name));
        return groceryArr;
    }
}

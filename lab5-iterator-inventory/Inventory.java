import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        // use an iterator so removing is safe
        Iterator<Item> iter = items.iterator();

        while (iter.hasNext()) {
            Item current = iter.next();

            // remove the first match for name1
            if (!found1 && current.getName().equalsIgnoreCase(name1)) {
                found1 = true;
                iter.remove();
            }
            // remove the first match for name2
            else if (!found2 && current.getName().equalsIgnoreCase(name2)) {
                found2 = true;
                iter.remove();
            }
        }

        // only add the new item if both were found
        if (found1 && found2) {
            Item combined = new Item("Magic Staff");
            items.add(combined);
            System.out.println(name1 + " and " + name2 + " were combined into " + combined + ".");
        } else {
            System.out.println("Could not combine items.");

            // put back anything that got removed if it failed
            if (found1) {
                items.add(new Item(name1));
            }
            if (found2) {
                items.add(new Item(name2));
            }
        }
    }
}

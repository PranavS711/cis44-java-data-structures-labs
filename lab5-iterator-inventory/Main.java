public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // starting items
        inventory.addItem(new Item("Wood"));
        inventory.addItem(new Item("Crystal"));
        inventory.addItem(new Item("Potion"));
        inventory.addItem(new Item("Rope"));

        System.out.println("Before combining:");
        inventory.display();

        System.out.println();
        System.out.println("Combining Wood and Crystal...");
        inventory.combineItems("Wood", "Crystal");

        System.out.println();
        System.out.println("After combining:");
        inventory.display();
    }
}

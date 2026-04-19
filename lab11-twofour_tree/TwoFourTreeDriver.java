public class TwoFourTreeDriver {
    public static void main(String[] args) {
        TwoFourTree tree = new TwoFourTree();

        int[] keys = {10, 20, 30, 40, 50, 60, 70, 80, 90, 5, 15, 25, 35};

        System.out.println("Inserting keys into 2-4 Tree...\n");

        for (int key : keys) {
            System.out.println("Inserting: " + key);
            tree.insert(key);
        }

        System.out.println("\nFinal Tree:");
        tree.inorder();

        System.out.println("\nExpected:");
        System.out.println("5 10 15 20 25 30 35 40 50 60 70 80 90");
    }
}

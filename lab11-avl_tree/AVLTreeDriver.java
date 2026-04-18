public class AVLTreeDriver {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        // insert values that trigger rotations
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // left rotate

        tree.insert(5);
        tree.insert(4); // right rotate

        tree.insert(8); // left right rotate

        tree.insert(25); // right left rotate

        // print traversals
        System.out.print("Inorder: ");
        tree.inorder();   // should be sorted

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();
    }
}

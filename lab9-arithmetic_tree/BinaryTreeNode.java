public class BinaryTreeNode {
    String value; // operator or operand
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Preorder traversal (Prefix notation)
     * Visit Parent, Left, Right
     */
    public void traversePreorder() {
        System.out.print(value + " "); // print this node first
        if (left != null) left.traversePreorder(); // then left child
        if (right != null) right.traversePreorder(); // then right child
    }

    /**
     * Inorder traversal (Infix notation)
     * Visit Left, Parent, Right
     * Parentheses added for clarity
     */
    public void traverseInorder() {
        if (left != null) {
            System.out.print("("); // start parentheses for left subtree
            left.traverseInorder();
        }
        System.out.print(value + " "); // print parent
        if (right != null) {
            right.traverseInorder();
            System.out.print(")"); // close parentheses after right subtree
        }
    }

    /**
     * Postorder traversal (Postfix / RPN)
     * Visit Left, Right, Parent
     */
    public void traversePostorder() {
        if (left != null) left.traversePostorder();
        if (right != null) right.traversePostorder();
        System.out.print(value + " "); // print parent last
    }
}

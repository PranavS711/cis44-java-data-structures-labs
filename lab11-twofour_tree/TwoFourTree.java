import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Node class for 2-4 tree
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Node is overfull when it has 4 keys (needs split)
    public boolean isOverflow() {
        return keys.size() > 3;
    }

    // Get next child to go down to
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert key into node and keep sorted
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // go down to leaf
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // insert key in leaf
        node.insertKey(key);

        // fix overflow going up
        while (node != null && node.isOverflow()) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // middle key gets pushed up
        int midIndex = 1;
        int midKey = node.keys.get(midIndex);

        // create left and right nodes
        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();

        left.keys.add(node.keys.get(0));
        right.keys.add(node.keys.get(2));
        right.keys.add(node.keys.get(3));

        // handle children if not leaf
        if (!node.isLeaf()) {
            for (int i = 0; i <= 1; i++) {
                left.children.add(node.children.get(i));
                node.children.get(i).parent = left;
            }
            for (int i = 2; i < node.children.size(); i++) {
                right.children.add(node.children.get(i));
                node.children.get(i).parent = right;
            }
        }

        // if splitting root
        if (node == root) {
            root = new TwoFourNode();
            root.keys.add(midKey);
            root.children.add(left);
            root.children.add(right);
            left.parent = root;
            right.parent = root;
        } else {
            TwoFourNode parent = node.parent;

            // add middle key to parent
            parent.insertKey(midKey);

            // replace old node with left and right
            int index = parent.children.indexOf(node);
            parent.children.remove(index);

            parent.children.add(index, left);
            parent.children.add(index + 1, right);

            left.parent = parent;
            right.parent = parent;
        }
    }

    // inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a general tree node for a company hierarchy.
 */
public class GeneralTreeNode {
    String name; // Employee name or department
    GeneralTreeNode parent; // reference to parent
    List<GeneralTreeNode> children; // list of child nodes

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this; // set this node as parent
        this.children.add(child); // add to children list
    }

    /**
     * Preorder traversal: visit parent first, then children
     */
    public void traversePreorder() {
        System.out.println(this.name); // print this node
        for (GeneralTreeNode child : children) {
            child.traversePreorder(); // recursively traverse each child
        }
    }

    /**
     * Postorder traversal: visit children first, then parent
     */
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {
            child.traversePostorder(); // recursively traverse each child
        }
        System.out.println(this.name); // print this node after children
    }
}

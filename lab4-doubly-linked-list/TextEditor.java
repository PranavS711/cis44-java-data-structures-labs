public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // empty text
        currentNode = new Node("", null, null);
    }

    public void add(String newText) {
        if (newText == null) newText = "";

        // if we type after undo redo history should be deleted
        if (currentNode.next != null) {
            currentNode.next = null;
        }

        String updated = currentNode.textState + newText;

        Node newNode = new Node(updated, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev == null) {
            System.out.println("Nothing to undo.");
            return currentNode.textState;
        }

        currentNode = currentNode.prev;
        return currentNode.textState;
    }

    public String redo() {
        if (currentNode.next == null) {
            System.out.println("Nothing to redo.");
            return currentNode.textState;
        }

        currentNode = currentNode.next;
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println("Current text:");
        System.out.println(currentNode.textState);
    }

    public String getCurrentText() {
        return currentNode.textState;
    }
}

public class Playlist {

    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        if (song == null) return;

        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void removeSong(String title) {
        if (head == null || title == null) {
            System.out.println("Playlist is empty or title is invalid.");
            return;
        }

        // removing the head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            if (currentNode == head) {
                currentNode = head.next; // move current forward
            }

            head = head.next;
            size--;

            // if list became empty
            if (head == null) {
                tail = null;
                currentNode = null;
            }

            System.out.println("Removed: " + title);
            return;
        }

        // removing from the middle or the end
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(title)) {

                if (currentNode == curr) {
                    currentNode = curr.next; // move current forward
                }

                prev.next = curr.next;

                // if removing tail
                if (curr == tail) {
                    tail = prev;
                }

                size--;
                System.out.println("Removed: " + title);
                return;
            }

            prev = curr;
            curr = curr.next;
        }

        System.out.println("Song not found: " + title);
    }

    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.song);

        // move to next wrap if needed
        if (currentNode.next == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        int i = 1;

        while (temp != null) {
            String marker = (temp == currentNode) ? " <-- current" : "";
            System.out.println(i + ". " + temp.song + marker);
            temp = temp.next;
            i++;
        }
    }

    public int size() {
        return size;
    }
}

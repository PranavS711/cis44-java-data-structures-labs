import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlaylist Manager");
            System.out.println("1 Add song");
            System.out.println("2 Remove song by title");
            System.out.println("3 Play next");
            System.out.println("4 Display playlist");
            System.out.println("0 Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Goodbye");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Song title: ");
                String title = sc.nextLine();

                System.out.print("Artist: ");
                String artist = sc.nextLine();

                playlist.addSong(new Song(title, artist));
                System.out.println("Added");

            } else if (choice.equals("2")) {
                System.out.print("Title to remove: ");
                String title = sc.nextLine();
                playlist.removeSong(title);

            } else if (choice.equals("3")) {
                playlist.playNext();

            } else if (choice.equals("4")) {
                playlist.displayPlaylist();

            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}

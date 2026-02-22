import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nText Editor");
            System.out.println("1 Type text");
            System.out.println("2 Undo");
            System.out.println("3 Redo");
            System.out.println("4 Print current");
            System.out.println("0 Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Goodbye");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Type something to add: ");
                String add = sc.nextLine();
                editor.add(add);
                editor.printCurrent();

            } else if (choice.equals("2")) {
                editor.undo();
                editor.printCurrent();

            } else if (choice.equals("3")) {
                editor.redo();
                editor.printCurrent();

            } else if (choice.equals("4")) {
                editor.printCurrent();

            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}

package SmartLife;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            MobileApplication app = new MobileApplication();
            while (true) {
                System.out.println("\n===== SmartLife Mobile Application =====");
                System.out.println("1. Launch Application");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        app.launchApp(sc);
                        break;

                    case "2":
                        System.out.println("Exiting SmartLife. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid menu choice.");
                }
            }
        }
    }
}

package SmartLife;
import java.util.Scanner;
public class MobileApplication {
    private final DeviceManager deviceManager = new DeviceManager();
    private final NetworkService networkService = new NetworkService();

    public void launchApp(Scanner sc) {

        try {
            System.out.print("Enter OS version: ");
            int osVersion = Integer.parseInt(sc.nextLine());

            System.out.print("Enter minimum supported OS version: ");
            int minimumVersion = Integer.parseInt(sc.nextLine());

            System.out.print("Enter available storage (MB): ");
            int storageMB = Integer.parseInt(sc.nextLine());

            try {
                deviceManager.checkDeviceCompatibility(
                        osVersion, minimumVersion, storageMB);

                // Network stage starts only if device validation succeeds
                try {
                    System.out.println("\nSelect Network Condition:");
                    System.out.println("1. Internet Available");
                    System.out.println("2. Internet Unavailable");
                    System.out.print("Enter your choice: ");

                    int networkChoice = Integer.parseInt(sc.nextLine());

                    if (networkChoice != 1 && networkChoice != 2) {
                        throw new IllegalArgumentException(
                                "Invalid network choice.");
                    }

                    int serverChoice = 0;

                    if (networkChoice == 1) {
                        System.out.println("\nSelect Server Response:");
                        System.out.println("1. Server Responds Successfully");
                        System.out.println("2. Server Times Out");
                        System.out.println(
                                "3. Server Times Out Twice, Then Succeeds");
                        System.out.print("Enter your choice: ");

                        serverChoice = Integer.parseInt(sc.nextLine());

                        if (serverChoice < 1 || serverChoice > 3) {
                            throw new IllegalArgumentException(
                                    "Invalid server response choice.");
                        }
                    }

                    networkService.connectToServer(
                            networkChoice, serverChoice);

                    System.out.println("Application launched successfully.");

                } catch (NetworkUnavailableException e) {
                    ExceptionHandler.handleException(e);

                } catch (ServerTimeoutException e) {
                    // Wrap the original network exception
                    throw new ApplicationStartException(
                            "Unable to connect to the server.", e);
                }

            } catch (UnsupportedOSException |
                     InsufficientStorageException e) {
                ExceptionHandler.handleException(e);
            }

        } catch (ApplicationStartException e) {
            ExceptionHandler.handleException(e);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Application startup process completed.");
        }

    }
}

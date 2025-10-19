import java.util.ArrayList; // Import ArrayList to store bookings
import java.util.Scanner;   // Import Scanner for user input

// Class representing the Booking System
public class OnlineBookingSystem {

    // List to store all booked slots
    static ArrayList<String> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input
        int choice; // Variable to store user menu choice

        // Infinite loop for the menu until user chooses to exit
        while (true) {
            System.out.println("\n--- Online Booking System ---");
            System.out.println("1. Book a Slot");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume newline left by nextInt

            switch (choice) {
                case 1:
                    // Book a slot
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date and time (e.g., 2025-10-20 10:00AM): ");
                    String slot = scanner.nextLine();
                    String booking = name + " - " + slot; // Create booking string
                    bookings.add(booking); // Add booking to list
                    System.out.println("Booking confirmed: " + booking);
                    break;

                case 2:
                    // View all bookings
                    System.out.println("\n--- All Bookings ---");
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings yet.");
                    } else {
                        for (int i = 0; i < bookings.size(); i++) {
                            System.out.println((i + 1) + ". " + bookings.get(i));
                        }
                    }
                    break;

                case 3:
                    // Cancel a booking
                    System.out.println("\n--- Cancel Booking ---");
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings to cancel.");
                    } else {
                        for (int i = 0; i < bookings.size(); i++) {
                            System.out.println((i + 1) + ". " + bookings.get(i));
                        }
                        System.out.print("Enter the number of the booking to cancel: ");
                        int cancelIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (cancelIndex > 0 && cancelIndex <= bookings.size()) {
                            String removed = bookings.remove(cancelIndex - 1);
                            System.out.println("Booking cancelled: " + removed);
                        } else {
                            System.out.println("Invalid booking number.");
                        }
                    }
                    break;

                case 4:
                    // Exit program
                    System.out.println("Exiting... Thank you!");
                    scanner.close(); // Close scanner
                    System.exit(0); // End program
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
package foodQuick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FoodQuick {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Welcome message
    System.out.println("Welcome to the Food Quick System!");

    // -----------------------------
    // Capturing Customer details
    // -----------------------------
    System.out.print("Enter customer name: ");
    String name = sc.nextLine();

    System.out.print("Enter customer contact number: ");
    String contactNumber = sc.nextLine();

    System.out.print("Enter customer email address: ");
    String email = sc.nextLine();

    System.out.print("Enter customer delivery address: ");
    String address = sc.nextLine();

    System.out.print("Enter customer city/location: ");
    String location = sc.nextLine();

    Customer customer = new Customer(name, contactNumber, email, address, location);

    // -----------------------------
    // Capturing Restaurant details
    // -----------------------------
    System.out.print("Enter restaurant name: ");
    String restaurantName = sc.nextLine();

    System.out.print("Enter restaurant location: ");
    String restaurantLocation = sc.nextLine();

    System.out.print("Enter restaurant contact number: ");
    String restaurantContactNumber = sc.nextLine();

    Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);

    // -----------------------------
    // Capturing Order details
    // -----------------------------
    int orderNumber = 1;
    Order order = new Order(orderNumber);

    System.out.print("How many different meals are you ordering? ");
    int numMeals = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < numMeals; i++) {
      System.out.println("Meal " + (i + 1) + ":");

      System.out.print("Enter meal name: ");
      String mealName = sc.nextLine();

      System.out.print("Enter quantity: ");
      int quantity = Integer.parseInt(sc.nextLine());

      System.out.print("Enter price: ");
      double price = Double.parseDouble(sc.nextLine());

      order.addMeal(mealName, quantity, price);
    }

    // -----------------------------
    // Special Instructions
    // -----------------------------
    System.out.print("Enter any special preparation instructions (or type 'none'): ");
    String instructions = sc.nextLine();
    if (instructions.isEmpty()) {
      instructions = "none"; // default if blank
    }
    order.setSpecialInstructions(instructions);

    // -----------------------------
    // Reading driver-info.txt and creating Driver objects
    // -----------------------------
    ArrayList<Driver> drivers = new ArrayList<>();

    try {
      File file = new File("driver-info.txt");
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine().trim();
        if (line.isEmpty())
          continue; // skip empty lines

        String[] parts = line.split(",");
        if (parts.length != 3)
          continue; // skip invalid lines

        String driverName = parts[0].trim();
        String driverLocation = parts[1].trim();
        int driverLoad = Integer.parseInt(parts[2].trim());

        Driver driver = new Driver(driverName, driverLocation, driverLoad);
        drivers.add(driver);
      }

      fileScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: driver-info.txt file not found.");
    }

    // -----------------------------
    // Selecting the nearest driver with the lowest load
    // -----------------------------
    Driver selectedDriver = null;
    int minLoad = Integer.MAX_VALUE;

    for (Driver d : drivers) {
      if (d.getLocation().equalsIgnoreCase(restaurant.getLocation()) && d.getLoad() < minLoad) {
        selectedDriver = d;
        minLoad = d.getLoad();
      }
    }

    // -----------------------------
    // Generating invoice.txt
    // -----------------------------
    try {
      Formatter formatter = new Formatter("invoice.txt");

      if (selectedDriver == null) {
        formatter.format("Sorry! Our drivers are too far away from you to be able to deliver to your location.%n");
      } else {
        // Customer details
        formatter.format("Order number %d%n", orderNumber);
        formatter.format("Customer: %s%n", customer.getName());
        formatter.format("Email: %s%n", customer.getEmail());
        formatter.format("Phone number: %s%n", customer.getContactNumber());
        formatter.format("Location: %s%n%n", customer.getLocation());

        // Restaurant and meals
        formatter.format("You have ordered the following from %s in %s:%n", restaurant.getName(),
            restaurant.getLocation());

        for (int i = 0; i < order.getMealNames().size(); i++) {
          formatter.format("%d x %s (R%.2f)%n", order.getMealQuantities().get(i), order.getMealNames().get(i),
              order.getMealPrices().get(i));
        }

        formatter.format("Special instructions: %s%n", order.getSpecialInstructions());

        // Total
        double total = order.calculateTotal();
        formatter.format("Total: R%.2f%n%n", total);

        // Delivery info
        formatter.format("%s is nearest to the restaurant and will deliver your order to:%n", selectedDriver.getName());
        formatter.format("%s%n", customer.getAddress());

        // Restaurant contact
        formatter.format("Restaurant contact: %s%n", restaurant.getContactNumber());
      }

      formatter.close();
      System.out.println("Invoice generated successfully!");

    } catch (Exception e) {
      System.out.println("Error generating invoice: " + e.getMessage());
    }

    sc.close();
  }
}

package foodQuick;

import java.util.ArrayList;

public class Order {

  // Attributes
  private int orderNumber;

  private ArrayList<String> mealNames;

  private ArrayList<Integer> mealQuantities;

  private ArrayList<Double> mealPrices;

  private String specialInstructions;

  private double totalAmount;

  // Constructor
  public Order(int orderNumber) {
    this.orderNumber = orderNumber;

    this.mealNames = new ArrayList<>();
    this.mealQuantities = new ArrayList<>();
    this.mealPrices = new ArrayList<>();

    this.specialInstructions = "";
    this.totalAmount = 0.0;

  }

  // Methods
  public void addMeal(String name, int quantity, double price) {
    mealNames.add(name);
    mealQuantities.add(quantity);
    mealPrices.add(price);
  }

  public void setSpecialInstructions(String instructions) {
    this.specialInstructions = instructions;
  }

  public double calculateTotal() {
    totalAmount = 0.0;

    for (int i = 0; i < mealNames.size(); i++) {
      totalAmount += mealPrices.get(i) * mealQuantities.get(i);
    }

    return totalAmount;
  }

// Getters
  public int getOrderNumber() {
    return orderNumber;
  }

  public ArrayList<String> getMealNames() {
    return mealNames;
  }

  public ArrayList<Integer> getMealQuantities() {
    return mealQuantities;
  }

  public ArrayList<Double> getMealPrices() {
    return mealPrices;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }

}

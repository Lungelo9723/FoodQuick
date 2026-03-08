# Food Quick Delivery System

## Overview
The **Food Quick Delivery System** is a console-based Java application that simulates a simple food ordering and delivery management system. 
The program captures customer and restaurant details, processes meal orders, assigns a suitable delivery driver based on location and workload, 
and generates an invoice for the order.

This project was developed as part of an **Object-Oriented Programming (OOP) capstone task**, focusing on proper class design, file handling, 
and program structure.

---

## Features

The program performs the following tasks:

1. **Capture Customer Information**
   - Customer name
   - Contact number
   - Email address
   - Delivery address
   - Customer location

2. **Capture Restaurant Information**
   - Restaurant name
   - Restaurant location
   - Restaurant contact number

3. **Capture Order Details**
   - Number of meals ordered
   - Meal name
   - Quantity
   - Price per meal
   - Special preparation instructions

4. **Driver Selection**
   - Reads driver information from `driver-info.txt`
   - Finds a driver in the same location as the restaurant
   - Selects the driver with the **lowest current delivery load**

5. **Invoice Generation**
   - Creates an `invoice.txt` file
   - Displays order details, meals ordered, total cost, and delivery driver information

---

## Program Structure

The system uses several classes to organize the functionality:

### Customer
Stores customer details such as name, contact number, email, address, and location.

### Restaurant
Stores restaurant details including name, location, and contact number.

### Order
Handles meal information including:
- Meal names
- Quantities
- Prices
- Special instructions
- Calculation of total order cost

### Driver
Represents delivery drivers and stores:
- Driver name
- Driver location
- Current delivery load

### FoodQuick
The main controller class that:
- Captures user input
- Reads driver data from file
- Selects the most suitable driver
- Generates the invoice

---

## File Requirements

### driver-info.txt
The program requires a file called **driver-info.txt** in the same directory as the program.

Example format:

John Krill, Cape Town, 4
Jane Doe, Johannesburg, 2
Mike Adams, Cape Town, 1

Format:
Driver Name, Location, Current Load

---

## How to Run the Program

1. Ensure all `.java` files are in the same folder:
   - Customer.java
   - Restaurant.java
   - Order.java
   - Driver.java
   - FoodQuick.java

2. Ensure `driver-info.txt` is also in the same folder.

3. Compile the program:

javac *.java

4. Run the program:

java FoodQuick

5. Follow the prompts in the console.

6. After the program runs, an **invoice.txt** file will be generated in the project folder.

---

## Output

Example invoice output:

Order number 1
Customer: John Smith
Email: john@email.com
Phone number: 0821234567
Location: Cape Town

You have ordered the following from Pizza Place in Cape Town:
2 x Pepperoni Pizza (R89.99)
1 x Garlic Bread (R39.99)

Special instructions: none
Total: R219.97

Mike Adams is nearest to the restaurant and will deliver your order to:
12 Main Road

Restaurant contact: 0211234567

---

## Notes

- The **order number is currently static** and set to `1` for simplicity.
- The program assumes that numeric inputs such as quantities and prices are entered correctly.
- The system will output a message in the invoice if no drivers are available in the restaurant’s location.

---

## Technologies Used

- Java
- Object-Oriented Programming principles
- File handling
- Console-based user input
- Formatter for structured file output

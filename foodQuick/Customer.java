package foodQuick;

public class Customer {

  // Attributes
  private String name;
  private String contactNumber;
  private String email;
  private String address;
  private String location;

  // Constructor
  public Customer(String name, String contactNumber, String email, String address, String location) {
    this.name = name;
    this.contactNumber = contactNumber;
    this.email = email;
    this.address = address;
    this.location = location;
  }

  // Methods (getters)
  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getLocation() {
    return location;
  }
}
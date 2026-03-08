package foodQuick;

public class Restaurant {

  // Attributes
  private String name;
  private String location;
  private String contactNumber;

  // Constructor
  public Restaurant(String name, String location, String contactNumber) {
    this.name = name;
    this.location = location;
    this.contactNumber = contactNumber;

  }

  // Methods
  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public String getContactNumber() {
    return contactNumber;
  }
}
package foodQuick;

public class Driver {

  // Attributes
  private String name;
  private String location;
  private int load;

  // Constructor
  public Driver(String name, String location, int load) {
    this.name = name;
    this.location = location;
    this.load = load;
  }

  // Methods (getters)
  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public int getLoad() {
    return load;
  }
}

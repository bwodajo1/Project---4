/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Represents a Property with details such as city, owner, property name, rent amount, and plot.
 * Due: 11/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
package application;

/**
 * The Property class represents a property with details such as city, owner, property name, rent amount, and plot.
 */
public class Property {

    private String city;          // City where the property is located
    private String owner;         // Owner of the property
    private String propertyName;  // Name of the property
    private double rentAmount;    // Rent amount for the property
    private Plot plot;            // Plot associated with the property

    /**
     * Default constructor that initializes the property with default values.
     */
    public Property() {
        this.city = "";
        this.owner = "";
        this.propertyName = "";
        this.rentAmount = 0;
        this.plot = new Plot();
    }

    /**
     * Copy constructor that creates a property based on another property.
     *
     * @param p The property to copy.
     */
    public Property(Property p) {
        this.city = p.city;
        this.owner = p.owner;
        this.propertyName = p.propertyName;
        this.rentAmount = p.rentAmount;
        this.plot = new Plot(p.plot);
    }

    /**
     * Parameterized constructor that creates a property with specified details.
     *
     * @param propertyName The name of the property.
     * @param city         The city where the property is located.
     * @param rentAmount   The rent amount for the property.
     * @param owner        The owner of the property.
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.city = city;
        this.owner = owner;
        this.propertyName = propertyName;
        this.rentAmount = rentAmount;
        this.plot = new Plot();
    }

    /**
     * Parameterized constructor that creates a property with specified details and plot.
     *
     * @param propertyName The name of the property.
     * @param city         The city where the property is located.
     * @param rentAmount   The rent amount for the property.
     * @param owner        The owner of the property.
     * @param x            The x-coordinate of the bottom-left corner of the plot.
     * @param y            The y-coordinate of the bottom-left corner of the plot.
     * @param width        The width of the plot.
     * @param depth        The depth of the plot.
     */
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.city = city;
        this.owner = owner;
        this.propertyName = propertyName;
        this.rentAmount = rentAmount;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * Getter for the city.
     *
     * @return The city where the property is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city.
     *
     * @param city The new city where the property is located.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the owner.
     *
     * @return The owner of the property.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter for the owner.
     *
     * @param owner The new owner of the property.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Getter for the property name.
     *
     * @return The name of the property.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Setter for the property name.
     *
     * @param propertyName The new name of the property.
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Getter for the rent amount.
     *
     * @return The rent amount for the property.
     */
    public double getRentAmount() {
        return rentAmount;
    }

    /**
     * Setter for the rent amount.
     *
     * @param rentAmount The new rent amount for the property.
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    /**
     * Getter for the plot.
     *
     * @return The plot associated with the property.
     */
    public Plot getPlot() {
        return plot;
    }

    /**
     * Returns a string representation of the property including its details.
     *
     * @return A string representation of the property.
     */
    @Override
    public String toString() {
        return "Property Name: " + propertyName + "\nLocated in " + city + "\nBelonging to " + owner
                + "\nRent Amount: " + rentAmount;
    }
}

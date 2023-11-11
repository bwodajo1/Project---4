package application;

/**
 * The ManagementCompany class represents a management company that manages properties.
 * It includes information such as the company name, tax ID, management fee percentage,
 * properties managed, and the plot of the management company.
 */
public class ManagementCompany {

    // Instance variables
    private String name;
    private String taxID;
    private double mgmFeePercentage;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constants
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Constructors
    /**
     * Default constructor for ManagementCompany.
     * Initializes instance variables with default values.
     */
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePercentage = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    /**
     * Parameterized constructor for ManagementCompany.
     * Initializes instance variables with provided values.
     *
     * @param name              The name of the management company.
     * @param taxID             The tax ID of the management company.
     * @param mgmFeePercentage The management fee percentage.
     */
    public ManagementCompany(String name, String taxID, double mgmFeePercentage) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePercentage = mgmFeePercentage;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getter/Setter methods

    /**
     * Get the name of the management company.
     *
     * @return The name of the management company.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the management company.
     *
     * @param name The new name of the management company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the tax ID of the management company.
     *
     * @return The tax ID of the management company.
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * Set the tax ID of the management company.
     *
     * @param taxID The new tax ID of the management company.
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     * Get the management fee percentage.
     *
     * @return The management fee percentage.
     */
    public double getMgmFeePercentage() {
        return mgmFeePercentage;
    }

    /**
     * Set the management fee percentage.
     *
     * @param mgmFeePercentage The new management fee percentage.
     */
    public void setMgmFeePercentage(double mgmFeePercentage) {
        this.mgmFeePercentage = mgmFeePercentage;
    }

    /**
     * Get the array of properties managed by the company.
     *
     * @return The array of properties.
     */
    public Property[] getProperties() {
        return properties;
    }

    /**
     * Get the plot of the management company.
     *
     * @return The plot of the management company.
     */
    public Plot getPlot() {
        return plot;
    }

    /**
     * Get the number of existing properties in the array.
     *
     * @return The number of existing properties.
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    /**
     * Get the total rent amount for all properties.
     *
     * @return The total rent amount.
     */
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                break;
            }
            total += properties[i].getRentAmount();
        }
        return total;
    }

    /**
     * Get the property with the highest rent amount.
     *
     * @return The property with the highest rent amount.
     */
    public Property getHighestRentPropperty() {
        int index = -1;
        double max = 0;

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                break;
            }
            if (properties[i].getRentAmount() > max) {
                max = properties[i].getRentAmount();
                index = i;
            }
        }

        if (index != -1) {
            return properties[index];
        } else {
            return null; // Return null if no property is found
        }
    }

    /**
     * Add a property to the management company.
     * This method returns one of the following values depending on the success or failure of adding the property:
     * - If there is a problem adding the property, this method will return:
     *   -1 if the array is full,
     *   -2 if the property is null,
     *   -3 if the plot for the property is not encompassed by the management company plot,
     *   -4 if the plot for the property overlaps any other property’s plot.
     * - Otherwise, if the property is successfully added, it will return the index of the array where the property was added.
     *
     * @param property The property to be added.
     * @return The result code based on the success or failure of adding the property.
     */
    public int addProperty(Property property) {
        if (isPropertiesFull()) {
            return -1; // Array is full
        }

        if (property == null) {
            return -2; // Property is null
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3; // Property plot is not encompassed by the management company plot
        }

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Property plot overlaps with another property's plot
            } else if (properties[i] == null) {
                properties[i] = property;
                numberOfProperties++;
                return i; // Property added successfully
            }
        }

        return -1; // Should not reach here
    }

    /**
     * Remove the last property in the properties array.
     * This method nullifies the last property in the array and decrements the number of properties.
     */
    public void removeLastProperty() {
        // Check if there are properties in the array
        if (numberOfProperties > 0) {
            // Nullify the last property in the array
            properties[numberOfProperties - 1] = null;
            // Decrement the number of properties
            numberOfProperties--;
        }
    }

    /**
     * Check if the properties array is full.
     *
     * @return True if the properties array is full, false otherwise.
     */
    private boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }
    @Override
    public String toString() {
        String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        result += "______________________________________________________\n";

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                break;
            }
            result += properties[i] + "\n";
        }

        result += "______________________________________________________\n";
        result += "total management Fee: " + (getTotalRent() * mgmFeePercentage / 100) + "\n";

        return result;
    }
}

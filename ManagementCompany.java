
public class ManagementCompany {

	// Fields
	private int MAX_PROPERTY = 5;				// Maximum number of properties that this management company handles
	private int MGMT_WIDTH = 10;				// The default width of a plot
	private int MGMT_DEPTH = 10;				// The default depth of a plot
	private double mgmFeePer;					// Management fee percentage
	private String name;						// Name of the management company
	private String taxID;						// Tax ID of the management company
	private Plot plot;							// Plot of the ManagementCompany
	private Property [] properties;				// An array of the Property objects
	
	// Constructors
	
	/**
	 * No-arg constructor
	 */
	public ManagementCompany() {
		name = taxID = null;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Parameterized constructor, without plot information and array information
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];		
	}
	
	/**
	 * Parameterized constructor, without array information
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Copy constructor
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		plot = new Plot(otherCompany.plot);
		properties = otherCompany.properties;
	}
	
	// Methods
	
	/**
	 * Returns the MAX_PROPERTY constant
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * Returns the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Creates a property object by copying from another property and adds it to the properties array.
	 * These are the possible return codes:
	 * -1 = The array is full
	 * -2 = The property is null
	 * -3 = The plot is not contained by the ManagementCompany plot
	 * -4 = The plot overlaps any other property
	 * 0 through 4 = the index in the array where the property was added
	 */
	public int addProperty(Property property) {
		// Checks if new property is empty
		if (property == null) {
			return -2;
		}
		
		// Checks if the new plot is encompassed by company plot
		if (plot.encompasses(property.getPlot()) == false) {
			return -3;
		}
		
		// For loop to go through the array
		for (int index = 0; index < properties.length; index++) {
			// Check if it is not empty, to check for overlap
			if (properties[index] != null) {
				if (properties[index].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
			// If array index is able to be filled
			else {
				properties[index] = property;
				return index;
			}
		}
		
		// If array is full
		return -1;
	}

	/**
	 * Creates a property object, with the property information but no plot information, to the properties array.
	 * Uses the same return codes from the same overloaded 'addProperty' method
	 */
	public int addProperty(String city, String owner, String propertyName, double rentAmount) {
		return addProperty(new Property(propertyName, city, rentAmount, owner));
	}
	
	/**
	 * Creates a property object, with the property information and plot information, to the properties array.
	 * Uses the same return codes from the same overloaded 'addProperty' method
	 */
	public int addProperty(String city, String owner, String propertyName, double rentAmount, int x, int y, int width, int depth) {
		return addProperty(new Property(propertyName, city, rentAmount, owner, x, y, width, depth));
	}

	/**
	 * This method sums all the property's rent in the 'properties' array and returns the total amount
	 */
	public double totalRent() {
		double total = 0.0;			// Running total
		
		for (int i = 0; i < properties.length && properties[i] != null; i++) {
				total += properties[i].getRentAmount();
		}
		
		return total;
	}
	
	/**
	 * This method finds the property with the highest rent.
	 */
	public double maxRentProp() {
		double max = properties[0].getRentAmount();
		
		for (int i = 1; i < properties.length && properties[i] != null; i++) {
			if (properties[i].getRentAmount() > max)
				max = properties[i].getRentAmount();
		}		
		return max;
			
	}

	/**
	 * This method finds the index of the property with the maximum rent amount.
	 */
	public int maxRentPropertyIndex() {
		int index = 0;
		
		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			if (properties[i].getRentAmount() == maxRentProp()) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Displays the information of the property at index i
	 */
	public String displayPropertyAtIndex(int i) {
		String rtrnString = "";
		if (properties[i] != null) {
			rtrnString = properties[i].toString();
		}
		return rtrnString;
	}

	/**
	 * Display all the information of all the properties in the properties array.
	 */
	public String toString() {
		// Management Company header
		String propertyInfo = "List of properties for " + name + ", taxID: " + taxID 
				+ "\n__________\n";
		
		// Individual property information
		for (int i = 0; i < properties.length && properties[i] != null; i++) {
				propertyInfo += properties[i].toString();
		}
		
		propertyInfo += "\n__________\n" 
				+ "\nTotal Management Fee: $" + (totalRent() * mgmFeePer) + "\n";
		
		return propertyInfo;
	}
}
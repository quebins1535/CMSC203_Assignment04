
public class Property {

	// Fields
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	// Constructors
	
	/**
	 * No-arg constructor
	 */
	public Property() {
		city = owner = propertyName = null;
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	/**
	 * Copy constructor
	 */
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = new Plot(p.plot);
	}
	
	/**
	 * Parameterized constructor, without Plot information
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	/**
	 * Parameterized constructor, with Plot information
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}
	
	// Methods
	
	/**
	 * Set the city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Return the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Set the propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * Return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * Set the rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	/**
	 * Return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * Set the plot
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
	}
	
	/**
	 * Return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Returns the name of the city, owner, propertyName, rentAmount for a property
	 */
	public String toString() {
		return ("Property Name: " + propertyName +
				"\nLocated in " + city +
				"\nBelonging to: " + owner +
				"\nRent Amount: " + rentAmount + "\n");
		
	}
}

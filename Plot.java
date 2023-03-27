
public class Plot {

	// Fields
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// Constructors
	
	/**
	 * No-arg constructor, sets x and y to 0, width and depth to 1.
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Copy constructor, creates a new object using the information of the object passed to it
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	/**
	 * Parameterized constructor
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	// Methods
	
	/**
	 * Sets the value of x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns the value of x 
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the value of y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Returns the value of y 
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the value of width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Returns the value of width 
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the value of depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Returns the value of depth 
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter, returns true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot p) {
		// This is what is returned
		boolean returnStatement = false; 
		
		// Plot Points
		// First Plot
		int p1_x1 = x;
		int p1_x2 = x + width;
		int p1_y1 = y;
		int p1_y2 = y + depth;
		
		// Second Plot
		int p2_x1 = p.x;
		int p2_x2 = p.x + p.width;
		int p2_y1 = p.y;
		int p2_y2 = p.y + p.depth;
		
		// Check if the parameters overlap
		if ((p1_x1 < p2_x2) && (p1_y1 < p2_y2))
			if ((p1_x2 > p2_x1) && (p1_y2 > p2_y1))
				returnStatement = true;
			
		return returnStatement;
	}
	
	/**
	 * Takes a Plot instance and determines if the current plot contains it.
	 */
	public boolean encompasses(Plot p) {
		// This is what is returned
		boolean returnStatement = false; 
		
		// Plot Points
		// First Plot
		int p1_x1 = x;
		int p1_x2 = x + width;
		int p1_y1 = y;
		int p1_y2 = y + depth;
		
		// Second Plot
		int p2_x1 = p.x;
		int p2_x2 = p.x + p.width;
		int p2_y1 = p.y;
		int p2_y2 = p.y + p.depth;
		
		if ((p2_x1 >= p1_x1) && (p2_y1 >= p1_y1) && (p2_x2 <= p1_x2) && (p2_y2 <= p1_y2))
			returnStatement = true;
		
		return returnStatement;
	}

	public String toString() {
		return ("Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth);
	}
}
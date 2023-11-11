package application;

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        this(0, 0, 1, 1); // Default constructor with width and depth of 1
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Getter and Setter methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Methods
    public boolean overlaps(Plot otherPlot) {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int otherX2 = otherPlot.x + otherPlot.width;
        int otherY2 = otherPlot.y + otherPlot.depth;

        // Check for non-overlapping conditions
        if (this.x >= otherX2 || thisX2 <= otherPlot.x || this.y >= otherY2 || thisY2 <= otherPlot.y) {
            return false;
        }

        // If the conditions above are not met, then the plots overlap
        return true;
    }

 // Method to check if the given plot is encompassed by the current plot
    public boolean encompasses(Plot otherPlot) {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int otherX2 = otherPlot.x + otherPlot.width;
        int otherY2 = otherPlot.y + otherPlot.depth;

        // Check if the other plot's coordinates are within the current plot
        boolean xWithinBounds = (otherPlot.x >= this.x) && (otherX2 <= thisX2);
        boolean yWithinBounds = (otherPlot.y >= this.y) && (otherY2 <= thisY2);

        // If both x and y are within bounds, the current plot encompasses the other plot
        return xWithinBounds && yWithinBounds;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}


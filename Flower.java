import ecs100.*;
import java.awt.Color;
/**
 * Flower support class.
 * Create a flower of a size and colour.
 * Can grow.
 * It can tell the driver class where it is on the screen.
 *
 * @author Amy
 * @version 28/03/22
 */
public class Flower
{
    // instance variables - replace the example below with your own
    private double flowerX = -100; // x pos of the flower
    private double flowerY = -100; // y pos of the flower
    private Color color; // color of flower
    
    private int flowerSize;
    private int flowerHeight;
    
    private double left;
    private double top;
    private double bottom;

    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        // initialise instance variables
        this.flowerX = x;
        this.flowerY = y;
        this.flowerSize = size;
        this.flowerHeight = stem;
        this.color = col;
        
        // set top, left, and bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
    }
    
    /**
     * Set left
     */
    public void setLeft() {
        this.left = this.flowerX - this.flowerSize / 2;
    }
    
    public double getLeft() {
        return this.left;
    }
    
    /**
     * Get right
     */
    public double getRight() {
        return this.left + this.flowerSize;
    }
    
    /**
     * Set top
     */
    public void setTop() {
        this.top = this.flowerY - this.flowerSize / 2;
    }
    
    public double getTop() {
        return this.top;
    }
    
    /**
     * Set bottom
     */
    public void setBottom() {
        this.bottom = this.flowerY + this.flowerHeight;
    }
    
    public double getBottom() {
        return this.bottom;
    }
    
    public void draw() {
        // draw stem
        UI.setColor(Color.green); // set colour of stem (to green)
        UI.setLineWidth(2); // set width of stem
        UI.drawLine(flowerX, flowerY, flowerX, bottom);
        
        // draw flower
        UI.setColor(this.color); // set the flower colour
        UI.fillOval(left, top, flowerSize, flowerSize); // draw flower
        UI.sleep(500); // wait
    }
    
    /**
     * Erase a rectangle around the current object
     */
    public void erase() {
        final int BUFFER = 1;
        UI.eraseRect(left, top, flowerSize + BUFFER, flowerHeight + flowerSize / 2 + BUFFER);
    }
    
    /**
     * Make the flower grow
     */
    public void grow() {
        // erase the flower
        this.erase();
        
        // increase the size
        this.flowerY -= 10; // increase the height
        this.flowerSize += 10; // increase the bulb
        this.setTop();
        this.setLeft();
        
        // draw flower again
        this.draw();
    }
}

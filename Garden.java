import ecs100.*;
import java.awt.Color;
/**
 * Driver class for flowers
 * Makes flowers and grows them
 *
 * @author Amy
 * @version 28/03/22
 */
public class Garden
{
    // instance variables - replace the example below with your own
    private Flower f1;
    private Flower f2;
    private Flower f3;
    private Flower f4;

    /**
     * Constructor for objects of class Garden
     */
    public Garden()
    {
        // initialise instance variables
        f1 = new Flower(50, 100, 20, 20, Color.blue);
        f2 = new Flower(100, 100, 25, 25, Color.pink);
        f3 = new Flower(150, 100, 15, 15, Color.red);
        f4 = new Flower(100, 150, 15, 15, Color.black);
        
        // draw in the flowers to start
        f1.draw();
        f2.draw();
        f3.draw();
        f4.draw();
        
        // grow our garden
        // f2.grow();
        // f3.grow();
        // f2.grow();
        // f1.grow();
        // f3.grow();
        // f4.grow();
        
        UI.addButton("Grow blue flower", f1::grow);
        UI.addButton("Grow pink flower", f2::grow);
        UI.addButton("Grow red flower", f3::grow);
        UI.addButton("Grow black flower", f4::grow);
    }
}
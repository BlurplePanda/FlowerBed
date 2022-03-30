import ecs100.*;
import java.awt.Color;

/**
 * Create a garden with each object in an array
 * Click on the flower and make it grow
 *
 * @author Amy
 * @version 30/03/22
 */
public class ClickGarden
{
    // make an array of flowers
    private final int STARTX = 75;
    private final int YPOS = 100;
    private final int MAXFLOWERS = 5;
    
    private Flower[] flowerBed = new Flower[MAXFLOWERS]; // array of flowers
    
    /**
     * Constructor for objects of class ClickGarden
     */
    public ClickGarden() {
        UI.initialise();
        // UI.addButton("Grow", this::growGarden);
        UI.addButton("Random Grow", this::randomGrow);
        UI.addButton("Quit", UI::quit);
        
        // set up the flower position
        for (int i = 0; i < MAXFLOWERS; i++) {
            // set every flower to a random colour
            Color col = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            flowerBed[i] = new Flower(STARTX*(i+1), YPOS, 10, 50, col); // create the flower object put in array
        }
        
        // draw each flower
        for (Flower flower : flowerBed) {
            flower.draw();
        }
        
        // set up mouse
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Randomly grow the flowers in the array
     */
    public void randomGrow() {
        for (int i = 0; i < 10; i++) {
            int randomFlower = (int) (Math.random() * MAXFLOWERS); // choose a random flower
            flowerBed[randomFlower].grow(); // make the random flower grow
        }
    }
    
    /**
     * Select object based on where the user clicks
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // check the location of the x and y against the location of the object
            for (Flower flower : flowerBed) {
                if ((x >= flower.getLeft()) && (x <= flower.getRight()) &&
                    (y >= flower.getTop()) && (y <= flower.getBottom())) {
                        flower.grow();
                    }
            }
        }
    }
}

import ecs100.*; 
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * let user draw lines on graphics pane with mouse
 *
 * @author BELLA
 * @version 14/03/24
 */
public class lineDrawer
{
    // instance variables
    private double startX, startY; // fields to remember 'pressed' position
    private Color currentColor = Color.black;

    /**
     * Constructor for objects of class lineDrawer
     */
    public lineDrawer()
    {
        // initialise instance variables
        UI.setLineWidth(10);
        UI.addButton("Random colour", this::randomColour);    // call back to change to random colours
        UI.addButton("Quit", UI::quit);
        UI.addButton("Choose colour", this::doChooseColour);
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * callback random colour changer
     */
    private void randomColour() {
        // set random rgb values between 0.0 and 1.0
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }
    
    /**
     * Call back method for mouse
     * Draws a line
     * 
     */
    private void doMouse(String action, double x , double y) {
        if (action.equals("pressed")) {
            // store the pressed position
            this.startX = x;
            this.startY = y;
            
        } else if (action.equals("released")) {
            // draw line when mouse released
            UI.drawLine(this.startX, this.startY, x, y);
            
        } else if (action.equals("clicked")) {
            UI.fillOval(x, y, 50, 50);
        }
    }
    public void doChooseColour() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Colour", this.currentColor);
        UI.setColor(this.currentColor);
    }
    // public void addSlider(String s, double min, double max, double intitial, UISliderListener obj);
}
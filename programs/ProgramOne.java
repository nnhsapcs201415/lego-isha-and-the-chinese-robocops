
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;


/**
 * Write a description of class ProgramOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgramOne
{
    public static void main(String[] args)
    {
        LCD.drawString("Program 1", 0,0);
        Button.waitForAnyPress();
        Motor.A.forward();
        LCD.clear();
        LCD.drawString("FORWARD", 0,0);
        Button.waitForAnyPress();
        Motor.A.backward();
        LCD.clear();
        LCD.drawString("BACKWARD", 0,0);
        Button.waitForAnyPress();
        Motor.A.stop();
    }
}

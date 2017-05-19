import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;                               
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
/**
 * Write a description of class RobotLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RobotLab
{
    public static void main (String[] args)
    {
        TravelTest traveler = new TravelTest();
        traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        traveler.go();
    }
    {
        //code for getting out of the box 
        if (range < 30)
        {
            pilot.rotate(5);
            pilot.travel(10);
            while(touch.isPressed())
            {
                pilot.travel(-15);
                pilot.rotate(15);
            }
        }
        else
        {
            pilot.travel(100);
        }
    }
}


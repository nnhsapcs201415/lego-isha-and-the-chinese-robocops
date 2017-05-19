import lejos.nxt.*;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
/**
 * 
 */
public class LightDetectRobot implements SensorPortListener
{
    DifferentialPilot pilot;
    public static void main(String args[])
    {
        LightDetectRobot detector = new LightDetectRobot(); 
        SensorPort.S3.addSensorPortListener(detector);
        Button.ENTER.waitForPressAndRelease();
        
    }
    public void stateChanged( SensorPort aSource, int aOldValue, int aNewValue)
    {
        LightSensor light = new LightSensor(SensorPort.S3);   
        TravelTest traveler = new TravelTest();
        traveler.pilot = new DifferentialPilot(56, 107, Motor.B, Motor.C);
        if( light.getLightValue() > 40 )
        {
            pilot.travel(50);
            System.out.println(light.getLightValue());
        }
        else
        {
            pilot.travel(-20);
            pilot.rotate(135);
            System.out.println("Stop Moving:"+ light.getLightValue());
        }
    }
}

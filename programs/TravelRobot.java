import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class TravelRobot {
    DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);
    public static int MAX_DETECT = 80;
    public void go() {
         void featureDetected(Feature feature, FeatureDetector detector) {
		int range = (int)feature.getRangeReading().getRange();
		Sound.playTone(1200 - (range * 10), 100);
		System.out.println("Range:" + range);
		
	}
        int range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("Range:" + range);
        if (range < 30)
        {
            pilot.rotate(5);
            pilot.travel(10);
            while (bump.isPressed())
            {
                pilot.travel(-15);
                pilot.rotate(10);
            }
        }
        else
        {
            pilot.travel(100);
        }
    }

    public static void main(String[] args) {
        TravelRobot traveler = new TravelRobot();
        traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        traveler.go();
    }
}
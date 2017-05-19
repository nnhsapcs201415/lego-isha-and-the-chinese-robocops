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
public class TravelTest {
    DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);
    public static int MAX_DETECT = 80;
    public void go() {
        pilot.travel(-15);
        pilot.rotate(15);
    }

    public static void main(String[] args) {
        TravelTest traveler = new TravelTest();
        traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        traveler.go();
    }
}
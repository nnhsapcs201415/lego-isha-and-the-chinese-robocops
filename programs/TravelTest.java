import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class TravelTest {
  DifferentialPilot pilot;
  TouchSensor bump = new TouchSensor(SensorPort.S1);

  public void go() {
    pilot.travel(500);
    pilot.rotate(90);
    pilot.travel(500);
    pilot.rotate(90);
    pilot.travel(500);
    pilot.rotate(93);
    pilot.travel(500);
    pilot.rotate(95);
  }

  public static void main(String[] args) {
    TravelTest traveler = new TravelTest();
    traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        traveler.go();
      }
}
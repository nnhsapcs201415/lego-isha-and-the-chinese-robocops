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
    pilot.travel(20);
    pilot.rotate(90);
    pilot.travel(20);
    pilot.rotate(90);
    pilot.travel(20);
    pilot.rotate(90);
    pilot.travel(20);
    pilot.rotate(90);
  }

  public static void main(String[] args) {
    TravelTest traveler = new TravelTest();
    traveler.pilot = new DifferentialPilot(56, ,Motor.B, Motor.C);
        traveler.go();
      }
}
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.Motor;

public class TouchTest {
  public static void main(String[] args) throws Exception {
    TouchSensor touch = new TouchSensor(SensorPort.S2);

    while (!touch.isPressed()) {
        LCD.drawString("Not Pressed", 3, 4);
        Motor.B.forward();
        Motor.C.forward();
        
    }
    LCD.drawString("Finished", 3, 4);
  }
}
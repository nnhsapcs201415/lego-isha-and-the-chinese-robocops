import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
public class OldRobotLab implements FeatureListener {

    public static int MAX_DETECT = 80;
    DifferentialPilot pilot;
    public static void main(String[] args) throws Exception {
        
        OldRobotLab robot= new OldRobotLab();
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
        RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
        fd.addListener(listener);
        traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        traveler.go();

        Button.ENTER.waitForPressAndRelease();
    }
    public void go()
    {
        pilot.travel(-20);
        pilot.rotate(10);
    }
    public void featureDetected(Feature feature, FeatureDetector detector) {
        int range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("    Range:" + range);
        TouchSensor touch = new TouchSensor(SensorPort.S1);        
        if (range < 30)
        {
            pilot.rotate(1);
            while(touch.isPressed())
            {
                robot.go();
            }
        }
        else
        {
            pilot.travel(100);
        }
    }
}
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
public class ObjectDetectRobot implements FeatureListener {

	DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);
    public static int MAX_DETECT = 80;
	
	public static void main(String[] args) throws Exception {
		ObjectDetectRobot listener = new ObjectDetectRobotO();
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
		RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
		fd.addListener(listener);
		Button.ENTER.waitForPressAndRelease();
	}
	
	public void featureDetected(Feature feature, FeatureDetector detector) {
		int range = (int)feature.getRangeReading().getRange();
		Sound.playTone(1200 - (range * 10), 100);
		System.out.println("Range:" + range);
		
	}
}
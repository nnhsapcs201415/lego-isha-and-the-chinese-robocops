import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
public class RobotFinal implements FeatureListener {

    private int state; 
    DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);
    public static int MAX_DETECT = 80;
    private int range;
    public static void main(String[] args) throws Exception {
        RobotFinal robot = new RobotFinal();
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
        RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
        fd.addListener(robot);
        robot.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        robot.go();
        Button.ENTER.waitForPressAndRelease();
        
    }

    public void featureDetected(Feature feature, FeatureDetector detector) {
        this.range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("Range:" + range);
        
        
    }
    
    public void go()
    
    {
        this.state = 0;
        while(true)
        {
            TouchSensor touch = new TouchSensor(SensorPort.S1);
            if(this.state == 0)
            {
                while(range < 20)
                {
                    System.out.println("Range:" + range);
                    pilot.rotate(60);
                    while(touch.isPressed())
                    {
                        pilot.travel(-20);
                        pilot.rotate(30);
                    }
                }
                pilot.travel(200);
                System.out.println("State:" + this.state);
                this.state = 1;
            }
            while(this.state == 1)
            {
                System.out.println("State:" + this.state);
                System.out.println("Range:" + range);
                pilot.rotate(30);
                pilot.travel(150);
                if(range > 15 && range < 40)
                {
                    pilot.travel(500);
                    while(touch.isPressed())
                    {
                        this.state = 1;
                    }
                }
                LightSensor light = new LightSensor(SensorPort.S3);
                if(light.getLightValue() < 35)
                {
                    System.out.println("Light Value:" +light.getLightValue());
                    pilot.travel(-50);
                    pilot.rotate(120);
                }
                System.out.println("Range:" + range);
                
            }
        }
    }
}
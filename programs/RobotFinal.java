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

    public int state; 
    DifferentialPilot pilot;
    TouchSensor bump = new TouchSensor(SensorPort.S1);
    public static int MAX_DETECT = 80;
    public int range;
    

    public static void main(String[] args) throws Exception {
        RobotFinal robot = new RobotFinal();
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
        RangeFeatureDetector fd = new RangeFeatureDetector(us, MAX_DETECT, 500);
        fd.addListener(robot);
        TravelTest traveler = new TravelTest();
        traveler.pilot = new DifferentialPilot(56, 107,Motor.B, Motor.C);
        Button.ENTER.waitForPressAndRelease();
        //robot.run();
    }

    

    public void featureDetected(Feature feature, FeatureDetector detector) {
        this.range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("Range:" + range);
        this.state = 0;
        while(true)
        {
            TouchSensor touch = new TouchSensor(SensorPort.S1);        
            if(this.state == 0)
            {

                if (this.range < 30)
                {
                    pilot.rotate(1);
                    while(touch.isPressed())
                    {
                        pilot.travel(-10);
                        pilot.travel(5);
                    }
                }
                else
                {
                    pilot.travel(50);
                }
                this.state = 1;
            }
            if(this.state == 1)
            {
                pilot.rotate(10);
                pilot.travel(20);
                if(this.range > 15 && this.range < 40)
                {
                    while(touch.isPressed())
                    {
                        this.state =2;
                    }
                }
            }
            if(this.state == 2)
            {
                LightSensor light = new LightSensor(SensorPort.S3);
                while(!(light.getLightValue() > 40))
                {
                    pilot.travel(5);
                }
                this.state = 3;
            }
            if(this.state == 3)
            {
                pilot.travel(-10);
                pilot.rotate(120);
                this.state = 1;
            }
        }
    }
}
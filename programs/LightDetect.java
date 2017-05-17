import lejos.nxt.*;

/**
 * 
 */
public class LightDetect implements SensorPortListener
{
    public static void main(String args[])
    {
        LightDetect detector = new LightDetect();        
        SensorPort.S3.addSensorPortListener(detector);
        Button.ENTER.waitForPressAndRelease();
    }
    public void stateChanged( SensorPort aSource, int aOldValue, int aNewValue)
    {
        LightSensor light = new LightSensor(SensorPort.S3);                  
        if( light.getLightValue() > 40 )
        {
            Motor.B.forward();
            Motor.C.forward();
            System.out.println(light.getLightValue());
        }
        else
        {
            Motor.B.stop();
            Motor.C.stop();
            System.out.println("Stop Moving:"+ light.getLightValue());
        }
    }
}

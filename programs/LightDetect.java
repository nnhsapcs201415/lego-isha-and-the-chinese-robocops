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
        LightSensor light = new LightSensor(SensorPort.S3);        
        Button.ENTER.waitForPressAndRelease();
    }
    public void stateChanged( SensorPort aSource, int aOldValue, int aNewValue)
    {
                
        while( aNewValue < 600 )
        {
            Motor.B.forward();
            Motor.C.forward();
            System.out.println(//getLightValue );
        }
        System.out.println("Stop Moving");
        
    }
}

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GP2D02 {
    private int PIN_IN;
    private int PIN_OUT;
    private final int LOW_START_TIME = 70; // milliseconds
    private final int CONMUTE_TIME = 100; // microseconds
    private DigitalInput inPin;
    private DigitalOutput outPin;
    public GP2D02(int pinIn, int pinOut) {
        this.PIN_IN = pinIn;
        this.PIN_OUT = pinOut;
        this.inPin = new DigitalInput(PIN_IN);
        this.outPin = new DigitalOutput(PIN_OUT);
        this.outPin.set(true);
    }

    private double millisTimer(double millisToConvert) {
        return millisToConvert / 1000;
    }

    private double microsTimer(double microsToConvert) {
        return microsToConvert / 1000000;
    }
    
    public byte getRawData() {  
        byte value = 0;
        outPin.set(false);
        Timer.delay(millisTimer(LOW_START_TIME));
        for(int i = 7; i >= 0; i--) {
            outPin.set(true);
            Timer.delay(microsTimer(CONMUTE_TIME));
            outPin.set(false);
            Timer.delay(microsTimer(CONMUTE_TIME));
            value = (byte) ((inPin.get() ? 1 : 0) << i);
            SmartDashboard.putNumber("I", i);
        }
        outPin.set(true);
        Timer.delay(millisTimer(2));
        outPin.set(false);
        return value;
    }
}
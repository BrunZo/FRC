package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;

public class CameraArm extends SubsystemBase {
    private Servo mServo;
    private int servoChannel;
    private OI oiInterface;
    private final int TOP = 0;
    private final int BOTTOM = 180;
    private final int DEFAULT = 0;
    private final int STEP = 3;
    private int angle;
    private boolean positionSet;
    /***
     * Used to create a new instance of the CameraArm class.
     * @param channel int representing the PWM channel in the roboRIO 
     * @param oiInt OI object used to interface joystics and Xbox controllers
     */
    public CameraArm(int channel, OI oiInt) {
        this.servoChannel = channel;
        mServo = new Servo(this.servoChannel);
        this.oiInterface = oiInt;
        this.angle = 0;
        this.positionSet = false;
        mServo.setAngle(DEFAULT);
    }

    @Override
    public void periodic(){
        if(oiInterface.mController.getPOV() == TOP){
            angle += STEP;
            positionSet = false;
        } else if(oiInterface.mController.getPOV() == BOTTOM){
            angle -= STEP;
            positionSet = false;
        } else if(positionSet == false){   
            angle = angle - angle % 10;
            if(angle < 0){
                angle = 0;
            }
            if(angle > 180){
                angle = 180;
            }
            mServo.setAngle(angle);
            positionSet = true;
        }
    }
}
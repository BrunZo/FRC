package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class StickTrigger extends Trigger{
    private XboxController mController;
    private int mAxis;
    /**
     * Create a new Trigger for a Xbox Controller type joystick axis.
     * @param controller XboXController object representing the controller to be listened
     * @param axis int representing the axis number that will be listened to
     */
    public StickTrigger (XboxController controller,int axis){
        this.mController = controller;
        this.mAxis = axis;
    }   
    @Override
    public boolean get(){
       if(mController.getRawAxis(mAxis) < 0){
           return true;
       }
       else{
           return false;
       }
    }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DropIntake;
import frc.robot.commands.HookDown;
import frc.robot.commands.HookStop;
import frc.robot.commands.HookUp;
import frc.robot.commands.StartIntake;
import frc.robot.commands.StopIntake;
import frc.robot.subsystems.*;

public class RobotContainer {
  public OI oiInterface = new OI();
  public Arm mArm = new Arm(5,0);
  public SensorSuite mSensorSuite = new SensorSuite(3,Range.k2G);
  public Hook mHook = new Hook(2); 
  public DriveTrain mDriveTrain = new DriveTrain(1,0);
  public CameraArm mCameraArm = new CameraArm(9, oiInterface);
  public Intake mIntake = new Intake(3);
  //$public PowerDistributionPanel mPowerPanel = new PowerDistributionPanel();
  private Command startIntake = new StartIntake(mIntake, 0.5);
  private Command stopIntake  = new StopIntake(mIntake);
  private Command dropIntake  = new DropIntake(mIntake, -0.5);
  private Command hookGoingUp = new HookUp(mHook);
  private Command hookStopper = new HookStop(mHook);
  private Command hookGoingDown = new HookDown(mHook);
  enum PDPChannel{
    ARM
  }
  public int getPDPChannel(PDPChannel channel){
    if(channel == PDPChannel.ARM){
      return 8;
    }
    else{
      return -1;
    }
  }
  
  
  
  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    oiInterface.rightTriggerButton.whenReleased(stopIntake, true);
    oiInterface.rightTriggerButton.cancelWhenPressed(stopIntake);
    oiInterface.rightTriggerButton.whenPressed(startIntake);
    oiInterface.leftTriggerButton.cancelWhenPressed(startIntake);
    oiInterface.leftTriggerButton.whenPressed(dropIntake);
    oiInterface.leftTriggerButton.whenReleased(stopIntake, true);
    oiInterface.aButton.whenPressed(hookGoingUp);
    oiInterface.aButton.whenReleased(hookStopper);
    oiInterface.bButton.whenReleased(hookStopper);
    oiInterface.bButton.whenPressed(hookGoingDown);
    oiInterface.xButton.whenPressed(new Runnable() {
      @Override
        public void run() {
          mArm.startDropping();
        }
    });
  }

}

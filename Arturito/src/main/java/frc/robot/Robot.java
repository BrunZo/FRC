/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*                            Andrés Kaminker                                 */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.BrakePID;
import frc.robot.commands.DriveAutonomous;
import frc.robot.commands.DriveWithDoubles;
import frc.robot.commands.DriveWithDoubles.possibleModes;
import frc.robot.commands.MoveArm;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.SensorSuite;
import frc.robot.subsystems.SensorSuite.PossibleDirection;


public class Robot extends TimedRobot {
  private RobotContainer mRobotContainer;
  private OI oiInterface;
  private SensorSuite mSensors;
  private Camera mCamera;
  private Command driveWithRoll; // FILL WITH STATE :))
  private Command driveWithYaw;
  //private Command driveWithDash;
  private Command fwdCommand;
  private Command leftCommand;
  private Command rightCommand;
  private Command brakeCommand;
  private Command moveArm;
  private Command driveAuto;

  @Override
  public void robotInit() {
    mRobotContainer = new RobotContainer();
    oiInterface = mRobotContainer.oiInterface;
    CameraServer.getInstance().startAutomaticCapture(0);
    mSensors  = mRobotContainer.mSensorSuite;
    driveWithRoll = new DriveWithDoubles(mRobotContainer.mDriveTrain, possibleModes.ROLL);
    driveWithYaw = new DriveWithDoubles(mRobotContainer.mDriveTrain, possibleModes.YAW);
    //driveWithDash = new DriveWithDoubles(mRobotContainer.mDriveTrain, possibleModes.DASH);
    fwdCommand = new DriveAutonomous(mRobotContainer.mDriveTrain, 0.6, 0, 0.5);
    leftCommand = new DriveAutonomous(mRobotContainer.mDriveTrain, 0.6, -0.5, 0.5);
    rightCommand = new DriveAutonomous(mRobotContainer.mDriveTrain, 0.6, 0.5, 0.5);
    brakeCommand = new BrakePID(mRobotContainer.mDriveTrain);
    moveArm = new MoveArm(mRobotContainer.mArm, oiInterface);
    driveAuto = new DriveAutonomous(mRobotContainer.mDriveTrain, 0.6, 0.5, 2);
  }

  boolean lastTrig = false;
  boolean lastBrake = false;
  boolean lastDash = false;
  boolean lastA = false;
  boolean lastB = false; // Check if the button was pressed

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void disabledPeriodic() {
    
  }

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousPeriodic() {
    if (mSensors.readSharp(PossibleDirection.LEFT) > 40) {
      CommandScheduler.getInstance().schedule(fwdCommand);
    } else {
      CommandScheduler.getInstance().cancel(fwdCommand);
      CommandScheduler.getInstance().schedule(false, driveAuto);
    }
    switch (mCamera.getBallDirection()) {
      case "LEFT":
        CommandScheduler.getInstance().schedule(leftCommand);
        CommandScheduler.getInstance().cancel(fwdCommand);
        break;
      case "RIGHT":
        CommandScheduler.getInstance().schedule(rightCommand);
        CommandScheduler.getInstance().cancel(fwdCommand);
        break;
      case "CENTER":
        CommandScheduler.getInstance().schedule(fwdCommand);
        CommandScheduler.getInstance().cancel(driveWithYaw);
        break;
    }
  }

  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().cancelAll();
    CommandScheduler.getInstance().schedule(driveWithRoll);
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Arm Speed", oiInterface.mController.getY(Hand.kLeft));
    
    oiInterface.triggerButton.whenPressed(driveWithYaw); 
    oiInterface.triggerButton.cancelWhenPressed(driveWithRoll);
    oiInterface.brakeButton.cancelWhenPressed(driveWithRoll);
    oiInterface.brakeButton.cancelWhenPressed(driveWithYaw);
	  final Command command = driveWithRoll;
	  oiInterface.brakeButton.whenInactive(command);
    Button whenReleased = oiInterface.brakeButton;
    oiInterface.brakeButton.whenPressed(brakeCommand);
    //oiInterface.dashButton.whenPressed(driveWithDash); // dash button adds dashDrive to queue
    oiInterface.dashButton.cancelWhenPressed(driveWithRoll);
    oiInterface.triggerButton.whenReleased(driveWithRoll);
    CommandScheduler.getInstance().schedule(moveArm);
    SmartDashboard.putBoolean("Yaw Drive", oiInterface.triggerButton.get());
    SmartDashboard.putBoolean("Break Enabled", oiInterface.brakeButton.get());
    lastA = oiInterface.aButton.get();
    lastB = oiInterface.bButton.get();
    lastTrig = oiInterface.triggerButton.get();
    lastBrake = oiInterface.brakeButton.get();
    lastDash = oiInterface.dashButton.get();

    mSensors.gyroCheck();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}

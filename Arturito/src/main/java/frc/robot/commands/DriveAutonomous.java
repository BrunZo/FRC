package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class DriveAutonomous extends CommandBase { //Building a new command
  final DriveTrain driveTrain; //asking for a drivetrain
  double driveRotation; //configure for future use
  double driveSpeed;
  double commandTime;
  OI oiInterface = new OI();
  public DriveAutonomous(DriveTrain driveTrain2, double speedValue, double rotationSpeed, double executeTime) { //Class constructor
    this.driveTrain = driveTrain2;
    this.driveRotation = rotationSpeed;
    this.driveSpeed = speedValue;
    this.commandTime = executeTime;
    addRequirements(driveTrain);
  }
    
  public void initialize() {
    oiInterface.mTimer.reset();
    oiInterface.mTimer.start();
  }

  public void execute() {
    driveTrain.diffDrive.arcadeDrive(driveSpeed, driveRotation);
    SmartDashboard.putNumber("Command Exec Time", oiInterface.mTimer.get());
  }
    
  protected void end() {
    driveTrain.diffDrive.arcadeDrive(0, 0);
  }
    
  protected void interrupted() {
    driveTrain.diffDrive.arcadeDrive(0, 0);
  }
    
  public boolean isFinished() {
    if(oiInterface.mTimer.get() < commandTime) {
      SmartDashboard.putBoolean("IsFinished", false);
      return false;
    } else{
      SmartDashboard.putBoolean("IsFinished", true);
      return true;   
    }
  }
}
    
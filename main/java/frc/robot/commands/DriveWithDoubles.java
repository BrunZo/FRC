package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class DriveWithDoubles extends CommandBase { //Building a new command
  final DriveTrain driveTrain; //asking for a drivetrain
  double driveRotation; //configure for future use
  double driveSpeed;
  final OI oiInterface = new OI();
  final Joystick joystick = oiInterface.mJoystick; // asking for joystick to be replaced by a call to OI lib
  public enum possibleModes{ // Enum detailing modes available
    ROLL, //you use getX to steer
    YAW, //you use getZ to steer
    DASH //steer as roll with speed fixed
  }
  possibleModes modeChoice;
  double dashSpeed = -500;
  public DriveWithDoubles(DriveTrain driveTrain2, possibleModes mode) { //Class constructor
    this.modeChoice = mode;
    this.driveTrain = driveTrain2;
    addRequirements(driveTrain);
  }
    
  public void initialize() {
    
  }

  public void execute() {
    double speedModifier;
    speedModifier = 1.3 - (joystick.getThrottle() + 1 ) / 2; //You use this to map the value in order to get from .3 to 1.3 to avoid a stall condition when it is not in brake mode
    SmartDashboard.putNumber("Speed", speedModifier * 100 - 30);
    switch(modeChoice) {
      case ROLL:
        driveTrain.diffDrive.arcadeDrive(-joystick.getY() * speedModifier, joystick.getX() * speedModifier); //Using the differential drive from our driveTrain system in the arcadeMode
        SmartDashboard.putNumber("Turn", joystick.getX());
        break;
      case YAW:
        driveTrain.diffDrive.arcadeDrive(-joystick.getY() * speedModifier, joystick.getZ() * speedModifier);
        SmartDashboard.putNumber("Turn", joystick.getZ());
        break;
      case DASH:
        driveTrain.diffDrive.arcadeDrive(dashSpeed, joystick.getX() * speedModifier);
        SmartDashboard.putNumber("Speed", dashSpeed);
        SmartDashboard.putNumber("Turn", joystick.getX());
        break;
      }   
    }
    
    protected void end() {
    
    }
    
    protected void interrupted() {
        
    }
}
    
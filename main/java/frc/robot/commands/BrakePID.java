package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class BrakePID extends CommandBase { //Building a new command
  private DriveTrain driveTrain;
  final double SETPOINT = 0.00;
  final double kP = 2;
  final double kD = 10;
  double error;
  double PIDOut;
  public BrakePID(DriveTrain driveTrain2) { //Class constructor
    this.driveTrain = driveTrain2;
    addRequirements(driveTrain);
  }
    
  public void initialize() {
    
  }
    
  public void execute() {
    driveTrain.diffDrive.arcadeDrive(0, 0);
  }
    
  protected void end() {
    
  }
    
  protected void interrupted() {
        
  }
}
    
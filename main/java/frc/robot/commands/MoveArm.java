package frc.robot.commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.OI;

public class MoveArm extends CommandBase { //Building a new command
  private Arm mArm;
  private OI mioInterface;
  public MoveArm(Arm arm, OI ioInterface) { // Classm                                                                                       // constructor
    this.mArm = arm;
    this.mioInterface = ioInterface;
        
    addRequirements(this.mArm);
  }
    
  public void initialize() {

  }
    
  public void execute() {
    mArm.moveArm(-mioInterface.mController.getY(Hand.kLeft), mArm.checkEndStop(), mioInterface.xButton.get());
    SmartDashboard.putNumber("Arm Speed", -mioInterface.mController.getY(Hand.kLeft));          
  }
    
  protected void end() {
       
  }
    
  protected void interrupted() {
    
  }
    
  public boolean isFinished() {
    return true;
  }
}

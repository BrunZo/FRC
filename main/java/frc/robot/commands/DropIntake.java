package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class DropIntake extends CommandBase { //Building a new command
    final Intake mIntake;
    double mMotorSpeed;
    public DropIntake(Intake intake, double motorSpeed) { //Class constructor
        this.mIntake = intake;
        this.mMotorSpeed = motorSpeed;
        addRequirements(this.mIntake);
    }
    
    public void initialize() {
        
    }
    
    public void execute() {
       mIntake.setIntakeMotor(mMotorSpeed);
       SmartDashboard.putString("Intake", "Stopped");
    }
    
    protected void end() {
        
    }
    
    protected void interrupted() {
    
    }
    
    public boolean isFinished() {
        return true;
    }
}
    
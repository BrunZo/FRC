package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class StopIntake extends CommandBase { //Building a new command
    final Intake mIntake;
    public StopIntake(Intake intake) { //Class constructor
        this.mIntake = intake;
        addRequirements(this.mIntake);
    }
    
    public void initialize() {
        
    }
    
    public void execute() {
       mIntake.stopIntake();
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
    
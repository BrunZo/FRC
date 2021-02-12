package frc.robot.commands;
//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class TestCommand extends CommandBase { //Building a new command
    private Arm mArm;
    public TestCommand(Arm arm) {
        this.mArm = arm;
        addRequirements(this.mArm);
    }
    
    public void initialize() {

    }
    
    public void execute() {
        SmartDashboard.putBoolean("Stick used" , true);            
    }
        
    protected void end() {
        SmartDashboard.putBoolean("Stick used" , false); 
    }

    protected void interrupted() {
        SmartDashboard.putBoolean("Stick used" , false); 
    }
    
    public boolean isFinished() {
        return true;
    }
}

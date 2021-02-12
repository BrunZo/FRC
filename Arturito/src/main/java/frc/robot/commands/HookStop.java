package frc.robot.commands;

//Importing the neccesary packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hook;

public class HookStop extends CommandBase { //Building a new command
    final Hook mHook;
    
    public HookStop(Hook hook) { //Class constructor
        this.mHook = hook;
        addRequirements(this.mHook);
    }

    public void initialize() {
        
    }
    
    public void execute() {
       mHook.stopMotor();
       SmartDashboard.putString("Stopping Hook Command", "Going up");
    }
    
    protected void end() {
        mHook.stopMotor();
        SmartDashboard.putString("Stopping Hook Command", "Command end");
    }
    
    protected void interrupted() {
        mHook.stopMotor();
        SmartDashboard.putString("Stopping Hook Command", "Command end");
    }
    
    public boolean isFinished() {
        return true;
    }
}
    
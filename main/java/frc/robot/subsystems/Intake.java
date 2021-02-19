package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private PWMVictorSPX intakeMotor;
  
  /**
   * The constructor for our arm subsystem (it also includes our intake subsystem).
   * @param intakeChannel int representing PWM channel in which the intake motor is connected
   */
  public Intake(int intakeChannel) { 
    this.intakeMotor = new PWMVictorSPX(intakeChannel); 
  }

  public void setIntakeMotor(double motorSpeed) {
    intakeMotor.setSpeed(motorSpeed);
    SmartDashboard.putBoolean("Intake Working", true);
  }
  
  public void stopIntake() {
    intakeMotor.setSpeed(0);
    SmartDashboard.putBoolean("Intake Working", false);
  }
  
  public void initDefaultCommand() {
  
  }
    
  @Override
  public void periodic() {
    
  }
}
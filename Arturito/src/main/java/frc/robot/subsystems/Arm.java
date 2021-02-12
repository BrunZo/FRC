package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private PWMVictorSPX liftMotor;
  private DigitalInput endStopSensor;
  static final double speedLimit = 0.8;
  static final double speedIdle = 0.2;
  private boolean dropping = false;

  /**
   * The constructor for our arm subsystem (it also includes our intake subsystem).
   * @param liftChannel int representing PWM channel in which the arm motor is connected
   * @param endStopChannel int representing the DIO channel in which the endstop sensor is connected
   */
  public Arm( int liftChannel, int endStopChannel) { 
    this.liftMotor = new PWMVictorSPX(liftChannel);
    this.endStopSensor = new DigitalInput(endStopChannel);
  }

  public boolean checkEndStop() {
    return !endStopSensor.get();
  }

  /**
   * A function to move our arm and also leave it still when moving is undesirable.
   * @param moveSpeed a double between -1.0 and 1.0 representing the moving speed
   * @param endStop a boolean representing whether the arm is lying on something.
   */
  public void moveArm(double moveSpeed, boolean endStop, boolean dropArm) {    
    SmartDashboard.putNumber("SPEEED", moveSpeed);
    SmartDashboard.putBoolean("DropArm", dropArm);
    if (dropping && !endStop){
      liftMotor.setSpeed(-0.1);
    } else if ((moveSpeed <= 0 || dropping) && endStop == true) {
      liftMotor.setSpeed(0.07);
      Timer.delay(0.5);
      liftMotor.setDisabled();
      dropping = false;
    } else if (moveSpeed <= speedIdle && moveSpeed > 0 && endStop == false) {
      liftMotor.setSpeed(speedIdle);
    } else if (moveSpeed < 0) {
      liftMotor.setSpeed(0.05);
    } else {
      liftMotor.setSpeed(moveSpeed);
    }
  }
  
  public void startDropping() {
    dropping = true;
  }
  
  public void dropArm(double motorSpeed) {
    liftMotor.setSpeed(motorSpeed);
  }
  
  public void initDefaultCommand() {
  
  }
    
  @Override
  public void periodic() {
    SmartDashboard.putBoolean("End Stop / Arm Down", checkEndStop());
  }
}
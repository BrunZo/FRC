package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hook extends SubsystemBase {
  public PWMVictorSPX motorController;
  /**
   * Constructor of a Hook object using the new keyword.
   * @param pwmChannel the PWM channel in the roboRIO in which the motor is connected.
   */
  public Hook(int pwmChannel) {
    this.motorController = new PWMVictorSPX(pwmChannel);
  }

  /**
   * A function that starts the motor and starts wrapping the rope around the motor axis. 
   */
  public void up() {
    motorController.setSpeed(1);
    SmartDashboard.putBoolean("UP", true);
  }

  /**
   * Completely stops the motor.
   */
  public void stopMotor() {
    motorController.setSpeed(0);
    SmartDashboard.putBoolean("UP", false);
    SmartDashboard.putBoolean("DOWN", false);
  }

  /**
   * A function that starts unwrapping the motor.
  */
  public void down() {
    motorController.setSpeed(-1);
    SmartDashboard.putBoolean("DOWN", true);
  }

  @Override
  public void periodic() {
    
  }
}
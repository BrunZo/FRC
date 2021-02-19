package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final PWMVictorSPX mLeftMotor;  
  private final PWMVictorSPX mRightMotor;
  public final DifferentialDrive diffDrive;
  
  /**
   * A constructor for our DriveTrain object.
   * @param channelLeft an int representing the left motors' PWM channel in the ROBOrio
   * @param channelRight an int representing the right motors' PWM channel in the ROBOrio
   */
  public DriveTrain(int channelLeft, int channelRight) {
    this.mLeftMotor = new PWMVictorSPX(channelLeft);
    this.mRightMotor = new PWMVictorSPX(channelRight);
    this.diffDrive = new DifferentialDrive(this.mLeftMotor, this.mRightMotor);
  }
  
  /**
   * Use this function to move the robot forward.
   * @param forwardSpeed a double from 0 to 1.0 representing the speed desired
   */
  public void driveForward(double forwardSpeed) {
    diffDrive.arcadeDrive(-forwardSpeed, 0); //Using a minus as - is forward 
  }
  
  /**
   * Use this function to move the robot backward speed.
   * @param backwardSpeed a double from 0 to 1.0 representing the speed desired
   */
  public void driveBackward(double backwardSpeed) {
    diffDrive.arcadeDrive(backwardSpeed, 0);
  }
  
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new DriveWithJoysticks(new DriveTrain()));
  }
    
  @Override
  public void periodic() {
    
  }
}
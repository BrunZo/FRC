package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SensorSuite extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private AnalogInput sharpInLeft;
  private BuiltInAccelerometer mAccelerometer;

  // private GP2D02 sharpSensor = new GP2D02(0, 1);
  /**
   * This is our SensorSuite constructor which can be used to create a new
   * instance of this class using the new keyword.
   *
   * @param portSharpInLeft the analog input port on the roboRIO where our sharp
   *                        is connected.
   * @param accelRange      the accelerometer measurable range for our
   *                        accelerometer.
   */
  public SensorSuite(int portSharpInLeft, Range accelRange) {
    sharpInLeft = new AnalogInput(portSharpInLeft);
    mAccelerometer = new BuiltInAccelerometer(accelRange);
  }

  public enum PossibleDirection {
    LEFT, RIGHT, CENTER,
  }

  public void gyroCheck() {
    /*
     * SmartDashboard.putBoolean("GyroAvailable", mpu.addressOnly());
     * mpu.write(0x6B, 1); mpu.read(0x43, 16, accelerationX);
     * System.out.println(accelerationX.getInt(0));
     * SmartDashboard.putNumber("Acceleration Read",accelerationX.getInt(0));
     */
  }

  public void initDefaultCommand() {

  }

  /**
   * Use this function to get the value of the accelerometer in the X Axis.
   * 
   * @return a double representing the acceleration in the x axis
   */
  public double getAccelX() {
    double accelX = mAccelerometer.getX();
    return accelX;

  }

  /**
   * Use this function to get the value of the accelerometer in the Y Axis.
   * 
   * @return a double representing the acceleration in the Y axis
   */
  public double getAccelY() {
    double accelY = mAccelerometer.getY();
    return accelY;
  }

  /**
   * Use this function to get the value of the accelerometer in the Z Axis.
   * 
   * @return a double representing the acceleration in the Z axis
   */

  public double getAccelZ() {
    double accelZ = mAccelerometer.getZ();
    return accelZ;
  }

  /**
   * Use this function to get the distance value in centimeters for our SHARP 
   * sensors.
   * @param direction any of the three possible directions in which the sharp
   *                  could be located.
   * @return a float representing distance between 0 and 40cm
   */
  public float readSharp(PossibleDirection direction) {
    float aux;
    switch (direction) {
      case LEFT:
        aux = sharpInLeft.getValue();
        break;
      case RIGHT:
        aux = -1;
        break;
      case CENTER:
        aux = -1;
        break;
      default:
        aux = -1;
        break;
    }
    aux /= 4096; // convierto a volt
    aux *= 5;

    if (aux <= 0.35) {
      aux = (float) 0.35;
    }
    aux = (float) Math.pow(aux - 0.3, 0.25);/* convertimos a cm con un aproximacion grafica */
    aux = (float) (27.5 / aux); /* no preguntar por los valores */
    aux -= 18;

    return aux;

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Sharp Left", readSharp(PossibleDirection.LEFT));
  }
}
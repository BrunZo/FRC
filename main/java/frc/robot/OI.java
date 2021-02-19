package frc.robot;

//We should start using this OI  / IO package
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class OI {
  public Joystick mJoystick = new Joystick(0);
  public Button triggerButton = new JoystickButton(mJoystick, 1);
  public Button brakeButton = new JoystickButton(mJoystick, 3);
  public Button dashButton = new JoystickButton(mJoystick, 12);
  public XboxController mController = new XboxController(1);
  public Timer mTimer = new Timer();
  public Button aButton = new JoystickButton(mController, 1);
  public Button bButton = new JoystickButton(mController, 2);
  public Button rightTriggerButton = new JoystickButton(mController, 6);
  public Button leftTriggerButton = new JoystickButton(mController, 5);
  public Button yButton = new JoystickButton(mController, 4);
  public Button xButton = new JoystickButton(mController, 3);
  public OI() {
       
  }
} 
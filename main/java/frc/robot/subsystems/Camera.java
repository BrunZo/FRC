package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase {
  public Camera() {
  }

  public void getCameraInput() {
    
  }

  public void readYellowObject() {
    /* cap = cv2.VideoCapture(0)
      amarillo_bajo = np.array([20, 90, 90], np.uint8)
      amarillo_alto = np.array([40, 255, 255], np.uint8)
      font = cv2.FONT_HERSHEY_SIMPLEX
      ret, frame = cap.read()
      if ret == True:
        frameHSV = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
        mask_amarillo = cv2.inRange(frameHSV, amarillo_bajo, amarillo_alto)
        return mask_amarillo
      */
    // return null;
  }

  public String getBallDirection() {
    /*
      objects, max_object = [], [0, 0, 0]
      contours = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
      for c in contours:
        area = cv2.contourArea(c)
        if area > 50:
          M = cv2.moments(c)
          M["m00"] = 1 if M["m00"] == 0 else M["m00"]
          x, y = int(M["m10"] / M["m00"]), int(M["m01"] / M["m00"])
          objects.append([x, y, area])
          new_contour = cv2.convexHull(c)
          cv2.putText(frame, '{}'.format(area), (x, y), font, 0.75, (0, 255, 0), 1, cv2.LINE_AA)
          cv2.drawContours(frame, [new_contour], 0, color, 3)
          if area > max_object[2]:
            cv2.circle(frame, (max_object[0], max_object[1]), 7, (0, 0, 0), -1)
            cv2.circle(frame, (x, y), 7, (255, 255, 0), -1)
            max_object = [x, y, area]
    */
    return "LEFT"; // "RIGHT", "CENTER".
  }

  @Override
  public void periodic() {
    
  }
}
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootOut extends SubsystemBase {
  // public Constants consts = new Constants();
  public DriveTrain driveTrain = new DriveTrain();

  public void startMotor(double motorSpeed) {
    driveTrain.DT_SHOOTING.set(motorSpeed);
  }
  
  public void stopMotor() {
    driveTrain.DT_SHOOTING.stopMotor();
  }

  /** Creates a new ShootOut. */
  public ShootOut() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootOut extends SubsystemBase {
  // public Constants consts = new Constants();
  public Constants consts = new Constants();

  public final WPI_TalonFX DT_SHOOTING = new WPI_TalonFX(consts.DT_SHOOTING_ID);
  
  public void startMotor(double motorSpeed) {
    DT_SHOOTING.set(motorSpeed);
  }
  
  public void stopMotor() {
    DT_SHOOTING.stopMotor();
  }

  /** Creates a new ShootOut. */
  public ShootOut() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

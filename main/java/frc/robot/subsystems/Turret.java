// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  // public Constants consts = new Constants();
  private Constants consts = new Constants();

  private final WPI_TalonFX turretMotor = new WPI_TalonFX(consts.TURRET_SHOOTMOTOR);
  private final WPI_TalonFX turretAligner = new WPI_TalonFX(consts.TURRET_ALIGNER);
  
  public void startMotor(double motorSpeed) {
    turretMotor.set(motorSpeed);
  }
  
  public void stopMotor() {
    turretMotor.stopMotor();
  }

  public void setAlign(double speed) {
    turretAligner.set(speed);
  }

  /** Creates a new ShootOut. */
  public Turret() {
    turretAligner.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

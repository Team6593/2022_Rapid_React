// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  public Constants consts = new Constants();

  public final WPI_TalonFX DT_MASTER_RIGHT = new WPI_TalonFX(consts.DT_MASTER_RIGHT_ID);
  public final WPI_TalonFX DT_MASTER_LEFT = new WPI_TalonFX(consts.DT_MASTER_LEFT_ID);
  public final WPI_TalonFX DT_SLAVE_RIGHT = new WPI_TalonFX(consts.DT_SLAVE_RIGHT_ID);
  public final WPI_TalonFX DT_SLAVE_LEFT = new WPI_TalonFX(consts.DT_SLAVE_LEFT_ID);

  public final MotorControllerGroup DT_LEFTSIDE = new MotorControllerGroup(DT_MASTER_LEFT, DT_SLAVE_LEFT);
  public final MotorControllerGroup DT_RIGHTSIDE = new MotorControllerGroup(DT_MASTER_RIGHT, DT_SLAVE_RIGHT);

  public final DifferentialDrive DIFF_DRIVE = new DifferentialDrive(DT_RIGHTSIDE, DT_LEFTSIDE);


  public void _arcadeDrive(double xSpd, double zRot) {
    DIFF_DRIVE.arcadeDrive(xSpd, zRot);
  }

  public void stopAllMotors() {
    DIFF_DRIVE.stopMotor();
  }
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

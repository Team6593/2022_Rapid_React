// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private Constants constants = new Constants();
  
  WPI_TalonFX leftClimber = new WPI_TalonFX(constants.CLIMBER_LEFT);
  WPI_TalonFX rightClimber = new WPI_TalonFX(constants.CLIMBER_RIGHT);

  /** Creates a new Climber. */
  public Climber() {}

  public void moveHooksUp(double speed) {
    leftClimber.set(speed);
    rightClimber.set(speed);
  }
  
  public void stopHooks() {
    leftClimber.stopMotor();
    rightClimber.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

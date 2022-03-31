// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private Constants constants = new Constants();
  
 public WPI_TalonFX leftClimber = new WPI_TalonFX(constants.CLIMBER_LEFT);
 public WPI_TalonFX rightClimber = new WPI_TalonFX(constants.CLIMBER_RIGHT);

  /** Creates a new Climber. */
  public Climber() {}

  public void init() {
    leftClimber.configFactoryDefault();
    rightClimber.configFactoryDefault();

    rightClimber.setNeutralMode(NeutralMode.Brake);
    leftClimber.setNeutralMode(NeutralMode.Brake);

    rightClimber.set(ControlMode.PercentOutput, 0);
    leftClimber.set(ControlMode.PercentOutput, 0);

    rightClimber.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    leftClimber.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

  }

  public void moveLeftHook(double speed) {
    leftClimber.set(speed);
  }

  public void moveRightHook(double speed) {
    rightClimber.set(speed);
  }

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

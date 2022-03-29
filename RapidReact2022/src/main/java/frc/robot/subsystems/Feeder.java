// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
 
  Constants constants = new Constants();
 
  WPI_TalonSRX feederRight = new WPI_TalonSRX(constants.FEEDER_RIGHT);
  WPI_TalonSRX feederLeft = new WPI_TalonSRX(constants.FEEDER_LEFT);
  WPI_TalonSRX feederMid = new WPI_TalonSRX(constants.FEEDER_MID);

  // COME BACK TO THIS LINE OF CODE IF THE FEEDER IS NOT MOVING CORRECTLY
  //MotorControllerGroup feederMotors = new MotorControllerGroup(feederLeft, feederLeft, feederMid);
  ////////////////////////////////////////////////////

  /** Creates a new Feeder. */
  public Feeder() {}

  public void stopFeeder() {
    feederLeft.stopMotor();
    feederMid.stopMotor();
    feederRight.stopMotor();
  }

  public void startFeeder(double feederSpeed) {
    feederLeft.set(feederSpeed);
    feederRight.set(feederSpeed);
    feederMid.set(feederSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

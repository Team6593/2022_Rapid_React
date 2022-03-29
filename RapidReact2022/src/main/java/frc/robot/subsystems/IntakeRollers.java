// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeRollers extends SubsystemBase {
  /** Creates a new IntakeRollers. */

  private WPI_TalonFX intakeRoller = new WPI_TalonFX(Constants.Intake_Roller_Motor_ID);
  //private speed = 0;


  public IntakeRollers(){
  }

  public void IntakeRun(double speed){
    intakeRoller.set(speed);
  }
  public void IntakeSoleExt(){
    
  }
  public void IntakeStop(){
    intakeRoller.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
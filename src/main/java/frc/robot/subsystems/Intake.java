// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
//when A pressed, motor should start, solenoid shoud extend.
  private Constants consts = new Constants();

  private WPI_TalonFX intakeBottomMotor = new WPI_TalonFX(consts.INTAKE_BOTTOM_ID);
  private WPI_TalonFX intakeMotor = new WPI_TalonFX(consts.Intake_UPPER_ID);
  private DoubleSolenoid intakeSolenoids = Constants.IT_SOLENOID;

  public Intake() {
    intakeBottomMotor.setInverted(true);
  }
//new
  public void intakeUpMotorStart(double uSpeed){
    intakeMotor.set(uSpeed);
  }
  public void intakeBottomMotorStart(double bSpeed){
    intakeBottomMotor.set(bSpeed);
    
  }
  //////
  public void intakeMotorRev(double speed){
    intakeBottomMotor.set(-speed);
    intakeMotor.set(-speed);
  }

  public void intakeMotorStop(){
    intakeBottomMotor.stopMotor();
    intakeMotor.stopMotor();
  }

  public void intakeSolExtend(){
    intakeSolenoids.set(Value.kForward);
  }

  public void intakeSolRetract(){
    intakeSolenoids.set(Value.kReverse);
  }

  public void intakeSolenoidStop(){
    intakeSolenoids.set(Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}

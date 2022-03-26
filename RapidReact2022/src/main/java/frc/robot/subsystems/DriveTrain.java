// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  public Constants consts = new Constants();

  public WPI_TalonFX DT_MASTER_RIGHT = new WPI_TalonFX(consts.DT_MASTER_RIGHT_ID, "rio");
  public WPI_TalonFX DT_MASTER_LEFT = new WPI_TalonFX(consts.DT_MASTER_LEFT_ID, "rio");
  public WPI_TalonFX DT_SLAVE_RIGHT = new WPI_TalonFX(consts.DT_SLAVE_RIGHT_ID, "rio");
  public WPI_TalonFX DT_SLAVE_LEFT = new WPI_TalonFX(consts.DT_SLAVE_LEFT_ID, "rio");
  

  // TalonFX testls1 = new TalonFX(1);
  // TalonFX testls2 = new TalonFX(2);
    
  // TalonFX testrs1 = new TalonFX(3);
  // TalonFX testrs2 = new TalonFX(4);

  // public void arcadedriveCustom(XboxController j, double L_Minus, double R_Minus)
  // {
  //   testls2.follow(testls1);
  //   testrs2.follow(testls2);

  //   double speed = -j.getRawAxis(1);
  //   double turn = j.getRawAxis(4);

  //   double left = (speed + turn) - L_Minus, 
  //         right = (speed - turn) - R_Minus;

  //         testls1.set(ControlMode.PercentOutput, left);
  //         testrs1.set(ControlMode.PercentOutput, right);
  // }

  public final MotorControllerGroup DT_LEFTSIDE = new MotorControllerGroup(DT_MASTER_LEFT, DT_SLAVE_LEFT);
  public final MotorControllerGroup DT_RIGHTSIDE = new MotorControllerGroup(DT_MASTER_RIGHT, DT_SLAVE_RIGHT);

  public final DifferentialDrive DIFF_DRIVE = new DifferentialDrive(DT_LEFTSIDE, DT_RIGHTSIDE);

  private final DoubleSolenoid shifter = Constants.DT_SHIFTER_SOLENOID;

  public void _arcadeDrive(double xSpd, double zRot) {
    DIFF_DRIVE.arcadeDrive(xSpd, zRot);
  }

  public void highGear(){
    shifter.set(Value.kForward);
  }
  public void lowGear(){
    shifter.set(Value.kReverse);
  }
  public void shifterOff(){
    shifter.set(Value.kOff);
  }

  public void stopAllMotors() {
    DIFF_DRIVE.stopMotor();
  }

  public void dt_Init() {
    /* Ensure motor output is neutral during init */
    DT_MASTER_LEFT.set(ControlMode.PercentOutput, 0);
    DT_MASTER_RIGHT.set(ControlMode.PercentOutput, 0);

    /* factory default values */
    DT_MASTER_RIGHT.configFactoryDefault();
    DT_SLAVE_RIGHT.configFactoryDefault();
    DT_MASTER_LEFT.configFactoryDefault();
    DT_SLAVE_LEFT.configFactoryDefault();

    /* set up followers */
     DT_SLAVE_RIGHT.follow(DT_MASTER_RIGHT);
     DT_SLAVE_LEFT.follow(DT_MASTER_LEFT);

     /* Set Neutral mode */
    DT_MASTER_RIGHT.setNeutralMode(NeutralMode.Brake);
    DT_MASTER_LEFT.setNeutralMode(NeutralMode.Brake);

    /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
     DT_MASTER_RIGHT.setInverted(TalonFXInvertType.Clockwise); // !< Update this
     DT_MASTER_LEFT.setInverted(TalonFXInvertType.CounterClockwise); // !< Update this

    /*
     * set the invert of the followers to match their respective master controllers
     */
     //DT_SLAVE_RIGHT.setInverted(InvertType.FollowMaster);
    // DT_SLAVE_LEFT.setInverted(InvertType.FollowMaster);
}
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

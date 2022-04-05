// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry LLtx = table.getEntry("tx");
  private NetworkTableEntry LLty = table.getEntry("ty");
  private NetworkTableEntry LLta = table.getEntry("ta");

  //reading values periodically
  private double limelightX = LLtx.getDouble(0.0);
  private double limelightY = LLty.getDouble(0.0);
  private double area = LLta.getDouble(0.0);

  public Limelight() {}

  //example of using a fixed camera to find distance
  public void TargetDistance(){
    double targetOffsetAngle_Vertical = LLty.getDouble(0.0);

    // how many degrees back is your limelight rotated from perfectly vertical?
    double limelightMountAngleDegrees = 25.0;

    // distance from the center of the Limelight lens to the floor
    double limelightLensHeightInches = 20.0;

    // distance from the target to the floor
    double goalHeightInches = 60.0;

    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

    //calculate distance
    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians);
  }
  public void seekingTarget(){
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;

public class LimeLight extends SubsystemBase {
  
  private NetworkTable table;
  private String tableName;

  /** Creates a new LimeLight. */
  public LimeLight(String tableName) {
    table = NetworkTableInstance.getDefault().getTable(tableName);
  }

  public LimeLight() {
    tableName = "limelight-hyper";
    table = NetworkTableInstance.getDefault().getTable(tableName);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    NetworkTableEntry tx = table.getEntry("tx"); // Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees) 
    NetworkTableEntry ty = table.getEntry("ty"); // Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
    NetworkTableEntry ta = table.getEntry("ta"); // Target Area (0% of image to 100% of image)

    double x = tx.getDouble(0);
    double y = ty.getDouble(0);
    double area = ta.getDouble(0);

    // post to SmartDashboard
    SmartDashboard.putNumber("LimeLight: X", x);
    SmartDashboard.putNumber("LimeLight: Y", y);
    SmartDashboard.putNumber("LimeLight: Area", area);
  }
}

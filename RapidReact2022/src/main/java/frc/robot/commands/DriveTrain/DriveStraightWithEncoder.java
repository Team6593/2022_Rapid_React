// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightWithEncoder extends CommandBase {
  private DriveTrain driveTrain;
  private double speed;
  private double distance;
  
  private double k_scale = 0;
  //k_scale is full revolution of the wheel


  /** Creates a new DTDriveStraight. */
  public DriveStraightWithEncoder(DriveTrain driveTrain, double speed, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.driveTrain = driveTrain;
    this.speed = speed;
    this.distance = distance + driveTrain.DT_MASTER_RIGHT.getSelectedSensorPosition();

    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.dt_Init();
    // driveTrain.stopAllMotors();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftDistance = driveTrain.DT_MASTER_LEFT.getSelectedSensorPosition();
    double rightDistance = driveTrain.DT_MASTER_RIGHT.getSelectedSensorPosition();
    double deltaDistance = rightDistance - leftDistance;

    driveTrain._arcadeDrive(speed + deltaDistance * k_scale, speed - deltaDistance * k_scale);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stopAllMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (driveTrain.DT_MASTER_RIGHT.getSelectedSensorPosition() >= distance);
    }
}

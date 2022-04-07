// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightWithGyro extends CommandBase {
  
  private DriveTrain driveTrain;
  double motorSpeed;
  
  /** Creates a new driveStraightWithGyro. */
  public DriveStraightWithGyro(DriveTrain driveTrain, double motorSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
    this.motorSpeed = motorSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.dt_Init();
    driveTrain.gyroReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.driveStraight(motorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //driveTrain.driveStraight(0);
    driveTrain.stopAllMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

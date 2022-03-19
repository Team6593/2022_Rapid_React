// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */

  private DriveTrain driveTrain = new DriveTrain();
  private double motorSpeed, rotationSpeed;


  public ArcadeDrive(DriveTrain driveTrain, double motorSpeed, double rotationSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.


    this.driveTrain = driveTrain;
    this.motorSpeed = motorSpeed;
    this.rotationSpeed = rotationSpeed;

    addRequirements(driveTrain);
  }


  @Override
  public void initialize() {

    driveTrain._arcadeDrive(motorSpeed, rotationSpeed);
    
  }

  @Override
  public void execute() {


  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.stopAllMotors();

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

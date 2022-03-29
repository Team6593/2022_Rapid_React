// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class StartShooting extends CommandBase {
  Turret turret = new Turret();
  private double speed = 0;
  /** Creates a new StartShooting. */
  public StartShooting(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(turret);
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turret.startMotor(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turret.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

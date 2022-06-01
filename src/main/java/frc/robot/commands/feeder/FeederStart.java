// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.feeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeederStart extends CommandBase {
  private Feeder feeder;
  public double speed;
  public double rightFeederSpeed;
  /** Creates a new StartFeeder. */
  public FeederStart(Feeder feeder, double speed, double rightFeederSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speed = speed;
    this.rightFeederSpeed = rightFeederSpeed;
    this.feeder = feeder;
    addRequirements(feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.startLRFeeder(speed, rightFeederSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    feeder.stopLRFeeder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.feeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeederReverse extends CommandBase {
  /** Creates a new FeederReverse. */
  private Feeder feeder;
  private double speed;
  private double rightFeederSpeed;
  public FeederReverse(Feeder feeder, double speed, double rightFeederSpeed) {
    this.feeder = feeder;
    this.speed = speed;
    this.rightFeederSpeed = rightFeederSpeed;

    addRequirements(feeder);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.FeederRev(speed, rightFeederSpeed);
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.feeder.FeederReverse;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeRevFeederRev extends ParallelCommandGroup {
  /** Creates a new IntakeRevFeederRev. */
  private Feeder feeder;
  private Intake intake;
  private double rightspeed;
  private double leftspeed;

  public IntakeRevFeederRev(Feeder feeder, Intake intake, double rightspeed, double leftspeed, double uSpeed, double bSpeed) {
    this.intake = intake;
    this.feeder = feeder;
    this.rightspeed = rightspeed;
    this.leftspeed = leftspeed;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new FeederReverse(feeder, rightspeed, leftspeed), 
      new IntakeMotorRun(intake, uSpeed, bSpeed)
    );
  }
}

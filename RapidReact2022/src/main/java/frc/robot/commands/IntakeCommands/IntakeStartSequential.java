// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeStartSequential extends SequentialCommandGroup {
  /** Creates a new IntakeStartSequential. */

  private Intake intake;
  private double speed;

  public IntakeStartSequential(Intake intake, double speed) {
    this.intake = intake;
    this.speed = speed;

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    
    //Intake solenoids extend
    new IntakeSolExtend(intake),

    //Intake motor run
    new IntakeMotorRun(intake, speed)
    );
  }
}

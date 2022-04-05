// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeMrunSolext extends ParallelCommandGroup {
  /** Creates a new IntakeMrunSolext. */
  Intake intake;
  double speed;
  
  public IntakeMrunSolext(Intake intake, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    this.intake = intake;
    this.speed = speed;
    addCommands(
      new IntakeMotorRun(intake, speed), 
      new IntakeSolExtend(intake)
      );
  }
}

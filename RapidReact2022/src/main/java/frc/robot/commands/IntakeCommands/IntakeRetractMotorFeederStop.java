// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.feeder.FeederStop;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeRetractMotorFeederStop extends ParallelCommandGroup {
  /** Creates a new IntakeRetractMotorFeederStop. */
  public IntakeRetractMotorFeederStop(Intake intake, Feeder feeder) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new IntakeMotorStop(intake),
      new IntakeSolRetract(intake),
      new FeederStop(feeder)
    );
  }
}

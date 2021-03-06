package frc.robot.commands.IntakeCommands;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class IntakeMotorRun extends CommandBase {
  /** Creates a new IntakeRun. */


  private Intake intake;
  private double uSpeed;
  private double bSpeed;

  public IntakeMotorRun(Intake intake, double uSpeed, double bSpeed){

    this.intake = intake;
    this.uSpeed = uSpeed;
    this.bSpeed = bSpeed;
    
    addRequirements(intake);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeUpMotorStart(uSpeed);
    intake.intakeBottomMotorStart(bSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.intakeMotorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class LowRungClimb extends CommandBase {
  
  Climber climber;
  double speed;
  double distance;

  double leftClimber_SelSenPos = climber.leftClimber.getSelectedSensorPosition();
  double leftClimber_SelSenVel = climber.leftClimber.getSelectedSensorVelocity();
  double rightClimber_SelSenPos = climber.rightClimber.getSelectedSensorPosition();
  double rightClimber_SelSenVel = climber.rightClimber.getSelectedSensorVelocity();

  /** Creates a new LowRungClimb. */
  public LowRungClimb(Climber climber, double speed, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climber = climber;
    this.speed = speed;
    addRequirements(climber);
    this.distance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.init();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // PSUEDOCODE
    if(leftClimber_SelSenPos >= distance && rightClimber_SelSenPos >= distance) {
      climber.leftClimber.stopMotor();
    } else {
      climber.moveHooksUp(speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.stopHooks();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveTrainDefaultCommand extends CommandBase {
  /** Creates a new ArcadeDrive. */

  private DriveTrain driveTrain ;
  private XboxController xboxController;
  private Joystick jstickController;


  public DriveTrainDefaultCommand(DriveTrain driveTrain, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.


    this.driveTrain = driveTrain;
    this.xboxController = xboxController;

    addRequirements(driveTrain);
  }
  public DriveTrainDefaultCommand(DriveTrain driveTrain, Joystick jstickController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.jstickController = jstickController;

    addRequirements(driveTrain);
  }


@Override
  public void initialize() {
    driveTrain.dt_Init();
  }

  @Override
  public void execute() {
    driveTrain._arcadeDrive(xboxController.getRawAxis(1), xboxController.getRawAxis(4));
    //driveTrain._arcadeDrive(jstickController.getRawAxis(1), -jstickController.getRawAxis(0));

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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.DriveTrain.DriveTrainDefaultCommand;
import frc.robot.commands.DriveTrain.HighGear;
import frc.robot.commands.DriveTrain.LowGear;
import frc.robot.commands.IntakeCommands.IntakeMotorRun;
import frc.robot.commands.IntakeCommands.IntakeMotorStop;
import frc.robot.commands.IntakeCommands.IntakeSolExtend;
import frc.robot.commands.IntakeCommands.IntakeSolRetract;
import frc.robot.commands.IntakeCommands.IntakeStartSequential;
import frc.robot.commands.IntakeCommands.IntakeStopSequential;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;
import frc.robot.commands.feeder.FeederStart;
import frc.robot.commands.feeder.FeederStop;
import frc.robot.commands.turret.ShootingStart;
import frc.robot.commands.turret.ShootingStop;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;
  private final Feeder feeder;
  private final Intake intake;
  private final Turret turret;

  //OI
  private XboxController x_stick = new XboxController(Constants.XboxController_Port);
  JoystickButton a_Button, x_Button, y_Button, b_Button, l_Button, r_Button, menu_Button;

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    feeder = new Feeder();
    intake = new Intake();
    turret = new Turret();

    driveTrain.setDefaultCommand(new DriveTrainDefaultCommand(driveTrain, x_stick));

    a_Button = new JoystickButton(x_stick, Constants.A_BUTTON);
    x_Button = new JoystickButton(x_stick, Constants.X_BUTTON);
    y_Button = new JoystickButton(x_stick, Constants.Y_BUTTON);
    b_Button = new JoystickButton(x_stick, Constants.B_BUTTON);
    l_Button = new JoystickButton(x_stick, Constants.L_BUTTON);
    r_Button = new JoystickButton(x_stick, Constants.R_BUTTON);
    menu_Button = new JoystickButton(x_stick, Constants.Menu_BUTTON);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * @param Turret 
   */
  private void configureButtonBindings() {
    
    //Button Maping
    x_Button.whenPressed(new HighGear(driveTrain));
    y_Button.whenPressed(new LowGear(driveTrain));

    //Feeder binding
    a_Button.whenPressed(new FeederStart(feeder, 0.2)).whenReleased(new FeederStop(feeder));

    //Intake bindings
    b_Button.whenPressed(new IntakeStartSequential(intake, 0.2));
    menu_Button.whenPressed(new IntakeStopSequential(intake));

    //Turret binding
    l_Button.whileHeld(new ShootingStart(turret, .2)).whenReleased(new ShootingStop(turret));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

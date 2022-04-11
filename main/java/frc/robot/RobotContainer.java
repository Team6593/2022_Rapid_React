// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.WaitCommand;
import frc.robot.commands.DriveTrain.DriveStraightWithEncoder;
import frc.robot.commands.DriveTrain.DriveStraightWithGyro;
import frc.robot.commands.DriveTrain.DriveTrainDefaultCommand;
import frc.robot.commands.DriveTrain.HighGear;
import frc.robot.commands.DriveTrain.LowGear;
import frc.robot.commands.IntakeCommands.IntakeExtendMotorFeederStart;
import frc.robot.commands.IntakeCommands.IntakeMotorRun;
import frc.robot.commands.IntakeCommands.IntakeMotorStop;
import frc.robot.commands.IntakeCommands.IntakeRetractMotorFeederStop;
import frc.robot.commands.IntakeCommands.IntakeSolExtend;
import frc.robot.commands.IntakeCommands.IntakeSolRetract;
import frc.robot.commands.climbing.LowRungClimb;
import frc.robot.commands.climbing.MidRungClimb;
import frc.robot.commands.climbing.StopClimbing;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;
import frc.robot.commands.feeder.FeederStart;
import frc.robot.commands.feeder.FeederStop;
import frc.robot.commands.turret.AlignTurret;
import frc.robot.commands.turret.ShootingStart;
import frc.robot.commands.turret.ShootingStop;
import frc.robot.commands.turret.TurnTurret;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final DriveTrain driveTrain;
  public final Feeder feeder;
  public final Intake intake;
  public final Turret turret;
  public final Climber climber;

  public final Compressor compressor;

  //OI
  private XboxController x_stick = new XboxController(Constants.XboxController_Port);
  //private Joystick x_stick = new Joystick(0);
  JoystickButton a_Button, x_Button, y_Button, b_Button, l_Button, r_Button, menu_Button,rclick_Button, lclick_Button;
  Button rightDpad, leftDpad;

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    feeder = new Feeder();
    intake = new Intake();
    turret = new Turret();
    climber = new Climber();
    
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    //driveStraightWithTime = new DriveStraightWithTime(driveTrain, 4);

    driveTrain.setDefaultCommand(new DriveTrainDefaultCommand(driveTrain, x_stick));
    
    a_Button = new JoystickButton(x_stick, Constants.A_BUTTON);
    x_Button = new JoystickButton(x_stick, Constants.X_BUTTON);
    y_Button = new JoystickButton(x_stick, Constants.Y_BUTTON);
    b_Button = new JoystickButton(x_stick, Constants.B_BUTTON);
    l_Button = new JoystickButton(x_stick, Constants.L_BUTTON);
    r_Button = new JoystickButton(x_stick, Constants.R_BUTTON);
    menu_Button = new JoystickButton(x_stick, Constants.Menu_BUTTON);
    rclick_Button = new JoystickButton(x_stick, Constants.RCLICK_BUTTON);
    lclick_Button = new JoystickButton(x_stick, Constants.LCLICK_BUTTON);
    
    leftDpad = new Button(() -> x_stick.getPOV() == 90);
    rightDpad = new Button(() -> x_stick.getPOV() == 270);
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
    //a_Button.whenPressed(new IntakeExtendMotorFeederStart(intake, 0.4, feeder, 0.2));
    //b_Button.whenPressed(new IntakeRetractMotorFeederStop(intake, feeder));
    a_Button.whenPressed(new IntakeSolExtend(intake).andThen(new IntakeMotorRun(intake, .5)));

    b_Button.whenPressed(new IntakeMotorStop(intake).andThen(new IntakeSolRetract(intake)));

    //menu_Button.whenPressed(new IntakeMotorRun(intake, 0.65));
    r_Button.whenPressed(new IntakeMotorStop(intake));
    //b_Button.whenPressed(new IntakeSolRetract(intake).andThen(new IntakeMotorStop(intake)));

    y_Button.whenPressed(new LowRungClimb(climber, 1)).whenReleased(new StopClimbing(climber));
    x_Button.whenPressed(new LowRungClimb(climber, -1)).whenReleased(new StopClimbing(climber));

    //r_Button.whileHeld(new AlignTurret(turret).andThen(new ShootingStart(turret, .75))).whenReleased(new ShootingStop(turret));
    l_Button.whileHeld(new ShootingStart(turret, .6)).whenReleased(new ShootingStop(turret));

    rclick_Button.whenPressed(new HighGear(driveTrain));
    lclick_Button.whenPressed(new LowGear(driveTrain));

    //leftDpad.whileHeld(new TurnTurret(turret,+0.75));
    //rightDpad.whileHeld(new TurnTurret(turret, -0.75));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new DriveStraightWithGyro(driveTrain, .4).withTimeout(5);
  }
}
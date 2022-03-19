// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    XboxController XBOX_CONTROLLER = new XboxController(0);

    public final WPI_TalonFX DT_MASTER_RIGHT = new WPI_TalonFX(3);
    public final WPI_TalonFX DT_MASTER_LEFT = new WPI_TalonFX(1);
    public final WPI_TalonFX DT_SLAVE_RIGHT = new WPI_TalonFX(4);
    public final WPI_TalonFX DT_SLAVE_LEFT = new WPI_TalonFX(2);

    public final MotorControllerGroup DT_LEFTSIDE = new MotorControllerGroup(DT_MASTER_LEFT, DT_SLAVE_LEFT);
    public final MotorControllerGroup DT_RIGHTSIDE = new MotorControllerGroup(DT_MASTER_RIGHT, DT_SLAVE_RIGHT);

    public final DifferentialDrive RB_DRIVE = new DifferentialDrive(DT_RIGHTSIDE, DT_LEFTSIDE);
    

    


}

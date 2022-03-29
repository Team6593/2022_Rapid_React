// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


    //Xbox Controller Port
    public static final int XboxController_Port = 0;

    //Intake Motor ID
 

    public static final int A_BUTTON = 1;

    public static final int X_BUTTON = 3;

    public static final int Y_BUTTON = 4;

    public static final int B_BUTTON = 2;

    //DriveTrain Motors
    public final int DT_MASTER_RIGHT_ID = 3;
    public final int DT_SLAVE_RIGHT_ID = 4;
    
    public final int DT_MASTER_LEFT_ID = 1;
    public final int DT_SLAVE_LEFT_ID = 2;

    public static final DoubleSolenoid DT_SHIFTER_SOLENOID = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    public static final DoubleSolenoid IT_SOLENOID = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    //Intake Solenoid and Motors
    public static final int Intake_Roller_Motor_ID = 0;
    public static final int TURRET_MOTOR_ID = 0;


}

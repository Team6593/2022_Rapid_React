// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.ctre.phoenix.sensors.Pigeon2;

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

    //Joystick button map
    public static final int hand_bottom_Button = 2;
    public static final int hand_right_Button = 4;
    public static final int hand_left_Button = 3;
    public static final int bottom_leftLeft_Button = 11;
    public static final int bottom_leftMid_Button = 12;
    public static final int bottom_leftRight_Button = 13;
    public static final int trigger_Button = 1;
    public static final int bottom_rightMid_Button = 6;
    public static final int bottom_rightRight_Button = 5;
    public static final int lowerbottom_left_Button = 15;

    //Xbox button map
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int L_BUTTON = 5;
    public static final int R_BUTTON = 6;
    public static final int Window_BUTTON = 7;
    public static final int Menu_BUTTON = 8;
    public static final int LCLICK_BUTTON = 9;
    public static final int RCLICK_BUTTON = 10;
    
    
    //DriveTrain Motors and Solenoid
    public final int DT_MASTER_RIGHT_ID = 3;
    public final int DT_SLAVE_RIGHT_ID = 4;
    public final int DT_MASTER_LEFT_ID = 1;
    public final int DT_SLAVE_LEFT_ID = 2;
    public static final DoubleSolenoid DT_SHIFTER_SOLENOID = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    
    // Climber
    public final int CLIMBER_LEFT = 9;
   //public final int CLIMBER_RIGHT = 10;

    // Feeder
    public final int FEEDER_LEFT = 6;
    public final int FEEDER_RIGHT = 11; 
    public final int FEEDER_MID = 7;
    
    //Intake Solenoid and Motor
    public static final DoubleSolenoid IT_SOLENOID = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    public final int INTAKE_BOTTOM_ID = 5; 
    public final int Intake_UPPER_ID = 10;//!Change to 10

    //Turret Motor
    public final int TURRET_SHOOTMOTOR = 8;
    public final int TURRET_ALIGNER = -1;

    // LimeLight
    public final int PORT = 5800; // might have to change port num later
}
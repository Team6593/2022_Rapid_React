package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLight {

    public static double ANGLE = 21.0; 

    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public static NetworkTableEntry targets = table.getEntry("tv");
    public static NetworkTableEntry xOffset = table.getEntry("tx");
    public static NetworkTableEntry yOffset = table.getEntry("ty");

    // public static NetworkTableEntry ts = table.getEntry("sk");

    public static boolean hasTarget() {
        return targets.getDouble(0) == 1;
    }

    public static double getXOffset(){ // returns degrees
        return xOffset.getDouble(0);
    }

    public static double getDistance() { // returns feet
        double angleDegrees = getXOffset() + ANGLE;
        double targetHeight = 8.0 + 9.0/12.0;

        return targetHeight / Math.tan(Math.toRadians(angleDegrees));
    }

}

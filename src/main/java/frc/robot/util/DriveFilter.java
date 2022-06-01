package frc.robot.util;

public class DriveFilter {
    private double last;

    public DriveFilter() {
        last = 0.0;
    }

    public double get(double next) {
        double sign = (next > 0) ? 1 : -1;
        next *= next * sign;

        return last += (next - last) * (1 - 0.92312);
    }
}

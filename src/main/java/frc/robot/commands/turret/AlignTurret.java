package frc.robot.commands.turret;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.Turret;

public class AlignTurret extends CommandBase {
    
    private final Turret turret;
    private final PIDController controller;

    public AlignTurret(Turret turret) {
        this.turret = turret;
        controller = new PIDController(1.0 / 13.5, 0, 0);
        controller.setSetpoint(0);
        controller.setTolerance(2.0); // maximum 2 degrees error

        addRequirements(turret);
    }

    public void execute() {
        double angleError = LimeLight.getXOffset();
        turret.setAlign(controller.calculate(+angleError)); // might have to come back to this later
    }

    public boolean isFinished() {
        return controller.atSetpoint();
    }

    public void end(boolean interrupted) {
        turret.setAlign(0);
    }

}

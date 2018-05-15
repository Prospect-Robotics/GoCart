package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import org.usfirst.frc2813.SkrrtSkrrt.subsystems.Cannon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleElevationSide extends Command {
	Direction d;
	
    public ToggleElevationSide(Direction d) {
        requires(Robot.cannonMotors);
    	this.d = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cannonMotors.whichSide = d;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

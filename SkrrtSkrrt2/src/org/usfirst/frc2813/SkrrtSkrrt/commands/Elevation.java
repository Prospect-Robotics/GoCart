package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import org.usfirst.frc2813.SkrrtSkrrt.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevation extends Command {
	private Direction elevationDirection;
	private WPI_VictorSPX motor;
	
	
    public Elevation(Direction d) {
        requires(Robot.cannonMotors);

    	this.elevationDirection = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switch(Robot.cannonMotors.whichSide) {
    	case LEFT:	
    		this.motor = RobotMap.driveTrainLeftMotor;
    		break;
    	case RIGHT:	
        	this.motor = RobotMap.driveTrainLeftMotor;
    		break;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(elevationDirection) {
    	case UP:
    		motor.set(1);
    		break;
    	case DOWN:
    		motor.set(-1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	motor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	motor.set(0);
    }
}

package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import org.usfirst.frc2813.SkrrtSkrrt.subsystems.CannonMotors;

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
    
    protected void initialize() {
    	switch(Robot.cannonMotors.whichSide) {
    	case LEFT:	
    		this.motor = CannonMotors.leftMotor;
    		break;
    	case RIGHT:	
        	this.motor = CannonMotors.rightMotor;
    		break;
    	case UP:
    		throw new IllegalArgumentException("Direction UP passed for cannon side");
    	case DOWN:
    		throw new IllegalArgumentException("Direction DOWN passed for cannon side");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(elevationDirection) {
    	case UP:
    		motor.set(0.2);
    		break;
    	case DOWN:
    		motor.set(-0.2);
    	case LEFT:
    		throw new IllegalArgumentException("Direction LEFT passed for cannon elevation direction");
    	case RIGHT:
    		throw new IllegalArgumentException("Direction RIGHT passed for cannon elevation direction");
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

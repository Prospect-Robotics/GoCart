package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import org.usfirst.frc2813.SkrrtSkrrt.RobotMap;
import org.usfirst.frc2813.SkrrtSkrrt.subsystems.CannonMotors;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Uses motor to change the elevation of the cannon
 */
public class Elevation extends Command {
	private Direction elevationDirection;
	private WPI_VictorSPX motor;
	private DigitalInput highLimitSwitch;
	private DigitalInput lowLimitSwitch;
	
    public Elevation(Direction d) {
        requires(Robot.cannonMotors);
    	this.elevationDirection = d;
    }
    
    protected void initialize() {
    	switch(Robot.cannonMotors.whichSide) {
    	case LEFT:	
    		this.motor = CannonMotors.leftMotor;
    		this.highLimitSwitch = RobotMap.leftHighLimitSwitch;
    		this.lowLimitSwitch = RobotMap.leftLowLimitSwitch;
    		break;
    	case RIGHT:	
        	this.motor = CannonMotors.rightMotor;
    		this.highLimitSwitch = RobotMap.rightHighLimitSwitch;
    		this.lowLimitSwitch = RobotMap.rightLowLimitSwitch;
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
    		if (!highLimitSwitch.get())
    			motor.set(-0.4);
    		break;
    	case DOWN:
    		if (!lowLimitSwitch.get())
    			motor.set(0.4);
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

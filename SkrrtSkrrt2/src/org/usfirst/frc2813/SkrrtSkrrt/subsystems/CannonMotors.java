package org.usfirst.frc2813.SkrrtSkrrt.subsystems;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Defines the two motors elevating the cannons in a subsystem
 */
public class CannonMotors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Direction whichSide = Direction.RIGHT;
	
	public static final WPI_VictorSPX leftMotor = RobotMap.elevationLeft;
    public static final WPI_VictorSPX rightMotor = RobotMap.elevationRight;

    public void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
    
}


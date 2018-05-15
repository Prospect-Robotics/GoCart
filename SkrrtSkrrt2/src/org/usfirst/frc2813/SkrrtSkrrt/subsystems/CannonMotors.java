package org.usfirst.frc2813.SkrrtSkrrt.subsystems;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CannonMotors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Direction whichSide;
	
	private final WPI_VictorSPX leftMotor = RobotMap.elevationLeft;
    private final WPI_VictorSPX rightMotor = RobotMap.elevationRight;

    public void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
    
}


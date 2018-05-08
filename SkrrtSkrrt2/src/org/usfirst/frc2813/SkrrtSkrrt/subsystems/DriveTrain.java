// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2813.SkrrtSkrrt.subsystems;

import org.usfirst.frc2813.SkrrtSkrrt.RobotMap;
import org.usfirst.frc2813.SkrrtSkrrt.commands.OIDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_VictorSPX leftMotor = RobotMap.driveTrainLeftMotor;
    private final WPI_VictorSPX rightMotor = RobotMap.driveTrainRightMotor;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    
    public static final double speedMax = 1;
    public static final double deceleration = 0.5;
    
    public static double leftSpeed = 0;
    public static double rightSpeed = 0;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new OIDrive());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
    
    public void tankDrive(Joystick Joystick, Joystick rightJoystick) {
    	double leftPositiveNegative = 0;
    	if(Joystick.getRawAxis(1) != 0) leftPositiveNegative = Joystick.getRawAxis(1)/Math.abs(Joystick.getRawAxis(1));
    	else leftPositiveNegative = 0;
    	
    	double rightPositiveNegative = 0;
    	if(Joystick.getRawAxis(3) != 0) rightPositiveNegative = Joystick.getRawAxis(3)/Math.abs(Joystick.getRawAxis(3));
    	else rightPositiveNegative = 0;
    	
    	/* robotDrive.tankDrive(Math.abs(leftJoystick.getY()) > speedMax ? speedMax*leftPositiveNegative : leftJoystick.getY(),
    						Math.abs(rightJoystick.getY()) > speedMax ? speedMax*rightPositiveNegative : rightJoystick.getY()); */
    	double leftJoystickValueSQRD = Math.pow(Joystick.getRawAxis(1),2);
    	
    	//If joysticks are desired over the controller, change Joystick.getRawAxis(3) below to rightJoystick.getY().
    	double rightJoystickValueSQRD = Math.pow(Joystick.getRawAxis(3),2);
    	
    	robotDrive.tankDrive(leftJoystickValueSQRD * speedMax * leftPositiveNegative, rightJoystickValueSQRD * speedMax * rightPositiveNegative); 
    }

    // Put methods for controlling this subsystem
    
    // here. Call these from Commands.

}


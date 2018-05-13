// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2813.SkrrtSkrrt;

import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import org.usfirst.frc2813.SkrrtSkrrt.commands.Fire;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
    public Joystick controller;

    public OI() {
    	Robot r = Robot.getInstance();
    	controller = new Joystick(0);
    	new JoystickButton(controller, 5).whenPressed(new Fire(r.leftCannon));	//  Left cannon has been pressure tested
		new JoystickButton(controller, 6).whenPressed(new Fire(r.rightCannon));	//  .Right cannon cannister is new; has NOT been pressure tested; uncomment when tested
        
        
    }

    public Joystick getLeftJoystick() {
        return controller;
    }
}


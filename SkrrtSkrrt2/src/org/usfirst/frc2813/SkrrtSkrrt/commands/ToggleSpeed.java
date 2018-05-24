package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * The Go Cart will move at full speed or half speed according to DriveTrain.speedMax
 */
public class ToggleSpeed extends InstantCommand {

    public ToggleSpeed() {
    }
    protected void initialize() {
    	if (DriveTrain.speedMax == 1) {
    		DriveTrain.speedMax = 0.65;
    	} else {
    		DriveTrain.speedMax = 1;
    	}
    }
}

package org.usfirst.frc2813.SkrrtSkrrt.commands;

import org.usfirst.frc2813.SkrrtSkrrt.Direction;
import org.usfirst.frc2813.SkrrtSkrrt.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Toggle the which side cannon is being moved up/down
 */
public class ToggleElevationSide extends InstantCommand {
	Direction d;
	
    public ToggleElevationSide(Direction d) {
        requires(Robot.cannonMotors);
    	this.d = d;
    }
    
    protected void initialize() {
    	Robot.cannonMotors.whichSide = d;
    }
}

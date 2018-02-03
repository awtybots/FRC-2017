package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class gearLifterLengthDown extends Command {
   boolean finished;
   double dLength;
	public gearLifterLengthDown(double length) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		dLength = length;
    } 
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearIntake.gearLiftDownLength(dLength);
    	 finished = Robot.gearIntake.gearLiftDownLength(dLength);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

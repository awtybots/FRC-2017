package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveForward extends Command {
	public double ds;
    public driveForward(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	ds = distance;
    	requires(Robot.shooter);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//ds = Robot.navx.getDisplacementZ() + ds;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveForward(ds);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

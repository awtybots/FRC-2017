package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class turnDegree extends Command {
	public double dg;
	
	public boolean turnIsFinished;

    public turnDegree(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	dg = degrees;
    	requires(Robot.shooter);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navx.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.driveTrain.turnDegrees(dg);
    	turnIsFinished = Robot.driveTrain.turnDegrees(dg);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return turnIsFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

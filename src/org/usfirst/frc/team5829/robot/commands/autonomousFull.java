package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autonomousFull extends CommandGroup {

    public autonomousFull() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	/*addSequential(new autonomousCurve(108,120,45));
    	addParallel(new Intake());
    	addSequential(new autonomousCurve(16.5,120,180));
    	addSequential(new autonomousShoot(5000,5));*/
    	//addSequential(new driveForward(87));
    	//addSequential(new GearOutake());

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	addSequential(new driveForward(80));
    	addSequential(new turnDegree(45));
    	
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

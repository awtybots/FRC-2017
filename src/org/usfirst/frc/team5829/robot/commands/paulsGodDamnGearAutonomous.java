package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class paulsGodDamnGearAutonomous extends Command {
	public int poc;

    public paulsGodDamnGearAutonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navx.resetDisplacement();
    	poc = 0;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*double dx = Robot.navx.getDisplacementX();
        double dy = Robot.navx.getDisplacementY();
        double td = Math.sqrt((dx*dx) + (dy*dy));
        Robot.driveTrain.turnDegrees(45);
        Timer.delay(1);
        Robot.driveTrain.driveForward(.5);
        Timer.delay(1);
        Robot.driveTrain.turnDegrees(-45);
        Timer.delay(1);
        Robot.driveTrain.driveForward(.5);
        Timer.delay(1);
        Robot.driveTrain.turnDegrees(135);*/
    	Robot.driveTrain.driveForward(1.3);
    	Timer.delay(4);
    	Robot.driveTrain.turnDegrees(60);
    	Timer.delay(4);
    	Robot.driveTrain.driveForward(2.49);
    	Timer.delay(4);
    	Robot.driveTrain.driveForward(-0.76);
    	Timer.delay(4);
    	Robot.driveTrain.turnDegrees(30);
    	Timer.delay(4);
    	Robot.driveTrain.driveForward(-2.34);
    	
        }

/*
    	if (poc == 0) {
    		new turnDegree(45);
    		if (Robot.navx.getYaw() <50 && Robot.navx.getYaw() > 40) {
    			poc++;
    		}
    	} 
    	else if (poc == 1) {
    		new driveForward(.5);
    		if (td > .5) {
    			poc++;
    		}
    	}
    	else if (poc == 2) {
    		new turnDegree(-45);
    		if (Robot.navx.getYaw() < -40 && Robot.navx.getYaw() > -50) {
    			poc++;
    		}
    	}
    	else if (poc == 3) {
    		new driveForward(.8); 
    		if (td > .8) {
    			poc++;
    		}
    	}
    	else {
    		
    	}
    	 */
    	

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

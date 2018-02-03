package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class autonomousCurve extends Command {
	double aChangeXPos;
	double aChangeYPos;
	double aChangeAngle;
    public autonomousCurve(double changeXPos, double changeYPos, double changeAngle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	aChangeXPos = changeXPos;
    	aChangeYPos = changeYPos;
    	aChangeAngle = changeAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		SmartDashboard.putNumber("DrivenLeft", Robot.driveTrain.encoderToInches(Robot.driveTrain.leftFrontMotor.getEncPosition()));
    		SmartDashboard.putNumber("DrivenRight", Robot.driveTrain.encoderToInches(Robot.driveTrain.rightBackMotor.getEncPosition()));
    		Robot.driveTrain.curve(aChangeXPos, aChangeYPos, aChangeAngle);
    	
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

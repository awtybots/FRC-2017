package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveForward extends Command {
	public boolean finished;
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
       	finished = false;
    	Robot.navx.resetDisplacement();
    	
      	Robot.driveTrain.rightBackMotor.setEncPosition(0);
    	Robot.driveTrain.leftFrontMotor.setEncPosition(0);
    	//ds = Robot.navx.getDisplacementZ() + ds;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveForward(ds);
 
    	  
    	double diameter = 4;
    	double circumference = diameter;
    	double distance = ds;
    	double lBMP = Robot.driveTrain.leftFrontMotor.getEncPosition();
    	double rBMP = Robot.driveTrain.rightBackMotor.getEncPosition();
    	double distanceDrivenRight = ((rBMP/1024)*circumference);
    	double distanceDrivenLeft =((lBMP/1024)*circumference);
    	double avgDistanceDriven = ((distanceDrivenRight + distanceDrivenLeft)/2);
    	finished = Robot.driveTrain.driveForward(ds);

    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.navx.resetDisplacement();
    	
      	Robot.driveTrain.rightBackMotor.setEncPosition(0);
    	Robot.driveTrain.leftFrontMotor.setEncPosition(0);
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

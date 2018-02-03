
package org.usfirst.frc.team5829.robot.commands;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.subsystems.TankDriveTrain;

/**
 *
 */
public class TankDrive extends Command {
	double p = 0.15;

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        
        
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 Robot.driveTrain.rightBackMotor.setEncPosition(0);
         Robot.driveTrain.leftFrontMotor.setEncPosition(0);
        
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = -(Robot.oi.xbox.getRawAxis(1));
    	double rightSpeed = (Robot.oi.xbox.getRawAxis(5));
    	SmartDashboard.putNumber("Yaw", Robot.navx.getYaw());
    	
    	//SmartDashboard.putNumber("Acceleration", TankDriveTrain.navx.getRawAccelY()); 
    
    	
    	//Robot.shooter.shooterMotorTwo.setP(p);
    	//p = p + 0.001;
    	//SmartDashboard.putNumber("P Value: ", Robot.shooter.shooterMotorTwo.getP());
    	//double xD = TankDriveTrain.navx.getDisplacementX();
    	//double yD = TankDriveTrain.navx.getDisplacementY();
    	//double displacement = (Math.sqrt((xD*xD)+(yD*yD)));
    	//SmartDashboard.putNumber("Displacement", TankDriveTrain.navx.getDisplacementX());
    	System.out.println(Robot.navx.getYaw());
    	System.out.println(Robot.navx.getDisplacementX());
    	
    	
    	if (Math.abs(leftSpeed) < .2){
    		leftSpeed = 0;
    	}
    	if (Math.abs(rightSpeed) < .2){
    		rightSpeed = 0;
    	}
    	
    	Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
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


package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.MecanumDrive;
import org.usfirst.frc.team5829.robot.commands.TankDrive;
import org.usfirst.frc.team5829.robot.commands.chesyDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

import com.kauailabs.navx.frc.*;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDriveTrain extends Subsystem {
	public CANTalon leftFrontMotor = new CANTalon(RobotMap.leftFrontMotor);
	public CANTalon leftBackMotor = new CANTalon(RobotMap.leftBackMotor);
	public CANTalon rightFrontMotor = new CANTalon(RobotMap.rightFrontMotor);
	public CANTalon rightBackMotor = new CANTalon(RobotMap.rightBackMotor);
	static final double CONSTANT_RAMP_LIMIT = 0.1;
	private double prevLeft = 0, prevRight = 0;
	private double prevY = 0, prevX = 0, prevR;

	double desiredAngle;
	boolean firstTime = true;
	double initialAngle;
	double leftSpeed = .425;
	public boolean isFinished;
	double rightSpeed = .4;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new chesyDrive());
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
       //tank drive
        leftFrontMotor.set(leftSpeed);
        leftBackMotor.set(leftSpeed);
        rightFrontMotor.set(rightSpeed);
        rightBackMotor.set(rightSpeed); 	
    }
    public void mecanumDrive(){
    	double y = Robot.oi.getRawAnalogStickALY();
    	double x = Robot.oi.getRawAnalogStickALX();
    	double r = Robot.oi.getRawAnalogStickARX();
		// deadband
		if (Math.abs(y) < 0.1)
			y = 0;
		if (Math.abs(x) < 0.1)
			x = 0;
		if (Math.abs(r) < 0.1)
			r = 0;
		double ox = x, oy = y, or = r;

		if (ox - prevX > CONSTANT_RAMP_LIMIT) {
			ox = prevX + CONSTANT_RAMP_LIMIT;
		} else if (prevX - ox > CONSTANT_RAMP_LIMIT) {
			ox = prevX - CONSTANT_RAMP_LIMIT;
		}
		if (oy - prevY > CONSTANT_RAMP_LIMIT) {
			oy = prevY + CONSTANT_RAMP_LIMIT;
		} else if (prevY - oy > CONSTANT_RAMP_LIMIT) {
			oy = prevY - CONSTANT_RAMP_LIMIT;
		}
		if (or - prevR > CONSTANT_RAMP_LIMIT) {
			or = prevR + CONSTANT_RAMP_LIMIT;
		} else if (prevR - or > CONSTANT_RAMP_LIMIT) {
			or = prevR - CONSTANT_RAMP_LIMIT;
		}

		prevX = ox;
		prevY = oy;
		prevR = or;
		
		
    }
    
    public void ChesyDrive(double straight, double rotate){
    	
    	leftFrontMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightBackMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	leftFrontMotor.setVoltageRampRate(.5);
    	leftBackMotor.setVoltageRampRate(.5);
    	rightFrontMotor.setVoltageRampRate(.5);
    	rightBackMotor.setVoltageRampRate(.5);
    	leftFrontMotor.set(straight + rotate);
    	leftBackMotor.set(straight + rotate);
        rightFrontMotor.set(straight - rotate);
        rightBackMotor.set(straight - rotate);
    }
    public  double encoderToInches(double ticks) {
    	
    	double diameter = 4;
    	double circumference = 2*3.14*diameter;
    	double rotations = ticks/1024;
    	double inches = rotations*circumference;
    	
    	
    	return inches;
    	
    }
    public boolean turnDegrees(double dg) {
    	double yaw = Robot.navx.getYaw();
    	double angle = Robot.navx.getAngle();
    	;
    	if (angle > 360 || angle <-360 ) {
    		angle = ((angle%360) * 360);
    		
    	}
    	SmartDashboard.putNumber("angle value", angle);
    	
    	
    	double motorSpeed = .4;
    	//double motorSpeed = ((difference/dg));
    	if (dg > 0) {
    	if (angle < (dg-5)   ) {
    		
    		leftFrontMotor.set(-motorSpeed);
    		leftBackMotor.set(-motorSpeed);
    		rightBackMotor.set(-motorSpeed);
    		rightFrontMotor.set(-motorSpeed);
    		isFinished = false;
    	}
    	else if (angle > (dg+5)  ) {
    		leftFrontMotor.set(motorSpeed);
    		leftBackMotor.set(motorSpeed);
    		rightFrontMotor.set(motorSpeed);
    		rightBackMotor.set(motorSpeed);
    		isFinished = false;
    		
    	}
    	else if (angle < (dg+4.9) && angle > (dg-4.9)) {
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightBackMotor.set(0);
    		rightFrontMotor.set(0);
    		isFinished = true;
 
    		}
    	return isFinished;
    	}
    	else if (dg < 0) {
        	if (angle < (dg - 5)   ) {
        		
        		leftFrontMotor.set(-motorSpeed);
        		leftBackMotor.set(-motorSpeed);
        		rightBackMotor.set(-motorSpeed);
        		rightFrontMotor.set(-motorSpeed);
        		isFinished = false;
        	}
        	else if (angle > (dg+5)  ) {
        		leftFrontMotor.set(motorSpeed);
        		leftBackMotor.set(motorSpeed);
        		rightFrontMotor.set(motorSpeed);
        		rightBackMotor.set(motorSpeed);
        		isFinished= false;
        	}
        	else if (angle < (dg+4.9) && angle > (dg-4.9)) {
        		leftFrontMotor.set(0);
        		leftBackMotor.set(0);
        		rightBackMotor.set(0);
        		rightFrontMotor.set(0);
        		isFinished= true;
     
        	}
        	return isFinished;
    	}
    	SmartDashboard.putBoolean("Finished turn?", isFinished);
    	return isFinished;
    	
    }
    public void curve(double changeX, double changeY, double changeAngle) {
    	
    	desiredAngle = changeAngle;
    	SmartDashboard.putNumber("Desired Angle", desiredAngle);
    	leftFrontMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightBackMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	double r = changeY/Math.sin(changeAngle);
    	double speed = .25;
    	double radiusRight = r +15.5;
    	double radiusLeft = r - 15.5;
    	double time = 3;
    	// Low gear max RPM is 530
    	double rPMMax = 530;
    	double rPSMax = rPMMax/60;
    	double diameter = 4;
    	double circumference = 4;
    	double velocityMax = rPSMax*circumference;
    	
    	if (firstTime = true) {
        	double initialLeftDriven = leftFrontMotor.getEncPosition();
        	double initialRightDriven = rightBackMotor.getEncPosition();
        	initialAngle = Robot.navx.getAngle();
        	double initialXPos = 30;
        	double initialYPos = 14.5;
        	double desiredXPos = initialXPos + changeX;
        	double desiredYPos = initialYPos + changeY;
        	
        	firstTime = false;

    	}
    	double arcForRight = ((desiredAngle)/360)*(2*3.14*radiusRight);
    	double arcForLeft = ((desiredAngle)/360)*(2*3.14*radiusLeft);
    	double velocityRight = (arcForRight)/time;
    	double velocityLeft = -(arcForLeft)/time;
    	double percentageRight = velocityRight/velocityMax;
    	double percentageLeft = velocityLeft/velocityMax;
    	
    	if (changeX > 0 && changeY > 0 ) {
    		if (changeAngle > 0 ) {
    			if ((Robot.navx.getAngle() < desiredAngle) && (Math.abs(encoderToInches(leftFrontMotor.getEncPosition())) < ((2*3.14*(r)*((180-changeAngle)/360)) ) ) && (Math.abs(encoderToInches(leftFrontMotor.getEncPosition())) < ((2*3.14*(r)*((180-changeAngle)/360)) ))) {
    				
    		leftFrontMotor.set(percentageLeft/2);
    		leftBackMotor.set(percentageLeft/2);
    		rightFrontMotor.set(percentageRight/2);
    		rightBackMotor.set(percentageRight/2);
    		}
    			else if (Math.abs(Robot.navx.getAngle()) >= desiredAngle || encoderToInches(leftFrontMotor.getEncPosition()) > ((2*3.14*(r)*((180-changeAngle)/360)))) {
    				leftFrontMotor.set(0);
    				leftBackMotor.set(0);
    				rightFrontMotor.set(0);
    				rightBackMotor.set(0);
    			}
    		}
    	}
 
    	
    	
    	
    	
    }
    public void resetEncoderPosition() {
    	
    	leftFrontMotor.setEncPosition(0);
    	rightBackMotor.setEncPosition(0);
    }
    public boolean driveForward(double ds) {
    	leftFrontMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightBackMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
  
    	double diameter = 4;
    	double circumference = diameter;
    	double distance = ds;
    	double lBMP = leftFrontMotor.getEncPosition();
    	double rBMP = rightBackMotor.getEncPosition();
    	double distanceDrivenRight = ((rBMP/1024)*circumference);
    	double distanceDrivenLeft =((lBMP/1024)*circumference);
    	double avgDistanceDriven = ((distanceDrivenRight + distanceDrivenLeft)/2);
    
    	SmartDashboard.putNumber("Auto Left Driven", distanceDrivenLeft);
    	SmartDashboard.putNumber("Auto Right Driven", distanceDrivenRight);
    	
    	
        //Are we there yet?
    	
    	if ((/* distanceDrivenRight > -distance || */ distanceDrivenLeft > -distance) && distance > 0 ) {
    		/*if (Math.abs(distanceDrivenRight )> Math.abs(distanceDrivenLeft)) {
    			leftSpeed = leftSpeed + 0.0075;
    		}
    		else if (Math.abs(distanceDrivenLeft) > Math.abs(distanceDrivenRight) ) {
    			leftSpeed= leftSpeed - 0.0025;
    		}*/
    		leftFrontMotor.set(-leftSpeed);
    		rightBackMotor.set(rightSpeed);
    		leftBackMotor.set(-leftSpeed);
    		rightFrontMotor.set(rightSpeed);
    		return false;

    	}
    	else if (Math.abs(distanceDrivenLeft) <  Math.abs(distance) && distance < 0) {
    		/*if (Math.abs(distanceDrivenRight )> Math.abs(distanceDrivenLeft)) {
    			leftSpeed = leftSpeed + 0.0035;
    			return false;
    		}
    		else if (Math.abs(distanceDrivenLeft) > Math.abs(distanceDrivenRight) ) {
    			leftSpeed= leftSpeed - 0.0035;
    		}*/
    		leftFrontMotor.set(leftSpeed);
    		rightBackMotor.set(-rightSpeed);
    		leftBackMotor.set(leftSpeed);
    		rightFrontMotor.set(-rightSpeed);

    		return false;
    		
    	}
    	else  {
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightBackMotor.set(0);
    		rightFrontMotor.set(0);
    		return true;
    	}

    }
}


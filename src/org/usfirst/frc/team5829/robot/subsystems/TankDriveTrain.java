
package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.TankDrive;
import org.usfirst.frc.team5829.robot.commands.chesyDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

import com.kauailabs.navx.frc.*;

import com.ctre.*;

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
    
    public void ChesyDrive(double straight, double rotate){
    	leftFrontMotor.set(straight + rotate);
        leftBackMotor.set(straight + rotate);
        rightFrontMotor.set(straight - rotate);
        rightBackMotor.set(straight - rotate);
    }
    public void turnDegrees(double dg) {
    	double yaw = Robot.navx.getYaw();
    //if (dg > 0) {	
    	
    	double difference = Math.abs(yaw - dg);
    	double motorSpeed = .25;
    	//double motorSpeed = ((difference/dg));
    	if (Robot.navx.getYaw() < (dg+2.5)) {
    		
    		leftFrontMotor.set(-motorSpeed);
    		leftBackMotor.set(-motorSpeed);
    		rightBackMotor.set(-motorSpeed);
    		rightFrontMotor.set(-motorSpeed);
    		Timer.delay(.1);
    		turnDegrees(dg);
    	}
    	else if (Robot.navx.getYaw() > (dg-2.5)) {
    		leftFrontMotor.set(motorSpeed);
    		leftBackMotor.set(motorSpeed);
    		rightFrontMotor.set(motorSpeed);
    		rightBackMotor.set(motorSpeed);
    		Timer.delay(.1);
    		turnDegrees(dg);
    	}
    	else if (Robot.navx.getYaw() < (dg+.025) && Robot.navx.getYaw() > (dg-.025)) {
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightBackMotor.set(0);
    		rightFrontMotor.set(0);
    	}
   // }
    /*
    else if (dg <0) {
    	double difference = Math.abs(yaw + dg);
    	double motorSpeed = 0.25;
    	//double motorSpeed = ((difference/dg));
    	if (Robot.navx.getYaw() < (dg-0.25)) {
    		
    		leftFrontMotor.set(motorSpeed);
    		leftBackMotor.set(motorSpeed);
    		rightBackMotor.set(motorSpeed);
    		rightFrontMotor.set(motorSpeed);
    	}
    	else if (Robot.navx.getYaw() > (dg+0.25)) {
    		leftFrontMotor.set(-motorSpeed);
    		leftBackMotor.set(-motorSpeed);
    		rightFrontMotor.set(-motorSpeed);
    		rightBackMotor.set(-motorSpeed);
    	}
    	else if (Robot.navx.getYaw() < (dg-.25) && Robot.navx.getYaw() > (dg+.25)) {
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightBackMotor.set(0);
    		rightFrontMotor.set(0);
    	}
    	
    }
    */
    }
    public void driveForward(double ds) {
        double dx = Robot.navx.getDisplacementX();
        double dy = Robot.navx.getDisplacementY();
        double tDisplacement;
        double dt = (dx*dx) + (dy*dy);
        tDisplacement = Math.sqrt(dt);
        //Are we there yet?
    	
    	if (tDisplacement < ds) {
    		leftFrontMotor.set(-.25);
    		leftBackMotor.set(-.25);
    		rightBackMotor.set(.25);
    		rightFrontMotor.set(.25);
    		Timer.delay(.10);
    		driveForward(ds);
    	}
    	else {
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightBackMotor.set(0);
    		rightFrontMotor.set(0);
    	}

    }
}


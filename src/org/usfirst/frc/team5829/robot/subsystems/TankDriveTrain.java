
package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

import com.ctre.*;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveTrain extends Subsystem {
	CANTalon leftFrontMotor = new CANTalon(RobotMap.leftFrontMotor);
	CANTalon leftBackMotor = new CANTalon(RobotMap.leftBackMotor);
	CANTalon rightFrontMotor = new CANTalon(RobotMap.rightFrontMotor);
	CANTalon rightBackMotor = new CANTalon(RobotMap.rightBackMotor);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new TankDrive());
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
       //tank drive
        leftFrontMotor.set(leftSpeed);
        leftBackMotor.set(leftSpeed);
        rightFrontMotor.set(rightSpeed);
        rightBackMotor.set(rightSpeed);
        
        
    	
    }
    
}


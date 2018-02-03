package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.HangerOff;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

// FIX FOR COMP BOT!!!!

public class Hanger extends Subsystem {
	CANTalon hangerMotorOne = new CANTalon(RobotMap.hangerMotorOne);
	CANTalon hangerMotorTwo = new CANTalon(RobotMap.hangerMotorTwo);
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HangerOff());
    }
    public void hangerIdle(double motorSpeed) {
    	hangerMotorOne.set(motorSpeed);
    	hangerMotorTwo.set(-motorSpeed);
    	
    }
    public void hangerOn(double direction) {
    	//hangerMotorOne.set(.85);
    	if (direction == 1) {
    	hangerMotorTwo.set(-.85);
    	hangerMotorOne.set(.85);
    	}
    	else if (direction == 2) {
    		hangerMotorTwo.set(.85);
    		hangerMotorOne.set(-85);
    	}
    	
    }
    public void hangerOff() {
    	hangerMotorOne.set(0);
    	hangerMotorTwo.set(0);
    	
    }
}


package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.HighGear;
import org.usfirst.frc.team5829.robot.commands.LowGear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveShifter extends Subsystem {
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.shiftHigh, RobotMap.shiftLow);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new LowGear());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lowGear(){
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void highGear(){
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}


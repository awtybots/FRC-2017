package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.GearIntakeOff;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	
	public CANTalon gearIntake = new CANTalon(RobotMap.gearIntake);
	public CANTalon gearLifter1 = new CANTalon(RobotMap.gearIntakeLifterOne);
	public CANTalon gearLifter2 = new CANTalon(RobotMap.gearIntakeLifterTwo);


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GearIntakeOff());
    }
    
    public void gearIntake(){

    	gearIntake.set(.85);
    }
    public void gearEncoderReset() {
    	gearLifter1.setEncPosition(0);
    }
    public void gearIntakeOff(){
    	gearIntake.set(0);
    	gearLifter1.set(0);
    	gearLifter2.set(0);
    }
    
    public void gearOutake(){
    	gearIntake.set(-.85);
    }
   public void gearLiftUpOverride() {
    	gearLifter1.set(-.3);
    	gearLifter2.set(.3);
    }
   public void gearLiftDownOverride() {
	   gearLifter1.set(.3);
	   gearLifter2.set(-.3);
   }
    public void gearLiftUp(){
    	gearLifter1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
    	// Flush = 0, all the way down is 175497.0 without division
    	// Flush = 0, all the way down is 1754.970 with division
    	if (gearLifter2.getEncPosition() > -500) {
    		gearLifter1.set(0);
    		gearLifter2.set(0);
    	}
    	else {
        	gearLifter1.set(-.4);
        	gearLifter2.set(.4);
    	}
    	//2222222222222gearLifter1.set(.5);
    	//gearLifter2.set(-.5);
    }
    public boolean gearLiftDownLength(double length) {
    	if (gearLifter2.getEncPosition() > length) {
    		gearLifter1.set(.4);
    		gearLifter2.set(-.4);
    		return false;
    	}
    	else {
    		gearLifter1.set(0);
    		gearLifter2.set(0);
    		return true;
    	}
    }
    public boolean gearLiftUpLength(double length) {
    	if (gearLifter1.getEncPosition() > length) {
    		gearLifter1.set(-.4);
    		gearLifter2.set(.4);
    		return false;
    	}
    	else {
    		gearLifter1.set(0);
    		gearLifter2.set(0);
    		return true;
    	}
    }
    public void gearLiftDown(){
    	/*gearIntake.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
    	if (gearIntake.getEncPosition() < 0) {
    	gearIn	take.set(.75);
    	}
    	else if (gearIntake.getEncPosition() > 0) {
    		gearIntake.set(0);
    	}*/
    	gearLifter1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
    	gearLifter1.setVoltageRampRate(.2);
    	gearLifter2.setVoltageRampRate(.2);
    	// Flush = 0, all the way down is 175497.0 without division
    	// Flush = 0, all the way down is 1754.970 with division
    
    	/*if (gearLifter1.getEncPosition() > 2100)
    	{
    		gearLifter1.set(-.1);
    		gearLifter2.set(.1);
    		
    	}
    	*/
    	
    	if (gearLifter2.getEncPosition() < -1750 && gearLifter2.getEncPosition() > -2650 ) {
    		gearLifter1.set(.3);
    		gearLifter2.set(-.3);
    		gearOutake();
    		
    	}
    	else if (gearLifter2.getEncPosition() < -800 && gearLifter2.getEncPosition()> -1700){
    		gearLifter1.set(.4);
    		gearLifter2.set(-.4);
    		gearOutake();
    	}

    	else if (gearLifter2.getEncPosition() > -800) {
        	gearLifter1.set(.5);
        	gearLifter2.set(-.5);
    	}
    	else {
    		gearLifter1.set(0);
    		gearLifter2.set(0);
    	} 
    	//gearLifter1.set(-.5);
    	//gearLifter2.set(.5);
    	

    }
}


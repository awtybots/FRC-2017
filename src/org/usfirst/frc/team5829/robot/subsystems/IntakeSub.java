package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.Intake;
import org.usfirst.frc.team5829.robot.commands.IntakeOff;

import com.ctre.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSub extends Subsystem {
	
	CANTalon intakeMotor = new CANTalon(RobotMap.intakeMotor);
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeOff());
    }
    
   public void intake() {
	   intakeMotor.set(.5);
	   
	   
   }
   public void intakeReverse() {
	   intakeMotor.set(-.5);
   }
   public void intakeOff() {
	   intakeMotor.set(0);
   }
   
}


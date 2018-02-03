package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.IntakeFlapClose;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeFlap extends Subsystem {
	
	//DoubleSolenoid intakeFlap = new DoubleSolenoid(RobotMap.intakeFlapOpen, RobotMap.intakeFlapClose);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeFlapClose());
    }
  

   /* public void flapOpen(){
    	intakeFlap.set(DoubleSolenoid.Value.kForward);
    }
    
    public void flapClose(){
    	intakeFlap.set(DoubleSolenoid.Value.kReverse);
    }*/
}


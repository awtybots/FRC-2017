package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.GearPunchClose;
import org.usfirst.frc.team5829.robot.commands.GearPunchOpen;
import org.usfirst.frc.team5829.robot.commands.IntakeFlapClose;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPuncher extends Subsystem {

	//DoubleSolenoid gearPunch = new DoubleSolenoid(RobotMap.gearPunchOpen, RobotMap.gearPunchClose);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GearPunchOpen());
    }
  

  /*  public void punchOpen(){
    	gearPunch.set(DoubleSolenoid.Value.kForward);
    }
    
    public void punchClose(){
    	gearPunch.set(DoubleSolenoid.Value.kReverse);
    }*/
}


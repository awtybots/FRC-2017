package org.usfirst.frc.team5829.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	public void initDefaultCommand(){
		
	}
	
	public Compressor cmp;
	public AnalogInput pressure;
	
	public Pneumatics(){
		cmp = new Compressor(30);
		cmp.setClosedLoopControl(true);
	}
	
	public void enableCompressor(){
		cmp.setClosedLoopControl(true);
		cmp.start();
	}
	
}
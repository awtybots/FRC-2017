package org.usfirst.frc.team5829.robot.subsystems;
import org.usfirst.frc.team5829.robot.Robot;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.Shoot;
import org.usfirst.frc.team5829.robot.commands.shooterOff;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
public class Shooter extends Subsystem {
	double p = .2;
	double i = 0;
	double d = 2;
	double f = 0.0;
	public CANTalon shooterMotorOne = new CANTalon(RobotMap.shooterMotorOne);
	public CANTalon shooterMotorTwo = new CANTalon(RobotMap.shooterMotorTwo);
	public CANTalon shooterIntakeMotor = new CANTalon(RobotMap.shooterIntakeMotor);
	public CANTalon hopperMotor = new CANTalon(RobotMap.intakeMotor);
	
	// FIX FOR COMP BOT!!!!
	public void updateDashboard()
	{

		
		
		}

	protected void initDefaultCommand() {
		
		setDefaultCommand (new shooterOff());
		setDefaultCommand (new org.usfirst.frc.team5829.robot.commands.shooterIntakeOff());
		
	}
	public void shootOff() {
		shooterMotorTwo.setP(0);
		shooterMotorTwo.setI(0);
		shooterMotorTwo.setD(0);
		shooterMotorTwo.setF(0);
		shooterMotorOne.set(0);
		shooterMotorTwo.set(0);
	}
	public void shoot(double speed) {


	shooterMotorOne.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
	shooterMotorTwo.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	
	
	shooterMotorTwo.reverseSensor(true);
	
	
	shooterMotorTwo.changeControlMode(TalonControlMode.Speed); 
	Robot.shooter.shooterMotorTwo.setP(p);
	Robot.shooter.shooterMotorTwo.setI(i);
	Robot.shooter.shooterMotorTwo.setD(d);
	Robot.shooter.shooterMotorTwo.setF(f);
	
	shooterMotorTwo.setVoltageRampRate(.5);
	shooterMotorOne.setVoltageRampRate(.5);
	//hopperMotor.set(.5);
	shooterMotorTwo.set(speed);
	double motorOutput = Robot.shooter.shooterMotorTwo.getOutputVoltage() / Robot.shooter.shooterMotorTwo.getBusVoltage();
	double speed2 = shooterMotorTwo.getSpeed();
	shooterMotorOne.set(motorOutput);
	//shooterMotorTwo.set(-1);
	//shooterMotorOne.set(-1);
	//hopperMotor.setVoltageRampRate(1.5);
	//hopperMotor.set(-.7);
	//shooterIntakeMotor.set(-.8);
	//d = d + 0.05;
	
	
	
	}
	public void shooterIntakeOn() {
		
		shooterIntakeMotor.set(-.8);
		hopperMotor.set(-.7);
	}
	public void shooterIntakeOff() {
		//shooterIntakeMotor.setVoltageRampRate(2);
		shooterIntakeMotor.set(0);
		hopperMotor.set(0);
	}
}

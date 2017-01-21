package org.usfirst.frc.team5829.robot.subsystems;
import org.usfirst.frc.team5829.robot.Robot;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.Shoot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
public class Shooter extends Subsystem {
	//Emilien is dumb
	double p = 4.5;
	double i = 0;
	double d = 2.7;
	double f = 0.0;
	public CANTalon shooterMotorOne = new CANTalon(RobotMap.shooterMotorOne);
	CANTalon shooterMotorTwo = new CANTalon(RobotMap.shooterMotorTwo);
	CANTalon shooterMotorThree = new CANTalon(RobotMap.shooterMotorThree);
	CANTalon shooterMotorFour = new CANTalon(RobotMap.shooterMotorFour);
	public void updateDashboard()
	{
		double shootSpeed = shooterMotorOne.getSpeed();
		

		double motorOutput = shooterMotorOne.getOutputVoltage() / shooterMotorOne.getBusVoltage();

		SmartDashboard.putNumber("Speed",shooterMotorOne.getSpeed());
		System.out.println("ShotSpeed: " + shootSpeed);
		System.out.println("Error: " + shooterMotorOne.getClosedLoopError());
		SmartDashboard.putNumber("Error: ", shooterMotorOne.getClosedLoopError());
		SmartDashboard.putNumber("P Value: ", shooterMotorOne.getP());
		SmartDashboard.putNumber("I Value: ", shooterMotorOne.getI());
		SmartDashboard.putNumber("D Value: ", shooterMotorOne.getD());
		SmartDashboard.putNumber("F Value: ", shooterMotorOne.getF()); 
		SmartDashboard.putNumber("Motor Output :" , motorOutput);
		SmartDashboard.putNumber("Target Speed :", shooterMotorOne.getSetpoint() );
		
		}

	protected void initDefaultCommand() {
		
		setDefaultCommand (new Shoot(0));
		
	}
	public void shoot(double speed) {
	
	

	shooterMotorOne.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
	shooterMotorTwo.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	shooterMotorThree.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	shooterMotorFour.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	
	shooterMotorOne.reverseSensor(true);
	shooterMotorTwo.reverseSensor(true);
	shooterMotorThree.reverseSensor(false);
	shooterMotorFour.reverseSensor(false);
	
	shooterMotorOne.changeControlMode(TalonControlMode.Speed);
	shooterMotorTwo.changeControlMode(TalonControlMode.Speed);
	shooterMotorThree.changeControlMode(TalonControlMode.Speed);
	shooterMotorFour.changeControlMode(TalonControlMode.Speed);
	/*
	double shooterP = Robot.prefs.getDouble("shooterP", 0.3);
	double shooterI = Robot.prefs.getDouble("shooterI", 0);
	double shooterD = Robot.prefs.getDouble("shooterD", 0);
	double shooterF = Robot.prefs.getDouble("shooterF", 0);
	double prefspeed = Robot.prefs.getDouble("prefspeed", speed);
	*/

	Robot.shooter.shooterMotorOne.setP(p);
	Robot.shooter.shooterMotorOne.setI(i);
	Robot.shooter.shooterMotorOne.setD(d);
	Robot.shooter.shooterMotorOne.setF(f);

	double targetSpeed = speed;
	
	shooterMotorOne.setProfile(0);
	
	
	shooterMotorOne.configPeakOutputVoltage(+12.0f, -0.0f);
	shooterMotorOne.configNominalOutputVoltage(+0.0f, -0.0f);
	shooterMotorTwo.configPeakOutputVoltage(+12.0f, -0.0f);
	shooterMotorThree.configPeakOutputVoltage(+12.0f, -0.0f);
	shooterMotorFour.configPeakOutputVoltage(+12.0f, -0.0f);
	
	shooterMotorOne.set(speed);
	shooterMotorTwo.set(speed);
	shooterMotorThree.set(speed);
	shooterMotorFour.set(speed);
	
	
	
	
	}
}

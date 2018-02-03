<<<<<<< HEAD
package org.usfirst.frc.team5829.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static int leftFrontMotor = 3;// set to 3
    public static int rightFrontMotor = 4; // set to 4
    public static int leftBackMotor = 1; // set to 1
    public static int rightBackMotor = 2; // set to 2
    public static int shooterMotorOne = 7; //RightSide1
    public static int shooterMotorTwo = 8;  //RightSide2
    public static int intakeMotor = 13;
    public static int shooterIntakeMotor = 12;
    public static int hangerMotorOne = 9; 
    public static int hangerMotorTwo = 6;
    
    public static int gearIntake = 10; //----> fix for comp bot
    public static int gearIntakeLifterOne = 5;
    public static int gearIntakeLifterTwo = 11;
     
    public static int pneumaticOne = 0;
    public static int pneumaticTwo = 1;
    public static int pneumaticThree = 2;
    
    
    public static int shiftHigh = 5;
    public static int shiftLow = 7;
    
    public static int intakeFlapOpen = 3;
    //public static int intakeFlapClose = 4;
    
    public static int gearPunchOpen = 0;
    //public static int gearPunchClose = 6;
    
    public static int shiftHangOn = 0;
    public static int shiftHangOff = 1;
    
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
=======
package org.usfirst.frc.team5829.robot;

import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	TalonSRX frontLeftMotor = new TalonSRX(1);
	TalonSRX frontRightMotor = new TalonSRX(2);
	TalonSRX backRightMotor = new TalonSRX(3);
	TalonSRX backLeftMotor = new TalonSRX(4);
	}
>>>>>>> refs/heads/New-Robot.java

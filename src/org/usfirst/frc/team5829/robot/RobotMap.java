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
    public static int leftFrontMotor = 2;
    public static int rightFrontMotor = 1;
    public static int leftBackMotor = 4;
    public static int rightBackMotor = 3;
    public static int shooterMotorOne = 5; //RightSide1
    public static int shooterMotorTwo = 6;  //RightSide2
    public static int shooterMotorThree = 7; //LeftSide1
    public static int shooterMotorFour = 8; //LeftSide2
    public static int intakeMotor = 9;
    
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}

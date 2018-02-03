
package org.usfirst.frc.team5829.robot;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5829.robot.commands.Intake;
import org.usfirst.frc.team5829.robot.commands.TankDrive;
import org.usfirst.frc.team5829.robot.commands.autonomous90Degree;
import org.usfirst.frc.team5829.robot.commands.autonomousCurve;
import org.usfirst.frc.team5829.robot.commands.autonomousFull;
import org.usfirst.frc.team5829.robot.commands.autonomousLeftToRight;
import org.usfirst.frc.team5829.robot.commands.autonomousMiddle;
import org.usfirst.frc.team5829.robot.commands.autonomousMiddleRed;
import org.usfirst.frc.team5829.robot.commands.autonomousRightToLeft;
import org.usfirst.frc.team5829.robot.commands.driveForward;
import org.usfirst.frc.team5829.robot.commands.paulsGodDamnGearAutonomous;
import org.usfirst.frc.team5829.robot.commands.turnDegree;
import org.usfirst.frc.team5829.robot.subsystems.DriveShifter;
import org.usfirst.frc.team5829.robot.subsystems.GearIntake;
import org.usfirst.frc.team5829.robot.subsystems.GearPuncher;
import org.usfirst.frc.team5829.robot.subsystems.Hanger;
import org.usfirst.frc.team5829.robot.subsystems.IntakeFlap;
import org.usfirst.frc.team5829.robot.subsystems.IntakeSub;
import org.usfirst.frc.team5829.robot.subsystems.Pneumatics;
import org.usfirst.frc.team5829.robot.subsystems.Shooter;
import org.usfirst.frc.team5829.robot.subsystems.TankDriveTrain;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Preferences prefs;
	AHRS ahrs;
	public static final TankDriveTrain driveTrain = new TankDriveTrain();
    public static final Shooter shooter = new Shooter();
    public static final IntakeSub intakeSub = new IntakeSub();
    public static final Pneumatics pneumatics = new Pneumatics();
    public static final Hanger hanger = new Hanger();
    public static final DriveShifter driveShifter = new DriveShifter();
    public static final IntakeFlap intakeFlap = new IntakeFlap();
    public static final GearPuncher gear = new GearPuncher();
    public static final GearIntake gearIntake = new GearIntake();
    
	public static AHRS navx = new AHRS(SerialPort.Port.kMXP);
	public static OI oi;
	NetworkTable table;
	
	
    Command autonomousCommand;
    SendableChooser autoChooser;
    double boxX;
    double boxY;
    double boxA;
    double imgH;
    double imgW;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	Robot.navx.resetDisplacement();
    	UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
    	UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
    	
    	cam0.setFPS(60);
    	cam1.setFPS(60);

    	
        autoChooser = new SendableChooser();
        autoChooser.addDefault("DRIVE FORWARD FOR 5 POINTS", new driveForward(270));
        autoChooser.addObject("Blue Middle", new autonomousMiddle());
        autoChooser.addObject("Blue Right", new autonomousRightToLeft());
        autoChooser.addObject("Blue Left", new autonomousLeftToRight());
        autoChooser.addObject("Red Right",new autonomousRightToLeft());
        autoChooser.addObject("Red Left", new autonomousLeftToRight());
        autoChooser.addObject("Red Middle", new autonomousMiddleRed());
        autoChooser.addObject("backwardsssssss long run", new driveForward(-270));
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		oi = new OI();
        prefs = Preferences.getInstance();
		// instantiate the command used for the autonomous period
        autonomousCommand = new TankDrive();
     // table = NetworkTable.getTable("Vision");

       
    }
	
	public void disabledPeriodic(
			) {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	
        // schedule the autonomous command (example)
    	Robot.driveTrain.leftFrontMotor.setEncPosition(0);
    	Robot.driveTrain.rightBackMotor.setEncPosition(0);
    	Robot.navx.reset();
    	
    	Robot.navx.resetDisplacement();
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //requires();
        new autonomousFull();
                
    }


	public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.

    	Robot.driveTrain.leftFrontMotor.setEncPosition(0);
    	Robot.driveTrain.rightBackMotor.setEncPosition(0);
    	Robot.navx.reset();
    	
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        

        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	Robot.driveTrain.leftFrontMotor.setEncPosition(0);
    	Robot.driveTrain.rightBackMotor.setEncPosition(0);
    	Robot.navx.reset();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	SmartDashboard.putNumber("Gear Intake Encoder Value", Robot.gearIntake.gearLifter2.getEncPosition());
    	SmartDashboard.putNumber("Speed of Drive", Robot.driveTrain.leftFrontMotor.getEncVelocity());
		double shootSpeed = Robot.shooter.shooterMotorTwo.getSpeed();
		SmartDashboard.putNumber("yaw", Robot.navx.getYaw());
		double motorOutput = Robot.shooter.shooterMotorTwo.getOutputVoltage() / Robot.shooter.shooterMotorTwo.getBusVoltage();
		double motorOutput2 = Robot.shooter.shooterMotorOne.getOutputVoltage() / Robot.shooter.shooterMotorOne.getBusVoltage();

		SmartDashboard.putNumber("Speed", Robot.shooter.shooterMotorTwo.getSpeed());
		//System.out.println("ShotSpeed: " + shootSpeed);
		//System.out.println("Error: " + Robot.shooter.shooterMotorTwo.getClosedLoopError());
		SmartDashboard.putNumber("Error: ", Robot.shooter.shooterMotorTwo.getClosedLoopError());
		SmartDashboard.putNumber("P Value", Robot.shooter.shooterMotorTwo.getP());
		SmartDashboard.putNumber("I Value: ", Robot.shooter.shooterMotorTwo.getI());
		SmartDashboard.putNumber("D Value: ",	Robot.shooter.shooterMotorTwo.getD());
		SmartDashboard.putNumber("F Value: ", Robot.shooter.shooterMotorTwo.getF()); 
		SmartDashboard.putNumber("Motor Output :" , motorOutput);
		SmartDashboard.putNumber("Motor Output2", motorOutput2);
		
		SmartDashboard.putNumber("Target Speed :", Robot.shooter.shooterMotorTwo.getSetpoint());
		SmartDashboard.putNumber("Gear Intake Current", Robot.gearIntake.gearLifter1.getOutputCurrent());
		
		//SmartDashboard.putNumber("Speed2", Robot.shooter.shooterMotorOne.getSpeed());
		double diameter = 4;
    	double circumference = diameter;
    	double ticksRight = Robot.driveTrain.leftFrontMotor.getEncPosition();
    	double ticksLeft = Robot.driveTrain.rightBackMotor.getEncPosition();
    	double drivenRight = ((ticksRight/1024)*circumference);
    	double drivenLeft = ((ticksLeft/1024)*circumference);
    	SmartDashboard.putNumber("Driven Right", drivenRight);
    	SmartDashboard.putNumber("Driven Left", drivenLeft);
    	double avgDriven = ((Math.abs(drivenLeft) + Math.abs(drivenRight))/2);
    	SmartDashboard.putNumber("dAvg Driven", avgDriven);
    	SmartDashboard.putNumber("Angle ", Robot.navx.getAngle());
        Scheduler.getInstance().run();
       
        
       //NetworkTable server = NetworkTable.getTable("Vision");
       // System.out.println(server.getNumber("IMAGE_COUNT",0.0));
        
        //table.getNumber("COG_X",boxX);
        //table.getNumber("COG_Y",boxY);
        //table.getNumber("COG_AREA",boxA);
        //table.getNumber("IMAGE_HEIGHT",imgH);
        //table.getNumber("IMAGE_WIDTH",imgW);
        //System.out.println(boxX);
        //System.out.println(boxY);
        //System.out.println(boxA);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

	
}

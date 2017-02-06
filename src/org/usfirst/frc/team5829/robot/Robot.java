
package org.usfirst.frc.team5829.robot;
import com.kauailabs.navx.frc.AHRS;
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
import org.usfirst.frc.team5829.robot.commands.driveForward;
import org.usfirst.frc.team5829.robot.commands.paulsGodDamnGearAutonomous;
import org.usfirst.frc.team5829.robot.commands.turnDegree;
import org.usfirst.frc.team5829.robot.subsystems.IntakeSub;
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
    	
    	
		oi = new OI();
        prefs = Preferences.getInstance();
		// instantiate the command used for the autonomous period
        autonomousCommand = new TankDrive();
     // table = NetworkTable.getTable("Vision");
       autoChooser = new SendableChooser();
       autoChooser.addDefault("Drive Forward", new driveForward(.5));
       autoChooser.addObject("90 Degrees", new  turnDegree(90));
       autoChooser.addObject("Paul's God damn gear autonomous", new paulsGodDamnGearAutonomous());
       SmartDashboard.putData("Autonomous mode chooser", autoChooser);
       
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        

        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	SmartDashboard.putNumber("displacement X", Robot.navx.getDisplacementX());
    	SmartDashboard.putNumber("Displacement Y", Robot.navx.getDisplacementY());
		double shootSpeed = Robot.shooter.shooterMotorTwo.getSpeed();
		SmartDashboard.putNumber("yaw", Robot.navx.getYaw());
	    double dx = Robot.navx.getDisplacementX();
	    double dy = Robot.navx.getDisplacementY();
	    double td = Math.sqrt((dx*dx) + (dy*dy));
	    SmartDashboard.putNumber("Displacement", td);
		//SmartDashboard.putNumber("Displacement Z?", Robot.navx.getDisplacementZ());

		double motorOutput = Robot.shooter.shooterMotorTwo.getOutputVoltage() / Robot.shooter.shooterMotorTwo.getBusVoltage();
		
		
		SmartDashboard.putNumber("Speed", Robot.shooter.shooterMotorTwo.getSpeed());
		System.out.println("ShotSpeed: " + shootSpeed);
		System.out.println("Error: " + Robot.shooter.shooterMotorTwo.getClosedLoopError());
		SmartDashboard.putNumber("Error: ", Robot.shooter.shooterMotorTwo.getClosedLoopError());
		
		SmartDashboard.putNumber("I Value: ", Robot.shooter.shooterMotorTwo.getI());
		SmartDashboard.putNumber("D Value: ",	Robot.shooter.shooterMotorTwo.getD());
		SmartDashboard.putNumber("F Value: ", Robot.shooter.shooterMotorTwo.getF()); 
		SmartDashboard.putNumber("Motor Output :" , motorOutput);
		SmartDashboard.putNumber("Target Speed :", Robot.shooter.shooterMotorTwo.getSetpoint());
		SmartDashboard.putNumber("Speed2", Robot.shooter.shooterMotorOne.getSpeed());
    	
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

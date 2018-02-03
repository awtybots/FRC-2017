<<<<<<< HEAD
package org.usfirst.frc.team5829.robot;
import org.usfirst.frc.team5829.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick xbox = new Joystick(0);
	public Joystick xbox2 = new Joystick(1);
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	Button btnA = new JoystickButton(xbox, 1);
	Button btnB = new JoystickButton(xbox, 2);
	Button btnX 
	= new JoystickButton(xbox, 3);
	Button btnR1 = new JoystickButton(xbox, 6);
	Button btnY = new JoystickButton(xbox,4);
	Button btnL1 = new JoystickButton(xbox, 5);
	Button btnS = new JoystickButton(xbox, 8);
	Button btnM = new JoystickButton(xbox, 7);
	Button btnW = new JoystickButton(xbox, 9);
	Button btnA2 = new JoystickButton(xbox2, 1);
	Button btnB2 = new JoystickButton(xbox2, 2);
	Button btnX2 = new JoystickButton(xbox2, 3);
	Button btnRB = new JoystickButton(xbox2, 6);
	Button btnY2 = new JoystickButton(xbox2,4);
	Button btnLB = new JoystickButton(xbox2, 5);
	Button btnS2 = new JoystickButton(xbox2, 8);
	Button btnM2 = new JoystickButton(xbox2, 7);
	Button btnW2 = new JoystickButton(xbox2, 9);
	public double getRawAnalogStickALX() {
		return xbox.getRawAxis(0);
	}

	public double getRawAnalogStickALY() {
		return xbox.getRawAxis(1);
	}

	public double getRawAnalogStickARX() {
		return xbox.getRawAxis(4);
	}

	public double getRawAnalogStickARY() {
		return xbox.getRawAxis(5);
	}
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
     
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
   
   
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public OI(){
		   // btnA.toggleWhenPressed(new shooterIntakeOn());
			btnX2.toggleWhenPressed(new Shoot(-3500));
		    //btnS.toggleWhenPressed(new IntakeFlapOpen());
		    
		    //btnS.whenPressed(new driveForward(60));
		    //btnS.whenPressed(new autonomousCurve(108,120,45));
		    //btnS.whenPressed(new autonomousCurve(16.5,120,180
		    //btnS.whenPressed(new autonomousCurve(10,10,90));
		    //btnS.toggleWhenPressed(new solenoidActivation(2,1));
		    //btnS2.toggleWhenPressed(new ());
		   //
		   // btnB2.toggleWhenPressed(new intakeReverse());
		   // btnY.whileHeld(new GearOutake());
		    btnB.whileHeld(new GearIntakeOn());
		    
		   // btnB.whileHeld(new GearIntakeOff());
		  btnY.whileHeld(new GearOutake());
		    btnB2.toggleWhenPressed(new Shoot(-5000));
		    btnA.whenPressed(new shooterOff());
		   btnLB.whenPressed(new hangerOn(1));
		   btnLB.whenReleased(new HangerOff());
		   btnRB.whenPressed(new hangerIdle(.95));
		   btnRB.whenReleased(new HangerOff());
		   btnS2.whenPressed(new shooterOff());
		  btnA2.toggleWhenPressed(new shooterIntakeOn());
		  btnY2.toggleWhenPressed(new shooterIntakeOff());
		   // btnA2.whileHeld(new gearLifterUpOverride());
		   //btnY2.whileHeld(new gearLifterDownOverride());
		   //btnX2.whenPressed(new resetEncoderPosition());
		   //btnRB.whenPressed(new hangerOn(2));
		   //btnRB.whenReleased(new HangerOff());
		    
		    btnL1.whileHeld(new GearLifterUp());
		    btnR1.whileHeld(new GearLifterDown());
		     	
		    	
		    

		    
		
	}
}


=======
package org.usfirst.frc.team5829.robot;

//import org.usfirst.frc.team5829.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import org.usfirst.frc.team5829.robot.commands.AutonAutoShoot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick xbox = new Joystick(0);
	public Joystick xbox2 = new Joystick(1);
	Button btnA = new JoystickButton(xbox, 1);
	Button btnB = new JoystickButton(xbox, 2);
	Button btnX = new JoystickButton(xbox, 3);
	Button btnY = new JoystickButton(xbox, 4);
	Button btnL1 = new JoystickButton(xbox, 5);
	Button btnR1 = new JoystickButton(xbox, 6);
	Button btnBack = new JoystickButton(xbox, 7);
	Button btnStart = new JoystickButton(xbox, 8);
	Button btnL3 = new JoystickButton(xbox, 9);
	Button btnR3 = new JoystickButton(xbox, 10);
	
	//2nd Controller for shooting
	Button btn2A = new JoystickButton(xbox2, 1);
	Button btn2B = new JoystickButton(xbox2, 2);
	Button btn2X = new JoystickButton(xbox2, 3);
	Button btn2Y = new JoystickButton(xbox2, 4);
	Button btn2L1 = new JoystickButton(xbox2, 5);
	Button btn2R1 = new JoystickButton(xbox2, 6);
	Button btn2Back = new JoystickButton(xbox2, 7);
	Button btn2Start = new JoystickButton(xbox2, 8);
	Button btn2L3 = new JoystickButton(xbox2, 9);
	Button btn2R3 = new JoystickButton(xbox2, 10);
	
	public OI(){

		/*btnX.toggleWhenPressed(new JSCheesyDrive());
		btnX.toggleWhenPressed(new FlippedJSCheesyDrive());
		
		btnY.whileHeld(new Shoot(200));
		btn2Y.whileHeld(new Shoot(200));
		
		btnA.whileHeld(new Shoot(100));
		btn2A.whileHeld(new Shoot(100));
		
		btnL1.whileHeld(new Intake(1));
		btnR1.whileHeld(new Intake(-1));
		
		btn2L1.whileHeld(new Intake(1));
		btn2R1.whileHeld(new Intake(-1));
		
		btnB.whenPressed(new HorizontalAngle());
		
		btnL3.whileHeld(new ShifterLowGear());
		
		btnStart.whileHeld(new ExtendTapeMeasure(-1));
		btnBack.whileHeld(new ExtendTapeMeasure(11));
		btnBack.whileHeld(new WinchReel(1));
		
		btn2Start.whileHeld(new ExtendTapeMeasure(-1));
		btn2Back.whileHeld(new ExtendTapeMeasure(11));
		btn2Back.whileHeld(new WinchReel(1));
*/
			
	}
}

/*Xbox Mapping/Indexing:
 * 
 * Input	

Button Name		Mapped Button Number	
A Button			1		
B Button			2		
X Button			3		
Y Button			4	
Left Bumper			5	
Right Bumper		6
Back Button			7
Start Button		8	
Left Stick Click	9
Right Stick Click	10	
D-Pad Up			Treats like a Joystick
D-Pad Down			Treats like a Joystick
D-Pad Left			Treats like a Joystick
D-Pad Right			Treats like a Joystick
Xbox Button		
 */

// Left/Right on D-Pad Joystick Axis, Axis 6
// Up/Down on D-Pad Joystick Axis, Axis 7
// Adress D-Pad as Joystick Axis,
>>>>>>> refs/heads/New-Robot.java

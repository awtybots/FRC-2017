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



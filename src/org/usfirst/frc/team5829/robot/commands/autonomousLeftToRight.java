package org.usfirst.frc.team5829.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autonomousLeftToRight extends CommandGroup {

    public autonomousLeftToRight() {
    	/*addSequential(new driveForward(94));
    	addSequential(new turnDegree(-57.5));
    	addSequential(new driveForward(50)); 
    	Works right side to left
    	*/
    	//Real Ones
    	//addSequential(new driveForward(94));
    	//addSequential(new turnDegree(57.5));
    	addSequential(new gearLifterLengthDown(-10));
    	addSequential(new driveForward(97));
    	
    	addSequential(new turnDegree(36));
    	addSequential(new driveForward(52.5));
    	addSequential(new gearLifterLengthDown(-1500));
    	addSequential(new driveForward(-15));
    	addSequential(new turnDegree(120));
    	addSequential(new shootAndIntake());
    	
    	
    	
    	//addSequential(new turnDegree(57.5));
        // Add Commands here: 
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 reqires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

package org.usfirst.frc.team5829.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autonomousRightToLeft extends CommandGroup {

    public autonomousRightToLeft() {
    	addSequential(new driveForward(97));
    	addSequential(new gearLifterLengthDown(-100));
    	addSequential(new turnDegree(-37));
    	addSequential(new driveForward(22.5)); 
    	addSequential(new gearLifterLengthDown(-1500));
    	addSequential(new driveForward(-10));
    	addSequential(new turnDegree(-200));
    	//addSequential(new shootAndIntake());
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
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class encoderCommand extends CommandBase {
  /** Creates a new encoderCommand. */

double leftCount, rightCount;

  public encoderCommand(double leftEncoderCount, double rightEncoderCount) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mEncoderSub);
    leftCount = leftEncoderCount * 2048;
    rightCount = rightEncoderCount *2048;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

leftCount += RobotContainer.mEncoderSub.getLeftEncoderCount();
rightCount += RobotContainer.mEncoderSub.getRightEncoderCount();

RobotContainer.mEncoderSub.setEncoderTarget(leftCount, rightCount);


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println("Encoder Count: "+leftCount);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.mEncoderSub.resetTicks();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    
    return RobotContainer.mEncoderSub.onTarget();
  }
}

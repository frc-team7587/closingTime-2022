/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

public class ArmDown extends CommandBase {

  private Arm m_arm;
  private int count;

  public ArmDown(Arm subsystem) {
    addRequirements(subsystem);
    m_arm = subsystem;
  }

  @Override
  public void initialize() {
    // m_arm.setSoftLimits();
    System.out.println(" ++++++ ARM UP INITIALIZED ....");
    
  }

  @Override
  public void execute() {
    if(++count>25){
      System.out.println(" armDown, encoder: " + m_arm.getEncoder().getPosition());
      count=0;
    }
    m_arm.lower();
    // m_arm.lowerTo(5);

  }

  // public void lowerTo(double rotations){
  //   m_arm.lowerTo(rotations);
  // }

  @Override
  public void end(boolean interrupted) {
    m_arm.stop();
    System.out.println("down---Stopped " + interrupted);
    // m_arm.reset();
  }
  
}

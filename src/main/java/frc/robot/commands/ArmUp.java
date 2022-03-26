/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

public class ArmUp extends CommandBase {
  
  private Arm m_arm;
  private int count;

  public ArmUp(Arm subsystem) {
    addRequirements(subsystem);
    m_arm = subsystem;
  }

  @Override
  public void initialize() {
    System.out.println(" ++++++ ARM UP INITIALIZED ....");

    
  }

  @Override
  public void execute() {
    if(++count>25){
      System.out.println(" armUP, encoder: " + m_arm.getEncoder().getPosition());
      count=0;
    }
    
    m_arm.raise();
    // m_arm.raiseTo(5);
  }

  // public void raiseTo(double rotations){
  //   m_arm.raiseTo(rotations);
  // }



  @Override
  public void end(boolean interrupted) {
    System.out.println("up ---Stopped " + interrupted);  
    m_arm.stop();
  }

}

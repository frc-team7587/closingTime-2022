/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

public class ArmDown extends WaitUntilCommand {
  private Arm m_arm;

  public ArmDown(Arm subsystem, BooleanSupplier btnState) {
    super(btnState);
    addRequirements(subsystem);
    m_arm = subsystem;
  }

  @Override
  public void initialize() {
    // m_arm.reset();
    
  }

  @Override
  public void execute() {
    System.out.println("armDown....");
    m_arm.lower();
  }

  @Override
  public void end(boolean interrupted) {
    m_arm.stop();
    // m_arm.reset();
  }
  
}

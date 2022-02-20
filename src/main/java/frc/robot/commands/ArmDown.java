package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

public class ArmDown extends WaitUntilCommand {
  private Arm m_arm;
  private int count;

  public ArmDown(Arm subsystem, BooleanSupplier btnState) {
    super(btnState);
    addRequirements(subsystem);
    m_arm = subsystem;
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    if(++count > 25){
      System.out.println("armDown....");
      count=0;
    }
    
    m_arm.lower();
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("armDown stopped");
    m_arm.stop();
  }
  
}

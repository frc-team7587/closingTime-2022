package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.subsystems.IntakeMouth;

public class CargoIn extends WaitUntilCommand{

    private IntakeMouth intake;

    public CargoIn(IntakeMouth intake, BooleanSupplier btnPress){
        super(btnPress);
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
      // m_arm.reset();
      
    }
  
    @Override
    public void execute() {
      System.out.println("cargo In....");
      intake.takeIn();
    }
  
    @Override
    public void end(boolean interrupted) {
  
      intake.stop();
      System.out.println(" cargoIN ---Stopped ");  }
  
  
}

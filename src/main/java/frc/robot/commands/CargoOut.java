package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.subsystems.IntakeMouth;


public class CargoOut extends WaitUntilCommand {

    private IntakeMouth intake;

    public CargoOut(IntakeMouth intake, BooleanSupplier btnPress){
        super(btnPress);
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
      
    }
  
    @Override
    public void execute() {
      System.out.println("cargo Out....");
      intake.spitOut();
    }
    
  
    @Override
    public void end(boolean interrupted) {
  
      intake.stop();
      System.out.println(" cargoOUt ---Stopped ");  }
  
   
}

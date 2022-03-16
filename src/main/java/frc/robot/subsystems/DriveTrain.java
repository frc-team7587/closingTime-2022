/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  PWMTalonSRX talon1 = new PWMTalonSRX(0);
  PWMTalonSRX talon2 = new PWMTalonSRX(1);
  DifferentialDrive m_drive = new DifferentialDrive(talon1, talon2);

  public DriveTrain(){
    this.talon1.setInverted(true);
  }

  public void drive(double leftSpeed, double rightSpeed) {
		this.m_drive.tankDrive(leftSpeed, rightSpeed);
	}

	public void drive(double leftSpeed, double rightSpeed, boolean squareInputs) {
		this.m_drive.tankDrive(leftSpeed, rightSpeed, squareInputs);
	}

  public void stop() {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public void setDefaultCommand(Command defaultCommand) {
    super.setDefaultCommand(defaultCommand);
  }

  @Override
  public void periodic() {
    
  }
}

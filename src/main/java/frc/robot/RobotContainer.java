package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;

public class RobotContainer {

    private final DriveTrain m_drive = new DriveTrain();
    private final Arm m_arm = new Arm();
    private final Intake m_intake = new Intake();

    // experiment: PID controlled Arm system
    private final ArmSubsystem m_robotArm = new ArmSubsystem();
    
    final XboxController xbox = new XboxController(XBOX_CTRL_PORT);
    final Joystick logi = new Joystick(LOGIJOY_PORT);

    public RobotContainer() {

        configureButtonBindings();

        m_drive.setDefaultCommand(
            new RunCommand(
                () -> m_drive.drive(
                    DRIVE_SPEED_MULTIPLIER * logi.getY() * logi.getThrottle(),
                    DRIVE_SPEED_MULTIPLIER * 0.75 * -logi.getTwist() * Math.abs(logi.getThrottle())
                    ),
                m_drive)
            );  
        
        m_arm.reset();

    }

    private void configureButtonBindings() {

        // Intake 
        final JoystickButton btnIn = new JoystickButton(xbox, Button.kLeftBumper.value);  // bumper left
            btnIn.whenPressed( new IntakeIn(m_intake, () -> !btnIn.get()) );

        final JoystickButton btnOut = new JoystickButton(xbox, Button.kRightBumper.value);  // bumper right
            btnIn.whenPressed( new IntakeIn(m_intake, () -> !btnOut.get()) );

        // Arm
       final JoystickButton btnArmDown = new JoystickButton(xbox, Button.kY.value); // Y button
           btnArmDown.whenPressed( new ArmDown(m_arm, () -> !btnArmDown.get()) );

       final JoystickButton btnArmUp = new JoystickButton(xbox, Button.kB.value);   // B button
           btnArmUp.whenPressed( new ArmUp(m_arm, () -> !btnArmUp.get()) );

        configurePIDControlledArmSystem();

    }

    private void configurePIDControlledArmSystem(){
        new JoystickButton(xbox, Button.kA.value)      // A button
        .whenPressed(
            () -> {
              m_robotArm.setGoal(2);
              m_robotArm.enable();
            },
            m_robotArm);

    // Move the arm to neutral position when the 'X' button is pressed.
    new JoystickButton(xbox, Button.kX.value)       // X button
        .whenPressed(
            () -> {
              m_robotArm.setGoal(Constants.ArmConstants.kArmOffsetRads);
              m_robotArm.enable();
            },
            m_robotArm);

    // Disable the arm controller when Back is pressed
    new JoystickButton(xbox, Button.kBack.value)
            .whenPressed(m_robotArm::disable);
    }

   /**
   * Disables all ProfiledPIDSubsystem and PIDSubsystem instances. This should be called on robot
   * disable to prevent integral windup.
   */
  public void disablePIDSubsystems() {
    m_robotArm.disable();
  }

    public Command getAutonomousCommand() {
        return null;
    }
}

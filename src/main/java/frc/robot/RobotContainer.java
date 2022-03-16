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
    
   // final XboxController xbox = new XboxController(XBOX_CTRL_PORT);
    final Joystick logi = new Joystick(LOGIJOY_PORT);
    final XboxController xbox = new XboxController(XBOX_CTRL_PORT);

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
        final JoystickButton btnIn = new JoystickButton(xbox, Button.kLeftBumper.value);
            btnIn.whenPressed( new IntakeIn(m_intake, () -> !btnIn.get()) );

        final JoystickButton btnOut = new JoystickButton(xbox, Button.kRightBumper.value);
            btnIn.whenPressed( new IntakeIn(m_intake, () -> !btnOut.get()) );

        // Arm
       final JoystickButton btnArmDown = new JoystickButton(xbox, Button.kY.value); // Y button
           btnArmDown.whenPressed( new ArmDown(m_arm, () -> !btnArmDown.get()) );

       final JoystickButton btnArmUp = new JoystickButton(xbox, Button.kB.value);   // B button
           btnArmUp.whenPressed( new ArmUp(m_arm, () -> !btnArmUp.get()) );

    }

    public Command getAutonomousCommand() {
        return null;
    }
}

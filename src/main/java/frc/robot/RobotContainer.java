package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
//import frc.robot.commands.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;

public class RobotContainer {

    // Subsystems (driver train, and other manipulators)
    private final DriveTrain m_drive = new DriveTrain();
    private final Arm m_arm = new Arm();
    // private final IntakeMouth intake = new IntakeMouth();
/*    private final Hanger m_hanger = new Hanger();
 */
    //private final TestMotor testMotor = new TestMotor();

    // Controllers (input devices)
    // USB PORTs sequenced from top-down if multiple devices are plugged in
    final XboxController gamePad = new XboxController(0);  
    final Joystick logi = new Joystick(1); 

    // command for autonomous mode
    // private final Command m_autoCommand = new AutoPortDeploy(m_drive, m_intake, AUTO_PORT_DEPLOY_TIME, AUTO_PORT_DEPLOY_SPEED);

    public RobotContainer() {
        
        // set the default command for the drive train
          m_drive.setDefaultCommand(
       
                        new RunCommand(
                            () -> m_drive.drive(
                                DRIVE_SPEED_MULTIPLIER * logi.getY() * logi.getThrottle(),        
                                DRIVE_SPEED_MULTIPLIER * 0.75 * -logi.getTwist() * Math.abs(logi.getThrottle())
                                ),
                            m_drive)
                        );  

                        // m_arm.reset();
                        // m_arm.setSoftLimits();
                        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        // bind arm controls

        // for sparkmax
    //    final Button btnArmDown = new JoystickButton(gamePad, BTN_Y); // A
    //    final Button btnArmUp = new JoystickButton(gamePad, BTN_B); // X
    //    btnArmDown.whenPressed(new ArmDown(m_arm, () -> (!btnArmDown.get())));
    //     btnArmUp.whenPressed(new ArmUp(m_arm, () -> (!btnArmUp.get())));

    /*
      This works with softlimits of sparkmax. Motor moves once button is pressed (and released) once,
      soft limit will then stops the motor.
    */
    new JoystickButton(gamePad, Button.kY.value) // Y button
            .whenPressed(new ArmUp(m_arm));

    new JoystickButton(gamePad, Button.kB.value)   // B button
            .whenPressed(new ArmDown(m_arm));

    /* This is the basic way of running the motor, which runs while button is held down and stops 
    when button is released.
     */
    // new JoystickButton(gamePad, Button.kY.value) // Y button
    //         .whileHeld(new ArmUp(m_arm));

    // new JoystickButton(gamePad, Button.kB.value)   // B button
    //         .whileHeld(new ArmDown(m_arm));

        // for intake roller  
    //     final Button btnIntakeOut = new JoystickButton(gamePad, BUMP_RIGHT); // Right bumper
    //    final Button btnIntakeIn = new JoystickButton(gamePad, BUMP_LEFT); // Left bumper
    //    btnIntakeOut.whenPressed(new CargoOut(intake, () -> (!btnIntakeOut.get())));
    //     btnIntakeIn.whenPressed(new CargoIn(intake, () -> (!btnIntakeIn.get())));
        
        // Gamepad Buttons to ID
       /* final Button btnForward = new JoystickButton(gamePad, BTN_Y); // Y
        btnForward.whenHeld(new TestGoForward(testMotor, () -> (!btnForward.get())));
        
        final Button btnBackward = new JoystickButton(gamePad, BTN_A); // A
        btnBackward.whenHeld(new TestGoBack(testMotor, () -> (!btnBackward.get()))); */
    }

    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // return m_autoCommand;
        return null;
    }
}

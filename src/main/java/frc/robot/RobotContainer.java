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
                        // m_arm.restoreFactoryDefaults();
                        m_arm.setSoftLimits(true);
                
                        configureButtonBindings();
    }

    public Arm getArmSubsystem(){
        return m_arm;
    }
    private void configureButtonBindings() {
        // bind arm controls
    /*
      This is to try PID control using sparkmax encoder. Not the best way to use it with button held
      but below is to just simulate teleopPeriodic()
    */
    // new JoystickButton(gamePad, Button.kY.value) // Y button
    //         .whileHeld(new ArmUp(m_arm));

    // new JoystickButton(gamePad, Button.kB.value)   // B button
    //         .whileHeld(new ArmDown(m_arm));




    /*
      This works with softlimits of sparkmax. Motor moves once button is pressed (and released) once,
      soft limit will then stops the motor.
    */
    // new JoystickButton(gamePad, Button.kY.value) 
    //         .whenPressed(() -> m_arm.raiseTo(5));

    // new JoystickButton(gamePad, Button.kB.value) 
    //         .whenPressed(() -> m_arm.lowerTo(5));


    /* This is the basic way of running the motor, which runs while button is held down and stops 
    when button is released.
    With soft limit enabled, however, this gives flexibility of stoppping / reversing
    the arm movement at will, but still impose limit in each direction,
    so a more desirable mode during teleOp.
     */
    new JoystickButton(gamePad, Button.kY.value) // Y button
            .whileHeld(new ArmUp(m_arm));

    new JoystickButton(gamePad, Button.kB.value)   // B button
            .whileHeld(new ArmDown(m_arm));



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

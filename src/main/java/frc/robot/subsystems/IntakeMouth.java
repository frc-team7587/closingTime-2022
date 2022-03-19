package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeMouth extends SubsystemBase {

    private final TalonSRX m_talon = new TalonSRX(INTAKE_MOUTH_TALON_ID);

    public void takeIn() {
        SmartDashboard.putNumber("Cargo IN: ", m_talon.getMotorOutputVoltage());
        m_talon.set(ControlMode.PercentOutput, -INTAKE_MOUTH_SPEED);
    }

    public void spitOut() {
        SmartDashboard.putNumber("Cargo OUT: ", m_talon.getMotorOutputVoltage());
        m_talon.set(ControlMode.PercentOutput, INTAKE_MOUTH_SPEED);
    }

    public void stop() {
        m_talon.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}

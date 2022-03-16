package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import static frc.robot.Constants.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    //private final CANSparkMax m_spark = new CANSparkMax(ARM_SPARK_ID, MotorType.kBrushless);
    private final TalonFX falco = new TalonFX(0);

    public void raise() {
        falco.set(ControlMode.Velocity, -ARM_MAX_SPEED);
    }

    public void lower() {
        falco.set(ControlMode.Velocity, ARM_MAX_SPEED);
    }

    public void stop() {
        falco.set(ControlMode.Velocity, 0);
    }

    public void reset() {

        // m_spark.restoreFactoryDefaults();

        // m_spark.enableSoftLimit(SoftLimitDirection.kForward, true);
        // m_spark.enableSoftLimit(SoftLimitDirection.kReverse, true);
        // m_spark.setSoftLimit(SoftLimitDirection.kForward, ARM_SOFT_LIMIT_FWD);
        // m_spark.setSoftLimit(SoftLimitDirection.kReverse, ARM_SOFT_LIMIT_BKW);
    }

    @Override
    public void periodic() {

    }
}

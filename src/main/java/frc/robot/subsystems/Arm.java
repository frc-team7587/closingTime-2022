package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import static frc.robot.Constants.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    
    private final CANSparkMax m_spark = new CANSparkMax(ARM_SPARK_CAN_ID, MotorType.kBrushless);
    private RelativeEncoder encoder;

    public Arm(){
        m_spark.restoreFactoryDefaults();
        this.setSoftLimits();
        this.encoder = m_spark.getEncoder();
    }

    public void raise() {
        m_spark.set(ARM_MAX_SPEED);
    }

    public void lower() {
        m_spark.set(-ARM_MAX_SPEED);
    }

    public void stop() {
        m_spark.set(0);
    }

    public RelativeEncoder getEncoder() {
        return encoder;
    }

    public void setSoftLimits(){
        m_spark.enableSoftLimit(SoftLimitDirection.kForward, true);
        m_spark.enableSoftLimit(SoftLimitDirection.kReverse, true);
        m_spark.setSoftLimit(SoftLimitDirection.kForward, ARM_SOFT_LIMIT_FWD);
        m_spark.setSoftLimit(SoftLimitDirection.kReverse, ARM_SOFT_LIMIT_BKW);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}

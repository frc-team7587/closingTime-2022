package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import static frc.robot.Constants.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    private final CANSparkMax m_spark = new CANSparkMax(ARM_SPARK_CAN_ID, MotorType.kBrushless);
    private RelativeEncoder encoder;
    private SparkMaxPIDController m_pidController;
    public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

    public Arm() {
        m_spark.restoreFactoryDefaults();
        this.encoder = m_spark.getEncoder();
        this.m_pidController = m_spark.getPIDController();
        preparePIDControl();
    }

    public void preparePIDControl() {
        
        // PID coefficients
        kP = 0.1;
        kI = 1e-4;
        kD = 1;
        kIz = 0;
        kFF = 0;
        kMaxOutput = ARM_MAX_SPEED;
        kMinOutput = -ARM_MAX_SPEED;

        // set PID coefficients
        m_pidController.setP(kP);
        m_pidController.setI(kI);
        m_pidController.setD(kD);
        m_pidController.setIZone(kIz);
        m_pidController.setFF(kFF);
        m_pidController.setOutputRange(kMinOutput, kMaxOutput);
        System.out.println("----------ARM contruction done");
    }

    public void restoreFactoryDefaults() {
        m_spark.restoreFactoryDefaults();
    }

    public void raise() {
        m_spark.set(ARM_MAX_SPEED);
    }

    public void lower() {
        m_spark.set(-ARM_MAX_SPEED);
    };

    int count;
    /* via pid control */
    /* public void raiseTo(double rotations) {

       REVLibError err = m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
       
       if(++count>20){
        System.out.println("raised at: " + encoder.getPosition());
        count=0;
       }
    }

    public void lowerTo(double rotations) {

        REVLibError err = m_pidController.setReference(-rotations, CANSparkMax.ControlType.kPosition);
        
        if(++count>20){
            System.out.println("lowered to: " + encoder.getPosition());
            count=0;
        }

    } */

    public void stop() {
        m_spark.set(0);
    }

    public RelativeEncoder getEncoder() {
        return encoder;
    }

    public void setSoftLimits(boolean enabled) {
        m_spark.enableSoftLimit(SoftLimitDirection.kForward, enabled);
        m_spark.enableSoftLimit(SoftLimitDirection.kReverse, enabled);
        if (enabled) {
            m_spark.setSoftLimit(SoftLimitDirection.kForward, ARM_SOFT_LIMIT_FWD);
            m_spark.setSoftLimit(SoftLimitDirection.kReverse, ARM_SOFT_LIMIT_BKW);
        }
    }

    @Override
    public void periodic() {
        // SmartDashboard.putNumber("Encoder Position: ", encoder.getPosition());
    }
}

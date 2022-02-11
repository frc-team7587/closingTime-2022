package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import static frc.robot.Constants.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    private final CANSparkMax sparky = new CANSparkMax(1, MotorType.kBrushless);
public Arm(){
    initSoftLimit();
}
    public void initSoftLimit(){

        sparky.enableSoftLimit(SoftLimitDirection.kForward, true);
        sparky.enableSoftLimit(SoftLimitDirection.kReverse, true);

        sparky.setSoftLimit(SoftLimitDirection.kForward, ARM_SOFT_LIMIT_FWD);
        sparky.setSoftLimit(SoftLimitDirection.kReverse, ARM_SOFT_LIMIT_BKW);

    }

    public void raise() {
        sparky.set(0.25 * -ARM_MAX_SPEED);
    }

    public void lower() {
        sparky.set(0.25 * ARM_MAX_SPEED);
    }

    public void stop() {
        sparky.set(0);
    }

    public void reset() {
        sparky.restoreFactoryDefaults();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

}

package frc.robot;

public class Constants {

    // Device CAN IDs
    public static final int DRIVE_VICTOR_LEFT1 = 0;
    public static final int DRIVE_VICTOR_LEFT2 = 2;
    public static final int DRIVE_VICTOR_RIGHT1 = 1;
    public static final int DRIVE_VICTOR_RIGHT2 = 3;
    public static final int INTAKE_TALON_ID = 4;
    public static final int ARM_SPARK_ID = 5;

    // Control ports
    public static final int XBOX_CTRL_PORT = 0;
    public static final int LOGIJOY_PORT = 1;
    
     // Performance constants
    public static final double DRIVE_SPEED_MULTIPLIER = 0.75;   // to be verified
    public static final double INTAKE_MAX_SPEED = 0.35;         // tested, ok
    public static final double ARM_MAX_SPEED = 0.3;             // to be tested on assembled arm

    // Arm soft limits (to be tested)
    public static final float ARM_SOFT_LIMIT_FWD = 15;
    public static final float ARM_SOFT_LIMIT_BKW = -15; 

    public static final class ArmConstants {
        public static final int kMotorPort = 4;
    
        public static final double kP = 1;
    
        // These are fake gains; in actuality these must be determined individually for each robot
        public static final double kSVolts = 1;
        public static final double kGVolts = 1;
        public static final double kVVoltSecondPerRad = 0.5;
        public static final double kAVoltSecondSquaredPerRad = 0.1;
    
        public static final double kMaxVelocityRadPerSecond = 3;
        public static final double kMaxAccelerationRadPerSecSquared = 10;
    
        public static final int[] kEncoderPorts = new int[] {4, 5};
        public static final int kEncoderPPR = 256;
        public static final double kEncoderDistancePerPulse = 2.0 * Math.PI / kEncoderPPR;
    
        // The offset of the arm from the horizontal in its neutral position,
        // measured from the horizontal
        public static final double kArmOffsetRads = 0.5;
      }
}
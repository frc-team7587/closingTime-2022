package frc.robot;

public class Constants {
    public Constants() {
    }

    // Testing constants
    public static final int PWM_ZERO = 0;
    public static final double TEST_1_MAXSPEED = 0.20;
    
    // Joystick constants
    public static final int LOGIJOY_PORT = 0;
    public static final int LOGI_BTN_1 = 1;
    public static final int LOGI_BTN_2 = 2;
    public static final int LOGI_BTN_3 = 3;
    public static final int LOGI_BTN_4 = 4;
    public static final int LOGI_BTN_5 = 5;
    public static final int LOGI_BTN_6 = 6;

    // Gamepad constants
    public static final int BTN_A = 1;
    public static final int BTN_B = 2;
    public static final int BTN_X = 3;
    public static final int BTN_Y = 4;
    public static final int BUMP_LEFT = 5;
    public static final int BUMP_RIGHT = 6;

     // Drivetrain constants
    public static final int DRIVE_LEFT1 = 0;
    public static final int DRIVE_LEFT2 = 1;
    public static final int DRIVE_RIGHT1 = 2;
    public static final int DRIVE_RIGHT2 = 3;
    public static final double DRIVE_SPEED_MULTIPLIER = 0.75;

    // Intake constants
    public static final int INTAKE_TALON_ID = 3;
    public static final double INTAKE_MAX_SPEED = 0.5;

    // Hanger constants
    public static final int HANGER_TALON_ID = 2;
    public static final double HANGER_MAX_SPEED = 0.80;

    // Arm constants
    // public static final int ARM_SPARK_PWM_ID = 4;
    public static final double ARM_MAX_SPEED = 0.075;
    public static final float ARM_SOFT_LIMIT_FWD = 15;
    public static final float ARM_SOFT_LIMIT_BKW = 0; 

    // Auto constants
    public static final double AUTO_PORT_DEPLOY_TIME = 2;
    public static final double AUTO_PORT_DEPLOY_SPEED = 0.25; 


}
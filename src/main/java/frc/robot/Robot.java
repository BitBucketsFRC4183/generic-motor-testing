// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;




/**
 * The VM is configured to automatically run this class, and to call the methods corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    XboxController joystick;


    static final int deviceId1 = 1;
    static final int deviceId2 = 2;
    static final int deviceId3 = 3;
    static final int deviceId4 = 4;

    static final double velocity_units = 2;


    CANSparkMax sparkmax1;
    CANSparkMax sparkmax2;
    //CANSparkMax sparkmax3;
    //CANSparkMax sparkmax4;

    SparkMaxPIDController controller1;
    SparkMaxPIDController controller2;

    //SparkMaxPIDController controller3;

    //SparkMaxPIDController controller4;


    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit()
    {

        sparkmax1 = new CANSparkMax(deviceId1, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkmax2 = new CANSparkMax(deviceId2, CANSparkMaxLowLevel.MotorType.kBrushless);

        sparkmax1.setSmartCurrentLimit(70);
        sparkmax2.setSmartCurrentLimit(70);
        /*sparkmax3 = new CANSparkMax(deviceId3, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkmax4 = new CANSparkMax(deviceId4, CANSparkMaxLowLevel.MotorType.kBrushless);*/



        controller1 = sparkmax1.getPIDController();
        controller2 = sparkmax2.getPIDController();
        /*controller1 = sparkmax3.getPIDController();
        controller1 = sparkmax4.getPIDController();*/

        joystick = new XboxController(0);


    }
    
    
    /**
     * This method is called every 20 ms, no matter the mode. Use this for items like diagnostics
     * that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic methods, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {

        double leftFF = joystick.getLeftY();



        //controller1.setReference(velocity_units, CANSparkMax.ControlType.kVelocity);

        sparkmax1.setVoltage(-leftFF * 12);
        sparkmax2.setVoltage(leftFF * 12);
        //sparkmax3.setVoltage(leftFF);
        //sparkmax4.setVoltage(leftFF);
    }
    
    

    @Override
    public void autonomousInit() {}
    
    
    /** This method is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {}
    
    
    /** This method is called once when teleop is enabled. */
    @Override
    public void teleopInit() {}
    
    
    /** This method is called periodically during operator control. */
    @Override
    public void teleopPeriodic() {}
    
    
    /** This method is called once when the robot is disabled. */
    @Override
    public void disabledInit() {}
    
    
    /** This method is called periodically when disabled. */
    @Override
    public void disabledPeriodic() {}
    
    
    /** This method is called once when test mode is enabled. */
    @Override
    public void testInit() {}
    
    
    /** This method is called periodically during test mode. */
    @Override
    public void testPeriodic() {}
    
    
    /** This method is called once when the robot is first started up. */
    @Override
    public void simulationInit() {}
    
    
    /** This method is called periodically whilst in simulation. */
    @Override
    public void simulationPeriodic() {}
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.spikes2212.command.drivetrains.TankDrivetrain;
import com.spikes2212.command.drivetrains.commands.DriveArcade;
import com.spikes2212.util.PlaystationControllerWrapper;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    public static final double MOVE_VALUE_LIMIT = 0.25;
    public static final double ROTATE_VALUE_LIMIT = 0.25;

    //    public final PlaystationControllerWrapper pl = new PlaystationControllerWrapper(0);
    public final Joystick left = new Joystick(0);
    public final Joystick right = new Joystick(1);
    public TankDrivetrain drivetrain = new TankDrivetrain(new SparkMax(RobotMap.CAN.LEFT_MASTER,
            SparkLowLevel.MotorType.kBrushless),
            new SparkMax(RobotMap.CAN.LEFT_SLAVE, SparkLowLevel.MotorType.kBrushless),
            new SparkMax(RobotMap.CAN.RIGHT_MASTER, SparkLowLevel.MotorType.kBrushless),
            new SparkMax(RobotMap.CAN.RIGHT_SLAVE, SparkLowLevel.MotorType.kBrushless));


    @Override
    public void robotInit() {

    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
        drivetrain.setDefaultCommand(new DriveArcade(drivetrain, () -> right.getY() * MOVE_VALUE_LIMIT,
                () -> left.getX() * ROTATE_VALUE_LIMIT));

//        drivetrain.setDefaultCommand(new DriveArcade(drivetrain, () -> pl.getRightY() * MOVE_VALUE_LIMIT,
//                () -> pl.getLeftX() * ROTATE_VALUE_LIMIT));
    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {

    }
}

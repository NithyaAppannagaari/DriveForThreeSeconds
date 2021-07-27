// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  public TalonFX frontRight;
  public TalonFX frontLeft;
  public TalonFX backRight;
  public TalonFX backLeft;

  public Drivetrain() {
    frontRight = new TalonFX(0);
    frontLeft = new TalonFX(1);
    backRight = new TalonFX(2);
    backLeft = new TalonFX(3);

    backRight.follow(frontRight);
    backLeft.follow(frontLeft);

    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runTheMotors(double rightSpeed, double leftSpeed)
  {
    frontRight.set(ControlMode.PercentOutput, rightSpeed);
    frontLeft.set(ControlMode.PercentOutput, leftSpeed);
  }
}

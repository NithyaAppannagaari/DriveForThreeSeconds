// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  public TalonSRX frontRight;
  public TalonSRX frontLeft;
  public TalonSRX backRight;
  public TalonSRX backLeft;

  public Drivetrain() {
    frontRight = new TalonSRX(0);
    frontLeft = new TalonSRX(1);
    backRight = new TalonSRX(2);
    backLeft = new TalonSRX(3);

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

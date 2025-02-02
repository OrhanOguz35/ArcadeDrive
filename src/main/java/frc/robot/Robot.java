// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;



/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with split
 * arcade steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
    private DifferentialDrive drivetrain;
    private XboxController controller;
  
 

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
      PWMSparkMax leftMotor = new PWMSparkMax(0);
      PWMSparkMax rightMotor = new PWMSparkMax(1);
    rightMotor.setInverted(true);

    drivetrain = new DifferentialDrive(leftMotor, rightMotor);

    controller = new XboxController(0);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with split arcade drive.
    // That means that the Y axis of the left stick moves forward
    // and backward, and the X of the right stick turns left and right.
    double x = controller.getLeftX();
    double y = -controller.getLeftY();
    
    drivetrain.arcadeDrive(y, x);

  }

  public void stop(){
    drivetrain.stopMotor();
  }
}

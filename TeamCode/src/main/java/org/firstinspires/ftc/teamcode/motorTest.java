package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by ethan on 11/30/17.
 */
@TeleOp
public class motorTest extends OpMode {
    DcMotor motor;

    double motorPow;

    @Override
    public void init(){
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        telemetry.addData("status", "initialized");
    }
    @Override
    public void loop(){
        motorPow = gamepad1.right_stick_y;
        telemetry.addData("motor power", motorPow);
        motor.setPower(motorPow);
        telemetry.addData("real motor power", motor.getPower());
    }
}

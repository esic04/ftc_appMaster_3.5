package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ethan on 11/28/17.
 */
@TeleOp
@Disabled
public class ServoTesting extends OpMode {
    Servo servo;
    double servoPos;

    @Override
    public void init(){
        servo = hardwareMap.get(Servo.class, "servo");

    }
    @Override
    public void loop(){
        servoPos = Math.abs(gamepad1.right_stick_y);
        telemetry.addData("servo position", servoPos);
        servo.setPosition(servoPos);
        telemetry.addData("real servo position", servo.getPosition());
    }
}

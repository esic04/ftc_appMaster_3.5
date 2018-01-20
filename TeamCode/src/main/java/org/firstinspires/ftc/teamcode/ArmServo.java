package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ethan on 11/26/17.
 */
@TeleOp
@Disabled
public class ArmServo extends OpMode {
    Servo servo;
    Servo servo2;

    double servoPos;
    double servo2Pos;
    
    @Override
    public void init(){
        telemetry.addData("Status", "Initializing");

        servo = hardwareMap.get(Servo.class, "servo");
        servo2 = hardwareMap.get(Servo.class, "servo2");
    }
    @Override
    public void loop(){
        servoPos = Math.abs(gamepad1.right_stick_x);
        servo2Pos = Math.abs(gamepad1.left_stick_x);

        telemetry.addData("Servo 1 position", servoPos);
        telemetry.addData("Servo 2 position", servo2Pos);
        telemetry.update();

        servo.setPosition(servoPos);
        servo2.setPosition(servo2Pos);

        telemetry.addData("real servo position", servo.getPosition());
        telemetry.addData("real servo 2 position", servo2.getPosition());


    }
}

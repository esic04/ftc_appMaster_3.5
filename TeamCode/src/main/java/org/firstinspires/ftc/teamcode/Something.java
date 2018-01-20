package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ethan on 11/24/17.
 */
@TeleOp
@Disabled
public class Something extends LinearOpMode{
    private DcMotor left;
    private Servo servo;



    @Override
    public void runOpMode(){
        left = hardwareMap.get(DcMotor.class,  "left");
        servo = hardwareMap.get(Servo.class, "servo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        double tgtPow = 0;
        while(opModeIsActive()) {
            tgtPow = this.gamepad1.left_stick_y;
            left.setPower(tgtPow);
            if(gamepad1.y){
                servo.setPosition(0);
            } else if (gamepad1.x || gamepad1.b){
                servo.setPosition(0.5);
            } else if (gamepad1.a){
                servo.setPosition(1);
            }
            telemetry.addData("Servo Position", servo.getPosition());
            telemetry.addData("target power", tgtPow);
            telemetry.addData("motor power", left.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }

    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by ethan on 11/26/17.
 */
@TeleOp
public class Drive4wheel extends OpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor left;
    private DcMotor right;

    float leftPow;
    float rightPow;


    @Override
    public void init(){
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeft = hardwareMap.get(DcMotor.class , "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class , "frontLeft");
        left = hardwareMap.get(DcMotor.class , "left");
        right = hardwareMap.get(DcMotor.class , "right");

    }
    @Override
    public void loop(){
        leftPow = gamepad1.left_stick_y + gamepad1.left_stick_x;
        rightPow = gamepad1.left_stick_y - gamepad1.left_stick_x;

        frontLeft.setPower(leftPow);
        left.setPower(leftPow);
        frontRight.setPower(rightPow);
        right.setPower(rightPow);

        telemetry.addData("Front left power", frontLeft.getPower());
        telemetry.addData("back left power", left.getPower());
        telemetry.addData("front right power", frontRight.getPower());
        telemetry.addData("back right power", right.getPower());


    }

}

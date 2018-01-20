package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by ethan on 11/26/17.
 */
@TeleOp
@Disabled
public class MecanumDrive extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    float FLPow;
    float FRPow;
    float BLPow;
    float BRPow;

    @Override
    public void init(){
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");


        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop(){
        FLPow = gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
        BLPow = gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;
        FRPow = gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
        BRPow = gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;

        telemetry.addData("Front Left Power", FLPow);
        telemetry.addData("Front Right Power", FRPow);
        telemetry.addData("Back Left Power", BLPow);
        telemetry.addData("Back Right Power", BRPow);
        telemetry.update();

        frontLeft.setPower(FLPow);
        frontRight.setPower(FRPow);
        backLeft.setPower(BLPow);
        backRight.setPower(BRPow);

    }
}

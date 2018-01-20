package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 12/1/17.
 */
@Autonomous
@Disabled
public class Turn90 extends LinearOpMode{
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;

    int leftTgtPos;
    int rightTgtPos;

    public void runOpMode(){
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftTgtPos = 34*2/32*1440;
        rightTgtPos = -34*2/32*1440;

        waitForStart();

        left.setTargetPosition(-2669);
        right.setTargetPosition(2669);
        frontLeft.setTargetPosition(-3068);
        frontRight.setTargetPosition(3068);

        while(left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy()){
            telemetry.addData("left current position", left.getCurrentPosition());
            telemetry.addData("right current position", right.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        left.setPower(-0.2);
        right.setPower(0.2);
        frontLeft.setPower(-0.2);
        frontRight.setPower(0.2);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


}

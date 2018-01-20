package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 11/25/17.
 */
@Autonomous
@Disabled
public class Encoder extends LinearOpMode {
    private DcMotor left;
    private DcMotor right;

    @Override
    public void runOpMode(){
        int LeftTgt;
        int RightTgt;
        double MotorPow;

        MotorPow = 0.3;

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

        LeftTgt = left.getCurrentPosition() + (100 * 2 / 32 * 1440); // in cm
        RightTgt = right.getCurrentPosition() + (100 * 2 / 32 * 1440);

        left.setTargetPosition(LeftTgt);
        right.setTargetPosition(RightTgt);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setPower(MotorPow);
        right.setPower(MotorPow);

        while (opModeIsActive() && left.isBusy() && right.isBusy()){
            telemetry.addData("right target", RightTgt);
            telemetry.addData("left target", LeftTgt);
            telemetry.addData("Right current position", right.getCurrentPosition());
            telemetry.addData("Left current position", left.getCurrentPosition());
            telemetry.update();
        }

        left.setPower(0);
        right.setPower(0);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        requestOpModeStop();


    }



}

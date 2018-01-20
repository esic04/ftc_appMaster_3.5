package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 1/9/18.
 */
@Autonomous
@Disabled
public class TurnRampPowerOn extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;

    public void runOpMode(){
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setTargetPosition(1220);
        right.setTargetPosition(1220);
        frontLeft.setTargetPosition(1440);
        frontRight.setTargetPosition(1440);

        left.setPower(0.01);
        right.setPower(0.01);
        frontLeft.setPower(0.01);
        frontRight.setPower(0.01);

        while(opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())){
            if(left.getPower() <= 0.5){
                left.setPower(left.getPower() + 0.01);
                right.setPower(right.getPower() + 0.01);
                frontLeft.setPower(frontLeft.getPower() + 0.01);
                frontRight.setPower(frontRight.getPower() + 0.01);

                sleep(100);

                telemetry.addData("motor power", left.getPower());
            } else{
                telemetry.addData("motor power", left.getPower());
            }
        }


    }
}

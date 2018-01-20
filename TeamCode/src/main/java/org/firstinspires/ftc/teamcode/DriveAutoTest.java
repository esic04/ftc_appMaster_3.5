package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 1/2/18.
 */
@Autonomous
@Disabled
public class DriveAutoTest extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;

    @Override
    public void runOpMode() {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setPower(0.05);
        right.setPower(0.05);
        frontLeft.setPower(0.05);
        frontRight.setPower(0.05);

        waitForStart();

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setTargetPosition(500);
        frontLeft.setTargetPosition(500);
        right.setTargetPosition(500);
        frontRight.setTargetPosition(500);

        while (opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }
    }

}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AllMotorTestHighPow extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;

    @Override
    public void runOpMode(){
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setPower(0.3);
        right.setPower(0.3);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        frontLeft.setTargetPosition(500);

        while(opModeIsActive() && frontLeft.isBusy()){
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        frontLeft.setTargetPosition(-500);

        while(opModeIsActive() && frontLeft.isBusy()){
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setTargetPosition(500);

        while(opModeIsActive() && frontRight.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontLeft.setTargetPosition(-500);

        while(opModeIsActive() && frontRight.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(500);

        while(opModeIsActive() && right.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(-500);

        while(opModeIsActive() && right.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(500);

        while(opModeIsActive() && left.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(-500);

        while(opModeIsActive() && right.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setTargetPosition(500);
        frontLeft.setTargetPosition(500);

        while(opModeIsActive() && frontRight.isBusy() && frontLeft.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setTargetPosition(-500);
        frontLeft.setTargetPosition(-500);

        while(opModeIsActive() && frontRight.isBusy() && frontLeft.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(500);
        left.setTargetPosition(500);

        while(opModeIsActive() && right.isBusy() && left.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(-500);
        left.setTargetPosition(-500);

        while(opModeIsActive() && right.isBusy() && left.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setTargetPosition(500);
        left.setTargetPosition(500);

        while(opModeIsActive() && frontRight.isBusy() && left.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setTargetPosition(-500);
        left.setTargetPosition(-500);

        while(opModeIsActive() && frontRight.isBusy() && left.isBusy()){
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(500);
        frontLeft.setTargetPosition(500);

        while(opModeIsActive() && right.isBusy() && frontLeft.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(-500);
        frontLeft.setTargetPosition(-500);

        while(opModeIsActive() && right.isBusy() && frontLeft.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(500);
        frontRight.setTargetPosition(500);

        while(opModeIsActive() && frontRight.isBusy() && right.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        right.setTargetPosition(-500);
        frontRight.setTargetPosition(-500);

        while(opModeIsActive() && frontRight.isBusy() && right.isBusy()){
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(500);
        frontLeft.setTargetPosition(500);

        while(opModeIsActive() && left.isBusy() && frontLeft.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(-500);
        frontLeft.setTargetPosition(-500);

        while(opModeIsActive() && left.isBusy() && frontLeft.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(500);
        frontLeft.setTargetPosition(500);
        right.setTargetPosition(500);
        frontRight.setTargetPosition(500);

        while(opModeIsActive() && left.isBusy() && frontLeft.isBusy() && right.isBusy() && frontRight.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(-500);
        frontLeft.setTargetPosition(-500);
        right.setTargetPosition(-500);
        frontRight.setTargetPosition(-500);

        while(opModeIsActive() && left.isBusy() && frontLeft.isBusy() && right.isBusy() && frontRight.isBusy()){
            telemetry.addData("left motor position", left.getCurrentPosition());
            telemetry.addData("front left motor position", frontLeft.getCurrentPosition());
            telemetry.addData("right motor position", right.getCurrentPosition());
            telemetry.addData("front right motor position", frontRight.getCurrentPosition());
            telemetry.update();
        }




    }
}

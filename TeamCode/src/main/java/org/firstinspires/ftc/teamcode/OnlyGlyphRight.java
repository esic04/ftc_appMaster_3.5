package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//inverted back motors for this program, need to do rest

@Autonomous
public class OnlyGlyphRight extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor armUp;
    Servo servo;
    Servo servo2;
    Servo servoJewel;

    double servoClosePos;
    double servo2ClosePos;
    double servoOpenPos;
    double servo2OpenPos;

    @Override
    public void runOpMode(){
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        armUp = hardwareMap.get(DcMotor.class, "armUp");
        servo = hardwareMap.get(Servo.class, "servo");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servoJewel = hardwareMap.get(Servo.class, "servoJewel");

        servoClosePos = 0.15;
        servo2ClosePos = 0.85;
        servoOpenPos = 0.35;
        servo2OpenPos = 0.65;

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armUp.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        servo.setPosition(servoClosePos);
        servo2.setPosition(servo2ClosePos);
        servoJewel.setPosition(1);

        telemetry.addData("status", "initialized");
        telemetry.update();

        waitForStart();

        left.setPower(0.2);
        right.setPower(0.2);
        frontLeft.setPower(0.2);
        frontRight.setPower(0.2);
        armUp.setPower(0.4);

        armUp.setTargetPosition(armUp.getCurrentPosition() - 900);

        while(opModeIsActive() && armUp.isBusy()){
            telemetry.addData("arm up position", armUp.getCurrentPosition());
            telemetry.update();
        }

        left.setTargetPosition(left.getCurrentPosition() + 1748);
        right.setTargetPosition(right.getCurrentPosition() - 1748);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 2062);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 2062);

        while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        left.setPower(0.3);
        right.setPower(0.3);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);

        left.setTargetPosition(left.getCurrentPosition() - 669);
        right.setTargetPosition(right.getCurrentPosition() - 669);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 790);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 790);

        while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        left.setPower(0.2);
        right.setPower(0.2);
        frontLeft.setPower(0.2);
        frontRight.setPower(0.2);

        left.setTargetPosition(left.getCurrentPosition() - 97);
        right.setTargetPosition(right.getCurrentPosition() + 97);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 115);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - 115);

        while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        servo.setPosition(servoOpenPos);
        servo2.setPosition(servo2OpenPos);

        left.setTargetPosition(left.getCurrentPosition() + 194);
        right.setTargetPosition(right.getCurrentPosition() - 194);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 229);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 229);

        while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        requestOpModeStop();

    }
}

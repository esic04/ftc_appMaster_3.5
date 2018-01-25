package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ethan on 1/24/18.
 */

public class OnlyGlyphOnlyFrontMotors extends LinearOpMode {
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
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        armUp = hardwareMap.get(DcMotor.class, "armUp");
        servo = hardwareMap.get(Servo.class, "servo");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servoJewel = hardwareMap.get(Servo.class, "servoJewel");

        servoClosePos = 0.15;
        servo2ClosePos = 0.85;
        servoOpenPos = 0.5;
        servo2OpenPos = 0.5;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armUp.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        servo.setPosition(servoClosePos);
        servo2.setPosition(servo2ClosePos);
        servoJewel.setPosition(1);

        telemetry.addData("status", "initialized");
        telemetry.update();

        waitForStart();

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(0.4);
        frontRight.setPower(0.4);
        armUp.setPower(0.4);

        armUp.setTargetPosition(armUp.getCurrentPosition() - 1000);

        while(opModeIsActive() && armUp.isBusy()){
            telemetry.addData("arm up position", armUp.getCurrentPosition());
            telemetry.update();
        }

        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 1997);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - 1997);

        while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 790);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 790);

        while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 630);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - 630);

        while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        servo.setPosition(servoOpenPos);
        servo2.setPosition(servo2OpenPos);

        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 401);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 401);

        while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        requestOpModeStop();

    }
}

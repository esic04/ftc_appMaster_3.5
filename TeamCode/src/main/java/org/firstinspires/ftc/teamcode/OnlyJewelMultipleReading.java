package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class OnlyJewelMultipleReading extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor armUp;
    Servo servo;
    Servo servo2;
    Servo servoJewel;
    ColorSensor color;

    float colorVal[];
    double servoClosePos;
    double servo2ClosePos;
    double servoOpenPos;
    double servo2OpenPos;
    int blueVal = 0;
    int redVal = 0;


    public void runOpMode() {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        armUp = hardwareMap.get(DcMotor.class, "armUp");
        servo = hardwareMap.get(Servo.class, "servo");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servoJewel = hardwareMap.get(Servo.class, "servoJewel");
        color = hardwareMap.get(ColorSensor.class, "color");

        servoClosePos = 0.15;
        servo2ClosePos = 0.85;
        servoOpenPos = 0.35;
        servo2OpenPos = 0.65;

        color.enableLed(true);

        colorVal = new float[10];

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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

        while (opModeIsActive() && armUp.isBusy()) {
            telemetry.addData("arm up position", armUp.getCurrentPosition());
            telemetry.update();
        }

        servoJewel.setPosition(0.4);

        sleep(1000);

        for (int i = 0; i < 50; i++){
            if(color.blue() >= 5){
                blueVal++;
            } else if (color.red() >= 5){
                redVal++;
            }
            sleep(20);
        }

        if(redVal > 40 && blueVal < 10){
            left.setTargetPosition(left.getCurrentPosition() + 203);
            right.setTargetPosition(right.getCurrentPosition() + 203);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 240);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 240);

            while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            servoJewel.setPosition(1);

            left.setTargetPosition(left.getCurrentPosition() - 203);
            right.setTargetPosition(right.getCurrentPosition() - 203);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 240);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 240);

            while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }
        } else if (blueVal > 50 && redVal < 10){
            left.setTargetPosition(left.getCurrentPosition() - 203);
            right.setTargetPosition(right.getCurrentPosition() - 203);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 240);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 240);

            while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            servoJewel.setPosition(1);

            left.setTargetPosition(left.getCurrentPosition() + 203);
            right.setTargetPosition(right.getCurrentPosition() + 203);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 240);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 240);

            while (opModeIsActive() && (left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }
        }

        requestOpModeStop();

    }
}
package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

//motors with no "left" are at the back
//don't add negatives for turn 90
//flip phone around so screen is facing outwards
//if phone can't read pictures, default is center
//ples work
//doesn't move jewel servo down, might be fixed
//write everything test program
//left and arm motors are reversed
//andymark motors(back ones) are 1220 counts instead of 1440
@Autonomous
public class LeftRed105 extends LinearOpMode {
    private DcMotor left;
    private DcMotor right;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor armUp;
    private Servo servo;
    private Servo servo2;
    private Servo servoJewel;
    private ColorSensor color;
    private VuforiaLocalizer vuforia;

    float colorVal[];
    int leftJewelTgt;
    int rightJewelTgt;
    int leftBoxTurnTgt;
    int backLeftBoxTurnTgt;
    int rightBoxTurnTgt;
    int backRightBoxTurnTgt;
    int leftTurn90;
    int backLeftTurn90;
    int rightTurn90;
    int backRightTurn90;
    int leftBoxTgt;
    int backLeftBoxTgt;
    int rightBoxTgt;
    int backRightBoxTgt;
    double servoClosePos;
    double servo2ClosePos;
    double servoOpenPos;
    double servo2OpenPos;

    @Override
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

        color.enableLed(true);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armUp.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftJewelTgt = 1440;
        rightJewelTgt = -1440;
        leftTurn90 = 3068;
        rightTurn90 = -3068;
        backLeftTurn90 = 2669;
        backRightTurn90 = -2669;
        leftBoxTgt = 4125;
        rightBoxTgt = 4125;
        backLeftBoxTgt = 3495;
        backRightBoxTgt = 3495;
        servoClosePos = 0.2;
        servo2ClosePos = 0.8;
        servoOpenPos = 0.25;
        servo2OpenPos = 0.75;

        colorVal = new float[10];
        color.enableLed(true);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AT7i4ID/////AAAAGcV/BI4020ycqKtCV427Y5JV93aTLjX3SXvzzWzrXFOFSRkpFhrmm7Y/N/kNo/rZ2ZqM3MZk17jGshCaR2EzLewC5ZoDjiitcVEhIjvPLtHpwg3e+MJ5cqcbZI/txt49FBrJOgcgBU6tDpul5NY994nLB3TTgKDnlDXWJ63Lr+d5TnfeO2tLU859wT4MJCZRZE89q36hmlQFo6V6bk0BK9+/Qr8aXOS3GtaLlvUMlQIwXcYePvNEHvF7q8g8D6a31VUzEdEVfQiFDV/gTtvreAbD5A2pDeGL187rMZdxkXbadG7iP7vQKrrQmY+kaIZF9sqFAHFfgH+v+ZDYkw4YKmfEeqnIToFpvCxSOMQ3vlC0";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT; // tell josh to flip phone around so screen is facing outward
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        left.setPower(0.3);
        right.setPower(0.3);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);
        armUp.setPower(0.3);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        servo.setPosition(servoClosePos);
        servo2.setPosition(servo2ClosePos);

        telemetry.addData("status", "initialized");
        telemetry.update();

        waitForStart();

        armUp.setTargetPosition(-360);

        telemetry.addData("status", "reading pictures");
        telemetry.update();

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
            telemetry.addData("VuMark", "% visible", vuMark);
            telemetry.update();
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                leftBoxTurnTgt = 9999;
                rightBoxTurnTgt = 9999;
                backLeftBoxTurnTgt = 8472;
                backRightBoxTurnTgt = 8472;

                telemetry.addData("vumark test", "left");
                telemetry.update();
            } else if (vuMark == RelicRecoveryVuMark.CENTER) {
                leftBoxTurnTgt = 8251;
                rightBoxTurnTgt = 8251;
                backLeftBoxTurnTgt = 6990;
                backRightBoxTurnTgt = 6990;

                telemetry.addData("vumark test", "center");
                telemetry.update();
            } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                leftBoxTurnTgt = 6502;
                rightBoxTurnTgt = 6502;
                backLeftBoxTurnTgt = 5509;
                backRightBoxTurnTgt = 5509;

                telemetry.addData("vumark test", "right");
                telemetry.update();
            }
        } else {
            leftBoxTurnTgt = 8251;
            rightBoxTurnTgt = 8251;
            backLeftBoxTurnTgt = 6990;
            backRightBoxTurnTgt = 6990;

            telemetry.addData("vumark test", "unknown");
            telemetry.update();
        }

        telemetry.addData("status", "jewel");
        servoJewel.setPosition(0.4);

        Color.RGBToHSV(color.red() * 8, color.green() * 8, color.blue() * 8, colorVal);

        if ((colorVal[0] <= 20 && colorVal[0] > 0) || colorVal[0] >= 340){
            telemetry.addData("color", "red");
            telemetry.update();

            telemetry.addData("status", "turning");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() + 610);
            right.setTargetPosition(right.getCurrentPosition() + 610);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 720);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 720);

            while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "turning back");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() - 610);
            right.setTargetPosition(right.getCurrentPosition() - 610);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 720);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 720);

            while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            servoJewel.setPosition(1);

        } else if (colorVal[0] >= 220 && colorVal[0] <= 260) {
            telemetry.addData("color", "blue");
            telemetry.update();

            telemetry.addData("status", "turning");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() - 610);
            right.setTargetPosition(right.getCurrentPosition() - 610);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 720);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 720);

            while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "turning back");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() + 610);
            right.setTargetPosition(right.getCurrentPosition() + 610);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 720);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 720);

            while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            servoJewel.setPosition(1);

        } else {
            telemetry.addData("color", "unknown");
            telemetry.update();

            servoJewel.setPosition(1);
        }
        telemetry.addData("status", "moving to cryptobox turn location");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() - backLeftBoxTurnTgt);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - leftBoxTurnTgt);
        right.setTargetPosition(right.getCurrentPosition() + backRightBoxTurnTgt);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + rightBoxTurnTgt);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "turning 90 degrees");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() - backLeftTurn90);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - leftTurn90);
        right.setTargetPosition(right.getCurrentPosition() + backRightTurn90);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + rightTurn90);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "moving to cryptobox");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() - backLeftBoxTgt);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - leftBoxTgt);
        right.setTargetPosition(right.getCurrentPosition() + backRightBoxTgt);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + rightBoxTgt);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        servo.setPosition(servoOpenPos);
        servo2.setPosition(servo2OpenPos);

        telemetry.addData("status", "moving back");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() + 2440);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 2880);
        right.setTargetPosition(right.getCurrentPosition() - 2440);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - 2880);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "turning 180 degrees");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() + 5338);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 6300);
        right.setTargetPosition(right.getCurrentPosition() + 5338);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 6300);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "lowering arm");
        telemetry.update();

        armUp.setTargetPosition(armUp.getCurrentPosition() + 360);

        while (opModeIsActive() && armUp.isBusy()) {
            telemetry.addData("arm 1current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "opening claw");
        telemetry.update();

        servo.setPosition(0.35);
        servo2.setPosition(0.65);

        telemetry.addData("status", "moving to glyph pit");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() - 9708);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 11459);
        right.setTargetPosition(right.getCurrentPosition() + 9708);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + 11459);

        while (opModeIsActive() && left.isBusy() && right.isBusy() && frontLeft.isBusy() && frontRight.isBusy()) {
            telemetry.addData("back right current position", right.getCurrentPosition());
            telemetry.addData("back left current position", left.getCurrentPosition());
            telemetry.addData("front right current position", frontRight.getCurrentPosition());
            telemetry.addData("front left current position", frontLeft.getCurrentPosition());
            telemetry.update();
        }

        telemetry.addData("status", "grabbing glyph");
        telemetry.update();

        servo.setPosition(0.2);
        servo2.setPosition(0.8);

        telemetry.addData("status", "moving back to cryptobox");
        telemetry.update();

        left.setTargetPosition(left.getCurrentPosition() + 9708);
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 11459);
        right.setTargetPosition(right.getCurrentPosition() - 9078);
        frontRight.setTargetPosition(frontRight.getCurrentPosition() - 11459); // not going to work

        telemetry.addData("status", "parked, stopping program");
        telemetry.update();

        requestOpModeStop();
    }
}
package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import static org.firstinspires.ftc.robotcontroller.internal.FieldPositionProgram.BalancingStone;

//motors with no "left" are at the back
//don't add negatives for turn 90
//flip phone around so screen is facing outwards
//if phone can't read pictures, default is center
//ples work
//doesn't move jewel servo down, might be fixed
//write everything test program
//left and arm motors are reversed
//andymark motors(back ones) are 1220 counts instead of 1440
//may need to change motor neg or pos because of setting motor direction
@Autonomous
@Disabled
public class AutonomousNoJewel extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor armUp;
    Servo servo;
    Servo servo2;
    Servo servoJewel;
    ColorSensor color;
    VuforiaLocalizer vuforia;

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

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armUp.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        color.enableLed(true);

        leftJewelTgt = 1440;
        rightJewelTgt = -1440;
        leftTurn90 = 790;
        rightTurn90 = 790;
        backLeftTurn90 = 669;
        backRightTurn90 = 669;
        leftBoxTgt = 888;
        rightBoxTgt = 888;
        backLeftBoxTgt = 752;
        backRightBoxTgt = 752;
        servoClosePos = 0.2;
        servo2ClosePos = 0.7;
        servoOpenPos = 0.35;
        servo2OpenPos = 0.65;
        colorVal = new float[10];

        color.enableLed(true);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AT7i4ID/////AAAAGcV/BI4020ycqKtCV427Y5JV93aTLjX3SXvzzWzrXFOFSRkpFhrmm7Y/N/kNo/rZ2ZqM3MZk17jGshCaR2EzLewC5ZoDjiitcVEhIjvPLtHpwg3e+MJ5cqcbZI/txt49FBrJOgcgBU6tDpul5NY994nLB3TTgKDnlDXWJ63Lr+d5TnfeO2tLU859wT4MJCZRZE89q36hmlQFo6V6bk0BK9+/Qr8aXOS3GtaLlvUMlQIwXcYePvNEHvF7q8g8D6a31VUzEdEVfQiFDV/gTtvreAbD5A2pDeGL187rMZdxkXbadG7iP7vQKrrQmY+kaIZF9sqFAHFfgH+v+ZDYkw4YKmfEeqnIToFpvCxSOMQ3vlC0";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT; // tell josh to flip phone around so screen is facing outward
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        left.setPower(0.15);
        right.setPower(0.15);
        frontLeft.setPower(0.15);
        frontRight.setPower(0.15);
        armUp.setPower(0.4);

        left.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        armUp.setDirection(DcMotorSimple.Direction.FORWARD);

        servo.setPosition(servoClosePos);
        servo2.setPosition(servo2ClosePos);
        servoJewel.setPosition(1);

        telemetry.addData("status", "initialized");
        telemetry.update();

        waitForStart();

        if(BalancingStone == 4){
            telemetry.addData("balancing platform", "left red");
            telemetry.update();

            relicTrackables.activate();

            left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            armUp.setTargetPosition(armUp.getCurrentPosition() - 800);

            while(opModeIsActive() && armUp.isBusy()){
                telemetry.addData("arm up position", armUp.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "reading pictures");
            telemetry.update();

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
                telemetry.addData("VuMark", "% visible", vuMark);
                telemetry.update();

                if (vuMark == RelicRecoveryVuMark.LEFT) {
                    leftBoxTurnTgt = 2443;
                    rightBoxTurnTgt = 2443;
                    backLeftBoxTurnTgt = 2069;
                    backRightBoxTurnTgt = 2069;

                    telemetry.addData("vumark test", "left");
                    telemetry.update();
                } else if (vuMark == RelicRecoveryVuMark.CENTER) {
                    leftBoxTurnTgt = 2005;
                    rightBoxTurnTgt = 2005;
                    backLeftBoxTurnTgt = 1699;
                    backRightBoxTurnTgt = 1699;

                    telemetry.addData("vumark test", "center");
                    telemetry.update();
                } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                    leftBoxTurnTgt = 1568;
                    rightBoxTurnTgt = 1568;
                    backLeftBoxTurnTgt = 1329;
                    backRightBoxTurnTgt = 1329;

                    telemetry.addData("vumark test", "right");
                    telemetry.update();
                }
            } else {
                leftBoxTurnTgt = 2005;
                rightBoxTurnTgt = 2005;
                backLeftBoxTurnTgt = 1699;
                backRightBoxTurnTgt = 1699;

                telemetry.addData("vumark test", "unknown");
                telemetry.update();
            }

            telemetry.addData("status", "moving to cryptobox turn location");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() + backLeftBoxTurnTgt);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + leftBoxTurnTgt);
            right.setTargetPosition(right.getCurrentPosition() - backRightBoxTurnTgt);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - rightBoxTurnTgt);

            while (opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "turning 90 degrees");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() + backLeftTurn90);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + leftTurn90);
            right.setTargetPosition(right.getCurrentPosition() - backRightTurn90);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - rightTurn90);

            while (opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "moving to cryptobox");
            telemetry.update();

            left.setTargetPosition(left.getCurrentPosition() + backLeftBoxTgt);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + leftBoxTgt);
            right.setTargetPosition(right.getCurrentPosition() - backRightBoxTgt);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - rightBoxTgt);

            while (opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())) {
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

            left.setTargetPosition(left.getCurrentPosition() - 1220);
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 1440);
            right.setTargetPosition(right.getCurrentPosition() + 1220);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 1440);

            while (opModeIsActive() && (left.isBusy() || right.isBusy() || frontLeft.isBusy() || frontRight.isBusy())) {
                telemetry.addData("back right current position", right.getCurrentPosition());
                telemetry.addData("back left current position", left.getCurrentPosition());
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            telemetry.addData("status", "parked, stopping program");
            telemetry.update();

            left.setPower(0);
            right.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            armUp.setPower(0);

            requestOpModeStop();
        } else if(BalancingStone == 1){
            telemetry.addData("balancing platform", "blue left");
            telemetry.update();
        } else if(BalancingStone == 2){
            telemetry.addData("balancing platform", "red right");
            telemetry.update();
        } else if(BalancingStone == 3){
            telemetry.addData("balancing platform", "blue right");
            telemetry.update();
        }
    }

}


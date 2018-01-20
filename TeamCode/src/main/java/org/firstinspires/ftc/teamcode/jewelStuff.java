package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ethan on 11/28/17.
 */
@Autonomous
@Disabled
public class jewelStuff extends LinearOpMode {
    DcMotor left;
    DcMotor right;
    ColorSensor color;
    Servo servoJewel;

    double servoUp;
    double servoDown;
    int leftTgt;
    int rightTgt;
    float colorVal[];

    @Override
    public void runOpMode(){
        colorVal = new float[10];

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        color = hardwareMap.get(ColorSensor.class, "color");
        servoJewel = hardwareMap.get(Servo.class, "servoJewel");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);

        color.enableLed(true);

        servoUp = 0;
        servoDown = 0.5;

        leftTgt = left.getCurrentPosition() + 1440;
        rightTgt = right.getCurrentPosition() -1440;

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("status", "initialized");
        telemetry.update();

        waitForStart();

        servoJewel.setPosition(servoDown);

        left.setPower(0.2);
        right.setPower(0.2);

        Color.RGBToHSV(color.red()*8, color.green()*8, color.blue()*8, colorVal);
        telemetry.addData("hsv value", colorVal[0]);

        if (colorVal[0] <= 20 || colorVal[0] >= 340){
            telemetry.addData("color", "red");
            telemetry.update();

            left.setTargetPosition(leftTgt);
            right.setTargetPosition(rightTgt);

            left.setTargetPosition(-leftTgt);
            right.setTargetPosition(-rightTgt);

        } else if (colorVal[0] >= 220 && colorVal[0] <= 260){
            telemetry.addData("color", "blue");
            telemetry.update();

            left.setTargetPosition(-leftTgt);
            right.setTargetPosition(-rightTgt);

            left.setTargetPosition(leftTgt);
            right.setTargetPosition(rightTgt);
        }
        servoJewel.setPosition(servoUp);

        left.setPower(0);
        right.setPower(0);

        requestOpModeStop();

    }

}

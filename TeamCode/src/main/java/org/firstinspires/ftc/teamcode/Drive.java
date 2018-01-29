package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class Drive extends OpMode {
    private DcMotor left;
    private DcMotor right;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private Servo servo;
    private Servo servo2;
    private Servo servoJewel;
    private DcMotor armUp;

    double LeftPow;
    double RightPow;
    double ArmPow;
    double ServoClosePos;
    double Servo2ClosePos;
    double ServoOpenPos;
    double Servo2OpenPos;
    double ServoGrabPos;
    double Servo2GrabPos;

    @Override
    public void init(){
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        armUp = hardwareMap.get(DcMotor.class, "armUp");
        servo = hardwareMap.get(Servo.class, "servo");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servoJewel = hardwareMap.get(Servo.class, "servoJewel");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        armUp.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        ServoClosePos = 0.2;
        Servo2ClosePos = 0.8;
        ServoOpenPos = 0.25;
        Servo2OpenPos = 0.75;
        ServoGrabPos = 0.35;
        Servo2GrabPos = 0.65;

        servo.setPosition(0.5);
        servo2.setPosition(0.5);
        servoJewel.setPosition(1);

    }

    @Override
    public void loop(){
        LeftPow = gamepad1.left_stick_y - gamepad1.left_stick_x;
        RightPow = gamepad1.left_stick_y + gamepad1.left_stick_x;
        ArmPow = gamepad1.right_stick_y;

        armUp.setPower(gamepad1.right_stick_y/2);
        servoJewel.setPosition(1);

        if(gamepad1.right_bumper){
            left.setPower(-LeftPow/3);
            right.setPower(-RightPow/3);
            frontLeft.setPower(LeftPow/3);
            frontRight.setPower(RightPow/3);
        } else if(gamepad1.left_bumper){
            left.setPower(-LeftPow/5);
            right.setPower(-RightPow/5);
            frontLeft.setPower(LeftPow/5);
            frontRight.setPower(RightPow/5);
        } else {
            left.setPower(-LeftPow/1.5);
            right.setPower(-RightPow/1.5);
            frontLeft.setPower(LeftPow/1.5);
            frontRight.setPower(RightPow/1.5);
        }

        if (gamepad1.y){
            servo.setPosition(0.35);
            servo2.setPosition(0.65);
            telemetry.addData("Arm Status:", "open");
            telemetry.update();
        } else if (gamepad1.x){
            servo.setPosition(0.1);
            servo2.setPosition(0.9);
            telemetry.addData("Arm Status:", "closed");
            telemetry.update();
        } else if (gamepad1.a){
            servo.setPosition(0.5);
            servo2.setPosition(0.5);
            telemetry.addData("Arm Status", "Grabbing");
            telemetry.update();
        }


    }

    @Override
    public void stop(){
        left.setPower(0);
        right.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }
}

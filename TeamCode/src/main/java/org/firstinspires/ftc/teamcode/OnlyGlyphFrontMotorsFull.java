package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.robotcontroller.internal.FieldPositionProgram.BalancingStone;

/**
 * Created by ethan on 1/26/18.
 */
@Autonomous
public class OnlyGlyphFrontMotorsFull extends LinearOpMode {
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

        while(opModeIsActive() && (armUp.getCurrentPosition() < (armUp.getTargetPosition() - 30))){
            telemetry.addData("arm up position", armUp.getCurrentPosition());
            telemetry.update();
        }

        if (BalancingStone == 1 || BalancingStone == 4){
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 3000);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 3000);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            frontLeft.setPower(0.6);
            frontRight.setPower(0.6);

            sleep(500);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 3000);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 3000);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            frontLeft.setPower(0.4);
            frontRight.setPower(0.4);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 2200);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 2200);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            servo.setPosition(servoOpenPos);
            servo2.setPosition(servo2OpenPos);

            sleep(1000);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 401);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 401);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }
        } else if (BalancingStone == 2 || BalancingStone == 3){
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 2700);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 2700);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            frontLeft.setPower(0.6);
            frontRight.setPower(0.6);

            sleep(500);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 3075);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 3075);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            frontLeft.setPower(0.4);
            frontRight.setPower(0.4);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 1700);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() - 1700);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }

            sleep(1000);

            servo.setPosition(servoOpenPos);
            servo2.setPosition(servo2OpenPos);

            sleep(1000);

            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 401);
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + 401);

            while (opModeIsActive() && (frontLeft.isBusy() && frontRight.isBusy())){
                telemetry.addData("front right current position", frontRight.getCurrentPosition());
                telemetry.addData("front left current position", frontLeft.getCurrentPosition());
                telemetry.update();
            }
        }

        requestOpModeStop();
    }
}

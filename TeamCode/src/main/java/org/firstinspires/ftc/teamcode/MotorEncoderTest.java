package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 12/28/17.
 */
@Autonomous
@Disabled
public class MotorEncoderTest extends LinearOpMode {
    private DcMotor armUp;

    public void runOpMode(){
        armUp = hardwareMap.get(DcMotor.class, "armUp");

        armUp.setPower(0.3);

        armUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("status", "initialized");

        waitForStart();

        armUp.setTargetPosition(1220);

        while(armUp.isBusy()){
            telemetry.addData("motor current position", armUp.getCurrentPosition());
        }
    }
}

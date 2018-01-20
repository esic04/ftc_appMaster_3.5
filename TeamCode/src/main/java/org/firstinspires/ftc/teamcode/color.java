package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

//ples work
@TeleOp
@Disabled
public class color extends OpMode {
    ColorSensor color;
    float rgbValues[];

    @Override
    public void init(){
        rgbValues = new float[10];
        color = hardwareMap.get(ColorSensor.class, "color");
        color.enableLed(true);
        telemetry.addData("status", "Initialized");


    }
    @Override
    public void loop(){
        Color.RGBToHSV(color.red()*8, color.green()*8, color.blue()*8, rgbValues);
        telemetry.addData("hue", rgbValues[0]);
        telemetry.addData("saturation", rgbValues[1]);
        telemetry.addData("value", rgbValues[2]);

        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);

        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, rgbValues));
            }
        });
    }
}

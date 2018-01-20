package org.firstinspires.ftc.robotcontroller.internal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qualcomm.ftcrobotcontroller.R;

public class FieldPositionProgram extends Activity {
    public static int BalancingStone;


    private TextView chosenText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_position_program);
        Button buttonRedBottom = (Button) findViewById(R.id.button_red_bottom);
        Button buttonRedTop = (Button) findViewById(R.id.button_red_top);
        Button buttonBlueTop = (Button) findViewById(R.id.button_blue_top);
        Button buttonBlueBottom = (Button) findViewById(R.id.button_blue_bottom);

        Button buttonSet = (Button)findViewById(R.id.button_set);

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("POSITION", FieldPositonData.fieldPostion);
                setResult(Activity.RESULT_OK,resultIntent);
                finish();

            }
        });
        chosenText = (TextView) findViewById(R.id.textView_selected);
        buttonRedBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldPositonData.fieldPostion = FieldPositonData.FieldPostion.RED_BOTTOM;
                updateChosenText();
                BalancingStone = 4;
            }
        });
        buttonRedTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldPositonData.fieldPostion = FieldPositonData.FieldPostion.RED_TOP;
                updateChosenText();
                BalancingStone = 2;
            }
        });
        buttonBlueTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldPositonData.fieldPostion = FieldPositonData.FieldPostion.BLUE_TOP;
                updateChosenText();
                BalancingStone = 1;
            }
        });
        buttonBlueBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldPositonData.fieldPostion = FieldPositonData.FieldPostion.BLUE_BOTTOM;
                updateChosenText();
                BalancingStone = 3;
            }
        });

        updateChosenText();
    }


    private void updateChosenText(){

        switch(FieldPositonData.fieldPostion){
            case RED_BOTTOM:
                chosenText.setText("Red Bottom");
                chosenText.setTextColor(Color.RED);
                BalancingStone = 4;
                break;
            case RED_TOP:
                chosenText.setText("Red Top");
                chosenText.setTextColor(Color.RED);
                BalancingStone = 2;
                break;
            case BLUE_BOTTOM:
                chosenText.setText("Blue Bottom");
                chosenText.setTextColor(Color.BLUE);
                BalancingStone = 3;
                break;
            case BLUE_TOP:
                chosenText.setText("Blue Top");
                chosenText.setTextColor(Color.BLUE);
                BalancingStone = 1;
                break;

        }

    }



}

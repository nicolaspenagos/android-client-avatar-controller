/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ControllerActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        //Background animation
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        rightButton = findViewById(R.id.rightButton);
        leftButton = findViewById(R.id.leftButton);

        upButton.setOnTouchListener(this);
        downButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);
        leftButton.setOnTouchListener(this);

    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
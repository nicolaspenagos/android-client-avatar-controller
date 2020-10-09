/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.android_client_avatar_controller.model.Direction;
import com.example.android_client_avatar_controller.model.Dirs;
import com.example.android_client_avatar_controller.model.RandomColor;
import com.google.gson.Gson;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ControllerActivity extends AppCompatActivity implements View.OnTouchListener, OnMessageListener {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;
    private Button colorButton;

    // -------------------------------------
    // Global assets
    // -------------------------------------
    private Gson gson;
    private TCPConnection tcp;

    // -------------------------------------
    // Global variables
    // -------------------------------------
    private boolean arrowKeyPressed;

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

        gson = new Gson();
        tcp = TCPConnection.getInstance();
        tcp.setObserver(this);

        arrowKeyPressed = false;

        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        rightButton = findViewById(R.id.rightButton);
        leftButton = findViewById(R.id.leftButton);
        colorButton = findViewById(R.id.colorButton);

        upButton.setOnTouchListener(this);
        downButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);
        leftButton.setOnTouchListener(this);
        colorButton.setOnTouchListener(this);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int option;
        switch (v.getId()){

            case R.id.upButton:

                option = event.getAction();

                if(option==MotionEvent.ACTION_DOWN){

                    arrowKeyPressed = true;
                    moveThread(Dirs.UP);
                    upButton.setBackgroundResource(R.drawable.up_arrow_pressed);

                }else if(option==MotionEvent.ACTION_UP){

                    arrowKeyPressed = false;
                    upButton.setBackgroundResource(R.drawable.up_arrow);

                }

                break;

            case R.id.downButton:

                option = event.getAction();

                if(option==MotionEvent.ACTION_DOWN){

                    arrowKeyPressed = true;
                    moveThread(Dirs.DOWN);
                    downButton.setBackgroundResource(R.drawable.down_arrow_pressed);

                }else if(option==MotionEvent.ACTION_UP){

                    downButton.setBackgroundResource(R.drawable.down_arrow);
                    arrowKeyPressed = false;

                }

                break;

            case R.id.leftButton:

                option = event.getAction();

                if(option==MotionEvent.ACTION_DOWN){

                    arrowKeyPressed = true;
                    moveThread(Dirs.LEFT);
                    leftButton.setBackgroundResource(R.drawable.left_arrow_pressed);

                }else if(option==MotionEvent.ACTION_UP){

                    leftButton.setBackgroundResource(R.drawable.left_arrow);
                    arrowKeyPressed = false;

                }

                break;

            case R.id.rightButton:

                option = event.getAction();

                if(option==MotionEvent.ACTION_DOWN){

                    arrowKeyPressed = true;
                    moveThread(Dirs.RIGHT);
                    rightButton.setBackgroundResource(R.drawable.right_arrow_pressed);

                }else if(option==MotionEvent.ACTION_UP){

                    rightButton.setBackgroundResource(R.drawable.right_arrow);
                    arrowKeyPressed = false;

                }

                break;

            case R.id.colorButton:

                option = event.getAction();

                if(option==MotionEvent.ACTION_DOWN){

                    colorButton.setBackgroundResource(R.drawable.change_ramdon_color_pressed);

                    String id = UUID.randomUUID().toString();
                    int r = ThreadLocalRandom.current().nextInt(0, 255 + 1);
                    int g = ThreadLocalRandom.current().nextInt(0, 255 + 1);
                    int b = ThreadLocalRandom.current().nextInt(0, 255 + 1);
                    String description = "Random color for the avatar";

                    RandomColor randomColor = new RandomColor(id, r, g, b, description);

                    String json = gson.toJson(randomColor);
                    tcp.sendMessage(json);

                }else if(option==MotionEvent.ACTION_UP){
                    colorButton.setBackgroundResource(R.drawable.change_color);
                }

                break;
        }

        return true;
    }

    @Override
    public void onMessage(String msg) {

    }

    // -------------------------------------
    // Logic methods
    // -------------------------------------
    public void moveThread(Dirs dirs){

        new Thread(
                ()->{

                    try {
                        while(arrowKeyPressed){

                            move(dirs);
                            Thread.sleep(150);

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }

    public void move(Dirs dirs){

        String id, description, json;
        int dir;
        Direction direction;

        switch (dirs){

            case UP:

                id = UUID.randomUUID().toString();
                dir = 0;
                description = "Direction for the movement of the avatar";

                direction = new Direction(id,dir,description);
                json = gson.toJson(direction);
                tcp.sendMessage(json);
                Log.e(">>>", json);
                break;

            case DOWN:

                id = UUID.randomUUID().toString();
                dir = 1;
                description = "Direction for the movement of the avatar";

                direction = new Direction(id,dir,description);
                json = gson.toJson(direction);
                tcp.sendMessage(json);
                Log.e(">>>", json);
                break;

            case RIGHT:

                id = UUID.randomUUID().toString();
                dir = 2;
                description = "Direction for the movement of the avatar";

                direction = new Direction(id,dir,description);
                json = gson.toJson(direction);
                tcp.sendMessage(json);
                Log.e(">>>", json);
                break;

            case LEFT:

                id = UUID.randomUUID().toString();
                dir = 3;
                description = "Direction for the movement of the avatar";

                direction = new Direction(id,dir,description);
                json = gson.toJson(direction);
                tcp.sendMessage(json);
                Log.e(">>>", json);
                break;

        }

    }

}
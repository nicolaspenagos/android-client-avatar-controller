/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_client_avatar_controller.model.Name;
import com.google.gson.Gson;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements OnMessageListener{

    // -------------------------------------
    // XML references
    // -------------------------------------
    private EditText nicknameEditText;
    private Button okButton;

    // -------------------------------------
    // Global assets
    // -------------------------------------
    private Gson gson;
    private TCPConnection tcp;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Background animation
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        gson = new Gson();
        tcp = TCPConnection.getInstance();
        tcp.setObserver(this);

        nicknameEditText = findViewById(R.id.nicknameEditText);
        okButton = findViewById(R.id.okButton);

        okButton.setOnClickListener(
                (view)->{

                    String nickname = nicknameEditText.getText().toString();
                    if( nickname!=null && !nickname.equals("") ){

                        String id = UUID.randomUUID().toString();
                        String description = "Is the nickname for the avatar";

                        Name name = new Name(id, nickname, description);
                        String json = gson.toJson(name);
                        
                        tcp.sendMessage(json);

                        Intent i = new Intent(this, ControllerActivity.class);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(this, "The nickname can't be empty", Toast.LENGTH_SHORT).show();
                    }

                }
        );

    }

    // -------------------------------------
    // TCP Methods
    // -------------------------------------
    @Override
    public void onMessage(String msg) {

    }

}
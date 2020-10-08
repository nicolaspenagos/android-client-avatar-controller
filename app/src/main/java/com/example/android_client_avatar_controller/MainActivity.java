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

public class MainActivity extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private EditText nicknameEditText;
    private Button okButton;

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

        nicknameEditText = findViewById(R.id.nicknameEditText);
        okButton = findViewById(R.id.okButton);

        okButton.setOnClickListener(
                (view)->{

                    String nickname = nicknameEditText.getText().toString();
                    if( nickname!=null && !nickname.equals("") ){

                        Intent i = new Intent(this, ControllerActivity.class);
                        i.putExtra("nickname", nickname);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(this, "The nickname can't be empty", Toast.LENGTH_SHORT).show();
                    }

                }
        );
        
    }
}
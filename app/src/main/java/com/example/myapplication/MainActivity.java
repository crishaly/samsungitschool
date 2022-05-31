package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startbt;
    Button exit;
    ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = (ImageView)findViewById(R.id.images);
        startbt = (Button) findViewById(R.id.startbt);
        exit = (Button)findViewById(R.id.exit);
        startbt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startbt:
                Intent intent = new Intent(this, game.class);
                startActivity(intent);
                break;
            case R.id.exit:{
                finish();
                break;}

            default:
                break;
        }
    };
    }

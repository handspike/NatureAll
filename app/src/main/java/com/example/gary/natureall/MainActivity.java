package com.example.gary.natureall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSearchAnimalClick(View view) {
    }

    public void onSearchPlantClick(View view) {
    }

    public void onUploadPictureClick(View view) {
        Intent getUploadPictureIntent = new Intent(this, uploadPicScreen.class);
        final int result = 1;
        getUploadPictureIntent.putExtra("callingActivity", "MainActivity");
        startActivity(getUploadPictureIntent);
    }


}

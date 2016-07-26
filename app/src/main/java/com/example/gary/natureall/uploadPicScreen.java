package com.example.gary.natureall;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import java.io.IOException;

/**
 * Created by Gary on 21/07/2016.Go Me
 */
public class uploadPicScreen extends AppCompatActivity {
    ImageView ivImage;

    static final int REQUEST_IMAGE_CAPTURE = 144;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Display the uploadPicScreen View
        setContentView(R.layout.upload_picture_layout);
        //Get the info about what activity has called this activity
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);
        //Display the info on which activity has called this one
        callingActivityMessage.append(" "+ previousActivity);
        //Set up the imageView for launching the camera and the area for displaying the picture taken
        ImageView ivCamera = (ImageView) findViewById(R.id.ivCamera);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        if(! hasCamera())
            ivCamera.setEnabled(false);
    }



    //Disable the launch button if the device has no camera.

//Check if device has camera
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
//Launch the camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass the result to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

    }


    //If you want to return to the image captured
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            ivImage.setImageBitmap(photo);
        }
    }
//Return to main activity screen
    public void onReturnBtnClick(View view) {
        Intent goingBack = new Intent();
        setResult(RESULT_OK, goingBack);
        finish();
    }





}

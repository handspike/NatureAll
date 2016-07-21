package com.example.gary.natureall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gary on 21/07/2016.Go Me
 */
public class uploadPicScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_picture_layout);
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("CallingActivity");
        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);
        callingActivityMessage.append(" "+ previousActivity);


    }
    public void onReturnBtnClick(View view) {
        Intent goingBack = new Intent();
        setResult(RESULT_OK, goingBack);
        finish();
    }
}

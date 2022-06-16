package com.example.shakeflashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button onButton;
    Button offButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onButton = findViewById(androidx.appcompat.R.id.on);
        offButton = findViewById(androidx.appcompat.R.id.off);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    torchOn();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    torchOff();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void torchOn() throws CameraAccessException {
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = camManager.getCameraIdList()[0];
        camManager.setTorchMode(cameraId, true);
    }
    private void torchOff() throws CameraAccessException {
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = camManager.getCameraIdList()[0];
        camManager.setTorchMode(cameraId, false);
    }
}
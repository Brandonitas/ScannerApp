package com.example.brandon.scanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class PermissionActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        //Fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button = findViewById(R.id.buttonPermission);
        verifyPermissions();

    }

    public void buttonPermission(View v){
        String[] permission = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(PermissionActivity.this,permission,REQUEST_CODE);
    }

    private void verifyPermissions(){
        Log.d("PermissionActivity", "asking user for permission");
        String[] permission = {Manifest.permission.CAMERA};
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),permission[0]) == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(PermissionActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }
}

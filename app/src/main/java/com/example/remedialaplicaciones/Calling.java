package com.example.remedialaplicaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;

public class Calling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        Intent call = getIntent();
        String num = call.getStringExtra("number");
        if(ContextCompat.checkSelfPermission(Calling.this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1987);
        }
        else{
            calling(num);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void calling(num) {
        Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num));
        startActivity(call);
    }
}
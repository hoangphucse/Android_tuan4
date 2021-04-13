package com.example.tiki_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  SendingData{

    TextView tvThanhTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhTien=this.findViewById(R.id.txThanhTien);


        getSupportFragmentManager().beginTransaction().add(R.id.frmBelow,Below_frangment.newInstance("0")).commit();

    }

    @Override
    public void SendData(String data) {
        tvThanhTien.setText(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.frmBelow,Below_frangment.newInstance(data)).commit();
    }
}
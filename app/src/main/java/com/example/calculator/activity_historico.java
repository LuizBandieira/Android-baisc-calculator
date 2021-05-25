package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_historico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        Intent main = getIntent();
        String historico = main.getStringExtra("historico");
        TextView txtHistorico = (TextView) findViewById(R.id.txtHistorico);
        txtHistorico.setText(historico);
    }

    public void voltar(View view)
    {
        finish();
    }
}
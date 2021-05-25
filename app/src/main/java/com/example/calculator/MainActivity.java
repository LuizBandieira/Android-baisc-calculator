package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double value;
    private TextView display;
    private int decPosition;
    private double primeiroValor;
    private String operacao;
    private historico txtHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value = 0;
        display = findViewById(R.id.txtValor);
        decPosition = 0;
        txtHistorico = new historico();
        operacao = "";
    }

    public void acessarHistorico(View view)
    {
        Intent historico = new Intent(getBaseContext(), activity_historico.class);
        historico.putExtra("historico", txtHistorico.getHistorico());
        startActivity(historico);
    }

    private void updateValue()
    {
        if( ( value % 1 ) == 0 ) {
            int semPonto;
            semPonto = (int) value;
            display.setText(String.valueOf(semPonto));
        }
        else
            display.setText(String.valueOf(value));

    }

    public void botaoNumerico(View view)
    {
        Button button = (Button) view;
        if(operacao == "=")
        {
            value = 0;
            operacao = "";
        }
        if ( decPosition == 0)
        {
            value *= 10;
            value += Double.parseDouble(button.getText().toString());
        }
        else
        {
            value += Double.parseDouble(button.getText().toString()) / Math.pow(10, decPosition);
            decPosition++;
        }

        updateValue();
    }

    public void botaoPonto(View view)
    {
        if (decPosition < 1)
            decPosition = 1;
    }

    public void botaoOperacao(View view)
    {
        Button button = (Button) view;
        if(operacao == "" || operacao == "=")
        {
            primeiroValor = value;
            value = 0;
            updateValue();
            txtHistorico.adicionarValor(String.valueOf(primeiroValor));
        }
        operacao = button.getText().toString();
    }

    public void botaoCalcular(View view)
    {
        txtHistorico.adicionarValor(operacao + " " + value);
        switch (operacao)
        {
            case "+":
                value += primeiroValor;
                break;
            case "-":
                value = primeiroValor - value;
                break;
            case "*":
                value *= primeiroValor;
                break;
            case "/":
                value = primeiroValor / value;
                break;
        }
        updateValue();
        txtHistorico.adicionarValor("= " + value);
        txtHistorico.adicionarSeparador();
        operacao = "=";
    }

    public void botaoLimpar(View view)
    {
        primeiroValor = 0;
        value = 0;
        operacao = "";
        display.setText("");
        txtHistorico.limpar();
    }

}
package com.example.david.imc_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso, mCampoEstatura;
    private Button VBotonCalcular, VBotonLimpiar;
    private TextView mEtiquetaImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCampoPeso = (EditText)findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText)findViewById(R.id.campo_estatura);
        VBotonCalcular = (Button)findViewById(R.id.boton_calcular);
        VBotonLimpiar = (Button)findViewById(R.id.btnClear);
        mEtiquetaImc = (TextView)findViewById(R.id.etiqueta_imc);

    }
    public void CalculaIMC (View v) {
        String s = mCampoPeso.getText().toString();
        double peso = Double.parseDouble(s);
        s = mCampoEstatura.getText().toString();
        double estatura = Double.parseDouble(s);
        double imc = peso / (estatura * estatura);
        s = String.format("%2.2f", imc);
        mEtiquetaImc.setText(s);
    }

    public void Limpiar(View v) {
        mCampoPeso.setText("");
        mCampoEstatura.setText("");
        mEtiquetaImc.setText("0.0");
    }
}

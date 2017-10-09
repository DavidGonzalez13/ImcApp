package com.example.david.imc_app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso, mCampoEstatura,calcular;
    private Button VBotonCalcular, VBotonLimpiar;
    private TextView mEtiquetaImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoPeso = (EditText) findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        VBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        VBotonLimpiar = (Button) findViewById(R.id.btnClear);
        mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);
        calcular = (EditText) findViewById(R.id.calcular);

        VBotonCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                double peso = getValueFromEdittext(mCampoPeso);
                double estatura = getValueFromEdittext(mCampoEstatura);
                double imc = peso / (estatura * estatura);
                mEtiquetaImc.setText(Double.toString(imc));


                if (imc < 18.5) {
                    calcular.setText("Peso bajo");

                } else {
                    if (imc < 24.99) {
                        calcular.setText("Peso Normal");
                    } else {
                        if (imc < 29.99) {
                            calcular.setText("sobre Peso");
                        } else {
                            if (imc < 39.99) {
                                calcular.setText("Obecidad");
                            } else {
                                if (imc > 40.00) {
                                    calcular.setText("Obecidad Extrema");
                                }
                            }
                        }
                    }
                }

            }

        });




        VBotonLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
                     public void onClick (View v){
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
            }});


    }

    private double getValueFromEdittext(EditText editPeso) {
        String s = editPeso.getText().toString();
        double value = Double.parseDouble(s);
        return value;
    }

    }

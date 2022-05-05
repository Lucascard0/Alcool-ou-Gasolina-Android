package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText EditPrecoAlcool, EditPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditPrecoAlcool     = findViewById(R.id.EditPrecoAlcool);
        EditPrecoGasolina   = findViewById(R.id.EditPrecoGasolina);
        textResultado   = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){
        //Recuperar os valores inseridos
        String precoAlcool = EditPrecoAlcool.getText().toString();
        String precoGasolina = EditPrecoGasolina.getText().toString();

        //Validar os capos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            //Convertendo String para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            double resultado = valorAlcool/valorGasolina;
            if(resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina!");
            } else {
                textResultado.setText("Melhor utilizar Alcool!");
            }

        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        //Validar os capos digitados
        Boolean camposValidados = true;

        if (pAlcool == null || pGasolina.equals("")){
            camposValidados = false;
        } else if(pGasolina == null || pAlcool.equals("")){
            camposValidados = false;
        }

        return camposValidados;

    }
}
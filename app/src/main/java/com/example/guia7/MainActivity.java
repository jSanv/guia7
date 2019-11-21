package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardjugar, cardver, carcorrrecta, carddatos;
    Button misdatos, jugar,verpuntos,verrespuesta;

    public static int numeroaleatorio;

    //claves de recuperacion
    public static final String clavepuntaje="clavepuntaje";
    public static final String clavenombredatos="datos";

    //para la persistencia
    private SharedPreferences puntajeshared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnjugar, btnmisdatos, btnvariable, btnpuntajes;

        cardjugar = findViewById(R.id.cardjugar);
        cardver = findViewById(R.id.cardver);
        carcorrrecta = findViewById(R.id.cardcorrecta);
        carddatos = findViewById(R.id.carddatos);

        cardjugar.setOnClickListener(this);
        cardver.setOnClickListener(this);
        carcorrrecta.setOnClickListener(this);
        carddatos.setOnClickListener(this);


        //control de persistencia
        puntajeshared = getSharedPreferences(clavenombredatos,MODE_PRIVATE);

    //asignando el valor del numero sin que pierda su numero
        if(numeroaleatorio>0)
        {

        }
        else
        {
            numeroaleatorio = (int) (Math.random()*10+1);
        }


    }

    @Override
    public void onClick(View view) {



        switch (view.getId())
        {
            case R.id.cardjugar:
            {
            Intent as = new Intent(this, com.example.guia7.jugar.class);
            startActivity(as);
                break;
            }


            case R.id.cardver:
            {
                Intent as = new Intent(this, verpuntaje.class);
                startActivity(as);
                break;
            }


            case R.id.cardcorrecta:
            {
                Intent as = new Intent(this, verrespuestacorrecta.class);
                startActivity(as);
                break;
            }

            case R.id.carddatos:
            {
                Intent as = new Intent(this, misdatos.class);
                startActivity(as);
                break;
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        //asignando el valor del numero sin que pierda su numero
        if(numeroaleatorio>0)
        {

        }
        else
        {
            numeroaleatorio = (int) (Math.random()*20+1);
        }

    }
}

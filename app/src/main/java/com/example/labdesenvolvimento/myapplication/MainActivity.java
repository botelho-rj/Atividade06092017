package com.example.labdesenvolvimento.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lista = (ListView) findViewById(R.id.lista);
        Button botaoSorteio = (Button) findViewById(R.id.button);

        final List<Integer> numeros = new ArrayList<Integer>();
        final List<Integer> numerosSorteados = new ArrayList<Integer>();
        final List<Integer> numerosPremiados = new ArrayList<Integer>();


        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numerosSorteados);
        lista.setAdapter(adapter);

        botaoSorteio.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //lista de numeros de 1 ate 60
                for (int i = 1; i <= 20; i++) {
                    numeros.add(i);
                }

                //Embaralhar os numeros:
                Collections.shuffle(numeros);

                //Nova lista com os 6 aleatórios sorteados

                for (int i = 0; i < 6; i++) {
                    numerosSorteados.add(numeros.get(i));
                    adapter.notifyDataSetChanged();
                }

                numerosPremiados.add(1);
                numerosPremiados.add(2);
                numerosPremiados.add(3);
                numerosPremiados.add(4);
                numerosPremiados.add(5);
                numerosPremiados.add(6);

                long valorPremiacao = 1000000;

                    if (numerosPremiados.containsAll(numerosSorteados)){
                        Toast.makeText(getApplicationContext(), "Parabéns você ganhou " + valorPremiacao, Toast.LENGTH_SHORT).show();

                    }else{
                        valorPremiacao += valorPremiacao;
                        Toast.makeText(getApplicationContext(), "Acumulado em " + valorPremiacao, Toast.LENGTH_SHORT).show();

                    }



            }




        });


    }



}

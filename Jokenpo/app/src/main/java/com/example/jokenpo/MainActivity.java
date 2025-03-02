package com.example.jokenpo;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.jokenpo.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        Criando o Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int[] escolhaUsuario = {0};

        binding.imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario[0] = 1;
            }
        });

        binding.imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario[0] = 2;
            }
        });

        binding.imgTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario[0] = 3;
            }
        });

        binding.btnJogar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int escolhaApp = random.nextInt(1, 4);
//                1 = pedra
//                2 = papel
//                3 = tesoura
                if (escolhaApp == 1) {
                    binding.imgEscolhaApp.setImageResource(R.drawable.pedra);
                } else if (escolhaApp == 2) {
                    binding.imgEscolhaApp.setImageResource(R.drawable.papel);
                } else if (escolhaApp == 3){
                    binding.imgEscolhaApp.setImageResource(R.drawable.tesoura);
                }

                if (escolhaUsuario[0] == 1) { // escolhaUsuario = pedra
                    binding.imgResultadoUsuario.setImageResource(R.drawable.pedra);
                    if (escolhaApp == 1) { // escolhaApp = pedra
                        binding.imgResultadoApp.setImageResource(R.drawable.pedra);
                        binding.txtResultado.setText("Empatou :(");
                    } else if (escolhaApp == 2) { // escolhaUsuario = papel
                        binding.imgResultadoApp.setImageResource(R.drawable.papel);
                        binding.txtResultado.setText("Você perdeu!"); // papel ganha de pedra
                    } else if (escolhaApp == 3) { // escolhaApp = tesoura
                        binding.imgResultadoApp.setImageResource(R.drawable.tesoura);
                        binding.txtResultado.setText("Você ganhou!!"); // pedra ganha de tesoura
                    }
                } else if (escolhaUsuario[0] == 2) { // escolhaUsuario = papel
                    binding.imgResultadoUsuario.setImageResource(R.drawable.papel);
                    if (escolhaApp == 1) { // escolhaApp = pedra
                        binding.imgResultadoApp.setImageResource(R.drawable.pedra);
                        binding.txtResultado.setText("Você ganhou!"); // papel ganha de pedra
                    } else if (escolhaApp == 2) { // escolhaApp = papel
                        binding.imgResultadoApp.setImageResource(R.drawable.papel);
                        binding.txtResultado.setText("Empatou :(");
                    } else if (escolhaApp == 3) { // escolhaApp = tesoura
                        binding.imgResultadoApp.setImageResource(R.drawable.tesoura);
                        binding.txtResultado.setText("Você perdeu!"); // tesoura ganha de papel
                    }
                } else if (escolhaUsuario[0] == 3) { // escolhaUsuario = tesoura
                    binding.imgResultadoUsuario.setImageResource(R.drawable.tesoura);
                    if (escolhaApp == 1) { // escolhaApp = pedra
                        binding.imgResultadoApp.setImageResource(R.drawable.pedra);
                        binding.txtResultado.setText("Você perdeu!"); // pedra ganha de tesoura
                    } else if (escolhaApp == 2) { //escolhaApp = papel
                        binding.imgResultadoApp.setImageResource(R.drawable.papel);
                        binding.txtResultado.setText("Você ganhou!"); // tesoura ganha de papel
                    } else if (escolhaApp == 3) { // escolhaApp = tesoura
                        binding.imgResultadoApp.setImageResource(R.drawable.tesoura);
                        binding.txtResultado.setText("Empatou :(");
                    } else {
                        Toast.makeText(MainActivity.this, "Selecione uma opção antes de jogar!", Toast.LENGTH_SHORT).show();
                    }
                }
                escolhaUsuario[0] = 0;
            }
        });
    }
}
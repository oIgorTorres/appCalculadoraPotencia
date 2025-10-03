package br.ulbra.app1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtPotencia, txtTempo, txtPreco;
    Button btnCalcular;
    TextView txtResp, txtResp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtPotencia = findViewById((R.id.txtPotencia));
        txtTempo = findViewById((R.id.txtTempo));
        txtPreco = findViewById((R.id.txtPreco));
        btnCalcular = findViewById((R.id.btnCalcular));
        txtResp = findViewById((R.id.txtResp));
        txtResp2 = findViewById((R.id.txtResp2));


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double consumoEnergia, custoEnergia, potencia, tempo, preco;

                potencia = Double.parseDouble(txtPotencia.getText().toString());
                tempo = Double.parseDouble(txtTempo.getText().toString());
                preco = Double.parseDouble(txtPreco.getText().toString());

                consumoEnergia = potencia * tempo / 1000;
                custoEnergia = consumoEnergia * preco;

                txtResp.setText("O consumo de energia em quilowatts/hora será de: " +consumoEnergia);
                txtResp2.setText("O custo de energia será de: " +custoEnergia);




            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
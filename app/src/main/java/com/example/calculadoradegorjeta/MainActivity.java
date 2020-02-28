package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private double porcentagem = 0;
  private EditText editValor;
  private TextView textGorjeta, textPorcentagem, textTotal;



  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editValor = findViewById(R.id.editValor);
    textGorjeta = findViewById(R.id.textGorjeta);
    textPorcentagem = findViewById(R.id.textPorcentagem);
    textTotal = findViewById(R.id.textTotal);
    SeekBar seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

    //
    seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener( ) {
      @Override
      public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
        porcentagem = progress;
        textPorcentagem.setText(String.format("%s%%", String.valueOf(Math.round(porcentagem))));

        calcular();

      }

      @Override
      public void onStartTrackingTouch (SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch (SeekBar seekBar) {

      }
    });
  }

  private void calcular () {
    String valorRecuperado = editValor.getText().toString();
    if(valorRecuperado.isEmpty()){
      Toast.makeText(this, "Digite um valor primeiro!", Toast.LENGTH_SHORT).show( );
    }else {
      double valorDigitado = Double.parseDouble(valorRecuperado);
      double gorjeta = valorDigitado * (porcentagem/100);
      double total = gorjeta + valorDigitado;
      textGorjeta.setText(String.format("R$ %s", Math.round(gorjeta)));
      textTotal.setText(String.format("R$ %s", Math.round(total)));
    }

  }


}

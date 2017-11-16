package aprendabrincando.edvanmatta.com.aprendabrincando;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class ObjetoDiferente extends AppCompatActivity{

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private  EditText input;

    private int contador;
    private int pontosAcertos;
    private int pontosErros;
    private int idView;
    private int ACERTOS = 1;
    private int ERROS = 1;

    private MediaPlayer som;
    public void tocarMusica() {
        if (som != null) {
            som.start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto_diferente);

        img1 = (ImageView)findViewById(R.id.img1Id);
        img2 = (ImageView) findViewById(R.id.img2Id);
        img3 = (ImageView) findViewById(R.id.img3Id);
        img4 = (ImageView) findViewById(R.id.img4Id);

        idView = numAletorio();
        imagemView(idView);
        pontuacaoJogo(pontosAcertos, pontosErros);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idView == 3) {
                    Toast.makeText(ObjetoDiferente.this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.ac);
                    tocarMusica();
                    imagemView(numAletorio());
                    pontosAcertos += ACERTOS;
                    contador ++;
                }else {
                    vibrar();
                    Toast.makeText(ObjetoDiferente.this, "Você Errou!", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.er);
                    tocarMusica();
                    pontosErros += ERROS;
                    contador ++;
                }
                if (pontosErros >= 5)
                    pontuacaoJogo(pontosAcertos, pontosErros);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idView == 1) {
                    Toast.makeText(ObjetoDiferente.this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.ac);
                    tocarMusica();
                    imagemView(numAletorio());
                    pontosAcertos += ACERTOS;
                    contador ++;
                }else {
                    vibrar();
                    Toast.makeText(ObjetoDiferente.this, "Você Errou!", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.er);
                    tocarMusica();
                    pontosErros += ERROS;
                    contador ++;
                }
                if (pontosErros >= 5)
                    pontuacaoJogo(pontosAcertos, pontosErros);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idView == 2) {
                    Toast.makeText(ObjetoDiferente.this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.ac);
                    tocarMusica();
                    imagemView(numAletorio());
                    pontosAcertos += ACERTOS;
                    contador ++;
                }else {
                    vibrar();
                    Toast.makeText(ObjetoDiferente.this, "Você Errou!", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.er);
                    tocarMusica();
                    pontosErros += ERROS;
                    contador ++;
                }
                if (pontosErros >= 5)
                    pontuacaoJogo(pontosAcertos, pontosErros);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idView == 0) {
                    Toast.makeText(ObjetoDiferente.this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.ac);
                    tocarMusica();
                    imagemView(numAletorio());
                    pontosAcertos += ACERTOS;
                    contador ++;
                }else {
                    vibrar();
                    Toast.makeText(ObjetoDiferente.this, "Você Errou!", Toast.LENGTH_SHORT).show();
                    som = MediaPlayer.create(ObjetoDiferente.this, R.raw.er);
                    tocarMusica();
                    pontosErros += ERROS;
                    contador ++;
                }
                if (pontosErros >= 5)
                    pontuacaoJogo(pontosAcertos, pontosErros);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contador = 0;
        pontosAcertos = 0;
        pontosErros = 0;
    }

    int numAletorio(){
        Random randomico = new Random();
        int num = randomico.nextInt(4);
        return  num;
    }

    private void imagemView(int rand){
        switch (rand){
            case 0:
                img1.setImageResource(R.drawable.menina_balao);
                img2.setImageResource(R.drawable.menina_balao);
                img3.setImageResource(R.drawable.menina_balao);
                img4.setImageResource(R.drawable.menina_bombole);
                break;
            case 1:
                img1.setImageResource(R.drawable.poligono_azul);
                img2.setImageResource(R.drawable.poligono_verm);
                img3.setImageResource(R.drawable.poligono_azul);
                img4.setImageResource(R.drawable.poligono_azul);
                break;
            case 2:
                img1.setImageResource(R.drawable.brincando_boneca);
                img2.setImageResource(R.drawable.brincando_boneca);
                img3.setImageResource(R.drawable.brincando_guerra);
                img4.setImageResource(R.drawable.brincando_boneca);
                break;
            case 3:
                img1.setImageResource(R.drawable.cao1);
                img2.setImageResource(R.drawable.cao2);
                img3.setImageResource(R.drawable.cao2);
                img4.setImageResource(R.drawable.cao2);
                break;
            default:
        }
        idView = rand;
    }

    private void pontuacaoJogo(final int acertos, final int erros){
        if (contador >= 5) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aprenda Brincando");
            builder.setMessage("Digite o seu nome");
            input = new EditText(this);
            builder.setView(input).toString();
            builder.setNeutralButton("Enviar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String nome = input.getText().toString();
                    Intent i = new Intent(ObjetoDiferente.this, Score.class);
                    i.putExtra("nome", nome);
                    i.putExtra("jogo", "Encontre o Objeto Diferente");
                    i.putExtra("pontosAcertos", acertos);
                    i.putExtra("pontosErros", erros);
                    startActivity(i);
                    finish();
                }
            });
            AlertDialog alerta = builder.create();
            alerta.show();
        }
    }

    public void vibrar(){
        Vibrator vibra = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long tempo = 100; //100 milissegundos
        vibra.vibrate(tempo);
    }
}

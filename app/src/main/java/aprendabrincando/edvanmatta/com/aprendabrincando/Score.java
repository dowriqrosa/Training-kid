package aprendabrincando.edvanmatta.com.aprendabrincando;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    private TextView nome;
    private TextView nomeJogo;
    private TextView pontosAcertos;
    private TextView pontosErros;
    private Button   botaoVoltar;
    private int saldoPontos;
    String jogo;
    String nomeExtra;
    String pontosA;
    String pontosE;
    int i;


    private static final String ARQUIVOPREFERENCIAS = "Preferencias";
//    private static final String DATABASE = "bd_app";
//    private static final String TABELA = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        nome = (TextView) findViewById(R.id.txtNomeID);
        nomeJogo = (TextView) findViewById(R.id.txtNomeJogoID);
        pontosAcertos = (TextView) findViewById(R.id.txtPontoAID);
        pontosErros = (TextView) findViewById(R.id.txtPontoEID);
        botaoVoltar = (Button) findViewById(R.id.botaoVoltarID);

        Intent it = getIntent();
        jogo = it.getStringExtra("jogo");
        nomeExtra = it.getStringExtra("nome");
        pontosA = Integer.toString(it.getIntExtra("pontosAcertos", 0));
        pontosE = Integer.toString(it.getIntExtra("pontosErros", 0));

        saldoPontos =  Integer.parseInt(pontosA) - Integer.parseInt(pontosE);

        nomeJogo.setText(jogo);
        nome.setText(nomeExtra);
        pontosAcertos.setText(pontosA);
        pontosErros.setText(pontosE);

        i = nome_jogo(jogo);

        try {
//            SQLiteDatabase bancoDados = openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);
//            String dll = "CREATE TABLE IF NOT EXISTS score (id INT PRIMARY KEY AUTOINCREMENT NOT NULL , nome_jogo VARCHAR, nome VARCHAR, pontuacao INT(3))";
//            String dml ="INSERT INTO" + TABELA + "( nome_jogo, nome, pontuacao) VALUES (Jogo_" + i + " ," + nomeExtra + ", " + saldoPontos + ")";
//
//            bancoDados.execSQL(dll);
//            bancoDados.execSQL(dml);

        }catch (Exception e){
            e.printStackTrace();
        }



        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferencias = getSharedPreferences(ARQUIVOPREFERENCIAS, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                if (nomeJogo.getText().toString().equals("")){
                    Toast.makeText(Score.this,"Score não foi salvo", Toast.LENGTH_SHORT).show();
                }else {
                    editor.putString("jogo", "Jogo " + i );
                    editor.putString("jogador", nomeExtra);
                    editor.putInt("pontuacao",saldoPontos);
                    editor.commit();
                    //Log.i();
                    startActivity(new Intent(Score.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private int nome_jogo(String jogo){
        int num;
        if (jogo.equals("Que animal é esse?")){
            num = 1;
        }else if (jogo.equals("Encontre o Objeto Diferente")){
            num = 2;
        }else
            num = 3;
        return num;
    }
}

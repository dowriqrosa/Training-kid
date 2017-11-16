package aprendabrincando.edvanmatta.com.aprendabrincando;

import android.app.Activity;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoricoScores extends ListActivity {

    private static final String ARQUIVOPREFERENCIAS = "Preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_scores);
        List<Usuarios> lista = gerarUsuarios();
        final ListaJogaodorAdapter adaptador = new ListaJogaodorAdapter(this, lista);
        setListAdapter(adaptador);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Object o = this.getListAdapter().getItem(position);
        String item = o.toString();
        Toast.makeText(this, "Você selecionaou " + item, Toast.LENGTH_SHORT).show();
    }

    private List<Usuarios> gerarUsuarios() {
        SharedPreferences preferencias = getSharedPreferences(ARQUIVOPREFERENCIAS, MODE_PRIVATE);
        List<Usuarios> user = new ArrayList<Usuarios>();
        String jogo = preferencias.getString("jogo", "");
        String jogador = preferencias.getString("jogador", "");
        int pontuacao = preferencias.getInt("pontuacao", 0);
        user.add(criarUsuarios(jogo, jogador, pontuacao));

        return user;
    }

    private Usuarios criarUsuarios(String jogo, String jogador, int pontuacao) {
        Usuarios user = new Usuarios(jogo, jogador, pontuacao);
        return user;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

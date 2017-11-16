package aprendabrincando.edvanmatta.com.aprendabrincando;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Familia_Matta on 27/05/2017.
 */

public class ListaJogaodorAdapter extends ArrayAdapter<Usuarios> {

    private Context contexto;
    private List<Usuarios> score = null;

    public ListaJogaodorAdapter(Context contexto, List<Usuarios> score){
        super(contexto,0,score);
        this.score= score;
        this.contexto = contexto;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Usuarios user = score.get(position);
        if (view == null){
            view = LayoutInflater.from(contexto).inflate(R.layout.list_item_user, null);
        }
        TextView textoJogo = (TextView) view.findViewById(R.id.textView_jogo_id);
        TextView textoJogador = (TextView) view.findViewById(R.id.textView_jogador_id);
        TextView textoPontos = (TextView) view.findViewById(R.id.textView_pontuacao_id);

        textoJogo.setText(user.getJogo());
        textoJogador.setText(user.getJogador());
        textoPontos.setText(String.valueOf(user.getPontuacao()));
        return view;
    }
}

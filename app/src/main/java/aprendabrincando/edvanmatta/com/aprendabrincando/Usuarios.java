package aprendabrincando.edvanmatta.com.aprendabrincando;

import java.util.PriorityQueue;

/**
 * Created by Familia_Matta on 27/05/2017.
 */

public class Usuarios {
    private String jogo;
    private String jogador;
    private int pontuacao;

    public Usuarios(){}
    public Usuarios(String jogo, String jogador, int pontuacao){
        super();
        this.jogo = jogo;
        this.jogador = jogador;
        this.pontuacao = pontuacao;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return jogo;
    }
}

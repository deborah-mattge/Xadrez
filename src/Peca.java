import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;

    public void mover(Tabuleiro tabuleiro, Posicao posicao){
        ArrayList<Posicao>possiveisPosicoes=possiveisMovimento(tabuleiro);
        for(Posicao posicaoPossivel :possiveisPosicoes ){
            if(posicaoPossivel==posicao){
                //atribuindo a peça para nova posição no tabuleiro
                posicao.setPeca(this);
                //removendo a peça da posição anterior
                this.posicao.setPeca(null);
                //trocando a posição atual da peça
                this.posicao=posicao;
                break;
            }
        }
        this.posicao=posicao;

    }
    public abstract ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro);
   // public abstract char icone();


    public Posicao getPosicao() {
        return posicao;
    }
}

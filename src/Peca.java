import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;
    public Peca (String cor){
        this.cor=cor;
    }


    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if (posicao.getPeca() == null) {
            possiveisMovimentos.add(posicao);
            return false;

        } else {
            if (!posicao.getPeca().getCor().equals(this.getCor())) {
                possiveisMovimentos.add(posicao);
            }
            return true;
        }


    }

    public void mover(Tabuleiro tabuleiro, Posicao posicao) {
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimento(tabuleiro);
        for (Posicao posicaoPossivel : possiveisPosicoes) {
            if (posicaoPossivel == posicao) {
                //atribuindo a peça para nova posição no tabuleiro
                posicao.setPeca(this);
                //removendo a peça da posição anterior
                this.posicao.setPeca(null);
                //trocando a posição atual da peça
                this.posicao = posicao;
                break;
            }
        }
        this.posicao = posicao;

    }
    public boolean validaExtremidade(int posicaoNoTabuleiro){
        return posicaoNoTabuleiro%8==0;

    }

    public abstract ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro);
    // public abstract char icone();


    public Posicao getPosicao() {
        return posicao;
    }

    public String getCor() {
        return cor;
    }
}


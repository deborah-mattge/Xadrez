import java.util.ArrayList;

public class Rainha extends Peca {

    public Rainha(String cor, Posicao posicao){
        super(cor, posicao);
    }
    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = posicaoNoTabuleiro + 8;
             i < tabuleiro.getPosicoes().size();
             i += 8) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }
        for (int i = posicaoNoTabuleiro - 8;
             i >= tabuleiro.getPosicoes().size();
             i -= 8) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                64 : posicaoNoTabuleiro + 1);
             i < tabuleiro.getPosicoes().size();
             i++) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                -1 : posicaoNoTabuleiro - 1);
             i >= tabuleiro.getPosicoes().size();
             i--) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                64 : posicaoNoTabuleiro + 7);
             i < tabuleiro.getPosicoes().size();
             i += 7) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)||validaExtremidade( i)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                -1 : posicaoNoTabuleiro + 7);
             i >= tabuleiro.getPosicoes().size();
             i -= 7) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)||validaExtremidade( i+1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                64 : posicaoNoTabuleiro + 7);
             i < tabuleiro.getPosicoes().size();
             i += 9) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)||validaExtremidade( i+1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoNoTabuleiro)?
                -1:posicaoNoTabuleiro+7);
             i >=tabuleiro.getPosicoes().size();
             i-=9) {

            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)||validaExtremidade( i)){
                break;
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "D";
    }
}


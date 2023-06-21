import java.util.ArrayList;

public class Rei extends Peca{
    public Rei(String cor){
        super(cor);
    }

    private boolean primMov;

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();


        for(Posicao posicao : tabuleiro.getPosicoes()){
            int indice =tabuleiro.getPosicoes().indexOf(posicao);
            if(indice == posicaoNoTabuleiro-9 ||
                    indice == posicaoNoTabuleiro -7 ||
                    indice == posicaoNoTabuleiro -1 ||
                    indice == posicaoNoTabuleiro +1 ||
                    indice == posicaoNoTabuleiro +7 ||
                    indice == posicaoNoTabuleiro +8 ||
                    indice == posicaoNoTabuleiro +9){
                //coluna H
                if(validaExtremidade(posicaoNoTabuleiro+1)&& !(
                        indice== posicaoNoTabuleiro-7||
                                indice== posicaoNoTabuleiro+1||
                                indice== posicaoNoTabuleiro+9
                )){
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //coluna A
                else if(validaExtremidade(posicaoNoTabuleiro) && !(
                        indice == posicaoNoTabuleiro-9||
                        indice == posicaoNoTabuleiro-1 ||
                        indice == posicaoNoTabuleiro+7)){
                    verificaPeca(posicao, possiveisMovimentos);

                }

            }

        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Rei{" +
                "primMov=" + primMov +
                "} " + super.toString();
    }
}

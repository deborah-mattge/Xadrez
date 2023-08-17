


import java.util.ArrayList;

public class Cavalo extends Peca{
    public Cavalo(String cor, Posicao posicao){
        super(cor, posicao);
    }


    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos =new ArrayList<>();
        Posicao posicaoAtual=this.getPosicao();
        int posicaoNoTabuleiro =tabuleiro.getPosicoes().indexOf(posicaoAtual);
        for(Posicao posicao : tabuleiro.getPosicoes()) {

            int indice =tabuleiro.getPosicoes().indexOf(posicao);

            if(indice == posicaoNoTabuleiro -17||
                    indice == posicaoNoTabuleiro -15||
                    indice == posicaoNoTabuleiro -10||
                    indice == posicaoNoTabuleiro -6||
                    indice == posicaoNoTabuleiro +6||

                    indice == posicaoNoTabuleiro +10||
                    indice == posicaoNoTabuleiro +15||
                    indice == posicaoNoTabuleiro +17) {



                //coluna A
                 if(validaExtremidade(posicaoNoTabuleiro) ) {
                    if (!(indice == posicaoNoTabuleiro - 17 ||
                            indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro + 6 ||
                            indice == posicaoNoTabuleiro + 15)) {

                        verificaPeca(posicao, possiveisMovimentos);

                    }
                }

                //coluna B
                else if(validaExtremidade(posicaoNoTabuleiro-1)) {
                    if (!(indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro + 6
                    )) {

                        verificaPeca(posicao, possiveisMovimentos);

                    }
                }
                //coluna G
                else if(validaExtremidade(posicaoNoTabuleiro+2)) {



                    if (!(indice == posicaoNoTabuleiro +10 ||
                            indice == posicaoNoTabuleiro-6
                    )) {

                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                //coluna H
                else if (this.validaExtremidade(posicaoNoTabuleiro + 1)){

                    if (!(
                            indice == posicaoNoTabuleiro - 15 ||
                                    indice == posicaoNoTabuleiro - 6 ||
                                    indice == posicaoNoTabuleiro + 10 ||
                                    indice == posicaoNoTabuleiro + 17)) {
                        verificaPeca(posicao, possiveisMovimentos);

                    }
                }
                //não é de canto
                else{

                    verificaPeca(posicao, possiveisMovimentos);

                }

            }


        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        if (getCor().equals("Branco")) {
            return "C-B";
        } else if (getCor().equals("Preto")) {
            return "C-P";
        }

        return "R";
    }
}

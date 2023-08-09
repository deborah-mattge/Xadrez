


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
                     System.out.println("coluna B");
                    if (!(indice == posicaoNoTabuleiro - 10 ||
                            indice == posicaoNoTabuleiro + 6
                    )) {

                        verificaPeca(posicao, possiveisMovimentos);

                    }
                }
                //coluna G
                else if(validaExtremidade(posicaoNoTabuleiro+2)) {
                     System.out.println(indice);
                     System.out.println("coluna g ");


                    if (!(indice == posicaoNoTabuleiro +10 ||
                            indice == posicaoNoTabuleiro-6
                    )) {
                        System.out.println("entrouu");
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }
                //coluna H
                else if (this.validaExtremidade(posicaoNoTabuleiro + 1)){
                    System.out.println("coluna h");
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
                     System.out.println("else");
                    verificaPeca(posicao, possiveisMovimentos);

                }

            }


        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "C" ;
    }
}

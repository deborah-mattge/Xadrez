import java.util.ArrayList;

public class Cavalo extends Peca{

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
                    indice == posicaoNoTabuleiro -6||
                    indice == posicaoNoTabuleiro +10||
                    indice == posicaoNoTabuleiro +15||
                    indice == posicaoNoTabuleiro +17){
                //coluna H
                if((posicaoNoTabuleiro+1)%8==0 && !(
                        indice== posicaoNoTabuleiro-15||
                                indice== posicaoNoTabuleiro-6||
                                indice== posicaoNoTabuleiro+10||
                                indice== posicaoNoTabuleiro+17
                )){
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //coluna A
                else if((posicaoNoTabuleiro)%8==0 && !(indice == posicaoNoTabuleiro-17 ||
                        indice == posicaoNoTabuleiro-10||
                        indice == posicaoNoTabuleiro-+6 ||
                        indice == posicaoNoTabuleiro+15)){
                    verificaPeca(posicao, possiveisMovimentos);

                }
                //coluna B
                else if((posicaoNoTabuleiro-1)%8 ==0 && !(indice ==posicaoNoTabuleiro -10 ||
                        indice ==posicaoNoTabuleiro +6
                        )){
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //coluna G
                else if((posicaoNoTabuleiro+2)%8 ==0 && !(indice ==posicaoNoTabuleiro -15 ||
                        indice ==posicaoNoTabuleiro +17
                )){
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //não é de canto
                else{
                    verificaPeca(posicao, possiveisMovimentos);
                }

            }


        }
        return null;
    }

}

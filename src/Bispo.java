import java.util.ArrayList;

public class Bispo extends Peca{
    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual=this.getPosicao();
        int posicaoNoTabuleiro =tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos =new ArrayList<>();
       for (int i = (posicaoNoTabuleiro%8==0?
               64:posicaoNoTabuleiro+7);
            i <tabuleiro.getPosicoes().size();
 i+=7) {
           if(i%8==0 ==  verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
               break;
           }
       }
        for (int i = ((posicaoNoTabuleiro+1)%8==0 ?-1:posicaoNoTabuleiro+7); i >=tabuleiro.getPosicoes().size(); i-=7) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(i%8==0 ||  verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
                break;
            }
        }
        for (int i =  ((posicaoNoTabuleiro+1)%8==0 ?64:posicaoNoTabuleiro+7); i <tabuleiro.getPosicoes().size(); i+=9) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(i%8==0 ||  verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
                break;
            }
        }
        for (int i = (posicaoNoTabuleiro%8==0?-1:posicaoNoTabuleiro+7); i >=tabuleiro.getPosicoes().size(); i-=9) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(i%8==0 ||  verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
                break;
            }
        }


        /*for(Posicao posicao: tabuleiro.getPosicoes()){
            int cont = tabuleiro.getPosicoes().indexOf(posicao);
            if((cont-posicaoNoTabuleiro)%7==0
            ){
                possiveisMovimentos.add(posicao);
            }
            else if((cont-posicaoNoTabuleiro)%9==0){
                possiveisMovimentos.add(posicao);
            }
        }*/

        return possiveisMovimentos;
    }


        }

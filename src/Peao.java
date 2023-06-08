import java.util.ArrayList;

public class Peao extends Peca{
    private boolean primMov = true;

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos =new ArrayList<>();
        Posicao posicaoAtual=this.getPosicao();
        int posicaoNoTabuleiro =tabuleiro.getPosicoes().indexOf(posicaoAtual);
       if(this.getCor().equals("preto")){
           if(tabuleiro.getPosicoes().get(posicaoNoTabuleiro+8).getPeca()==null) {
               possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 8));
               if (this.primMov) {
                   if(tabuleiro.getPosicoes().get(posicaoNoTabuleiro+16).getPeca()==null){
                   possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 16));
               }}
           }
       }
        else{
           if(tabuleiro.getPosicoes().get(posicaoNoTabuleiro-8).getPeca()==null) {
               possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 8));
               if (this.primMov) {
                   if(tabuleiro.getPosicoes().get(posicaoNoTabuleiro-16).getPeca()==null){
                       possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 16));
                   }}
           }
           if(tabuleiro.getPosicoes().get(posicaoNoTabuleiro+9).getPeca().getCor().equals("Branco")){
               possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro+9));
           }
        }



        return possiveisMovimentos;
    }
}

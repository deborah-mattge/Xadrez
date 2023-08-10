import java.util.ArrayList;

public class Rei extends Peca{
    public Rei(String cor, Posicao posicao){
        super(cor, posicao);
    }

    private boolean primMov = true;

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();


        for(Posicao posicao : tabuleiro.getPosicoes()){

            int indice =tabuleiro.getPosicoes().indexOf(posicao);
            if(     indice == posicaoNoTabuleiro -8 ||
                    indice == posicaoNoTabuleiro-9 ||
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
                        indice == posicaoNoTabuleiro+7
                )){
                    verificaPeca(posicao, possiveisMovimentos);

                }
                else{
                    verificaPeca(posicao, possiveisMovimentos);

                }

            }

        }
        return possiveisMovimentos;
    }
    public ArrayList<Posicao> verificaXeque(Tabuleiro tabuleiro, ArrayList<Posicao> posicoesRei){
        boolean verificaXeque =false;
        ArrayList<Posicao> possivelXeque = new ArrayList<>();
        for(Posicao posicao : tabuleiro.getPosicoes()){

            if(posicao.getPeca()!=null && !(posicao.getPeca().getCor().equals(this.getCor()))) {


                ArrayList<Posicao> posicoesAtaque =posicao.getPeca().possiveisMovimento(tabuleiro);
                for (Posicao p : posicoesAtaque){
                    if(p.equals(this.getPosicao())){

                        possivelXeque.add(p);
                        verificaXeque=true;
                        break;
                    }
                }
            }
        }
        if(!(possivelXeque.size()>0)){
            return null;
        }
        System.out.println("pos"+possivelXeque);
        return possivelXeque;

    }
    public boolean isPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }


    @Override
    public String toString() {
        return "R";
    }
}

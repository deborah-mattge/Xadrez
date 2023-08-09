import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {

    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc= new Scanner(System.in);
    static boolean promover;
    static Jogador  jogadorDaVez;
    static  Jogador jogadorAdversario;

    public static void main(String[] args) {
        Jogador j1 =new Jogador("jorge","Senh@123");
        Jogador j2 =new Jogador("Wilson","wilson");

        j1.setCor("Branco",tabuleiro);
        j2.setCor("Preto", tabuleiro);
        jogadorDaVez=j1;
        jogadorAdversario=j2;
        int i=1;
        do {
            mostrarTabuleiro();
            System.out.println("escoha a peça que deseja movimenar: ");
            int escolhaPeca = sc.nextInt();
            if(!movimentar(escolhaPeca)){
                System.out.println("movimento inválido");
            }

        }while(i>0);


    }
    private static boolean validaVitoria(Jogador adversario){
        for(Peca peca : adversario.getPecas()){
            if(peca instanceof Rei){
                return false;
            }
        }
        return true;
    }

    public static boolean movimentar(int escolhaPeca) {
        Peca peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
        if (jogadorDaVez.getPecas().contains(peca)) {

            System.out.println(peca);
            //Escolha da posição para o movimento
            ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
            for(Posicao p : tabuleiro.getPosicoes()){
                if(p.getPeca() instanceof Rei) {
                    System.out.println(((Rei) p.getPeca()).verificaXeque(tabuleiro,p.getPeca().possiveisMovimento(tabuleiro)));

                }


            }
           for(Posicao posicao : posicoes){
               System.out.println("posição possivel: "+tabuleiro.getPosicoes().indexOf(posicao));
           }
            System.out.println("escolha a posição: ");
            int escolhaPosicao = sc.nextInt();
            Posicao posicaoMovimentar = tabuleiro.getPosicoes().get(escolhaPosicao);
            for (Posicao posicao : posicoes) {
                if (posicao.equals(posicaoMovimentar)) {
                    jogadorDaVez.moverPeca(peca, posicaoMovimentar, tabuleiro, jogadorAdversario);
                    if (peca instanceof Peao) {
                        ((Peao) peca).setPrimMov(false);
                        promover=((Peao) peca).promover(tabuleiro);
                        System.out.println(promover);
                        promocao(peca);
                    }


                    System.out.println(validaVitoria(jogadorAdversario));
                    return true;
                }

            }


        }
        return false;
    }
    public  static void promocao(Peca peca) {
        Peca pecaPromovida;
        if (promover) {
            System.out.println("""
                    Seu peão chegou ao fim do tabuleiro!
                    para qual peça deeja promove-lo?
                    1- Rainha 
                    2- Torre 
                    3 - Cavalo 
                    4 -Bispo 
                    """);
            int escolha = sc.nextInt();
            int indexPecaPromovida = tabuleiro.getPosicoes().indexOf(peca.getPosicao());

            switch (escolha) {
                case 1:
                    pecaPromovida = new Rainha(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    peca = pecaPromovida;

                    break;
                case 2:
                    pecaPromovida = new Torre(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    peca = pecaPromovida;

                    break;
                case 3:
                    pecaPromovida = new Cavalo(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    peca = pecaPromovida;

                    break;
                case 4:
                    pecaPromovida = new Bispo(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    peca = pecaPromovida;

                    break;

            }
            System.out.println(peca);


        }
    }

        public static void mostrarTabuleiro() {
            int pos = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (pos < tabuleiro.getPosicoes().size()) {
                        Peca peca = tabuleiro.getPosicoes().get(pos).getPeca();
                        if (peca != null) {
                            System.out.print("|" + peca + "| ");

                        } else {
                            System.out.print("| | ");

                        }
                        pos++;
                    } else {
                        System.out.print("         ");
                    }
                }
                System.out.println();
            }
            pos = 0;
        }


}



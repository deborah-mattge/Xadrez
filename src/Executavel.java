import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {

    static Tabuleiro tabuleiro = new Tabuleiro();
    static Scanner sc = new Scanner(System.in);
    static boolean promover;
    static Jogador jogadorDaVez;
    static Jogador jogadorAdversario;

    static ArrayList<Posicao> posicoesAjudam = new ArrayList<>();

    public static void main(String[] args) {
        Jogador j1 = new Jogador("jorge", "Senh@123", false);
        Jogador j2 = new Jogador("Wilson", "wilson", false);

        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto", tabuleiro);
        jogadorDaVez = j1;
        jogadorAdversario = j2;
        int i = 1;
        boolean a=true;
        do {
            a=true;
            System.out.println(jogadorDaVez.getPecas().get(12));
            mostrarTabuleiro();
           for(Peca peca: jogadorDaVez.getPecas() ){
               if(peca instanceof Rei){
                  if( ((Rei) peca).verificaXeque(tabuleiro)!=null){
                      System.out.println("Jogador: " + jogadorAdversario + "Você está em xeque!");
                      jogadorDaVez.setEstaEmXeque(true);
                      posicoesAjudam = verificaSalvarRei(peca);
                      System.out.println("setei true 1");
                      break;

                  }else{
                      System.out.println("vish entrei aq sem querer 1");
                      jogadorDaVez.setEstaEmXeque(false);
                  }

               }
           }
            for(Peca peca: jogadorAdversario.getPecas() ){
                if(peca instanceof Rei){
                    ((Rei) peca).verificaXeque(tabuleiro);
                    if( ((Rei) peca).verificaXeque(tabuleiro)!=null){
                        System.out.println("Jogador: " + jogadorAdversario + "Você está em xeque!");
                        posicoesAjudam = verificaSalvarRei(peca);
                        jogadorAdversario.setEstaEmXeque(true);
                        System.out.println("setei true");
                        break;

                    }else{
                        jogadorAdversario.setEstaEmXeque(false);
                        System.out.println("vish entrei aq sem querer");
                    }
                }
            }

            if(jogadorDaVez.isEstaEmXeque()){
                for (Posicao pFor : posicoesAjudam) {
                    System.out.println("peças que podem movintar: " + pFor.getPeca() + " " + tabuleiro.getPosicoes().indexOf(pFor));
                }
            }
            System.out.println("escolha a peça que deseja movimentar jogador "+jogadorDaVez.getCor()+": ");
            int escolhaPeca = sc.nextInt();
            if (!movimentar(escolhaPeca)) {
                a=false;
                System.out.println("movimento inválido");
            }
            if(a){
            if(jogadorDaVez.equals(j1)){
                jogadorDaVez=j2;
                jogadorAdversario=j1;
            }else{
                jogadorDaVez=j1;
                jogadorAdversario=j2;
            }


            }
        } while (!validaVitoria(jogadorAdversario));
    }

    private static boolean validaVitoria(Jogador adversario) {
        for (Peca peca : adversario.getPecas()) {
            if (peca instanceof Rei) {
                return false;
            }
        }
        return true;
    }

    public static boolean movimentar(int escolhaPeca) {
        Peca peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
        if (jogadorDaVez.getPecas().contains(peca)) {
            System.out.println(peca);
            ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);

            if(roque(peca)){
                primMov(peca);
                return true;
            }

            if(jogadorDaVez.isEstaEmXeque()) {
                System.out.println("aa");
                System.out.println("escolha a posição: ");
                int escolhaPosicao = sc.nextInt();
                Posicao posicaoMovimentar = tabuleiro.getPosicoes().get(escolhaPosicao);
                for (Posicao posicao : posicoesAjudam) {
                    if (posicao.equals(posicaoMovimentar)) {

                        jogadorDaVez.moverPeca(peca, posicaoMovimentar, tabuleiro, jogadorAdversario);
                        primMov(peca);
                        return true;
                    }
                }
            }else{
                    for (Posicao posicao : posicoes) {
                        System.out.println("posição possivel: " + tabuleiro.getPosicoes().indexOf(posicao));
                    }
                    System.out.println("escolha a posição: ");
                    int escolhaPosicao = sc.nextInt();
                    Posicao posicaoMovimentar = tabuleiro.getPosicoes().get(escolhaPosicao);
                    for (Posicao posicao : posicoes) {
                        if (posicao.equals(posicaoMovimentar)) {
                            jogadorDaVez.moverPeca(peca, posicaoMovimentar, tabuleiro, jogadorAdversario);
                            primMov(peca);
                            System.out.println("askjlaslkasjaskl");
                            return true;
                        }
                    }
                }
            }


        return false;
    }
    public static ArrayList<Posicao> verificaSalvarRei(Peca rei){
        ArrayList<Posicao>  posicoes = new ArrayList<Posicao>();
        for(Posicao posicao : tabuleiro.getPosicoes()){
            if(posicao.getPeca()!=null && posicao.getPeca().getCor().equals(rei.getCor())){
                Peca pecaTeste = posicao.getPeca();
                for(Posicao posicao1 : pecaTeste.possiveisMovimento(tabuleiro)){
                    Peca pecaMorta = posicao1.getPeca();
                    pecaTeste.mover(tabuleiro, posicao1);
                    if(((Rei) rei).verificaXeque(tabuleiro)!=null){
                        pecaTeste.mover(tabuleiro,posicao);
                        posicao1.setPeca(pecaMorta);
                    }else{
                        pecaTeste.mover(tabuleiro,posicao);
                        posicao1.setPeca(pecaMorta);
                        posicoes.add(posicao1);

                    }
                }
            }
        }


        return posicoes;
    }


    public static boolean primMov(Peca peca) {
        if (peca instanceof Peao) {
            ((Peao) peca).setPrimMov(false);
            promover = ((Peao) peca).promover(tabuleiro);
            System.out.println(promover);
            promocao(peca);
        } else if (peca instanceof Rei) {
            ((Rei) peca).setPrimMov(false);
            return false;
        } else if (peca instanceof Torre) {
            ((Torre) peca).setPrimMov(false);
            return false;
        }
        return true;

    }

    public static boolean roque(Peca peca) {

        if (peca instanceof Rei) {
            if (((Rei) peca).isPrimMov()) {
                int indice = tabuleiro.getPosicoes().indexOf(peca.getPosicao());
                if (tabuleiro.getPosicoes().get(indice + 1).getPeca() == null) {
                    if (tabuleiro.getPosicoes().get(indice + 2).getPeca() == null) {
                        if (tabuleiro.getPosicoes().get(indice + 3).getPeca() instanceof Torre) {

                            System.out.println("deseja realizar o roque curto? \n" +
                                    "1-sim\n" +
                                    "0-não");
                            int respostas = sc.nextInt();
                            if(respostas==1){
                                peca.mover(tabuleiro,tabuleiro.getPosicoes().get(indice+2));

                                tabuleiro.getPosicoes().get(indice + 3).getPeca().mover(tabuleiro,tabuleiro.getPosicoes().get(indice+1));
                                return true;
                            }

                        }
                    }
                }else if (tabuleiro.getPosicoes().get(indice - 1).getPeca() == null) {
                        if (tabuleiro.getPosicoes().get(indice - 2).getPeca() == null) {
                            if (tabuleiro.getPosicoes().get(indice - 3).getPeca() == null) {
                                if (tabuleiro.getPosicoes().get(indice - 4).getPeca() instanceof Torre) {
                                    System.out.println("deseja realizar o roque longo? \n" +
                                            "1-sim\n" +
                                            "0-não");
                                    int respostas = sc.nextInt();
                                    if (respostas == 1) {
                                        peca.mover(tabuleiro, tabuleiro.getPosicoes().get(indice - 2));
                                        tabuleiro.getPosicoes().get(indice - 4).getPeca().mover(tabuleiro, tabuleiro.getPosicoes().get(indice - 1));
                                        return true;
                                    }

                                }
                            }
                        }
                    }
                }


            }
        return false;

        }




    public static void promocao(Peca peca) {
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
                    jogadorDaVez.setPecas(pecaPromovida);

                    break;
                case 2:
                    pecaPromovida = new Torre(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    jogadorDaVez.setPecas(pecaPromovida);



                    break;
                case 3:
                    pecaPromovida = new Cavalo(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    jogadorDaVez.setPecas(pecaPromovida);



                    break;
                case 4:
                    pecaPromovida = new Bispo(peca.getCor(), peca.getPosicao());
                    tabuleiro.getPosicoes().get(indexPecaPromovida).setPeca(pecaPromovida);
                    jogadorDaVez.setPecas(pecaPromovida);


                    break;

            }



        }
    }

    public static void mostrarTabuleiro() {
        int pos = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pos < tabuleiro.getPosicoes().size()) {
                    Peca peca = tabuleiro.getPosicoes().get(pos).getPeca();
                    if (peca != null) {
                        System.out.print("|" + peca + "|");

                    } else {
                        System.out.print("|   |");

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



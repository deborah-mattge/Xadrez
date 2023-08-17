import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String cor;
    private double pontos;
    private ArrayList<Peca> pecas ;
    private boolean estaEmXeque;

    public Jogador(String nome, String senha, Boolean estaEmXeque) {
        this.nome = nome;
        this.senha = senha;
        this.pecas=new ArrayList<>(64);
        this.estaEmXeque=estaEmXeque;
    }


    public boolean moverPeca(Peca peca,
                             Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro, posicao);
        if (pecaAdversaria != null && valida) {
            adversario.pecas.remove(pecaAdversaria);

        }


        return valida;
    }


    public void desistir() {
    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao :
                tabuleiro.getPosicoes()) {
            if (posicao.getPeca()!=null && posicao.getPeca().getCor().equals(cor)) {
                this.pecas.add(posicao.getPeca());
            }
        }


    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cor='" + cor + '\'' +
                ", pontos=" + pontos +
                ", pecas=" + pecas +
                '}';
    }

    public String getCor() {
        return cor;
    }

    public void setPecas(Peca peca) {
        this.pecas.add(peca);
    }

    public boolean isEstaEmXeque() {
        return estaEmXeque;
    }

    public void setEstaEmXeque(boolean estaEmXeque) {
        this.estaEmXeque = estaEmXeque;
    }
}

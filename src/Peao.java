import java.util.ArrayList;

public class Peao extends Peca {
    public Peao(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    private boolean primMov = true;

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> posicaoTAbuleiro = tabuleiro.getPosicoes();

        if (this.getCor().equals("Preto")) {
            if (!((posicaoNoTabuleiro + 8) > 64)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                    possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro + 8));
                    if (this.primMov) {
                        if (posicaoTAbuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                            possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro + 16));
                        }
                    }
                }
            }
            if(!((posicaoNoTabuleiro+9)>64)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null &&
                        posicaoTAbuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                    possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro + 9));

                }
            }
            if(!((posicaoNoTabuleiro+7)>64)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null &&
                        posicaoTAbuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro + 7));

                }
            }


        } else {
            if (!((posicaoNoTabuleiro - 8) < 0)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                    possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 8));
                    if (this.primMov) {
                        if (posicaoTAbuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                            possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro - 16));
                        }
                    }
                }
            }
            if (!((posicaoNoTabuleiro - 9) < 0)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null &&
                        posicaoTAbuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro - 9));

                }
            }
            if (!((posicaoNoTabuleiro - 7) < 0)) {
                if (posicaoTAbuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null &&
                        posicaoTAbuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                    possiveisMovimentos.add(posicaoTAbuleiro.get(posicaoNoTabuleiro - 7));

                }
            }
        }


        return possiveisMovimentos;
    }

    public boolean isPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }

    public boolean promover(Tabuleiro tabuleiro) {
        if (tabuleiro.getPosicoes().indexOf(this.getPosicao()) >= 0 && tabuleiro.getPosicoes().indexOf(this.getPosicao()) <= 7 ||
                tabuleiro.getPosicoes().indexOf(this.getPosicao()) >= 56 && tabuleiro.getPosicoes().indexOf(this.getPosicao()) <= 63
        ) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        if (getCor().equals("Branco")) {
            return "P-B";
        } else if (getCor().equals("Preto")) {
            return "P-P";
        }

        return "R";
    }
}

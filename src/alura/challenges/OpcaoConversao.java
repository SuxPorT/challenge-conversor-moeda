package alura.challenges;

public class OpcaoConversao {
    private final Moeda moedaOrigem, moedaDestino;

    public OpcaoConversao(Moeda moedaOrigem, Moeda moedaDestino) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
    }

    public String getSiglaMoedaOrigem() {
        return moedaOrigem.getSigla();
    }

    public String getSiglaMoedaDestino() {
        return moedaDestino.getSigla();
    }

    @Override
    public String toString() {
        return moedaOrigem.getDescricao() + " =>> " + moedaDestino.getDescricao();
    }
}

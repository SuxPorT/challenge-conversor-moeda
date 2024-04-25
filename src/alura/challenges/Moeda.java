package alura.challenges;

public enum Moeda {
    USD("USD", "Dólar"),
    ARS("ARS", "Peso Argentino"),
    BRL("BRL", "Real Brasileiro"),
    COP("COP", "Peso Colombiano"),
    JPY("JPY", "Iene Japonês"),
    EUR("EUR", "Euro");

    private final String sigla, descricao;

    Moeda(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}

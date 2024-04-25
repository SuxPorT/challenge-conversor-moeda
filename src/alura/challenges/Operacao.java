package alura.challenges;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Operacao {
    private final String ID;
    private final OpcaoConversao opcao;
    private final LocalDateTime dataRequisicao;
    private final double valor, taxaConversao;

    public Operacao(OpcaoConversao opcao, LocalDateTime dataRequisicao, double valor, double taxaConversao) {
        this.ID = UUID.randomUUID().toString();
        this.opcao = opcao;
        this.dataRequisicao = dataRequisicao;
        this.valor = valor;
        this.taxaConversao = taxaConversao;
    }

    public void detalhar(boolean mostrarId) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        double valorConvertido = this.valor * this.taxaConversao;

        DecimalFormat df = new DecimalFormat("#0.0000");
        String dataFormatada = this.dataRequisicao.format(formatador);
        String valorFormatado = df.format(this.valor);
        String taxaConversaoFormatada = df.format(this.taxaConversao);
        String valorConvertidoFormatado = df.format(valorConvertido);

        if (mostrarId) {
            System.out.println(ConsoleColors.YELLOW_BOLD + "[OPERAÇÃO " + this.ID + "]");
        }

        System.out.println(ConsoleColors.GREEN_BOLD + "Data da operação: "
                + ConsoleColors.GREEN_BOLD_BRIGHT + "[" + dataFormatada + "]");
        System.out.println(ConsoleColors.GREEN_BOLD + "Valor a ser convertido: "
                + ConsoleColors.GREEN_BOLD_BRIGHT + valorFormatado +  " [" + this.opcao.getSiglaMoedaOrigem() + "]");

        System.out.println(ConsoleColors.GREEN_BOLD + "Taxa de conversão: "
                + ConsoleColors.GREEN_BOLD_BRIGHT + taxaConversaoFormatada);

        System.out.println(ConsoleColors.GREEN_BOLD + "Valor convertido: "
                + ConsoleColors.GREEN_BOLD_BRIGHT + valorConvertidoFormatado + " [" + this.opcao.getSiglaMoedaDestino() + "]");
    }
}

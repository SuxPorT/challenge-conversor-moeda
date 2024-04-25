package alura.challenges;

import java.time.LocalDateTime;

public class ConversorMoeda {

    public ConversorMoeda() { }

    public void converterMoeda(OpcaoConversao opcao) {
        try {
            System.out.print("Digite o valor que deseja converter: ");
            double valor = LeitorEntrada.lerDouble();
            System.out.println();

            RequisicaoMoedas requisicaoMoedas = new RequisicaoMoedas();
            LocalDateTime dataRequisicao = LocalDateTime.now();
            double taxaConversao =
                    requisicaoMoedas.obterTaxaConversao(opcao.getSiglaMoedaOrigem(), opcao.getSiglaMoedaDestino());

            if (taxaConversao != -1) {
                Operacao operacao = new Operacao(opcao, dataRequisicao, valor, taxaConversao);
                operacao.detalhar(false);

                HistoricoOperacoes.registrar(operacao);
            } else {
                System.out.println(ConsoleColors.RED_BOLD + "Falha na obtenção da taxa de conversão.");
            }
        } catch (Exception e) {
            throw new NumberFormatException();
        }
    }
}

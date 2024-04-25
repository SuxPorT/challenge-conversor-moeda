package alura.challenges;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Menu {
    private final ConversorMoeda conversorMoeda;
    private final List<OpcaoConversao> opcoesConversao;

    public Menu() {
        this.conversorMoeda = new ConversorMoeda();
        this.opcoesConversao = new ArrayList<>();
        this.preencherOpcoes();
    }

    private void preencherOpcoes() {
        this.opcoesConversao.add(new OpcaoConversao(Moeda.USD, Moeda.ARS));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.ARS, Moeda.USD));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.USD, Moeda.BRL));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.BRL, Moeda.USD));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.USD, Moeda.COP));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.COP, Moeda.USD));

        this.opcoesConversao.add(new OpcaoConversao(Moeda.JPY, Moeda.BRL));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.EUR, Moeda.BRL));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.USD, Moeda.EUR));
        this.opcoesConversao.add(new OpcaoConversao(Moeda.USD, Moeda.JPY));
    }

    public void exibirMenu() {
        int escolha = -1;
        int opcaoSair = opcoesConversao.size() + 2;

        System.out.println(ConsoleColors.WHITE_BOLD +  "*".repeat(45));
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Seja bem-vindo/a ao Conversor de Moedas =]");

        do {
            this.exibirOpcoes(opcaoSair);

            try {
                System.out.print(ConsoleColors.YELLOW_BOLD + "Escolha uma opção: ");
                escolha = LeitorEntrada.lerInteiro();

                if (escolha > 0 && escolha <= opcoesConversao.size()) {
                    conversorMoeda.converterMoeda(opcoesConversao.get(escolha - 1));
                    System.out.println();
                } else if (escolha == opcoesConversao.size() + 1) {
                    HistoricoOperacoes.mostrarHistorico();
                } else if (escolha == opcaoSair) {
                    System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "\nObrigado por usar o Conversor de Moedas Alura!");
                } else {
                    System.out.println(ConsoleColors.RED_BOLD + "\nEscolha inválida. Por favor, escolha novamente.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.RED_BOLD + "\nEscolha inválida. Por favor, escolha novamente.\n");
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED_BOLD + "\nValor inválido. Por favor, tente novamente.\n");
            } finally {
                LeitorEntrada.limparBuffer();
            }
        } while (escolha != opcaoSair);
    }

    private void exibirOpcoes(int opcaoSair) {
        System.out.println(ConsoleColors.WHITE_BOLD + "*".repeat(45));

        for (int i = 0; i < opcoesConversao.size(); i++) {
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + (i + 1) + ") " + opcoesConversao.get(i).toString());
        }

        System.out.println((opcoesConversao.size() + 1) + ") Consultar histórico");
        System.out.println((opcaoSair) + ") Sair");
        System.out.println(ConsoleColors.WHITE_BOLD + "*".repeat(45));
    }
}

package alura.challenges;

import java.util.ArrayList;
import java.util.List;

public class HistoricoOperacoes {
    private final static List<Operacao> operacoes = new ArrayList<>();

    public static void registrar(Operacao operacao) {
        operacoes.add(operacao);
    }

    public static void mostrarHistorico() {
        System.out.println();

        if (operacoes.size() == 0) {
            System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Nenhuma operação foi realizada até o momento.\n");
        } else {
            for (Operacao operacao : operacoes) {
                operacao.detalhar(true);
                System.out.println();
            }
        }
    }
}

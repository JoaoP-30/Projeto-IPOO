import java.util.ArrayList;
import java.util.HashMap;

/**
 * Gerencia e armazena a pontuação total do jogador, fase por fase.
 * Implementa o padrão de design Singleton, garantindo que haja apenas uma
 * instância de {@code Pontuacao} em toda a execução do jogo.
 * @version 1.0
 */

public class Pontuacao{
    //Única instância estática da classe Pontuacao.
    private static Pontuacao instancia;

    //Armazena a pontuação de cada fase.
    private HashMap<String, Integer> pontos;

    /**
     * Construtor privado, essencial para o padrão Singleton.
     * <p>
     * Inicializa o {@code HashMap} e define a pontuação inicial de todas as fases como zero.
     * </p>
     */

    private Pontuacao(){
        // Comentário original: pontos = new ArrayList<>();

        pontos = new HashMap<>();

        // Inicializa todas as fases com pontuação zero
        pontos.put("Fase_1",0);
        pontos.put("Fase_2",0);
        pontos.put("Fase_3",0);
        pontos.put("Fase_4",0);
        pontos.put("Fase_5",0);
        pontos.put("Fase_6",0);
    }

    /**
     * Método estático para obter a única instância de {@code Pontuacao} (Singleton).
     * Se a instância ainda não existir, ela é criada.
     * @return A única instância de Pontuacao.
     */

    public static Pontuacao obterInstancia(){
        if(instancia == null){
            instancia = new Pontuacao();
        }

        return instancia;
    }

    /**
     * Adiciona ou atualiza a pontuação de uma fase específica no {@code HashMap}.
     * O valor de {@code pontuacao} deve ser a pontuação total acumulada ao final da fase.
     * @param fase O nome da fase (String) cuja pontuação será registrada (ex: "Fase_1").
     * @param pontuacao A pontuação total acumulada ao final daquela fase.
     */

    public void adicionarPontuacao(String fase, int pontuacao){
        pontos.put(fase,pontuacao);
    }

    /**
     * Obtém a pontuação total acumulada registrada para uma fase.
     * @param fase O nome da fase a ser consultada.
     * @return A pontuação total daquela fase, ou 0 se a fase não estiver registrada (ou for nula).
     */
    public int obterPontuacaoFase(String fase){
        if(pontos.get(fase) != null){
            return pontos.get(fase);
        }

        return 0;
    }

    /**
     * Organiza as pontuações para calcular a pontuação *líquida* de algumas fases.
     * Este método modifica o valor armazenado no {@code HashMap} de certas fases
     * (Fase_2, Fase_3 e Fase_6) para que o valor armazenado passe a ser a diferença
     * entre a pontuação total da fase atual e a pontuação total da fase anterior,
     * transformando a pontuação acumulada em pontuação da fase individual.
     */
    public void organizarPontuacao(){

        pontos.put("Fase_2", calculaPontuacaoReal("Fase_2", "Fase_1"));

        pontos.put("Fase_3", calculaPontuacaoReal("Fase_3", "Fase_2"));

        pontos.put("Fase_6", calculaPontuacaoReal("Fase_6", "Fase_5"));
    }

    private int calculaPontuacaoReal(String faseAt, String faseAn){
        int faseAtual = Pontuacao.obterInstancia().obterPontuacaoFase(faseAt);
        int faseAnterior = Pontuacao.obterInstancia().obterPontuacaoFase(faseAn);
        int pontuacaoReal = faseAtual - faseAnterior;

        if(pontuacaoReal < 0){
            return 0;
        }

        return pontuacaoReal;
    }
}
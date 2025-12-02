import java.util.HashMap;

/**
 * Gerencia e armazena a pontuação total do jogador, fase por fase.
 * Implementa o padrão de design Singleton, garantindo que haja apenas uma
 * instância de {@code Pontuacao} em toda a execução do jogo.
 * @version 1.1 - Refatoração para melhorar a clareza e separação de responsabilidades.
 */

public class Pontuacao{
    // Única instância estática da classe Pontuacao (Singleton).
    private static Pontuacao instancia;

    // Armazena a pontuação ACUMULADA de cada fase.
    private HashMap<String, Integer> pontos;

    /**
     * Construtor privado, essencial para o padrão Singleton.
     * Inicializa o {@code HashMap} e define a pontuação inicial de todas as fases como zero.
     */
    private Pontuacao(){
        pontos = new HashMap<>();
        
        // Inicializa todas as fases com pontuação zero
        pontos.put("Fase_1",0);
        pontos.put("Fase_2",0);
        pontos.put("Fase_3",0);
        pontos.put("Fase_4",0);
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
     * O valor de {@code pontuacao} deve ser a pontuação total ACUMULADA ao final da fase.
     * @param fase O nome da fase (String) cuja pontuação será registrada (ex: "Fase_1").
     * @param pontuacao A pontuação total acumulada ao final daquela fase.
     */
    public void adicionarPontuacao(String fase, int pontuacao){
        pontos.put(fase,pontuacao);
    }

    /**
     * Obtém a pontuação total ACUMULADA registrada para uma fase.
     * @param fase O nome da fase a ser consultada.
     * @return A pontuação total acumulada daquela fase, ou 0 se a fase não estiver registrada.
     */
    
    public int obterPontuacaoFase(String fase){
        if(pontos.get(fase) != null){
            return pontos.get(fase);
        }

        return 0;
    }

    /**
     * Calcula a pontuação REAL (líquida) de uma fase, subtraindo a pontuação 
     * acumulada da fase anterior da pontuação acumulada da fase atual.
     * * @param faseAt O nome da fase atual.
     * @param faseAn O nome da fase anterior.
     * @return A pontuação líquida da fase atual. Retorna 0 se o cálculo for negativo.
     */
    
    private int calculaPontuacaoReal(String faseAt, String faseAn){
        int faseAtualAcumulada = obterPontuacaoFase(faseAt);
        int faseAnteriorAcumulada = obterPontuacaoFase(faseAn);
        
        int pontuacaoReal = faseAtualAcumulada - faseAnteriorAcumulada;

        if(pontuacaoReal < 0){
            return 0;
        }

        return pontuacaoReal;
    }

    /**
     * Retorna a pontuação total do jogo somando as pontuações LÍQUIDAS 
     * (não acumuladas) de cada fase, usando as chaves das fases.
     * @return A soma da pontuação líquida de todas as fases.
     */
    
    public int obterPontuacaoTotalLiquidaFase(String fase){
        
        if(fase.equalsIgnoreCase("Fase_1")){
            return pontos.get("Fase_1");
        }
        else if(fase.equalsIgnoreCase("Fase_2")){
            return calculaPontuacaoReal("Fase_2","Fase_1");    
        }
        else if(fase.equalsIgnoreCase("Fase_3")){
            return calculaPontuacaoReal("Fase_3","Fase_2");
        }
        else if(fase.equalsIgnoreCase("Fase_4")){
            return calculaPontuacaoReal("Fase_4","Fase_3");
        }
        
        return 0;
    }
    
    /**
     * Retorna a pontuação total acumulada do jogo.
     * Em um jogo sequencial (Fase 1 -> Fase 4), o valor da última fase 
     * jogada é a pontuação acumulada. Se todas foram jogadas, é o total.
     * @return A pontuação total acumulada do jogo.
     */
    public int obterPontuacaoTotalAcumulada(){
        // A pontuação acumulada final é o valor registrado na última fase.
        return obterPontuacaoFase("Fase_4");
    }
}
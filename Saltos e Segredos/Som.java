import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Gerencia a reprodução de trilhas sonoras e efeitos sonoros no jogo.
 * Esta classe pré-carrega os sons em HashMaps para acesso rápido e permite
 * tocar, parar e mutar os sons.
 * 
 * @author Joao Fernandes 
 * @version Versão 1.0
 */
public class Som extends Actor
{
    /** Armazena as trilhas sonoras (musicas)*/
    private HashMap <String, GreenfootSound> trilhas;
    
    /** Armazena os efeitos sonoros */
    private HashMap <String, GreenfootSound> efeitos;
    
    /** Referência ao objeto GreenfootSound da último trilha sonora tocada.*/
    private GreenfootSound tocaTrilhas;
    
    /** Referência ao objeto GreenfootSound do último efeito sonoro tocado. */
    private GreenfootSound tocaEfeitos;

    /**
     * Construtor da classe Som.
     * Inicializa os HashMaps para armazenar as trilhas e efeitos.
     * Chama métodos para pré-carregar os arquivos de som e define
     * os sons atuais como nulos.
     */

    public Som(){
        trilhas = new HashMap<>();
        efeitos = new HashMap<>();

        preencherTrilhas();
        preencherEfeitos();

        tocaTrilhas = null;
        tocaEfeitos = null;
    }

    /**
     *  Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     *  Método principal de atuação (loop) da classe Som. 
     */
    
    public void act()
    {
        mutarTrilha();
    }

    /**
     * Pré-carrega as trilhas sonoras (músicas de fundo) no HashMap 'trilhas'.
     * Associa um nome (String) a cada objeto GreenfootSound.
     */

    private void preencherTrilhas(){
        trilhas.put("first.mp3", new GreenfootSound("first.mp3"));
        trilhas.put("time_for_adventure.mp3", new GreenfootSound("time_for_adventure.mp3"));
    }

    /**
     * Pré-carrega os efeitos sonoros no HashMap 'efeitos'.
     * Associa um nome (String) a cada objeto GreenfootSound.
     */

    private void preencherEfeitos(){
        efeitos.put("coin.wav", new GreenfootSound("coin.wav"));
        efeitos.put("hurt.wav", new GreenfootSound("hurt.wav"));
        efeitos.put("jump.wav", new GreenfootSound("jump.wav"));
        efeitos.put("power_up.wav", new GreenfootSound("power_up.wav"));
    }

    /**
     * Verifica se a tecla 'm' foi pressionada.
     * Se a tecla 'm' for pressionada e uma trilha sonora estiver tocando,
     * a trilha é parada (mutada).
     */

    private void mutarTrilha(){
        if(Greenfoot.isKeyDown("m")){
            if(tocaTrilhas != null){
                tocaTrilhas.stop();
            }
        }
    }

    /**
     * Toca uma trilha sonoro específica em loop contínuo.
     * Busca a trilha pelo nome no HashMap e inicia sua reprodução em loop.
     * * @param trilha O nome (chave do HashMap) do arquivo de som a ser tocado.
     */

    public void tocarTrilha(String trilha){
        tocaTrilhas = trilhas.get(trilha);
        tocaTrilhas.playLoop();
    }        

    /**
     * Toca um efeito sonoro uma única vez.
     * Busca o efeito pelo nome no HashMap e executa a reprodução uma única vez.
     * * @param efeito O nome (chave do HashMap) do arquivo de som a ser tocado.
     */

    public void tocarEfeito(String efeito){
        tocaEfeitos = efeitos.get(efeito);
        tocaEfeitos.play();
    }
}

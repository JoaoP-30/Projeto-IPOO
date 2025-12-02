import java.util.HashMap;
import greenfoot.GreenfootSound;

/**
 * Gerencia a reprodução de trilhas sonoras e efeitos sonoros no jogo.
 * Esta classe usa o padrão Singleton.
 * @author Joao Fernandes 
 * @version 2.0 (Refatorada para Singleton)
 */

public class Som{

    // Unica referencia de som
    private static Som instancia;
    
    //Armazena as trilhas sonoras (musicas)
    private HashMap <String,GreenfootSound> trilhas;

    //Armazena os efeitos sonoros
    private HashMap <String, GreenfootSound> efeitos;

    //Referência ao objeto GreenfootSound da último trilha sonora tocada.
    private GreenfootSound tocaTrilhas;

    //Referência ao objeto GreenfootSound do último efeito sonoro tocado.
    private GreenfootSound tocaEfeitos;
    
    
    /**
     * Construtor da classe Som.
     * Inicializa os HashMaps para armazenar as trilhas e efeitos.
     * Chama métodos para pré-carregar os arquivos de som e define
     * os sons atuais como nulos.
     */
    
    private Som(){
        trilhas = new HashMap<>();
        efeitos = new HashMap<>();

        preencherTrilhas();
        preencherEfeitos();

        tocaTrilhas = null;
        tocaEfeitos = null;
    }
   
    public static Som obterInstancia(){
        if(instancia == null){
            instancia = new Som();
        }
        
        return instancia;
    }
    
    /**
     * Pré-carrega as trilhas sonoras (músicas de fundo) no HashMap 'trilhas'.
     * Associa um nome (String) a cada objeto GreenfootSound.
     */
    
    private void preencherTrilhas(){
        trilhas.put("Intro.wav",new GreenfootSound("intro.wav"));
        trilhas.put("Tema1.wav",new GreenfootSound("tema1.wav"));
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
        efeitos.put("explosion.wav", new GreenfootSound("explosion.wav"));
    }
    
     /**
     * Toca uma trilha sonoro específica em loop contínuo.
     * Busca a trilha pelo nome no HashMap e inicia sua reprodução em loop.
     * * @param trilha O nome (chave do HashMap) do arquivo de som a ser tocado.
     */

    public void tocarTrilha(String trilha){
        tocaTrilhas = trilhas.get(trilha);

        if(tocaTrilhas != null){
            //tocaTrilhas.setVolume(30);
            //tocaTrilhas.play();
        }
    }        

    /**
     * Toca um efeito sonoro uma única vez.
     * Busca o efeito pelo nome no HashMap e executa a reprodução uma única vez.
     * * @param efeito O nome (chave do HashMap) do arquivo de som a ser tocado.
     */

    public void tocarEfeito(String efeito){
        tocaEfeitos = efeitos.get(efeito);

        if(tocaEfeitos != null){
            tocaEfeitos.setVolume(70);
            tocaEfeitos.play();
        }
    }

    /**
     * Para a reprodução da trilha sonora atual.
     */

    public void mutarTrilha(){
        if(tocaTrilhas != null){
            //tocaTrilhas.stop();
        }
    }

    /**
     * Volta a reprodução da ultima trilha sonora tocada.
     */
    
    public void voltarTrilha(){
        if(tocaTrilhas != null){
            //tocaTrilhas.playLoop();
        }
    }

}
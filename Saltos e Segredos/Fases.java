import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse abstrata para todas as fases (níveis) do jogo.
 * * Esta classe fornece a funcionalidade básica comum a todas as fases,
 * como a configuração inicial do mundo (tamanho e cor de fundo) e
 * a integração com o gerenciador de som (classe Som).
 * * As classes concretas de cada fase devem herdar desta classe.
 * * @author Joao Fernandes 
 * * @version 1.0
 */

public abstract class Fases extends World
{
    /** Referência ao objeto Som, responsável por tocar músicas e efeitos sonoros. */
    private Som som;
    
    /**
     * Construtor da superclasse Fases.
     * * Configura o tamanho padrão do mundo (1150x600 pixels),
     * define a cor de fundo padrão (azul claro) e
     * inicializa e adiciona o ator 'Som' ao mundo para gerenciar o áudio.
     */
    
    public Fases()
    {    
        // Cria um novo mundo com 1150x600 células com um tamanho de célula de 1x1 pixels.
        super(1150, 600, 1); 
    
        background();
        
        som = new Som();
        // Adiciona o ator Som em uma posição fixa (canto superior direito)
        addObject(som,1129,17);
    }

    /**
     * Define a cor de fundo padrão para o mundo.
     * Pinta o fundo com um tom de azul claro.
     */
    
    private void background(){
        getBackground().setColor(new Color(135, 206, 235));
        getBackground().fill();
    }
    
    /**
     * Inicia a reprodução de uma trilha sonora em loop.
     * Este método é um "wrapper" que delega a chamada para o objeto Som.
     * * @param trilha O nome (String) da trilha sonora a ser tocada.
     */
    
    public void iniciaTrilha(String trilha){
        som.tocarTrilha(trilha);
    }

    /**
     * Para a reprodução da trilha sonora que está tocando atualmente.
     * Este método é um "wrapper" que delega a chamada para o objeto Som.
     */
    
    public void paraTrilha(){
        som.mutarTrilha();
    }
}

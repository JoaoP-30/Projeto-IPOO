import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse para todas as fases (níveis) do jogo.
 * * Esta classe fornece a funcionalidade básica comum a todas as fases,
 * como a configuração inicial do mundo (tamanho e cor de fundo) e
 * a integração com o gerenciador de som (classe Som).
 * * @author Joao Fernandes 
 * * @version 1.0
 */

public class Fases extends World
{
    private Auxilia_Som som;   

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

        som = new Auxilia_Som();        
        addObject(som,1129,17);

        background();
    }

    /**
     * Define a cor de fundo padrão para o mundo.
     * Pinta o fundo com um tom de azul claro.
     */

    private void background(){
        getBackground().setColor(new Color(135, 206, 235));
        getBackground().fill();
    }

    public void botaoClicado(int id){
    
    }
}

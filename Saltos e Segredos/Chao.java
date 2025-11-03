import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um objeto de "Chao" simples no mundo.
 * É uma implementação concreta da classe abstrata {@link Solo}.
 * @author Joao Fernandes 
 * @version 1.0
 */
public class Chao extends Solo
{
    /**
     * Construtor da classe Chao. 
     * Repassa a largura e altura para o construtor da superclasse {@link Solo}.
     * @param largura A largura desejada para a imagem do chão.
     * @param altura A altura desejada para a imagem do chão.
     */
    
    public Chao(int largura, int altura){
        super(largura, altura);
    }
    
    /**
     *  Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     *  Método principal de atuação (loop) da classe Chao. 
     *  Atualmente, o chão não possui ações (é um ator passivo).
     */
    
    public void act()
    {
    
    }
}

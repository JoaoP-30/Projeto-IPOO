import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um inimigo estacionário (Cacto).
 * Ele não se move; apenas permanece no lugar e causa dano ao jogador
 * se houver contato, utilizando a lógica da superclasse {@link Inimigos}.
 * * @author Joao Fernandes
 * @version 1.0
 */

public class Cacto extends Inimigos
{
    /**
     * Construtor da classe Cacto.
     * Apenas repassa a referência do jogador para a superclasse Inimigos.
     * @param jogador A instância do Jogador que está no mundo.
     */
    
    public Cacto(Jogador jogador){
        super(jogador);
    }
    
    /**
     * Método principal de atuação (loop) do Cacto.
     * A única ação do cacto é verificar continuamente se pode atacar o jogador.
     */
    
    public void act()
    {
        ataque();
    }
}

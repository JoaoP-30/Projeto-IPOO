import greenfoot.*;
import java.util.List;

/**
 * Representa um projétil ou ataque lançado pelo {@link Jogador}.
 * O objetivo principal do {@code Ataque} é colidir com inimigos (como {@link Monstro}
 * ou {@link Skull}), eliminá-los e, em seguida, se remover do mundo.
 * @version 1.0
 */

public class Ataque extends Actor
{ 
    /**
     * O método 'Act' é chamado a cada frame de execução.
     * Seu único propósito é chamar o método principal de detecção de colisão
     * e eliminação de inimigos.
     */
    public void act() 
    {
        matarInimigo();
    }    
    
    /**
     * Remove o objeto {@code Ataque} do mundo se ele colidir com uma parede
     * (objeto da classe {@link Solo}) ou se sair dos limites horizontais do mundo.
     */
    public void remover()
    {
       // Verifica se há colisão com um objeto da classe Solo (Parede)
       Actor walls = getOneIntersectingObject(Solo.class);
       
       // Verifica se o ataque atingiu a borda esquerda ou direita do mundo
       if(getX() <=1 || getX() >= getWorld().getWidth() -1)
       {
           getWorld().removeObject(this);
        }
        // Se colidiu com uma parede
        else if(walls != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Verifica se o objeto {@code Ataque} está sobrepondo um objeto de uma classe específica.
     * Usa um offset (0,0) para verificar a posição exata de intersecção.
     * @param clss A classe do objeto a ser verificado (ex: Monstro.class).
     * @return {@code true} se houver intersecção, {@code false} caso contrário.
     */
    
    public boolean acertado(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        return actor != null;
    }
    
    /**
     * Remove o objeto da classe especificada no ponto de intersecção.
     * Este método é chamado após o {@code acertado(Class clss)} ter retornado {@code true}.
     * @param clss A classe do objeto a ser removido (ex: Inimigos.class).
     */
    public void matar(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        
        if(actor != null)
        {
            getWorld().removeObject(actor);
        }
    }
    
    /**
     * Lógica principal de ataque.
     * Verifica se acertou um {@link Monstro} ou uma {@link Skull}. Se sim,
     * remove o inimigo (usando a superclasse {@link Inimigos}), pontua e se remove.
     * Caso contrário, chama o método {@code remover()} para verificar colisão com paredes ou bordas.
     */
    public void matarInimigo()
    {
        // Verifica se acertou um Monstro ou um Skull
        if(acertado(Monstro .class) || acertado(Skull.class))
        {
            // Remove o objeto Inimigos genérico que foi acertado
            matar(Inimigos.class); 
            pontuar(); // Adiciona pontos no HUD
            getWorld().removeObject(this); // Remove o próprio projétil de ataque
        }
        else
        {
            remover(); // Verifica se o ataque atingiu uma parede ou borda
        }
    }

    /**
     * Encontra a instância de {@link HUD} no mundo e chama o método para adicionar
     * pontos pela morte de um inimigo.
     */
    public void pontuar(){
        Jogador jogador = (Jogador) getWorld().getObjects(Jogador.class).get(0); 
        jogador.incrementarInimigosMortos();      
    }
}
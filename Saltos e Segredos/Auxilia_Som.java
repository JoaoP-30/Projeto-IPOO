import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Responsável por gerenciar o estado da trilha sonora,
 * garantindo que ela esteja tocando ou mutada.
 * @version 1.0
 */

public class Auxilia_Som extends Actor
{
    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Auxilia_Som.
     */
    
    public void act()
    {
        verificaSom();
    }
    
    /**
     * Verifica as teclas 'm' e 'p' para controlar o som.
     */
    
    private void verificaSom(){
        if(Greenfoot.isKeyDown("m")){
            Som.obterInstancia().mutarTrilha();
        }
        if(Greenfoot.isKeyDown("p")){
            Som.obterInstancia().voltarTrilha();
        }
    }
}

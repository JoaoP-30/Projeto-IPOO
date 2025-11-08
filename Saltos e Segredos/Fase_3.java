import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fase_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fase_3 extends Fases
{
    private Jogador jogador;
    
    /**
     * Constructor for objects of class Fase_3.
     * 
     */
    public Fase_3(Jogador jogador)
    {
        this.jogador = jogador;
    }


    public void irParaProximaFase(){
        // AQUI DEVE SER SETADO O TEXTO DO GANHADOR
        
        showText("YOU WIN", getWidth() / 2, getHeight() / 2 + 100);
        Greenfoot.stop();
    }
}

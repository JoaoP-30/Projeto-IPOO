import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fase_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fase_2 extends Fases
{
    private Jogador jogador;
    
    /**
     * Constructor for objects of class Fase_2.
     * 
     */
    public Fase_2(Jogador jogador)
    {    
        this.jogador = jogador;
    }

    private void prepare(){
    
    }

    public void irParaProximaFase(){
        paraTrilha();
        //Fase_3 proximaFase = new Fase_3(jogador);
        //Greenfoot.setWorld(proximaFase);
    }
}

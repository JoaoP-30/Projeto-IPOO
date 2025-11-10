import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teste extends Fases
{

    /**
     * Constructor for objects of class Teste.
     * 
     */
    public Teste()
    {
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Resultado resultado = new Resultado(0);
        addObject(resultado,getWidth() / 2 ,getHeight() / 2 - 30);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataforma extends Solo
{
    private int largura;
    private int velocidade;
    
    
    public Plataforma(int largura, int altura){
        super(largura, altura);
    
        this.largura = largura;
        
        velocidade = 3;
    }
    
    /**
     * Act - do whatever the Plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimento();
    }

    private void movimento(){
        if(getX() <= largura / 2 || getX() >= getWorld().getWidth() - (largura / 2)){
            velocidade *= -1;
        }
        move(velocidade);
    }

    public void alterarVelocidade(int velocidade){
       this.velocidade = velocidade; 
    }
}

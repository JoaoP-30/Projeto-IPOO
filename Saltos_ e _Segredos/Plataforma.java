import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa uma plataforma móvel horizontalmente no jogo.
 * Esta plataforma se move de um lado para o outro, invertendo a direção ao
 * atingir as bordas do mundo.
 * @version 1.0
 */
public class Plataforma extends Solo
{
    //Armazena a largura da plataforma, usada para calcular as bordas. */
    private int largura;
    //A velocidade de movimento da plataforma. 
    //O sinal positivo/negativo indica a direção (direita/esquerda).
    private int velocidade;
    
    /**
     * Construtor para objetos da classe Plataforma.
     * @param largura A largura horizontal da plataforma.     
     * @param altura A altura vertical da plataforma.
     */
    
    public Plataforma(int largura, int altura){
        // Chama o construtor da classe pai (Solo) para definir as dimensões do objeto
        super(largura, altura);
    
        this.largura = largura;
        
        // Define a velocidade inicial de movimento
        velocidade = 3;
    }
    
    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * É aqui que a lógica de movimento da plataforma é executada.
     */
    
    public void act()
    {
        movimento();
    }

    /**
     * Implementa a lógica de movimento horizontal da plataforma.
     * A plataforma se move e inverte sua direção (invertendo a 'velocidade')
     * quando seu centro atinge as margens laterais do mundo (considerando sua largura).
     */
    
    private void movimento(){
        // Verifica se a plataforma atingiu a borda esquerda (posição X menor ou igual à metade da largura)
        // OU se atingiu a borda direita (posição X maior ou igual à largura do mundo menos a metade da largura)
        if(getX() <= largura / 2 || getX() >= getWorld().getWidth() - (largura / 2)){
            // Inverte a direção do movimento
            velocidade *= -1;
        }
        // Move a plataforma pela quantidade definida em 'velocidade'
        move(velocidade);
    }

    /**
     * Altera a velocidade e, consequentemente, a direção da plataforma.
     * @param velocidade A nova velocidade de movimento (positivo para direita, negativo para esquerda).
     */
    
    public void alterarVelocidade(int velocidade){
       this.velocidade = velocidade; 
    }
}
import greenfoot.*;

/**
 * Representa um projétil ou ataque que se move unicamente para a direita.
 * Esta classe herda de {@link Ataque} e implementa sua própria lógica de movimento
 * para se deslocar horizontalmente no sentido positivo (para a direita).
 * @version 1.0
 */

public class AtaqueDireito extends Ataque
{
    //Define a velocidade horizontal de movimento do projétil para a direita.
    private int velocidadeTiro = 8;
    
    /**
     * O método 'Act' é chamado a cada frame de execução.
     * Move o ataque para a direita usando {@code velocidadeTiro} e, em seguida,
     * verifica a colisão com inimigos ou bordas chamando {@code matarInimigo()}.
     */
    public void act() 
    {
        // Atualiza a posição X, movendo o objeto para a direita
        setLocation(getX() + velocidadeTiro, getY());
        
        // Verifica se acertou um inimigo ou se deve ser removido (paredes/bordas)
        matarInimigo();
    }    
}
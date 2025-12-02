import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um bloco de "chão falso".
 * Este tipo de chão é projetado para desaparecer assim que o {@link Jogador}
 * tocar nele.
 * @version 1.0
 */
public class Chao_Falso extends Actor
{
    /**
     * Construtor da classe Chao_Falso.
     * Redimensiona a escala da imagem de acordo com a largura e altura especificadas.
     * @param largura A largura desejada para o bloco de chão.
     * @param altura A altura desejada para o bloco de chão.
     */

    public Chao_Falso(int largura , int altura){
        getImage().scale(largura, altura);
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Chao_Falso.
     * A cada chamada, ele verifica se deve ser removido.
     */
    
    public void act()
    {
        removeSolo();
    }

    /**
     * Verifica se o {@link Jogador} está tocando este objeto.
     * Se houver uma intersecção (ou seja, se o jogador estiver sobre o chão falso),
     * este objeto (o Chao_Falso) é removido do mundo.
     */
    
    private void removeSolo(){
        Actor jogador = getOneIntersectingObject(Jogador.class);

        if(jogador != null){
            getWorld().removeObject(this);
        }
    }
}

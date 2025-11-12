import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe abstrata base para todos os inimigos do jogo.
 * * Fornece a funcionalidade central de 'ataque', que verifica a colisão 
 * com o jogador e aplica dano, respeitando o tempo de invulnerabilidade.
 * * @author Joao Fernandes 
 * @version 1.0
 */

public abstract class Inimigos extends Actor
{
    //Referência ao jogador, necessária para aplicar dano.
    private Jogador jogador;
    
    /**
     * Construtor da classe Inimigos.
     * Armazena a referência do jogador e inicializa o objeto de som.
     * @param jogador A instância do Jogador que está no mundo.
     */

    public Inimigos(Jogador jogador){
        this.jogador = jogador;
    }

    /**
     * Método Act (abstrato). 
     * As subclasses (ex: Cacto, Monstro) devem implementar seu próprio 
     * comportamento, como movimento.
     */

    public void act()
    {

    }

    /**
     * Método de ataque padrão para todos os inimigos.
     * Chamado pelas subclasses (geralmente dentro do 'act').
     * * Verifica se está tocando no jogador. Se sim, E se o jogador NÃO 
     * estiver invulnerável ({@link Jogador#estaInvulneravel()}), 
     * aplica dano ({@link Jogador#receberDano()}) e toca o som "hurt.wav".
     */
    
    public void ataque(){
        Actor alvo = getOneIntersectingObject(Jogador.class);
        
        // Só ataca se houver colisão E o jogador não estiver invulnerável
        if(alvo != null && !jogador.estaInvulneravel()){
            jogador.receberDano();
            Som.obterInstancia().tocarEfeito("hurt.wav");
        }
    }
}

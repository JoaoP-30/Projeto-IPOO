import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o projétil de ataque lançado pelo {@link Boss}, no formato de uma caveira.
 * A classe Skull herda de {@link Inimigos} e se move em uma direção definida,
 * causando dano ao {@link Jogador} se houver colisão.
 * @version 1.0
 */
public class Skull extends Inimigos
{
    //Referência ao objeto {@link Jogador} para quem o projétil está direcionado.
    private Jogador jogador;
    //A velocidade de movimento do projétil. O valor padrão é 4.
    private int velocidade = 4;
    
    /**
     * Construtor principal da classe Skull.
     * Associa o projétil a um {@link Jogador} específico e ajusta o tamanho da imagem.
     * @param jogador O objeto Jogador que o projétil irá tentar atingir.
     */
    
    public Skull(Jogador jogador){
        super(jogador);
    
        this.jogador = jogador;
        
        // Redimensiona a imagem para 40x40 pixels
        getImage().scale(40,40);
    }
    
    /**
     * O método 'Act' é chamado a cada frame de execução.
     * Gerencia o movimento do projétil, verifica a colisão e chama o método de ataque,
     * desde que o projétil não tenha desaparecido (saído dos limites do mundo).
     */
    
    public void act()
    {
        if(!desaparecer()){
            ataque(); // Verifica colisão com o jogador
            movimento(); // Move o projétil
        }
    }

    /**
     * Verifica a colisão com o {@link Jogador} e aplica dano.
     * Este método sobrescreve o método {@code ataque()} da superclasse {@link Inimigos}.
     * Se o projétil colidir com o jogador e ele não estiver invulnerável, o jogador
     * recebe dano, o projétil é removido e um som de explosão é tocado.
     */
    
    @Override
    public void ataque(){
        Actor alvo = getOneIntersectingObject(Jogador.class);
        
        // Só ataca se houver colisão E o jogador não estiver invulnerável
        if(alvo != null && !jogador.estaInvulneravel()){
            jogador.receberDano();
            getWorld().removeObject(this);
            Som.obterInstancia().tocarEfeito("explosion.wav");
        }
    }
    
    /**
     * Move o projétil na direção atual, usando o valor de {@code velocidade}.
     */
    public void movimento(){
        move(velocidade);
    }

    /**
     * Gira o projétil em 90 graus para mudar sua direção de movimento.
     */
    public void mudarDirecao(){
        turn(90);
    }
    
    /**
     * Inverte o sentido de movimento do projétil, multiplicando a velocidade por -1.
     * Também espelha a imagem horizontalmente.
     */
    public void inverterSentido(){
        velocidade *= -1;
        
        getImage().mirrorHorizontally();
    }

    /**
     * Verifica se o projétil saiu dos limites do mundo.
     * O projétil é removido se atingir as bordas esquerda, direita ou inferior do mundo.
     * @return {@code true} se o projétil foi removido, {@code false} caso contrário.
     */
    private boolean desaparecer(){
        // Verifica se saiu da borda direita, borda inferior, ou borda esquerda
        if(getX() >= getWorld().getWidth() - (getImage().getWidth() / 2) || 
           (getY() >= getWorld().getHeight() - 10) ||
           getX() <= getImage().getWidth() / 2){
            
            getWorld().removeObject(this);
            return true;
        }
    
        return false;
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o jogador principal no jogo.
 * Esta classe controla o movimento, as animações e estado (como vida)
 * do personagem controlado pelo usuário.
 * @author Joao Fernandes 
 * @version 1.0
 */

public class Jogador extends Actor
{
    //Array de imagens para a animação do jogador movendo-se para a direita.
    private GreenfootImage[] animacaoD;
    //Array de imagens para a animação do jogador movendo-se para a esquerda.
    private GreenfootImage[] animacaoE;
    //Contador para controlar o frame atual da animação.
    private int frame;
    //Contador de vida do jogador
    private static int vida;
    //Velocidade de movimento do jogador
    private int velMovimento;

    /**
     * Construtor da classe Jogador.
     * Inicializa os arrays de animação carregando as imagens.
     * Define os valores iniciais para o frame de animação, a vida e a velocidade de movimento. 
     */
    
    public Jogador(){
        animacaoD = new GreenfootImage[4];
        animacaoE = new GreenfootImage[4];

        for (int i = 0; i < animacaoD.length; i++){
            animacaoD[i] = new GreenfootImage("/jogador/run" + (i + 1) + "r.png");
            animacaoE[i] = new GreenfootImage("/jogador/run" + (i + 1) + "l.png");
        }

        frame = 0;

        vida = 2;

        velMovimento = 5;
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Jogador.
     * Ele chama o método de movimento.
     */
    
    public void act()
    {
        movimento();
    }

    /**
     * Verifica a entrada do teclado (teclas "right" e "left") e
     * chama os métodos de movimento correspondentes.
     */
    
    private void movimento(){
        if(Greenfoot.isKeyDown("right")){
            moverDireita();
        }
        if(Greenfoot.isKeyDown("left")){
            moverEsquerda();
        }
    }

    /**
     * Executa o movimento do jogador para a direita.
     * Move o ator 'velMovimento' pixels e atualiza o sprite (imagem)
     * para o próximo quadro da animação 'animacaoD'.
     */
    
    private void moverDireita(){
        move(velMovimento);

        if(frame % 4 == 0){
            frame = 0;
        }

        setImage(animacaoD[frame]);
        frame++;
    }

    /**
     * Executa o movimento do jogador para a esquerda.
     * Move o ator '-velMovimento' pixels (para trás) e atualiza o sprite (imagem)
     * para o próximo quadro da animação 'animacaoE'.
     */
    
    private void moverEsquerda(){
        move(-velMovimento);

        if(frame % 4 == 0){
            frame = 0;
        }

        setImage(animacaoE[frame]);
        frame++;
    }
}

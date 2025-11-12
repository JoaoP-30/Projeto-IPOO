import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um inimigo móvel (Monstro) que patrulha uma área.
 * Ele anda para a esquerda por um tempo, depois vira e anda para a direita,
 * repetindo o ciclo. Ele também causa dano ao contato.
 * * @author Joao Fernandes
 * @version 1.0
 */

public class Monstro extends Inimigos
{
    //Array de imagens para a animação de corrida (reutilizado para D/E com mirror).
    private GreenfootImage[] animacaoD;
    //Contador para o frame atual da animação.
    private int frame;
    //Velocidade de movimento horizontal (negativa = esquerda, positiva = direita).
    private int velocidade;
    //Contador de ciclos para controlar o tempo de patrulha.
    private int cont;
    //Duração que o monstro anda em uma direção antes de virar.
    private int tempo;

    /**
     * Construtor da classe Monstro.
     * Inicializa a animação, carregando e espelhando as imagens.
     * Define os valores iniciais de patrulha (velocidade, tempo).
     * @param jogador A instância do Jogador que está no mundo.
     */

    public Monstro(Jogador jogador){
        super(jogador);

        animacaoD = new GreenfootImage[4];

        for (int i = 0; i < animacaoD.length; i++){
            animacaoD[i] = new GreenfootImage("/monstro/monstro" + (i + 1) + ".png");
            animacaoD[i].mirrorHorizontally();
        }

        frame = 0;

        velocidade = -2;
        cont = 0;
        tempo = 300;
    }

     
    /**
     * Construtor auxiliar afim de facilitar a criação e testes de fases.
     */
    
    public Monstro(){
        super(new Jogador());
        
        animacaoD = new GreenfootImage[4];

        for (int i = 0; i < animacaoD.length; i++){
            animacaoD[i] = new GreenfootImage("/monstro/monstro" + (i + 1) + ".png");
            animacaoD[i].mirrorHorizontally();
        }

        frame = 0;

        velocidade = -2;
        cont = 0;
        tempo = 300;
    }
    
    
    /**
     * Método principal de atuação (loop) do Monstro.
     * Chama os métodos de {@link #movimento()} e {@link #ataque()} a cada ciclo.
     */
    public void act()
    {
        movimento();
        ataque();
    }

    /**
     * Controla a lógica de patrulha (movimento de ida e volta) e a animação.
     * O monstro anda em uma direção (baseada na 'velocidade') por 'tempo' ciclos.
     * Quando 'cont' atinge 'tempo', ele inverte a 'velocidade', espelha
     * todas as suas imagens de animação e zera o 'cont'.
     */
    
    private void movimento(){
        cont++;

        if(frame % 4 == 0){
            frame = 0;
        }

        if(cont < tempo){
            setLocation(getX() + velocidade, getY());
            setImage(animacaoD[frame]);
        }
        else{
            velocidade = -velocidade;

            for (int i = 0; i < animacaoD.length; i++){
                animacaoD[i].mirrorHorizontally();
            }

            cont = 0;
        }

        frame++;
    }

    /**
     * Permite que o mundo (World) altere a velocidade do monstro.
     * Note que o valor recebido é invertido (negado).
     * @param velocidade O novo valor base da velocidade.
     */
    
    public void mudarVelocidade(int velocidade){
        this.velocidade = -(velocidade);
    }

    /**
     * Permite que o mundo (World) altere o tempo (duração) da patrulha.
     * @param tempo O novo número de ciclos antes de virar.
     */
    
    public void mudarTempo(int tempo){
        this.tempo = tempo;
    }
}

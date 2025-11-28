import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa o Boss final do jogo.
 * O Boss é um tipo de {@link Inimigos} que implementa um padrão de ataque e
 * teletransporte baseado em tempo (ticks) e possui uma vida limitada. 
 * @version 1.0
 */
public class Boss extends Inimigos
{
    //Referência ao objeto Jogador para quem os ataques são direcionados.    
    private Jogador jogador;
    //A vida atual do Boss. 
    private int vida;
    //Contador de tempo para o ataque especial. Quando atinge 300, o ataque é lançado.
    private int tempoAtaque;
    //Contador de tempo para o teletransporte. Quando atinge 180, o Boss se move.
    private int tempoTeletransporte;
    //Imagem do Boss virado para a direita.
    private GreenfootImage bossD;
    //Imagem do Boss virado para a esquerda.
    private GreenfootImage bossE;

    /**
     * Construtor principal da classe Boss.
     * Associa o Boss a um {@link Jogador} específico e prepara as imagens,
     * espelhando a imagem de Boss virado para a esquerda (`bossE`).
     * @param jogador O objeto Jogador que o Boss irá perseguir/atacar.
     */
    public Boss(Jogador jogador){
        super(jogador);
        this.jogador = jogador;

        vida = 3;
        tempoAtaque = 0;
        tempoTeletransporte = 0;
        
        bossD = new GreenfootImage("VampI.png");
        bossE = new GreenfootImage("VampI.png");
        
        // Espelha a imagem para que 'bossE' represente o Boss virado para a esquerda
        bossE.mirrorHorizontally();
    }

    /**
     * O método 'Act' é chamado a cada frame de execução.
     * Responsável por checar se o Boss foi atacado e, se ainda tiver vida,
     * gerenciar os contadores de tempo para o ataque especial e o teletransporte.
     */
    
    public void act()
    {
        //Verifica se o Boos sofreu dano
        atacado();

        // Se o Boss ainda tiver vida
        if(!verificaVida()){

            // Lança o ataque especial quando o contador atinge o limite
            if(tempoAtaque == 300){    
                ataqueEspecial();
                tempoAtaque = 0;
            }

            // Executa o teletransporte quando o contador atinge o limite
            if(tempoTeletransporte == 180){
                tesletransporte();
                tempoTeletransporte = 0;
            }

            tempoAtaque++;
            tempoTeletransporte++;
        }
    }

    /**
     * Executa o ataque especial do Boss.
     * Adiciona múltiplos objetos {@link Skull} (projéteis) em posições e direções
     * estratégicas no mundo.
     */
    
    private void ataqueEspecial(){
        // Skull 1: lado direito, indo para a esquerda
        Skull skull1 = new Skull(jogador);
        getWorld().addObject(skull1, 1100, 480);
        skull1.inverterSentido();

        // Skull 2 e 3: lado esquerdo, indo para a direita
        Skull skull2 = new Skull(jogador);
        getWorld().addObject(skull2, 30, 320);

        Skull skull3 = new Skull(jogador);
        getWorld().addObject(skull3, 30, 120);

        // Skull 4: Inicia em uma posição padrão (provavelmente a do Boss ou 0,0)
        Skull skull4 = new Skull(jogador);
        skull4.mudarDirecao();

        // Skulls 5, 6 e 7: No topo do mundo, caindo ou indo para baixo
        Skull skull5 = new Skull(jogador);
        getWorld().addObject(skull5, (getWorld().getWidth() / 2), 0);
        skull5.mudarDirecao();

        Skull skull6 = new Skull(jogador);
        getWorld().addObject(skull6, (getWorld().getWidth() / 2) + 300, 0);
        skull6.mudarDirecao();

        Skull skull7 = new Skull(jogador);
        getWorld().addObject(skull7, (getWorld().getWidth() / 2) - 300, 0);
        skull7.mudarDirecao();
    }

    /**
     * Move o Boss instantaneamente para uma das quatro posições pré-definidas.
     * A posição de destino é escolhida aleatoriamente e a imagem do Boss é
     * atualizada para corresponder à direção escolhida. Tenta 10 vezes garantir
     * que a posição de destino seja diferente da posição atual.
     */
    private void tesletransporte(){
        int posXAtual = getX();
        int posYAtual = getY();

        // Tenta encontrar uma nova posição 10 vezes para evitar teletransportar para o mesmo lugar
        for (int i = 0; i < 10; i++){
            int pos = Greenfoot.getRandomNumber(4);
    
            int posXDestino = 0;
            int posYDestino = 0;
            GreenfootImage imgDestino = null;
            
            // Posição 0: Canto superior direito
            if(pos == 0){
                posXDestino = 1120;
                posYDestino = 38;
                imgDestino = bossE;
            }
            // Posição 1: Canto inferior direito
            else if(pos == 1){
                posXDestino = 1100;
                posYDestino = 508;
                imgDestino = bossE;
            }
            // Posição 2: Canto inferior esquerdo
            else if(pos == 2){
                posXDestino = 100;
                posYDestino = 508;
                imgDestino = bossD;
            }
            // Posição 3: Canto superior esquerdo (próximo à posição inicial)
            else if(pos == 3){
                posXDestino = 35;
                posYDestino = 35;
                imgDestino = bossD;
            }
        
            // Garante que a posição de destino seja diferente da atual antes de teletransportar
            if(posXDestino != posXAtual && posYDestino != posYAtual){
                setLocation(posXDestino, posYDestino);
                setImage(imgDestino);
                break; // Sai do loop após o teletransporte
            }
        }
    }

    /**
     * Verifica se a vida do Boss chegou a zero.
     * Se a vida for menor ou igual a zero, chama os métodos para encerrar a fase
     * (coloca o portal e o caminho final) e remove o Boss do mundo.
     */
    
    private boolean verificaVida(){
        if(vida <= 0){
            portalFinal(); // Adiciona o portal de saída
            caminhoFinal(); // Modifica as plataformas
            
            getWorld().removeObject(this); // Remove o Boss
        }

        return false;
    }

    /**
     * Adiciona o {@link Portal} de saída ao mundo após a derrota do Boss.
     */
    private void portalFinal(){
        Portal portal = new Portal();
        getWorld().addObject(portal, 1123, 499);
        portal.getImage().mirrorHorizontally(); // Inverte a imagem do portal
    }

    /**
     * Modifica o cenário para abrir o caminho até o portal de saída.
     * Adiciona uma série de plataformas de {@link Chao} e um {@link Chao_Falso}
     * e remove todas as plataformas móveis (`Plataforma`) do mundo.
     */
    private void caminhoFinal(){
        World fase = getWorld();

        // Adiciona plataformas de chão formando um caminho
        Chao chao = new Chao(50,25);
        fase.addObject(chao, 338, 588);

        Chao chao2 = new Chao(50,25);
        fase.addObject(chao2, 438, 588);

        Chao chao3 = new Chao(50,25);
        fase.addObject(chao3, 538, 588);

        // Adiciona um "Chão Falso" (armadilha)
        Chao_Falso chao4 = new Chao_Falso(50,25);
        fase.addObject(chao4, 638, 588);

        Chao chao5 = new Chao(50,25);
        fase.addObject(chao5, 738, 588);

        Chao chao6 = new Chao(50,25);
        fase.addObject(chao6, 838, 588);
        
        // Remove todas as plataformas móveis existentes no mundo
        List <Plataforma> plataformas = getWorld().getObjects(Plataforma.class);
    
        for (int i = 0; i < plataformas.size(); i++){
            getWorld().removeObject(plataformas.get(i));
        }
    }

    /**
     * Lógica para lidar com o Boss sendo atingido por um ataque.
     * Verifica se intersecta com um objeto da classe {@link Ataque}. Se sim,
     * diminui a vida, remove o ataque e força um teletransporte imediato.
     */
    
    private void atacado(){
        // Verifica se há um objeto específico da classe Ataque tocando no Boss
        Actor ataque = getOneIntersectingObject(Ataque.class);

        // Se 'ataque' não for nulo, significa que foi atingido
        if(ataque != null){
            vida--; // Tira 1 de vida
            getWorld().removeObject(ataque); // Remove o ataque para evitar dano duplo
            tesletransporte();
        }
    }
}
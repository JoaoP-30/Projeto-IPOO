import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a terceira fase (nível) do jogo.
 * Esta classe é responsável por inicializar todos os objetos, plataformas,
 * inimigos e itens colecionáveis específicos da Fase 3.
 * @author Joao Fernandes 
 * @version 1.0
 */
public class Fase_3 extends Fases
{
    //Jogador principal
    private Jogador jogador;
    //Instância da classe HUD, usada para exibir as informações do jogador 
    private HUD hud;
    
    /**
     * Construtor para objetos da classe Fase_3.
     * Recebe o objeto Jogador da fase anterior para manter seu estado (vida, moedas, etc.).
     * * @param jogador O objeto Jogador que vem da fase anterior.
     */    
    public Fase_3(Jogador jogador)
    {                
        this.jogador = jogador;
        
        Som.obterInstancia().tocarTrilha("Tema1.wav");

        prepare();
    }

    /**
     * Construtor auxiliar para objetos da classe Fase_2.
     * Tem por objetivo facilitar a crição/modificação do mesmo.
     */
    
    public Fase_3(){
        jogador = new Jogador();
        
        prepare();
    }
    
    /**
     * Prepara o mundo da Fase 3.
     * Este método é responsável por criar e adicionar todos os atores 
     * (jogador, plataformas, moedas, inimigos, chave, portal e HUD) 
     * em suas posições iniciais no mundo.
     */
    
    private void prepare(){
        Chao chao = new Chao(200, 100);
        addObject(chao,1068,550);

        Chao chao2 = new Chao(200, 100);
        addObject(chao2,99,550);

        Chao chao3 = new Chao(100, 50);
        addObject(chao3,597,97);

        Plataforma plataforma = new Plataforma(80, 40);
        addObject(plataforma,597,385);
        plataforma.alterarVelocidade(2);

        Chao_Falso chao_Falso = new Chao_Falso(40, 40);
        addObject(chao_Falso,880,561);
        
        Chao chao9 = new Chao(40,40);
        addObject(chao9, 780, 561);
        
        Chao_Falso chao_Falso2 = new Chao_Falso(40,40);
        addObject(chao_Falso2, 680, 561);
        
        Fruta_1 fruta2 = new Fruta_1(jogador);
        addObject(fruta2, 630, 481);
        
        Chao chao10 = new Chao(40,40);
        addObject(chao10, 580, 561);
        
        Chao_Falso chao_Falso3 = new Chao_Falso(40,40);
        addObject(chao_Falso3, 480, 561);
        
        Chao chao11 = new Chao(40,40);
        addObject(chao11, 380, 561);

        Chao_Falso chao_Falso4 = new Chao_Falso(40,40);
        addObject(chao_Falso4, 280, 561);
        
        Chao chao4 = new Chao(90,30);
        addObject(chao4, 1098, 161);

        Chave chave = new Chave(jogador);
        addObject(chave,1065,467);        

        addObject(jogador,599,50);
        jogador.inserirPosicaoInicial(599, 50);

        Monstro monstro = new Monstro(jogador);
        monstro.mudarTempo(80);
        addObject(monstro,1140,490);

        Portal portal = new Portal();
        addObject(portal,19,473);

        hud = new HUD(jogador);
        addObject(hud, 148, 45);       

        Moeda moeda = new Moeda();
        addObject(moeda,1117,83);

        Moeda moeda2 = new Moeda();
        addObject(moeda2,1073,83);

        Moeda moeda3 = new Moeda();
        addObject(moeda3,1117,124);

        Moeda moeda4 = new Moeda();
        addObject(moeda4,1073, 124);

        Chao chao5 = new Chao(40, 40);
        addObject(chao5,1006,246);

        Chao chao6 = new Chao(40, 40);
        addObject(chao6,317,246);

        Chao chao7 = new Chao(40, 40);
        addObject(chao7,217,186);

        Chao chao8 = new Chao(100, 30);
        addObject(chao8, 44, 116);

        Cacto cacto = new Cacto(jogador);
        addObject(cacto,127,471);

        Fruta_1 fruta_1 = new Fruta_1(jogador);
        addObject(fruta_1,40,84);
        
        showText("Capítulo 1 - Fase 3", getWidth() / 2, 20);
    }
    
    /**
     * Define a transição para a próxima fase.
     * Cria uma instância da Tela_Vitoria, passando a pontução e o tempo final,
     * e define o mundo Greenfoot para esta nova "fase".
     */
    
    public void irParaProximaFase(){
        Som.obterInstancia().mutarTrilha();
        
        int pontuacaoFinal = hud.obterPontuacaoFinal();
        int tempoFinal = jogador.obterTempo();
        
        // Muda para a Tela de Vitória, passando a pontuação
        Greenfoot.setWorld(new Tela_Vitoria(pontuacaoFinal, tempoFinal));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a segunda fase (nível) do jogo.
 * Esta classe é responsável por inicializar todos os objetos, plataformas,
 * inimigos e itens colecionáveis específicos da Fase 2.
 * @author Joao Fernandes 
 * @version 1.0
 */
public class Fase_2 extends Fases
{
    //Referência ao jogador principal
    private Jogador jogador;
    //Instância da classe HUD, usada para exibir as informações do jogador
    private HUD hud;
        
    /**
     * Construtor para objetos da classe Fase_2.
     * Recebe o objeto Jogador da fase anterior para manter seu estado (vida, moedas, etc.).
     * * @param jogador O objeto Jogador que vem da fase anterior.
     */    
    
    public Fase_2(Jogador jogador)
    {            
        this.jogador = jogador;
            
        Som.obterInstancia().tocarTrilha("Tema1.wav");

        hud = new HUD(jogador);
        
        prepare();
    }
    
    /**
     * Construtor auxiliar para objetos da classe Fase_2.
     * Tem por objetivo facilitar a crição/modificação do mesmo.
     */
    
    
    public Fase_2(){    
        jogador = new Jogador();
        
        hud = new HUD(jogador);
        
        prepare();
    }
    
    
    /**
     * Prepara o mundo da Fase 2.
     * Este método é responsável por criar e adicionar todos os atores 
     * (jogador, plataformas, moedas, inimigos, chave, portal e HUD) 
     * em suas posições iniciais no mundo.
     */
    
    private void prepare(){
        addObject(jogador,1135,57);
        jogador.inserirPosicaoInicial(1135,57);

        Chao plat1 = new Chao(70, 30);
        addObject(plat1,1115,98);

        Chao plat2 = new Chao(70, 30);
        addObject(plat2,965,158);

        Chao plat3 = new Chao(70, 30);
        addObject(plat3,765,358);

        Chao plat4 = new Chao(70, 30);
        addObject(plat4,895,358);

        Chao plat5 = new Chao(70, 30);
        addObject(plat5,995,450);

        Chao plat6 = new Chao(70, 30);
        addObject(plat6,1119,521);

        Chao plat7 = new Chao(350, 30);
        addObject(plat7,665,158);

        Chao_Falso plat8 = new Chao_Falso(40, 30);
        addObject(plat8,420,158);

        Chao plat9 = new Chao(40, 30);
        addObject(plat9,350,158);

        Chao plat10 = new Chao(150, 30);
        addObject(plat10,220,158);

        Chao plat11 = new Chao(40, 40);
        addObject(plat11,696,575);

        Chao plat12 = new Chao(40, 40);
        addObject(plat12,796,575);

        Chao plat13 = new Chao(40, 40);
        addObject(plat13,896,575);

        Chao grama = new Chao(450, 100);
        addObject(grama,299,550);
        grama.alterarDimensoes(600, 100);

        Monstro monstro = new Monstro(jogador);
        addObject(monstro,585,488);
        
        Monstro monstro2 = new Monstro(jogador);
        monstro2.mudarTempo(170);
        addObject(monstro2, 833, 132);
        
        Moeda moeda = new Moeda(jogador);
        addObject(moeda,533,116);

        Moeda moeda2 = new Moeda(jogador);
        addObject(moeda2,573,116);

        Moeda moeda3 = new Moeda(jogador);
        addObject(moeda3,613,116);

        Moeda moeda4 = new Moeda(jogador);
        addObject(moeda4,653,116);

        Moeda moeda5 = new Moeda(jogador);
        addObject(moeda5,693,116);

        Moeda moeda6 = new Moeda(jogador);
        addObject(moeda6,240,116);

        Moeda moeda7 = new Moeda(jogador);
        addObject(moeda7,200,116);

        Moeda moeda8 = new Moeda(jogador);
        addObject(moeda8,240,76);

        Moeda moeda9 = new Moeda(jogador);
        addObject(moeda9,200,76);

        Chave chave = new Chave(jogador);
        addObject(chave,1131,493);

        Portal portal = new Portal();
        addObject(portal,12,487);

        Fruta_1 fruta_1 = new Fruta_1(jogador);
        addObject(fruta_1,897,541);
        
        hud = new HUD(jogador);
        addObject(hud, 148, 45);
        
        showText("Capítulo 1 - Fase 2", getWidth() / 2, 20);
    }

    /**
     * Define a transição para a próxima fase.
     * Cria uma instância da Fase_3, passando o jogador atual (para manter o estado),
     * e define o mundo Greenfoot para esta nova fase.
     */
    
    public void irParaProximaFase(){
        Som.obterInstancia().mutarTrilha();
        
        Fase_3 proximaFase = new Fase_3(jogador);
            
        Greenfoot.setWorld(proximaFase);
    }
}

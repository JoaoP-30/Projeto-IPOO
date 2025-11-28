import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a primeira fase (nível) do jogo.
 * Esta classe é responsável por inicializar todos os objetos, plataformas,
 * inimigos e itens colecionáveis específicos da Fase 1, bem como o jogador.
 * @author Joao Fernandes
 * @version 1.0
 */
public class Fase_1 extends Fases
{
    //Jogador principal
    private Jogador jogador;
    //Instância da classe HUD, usada para exibir as informações do jogador 
    private HUD hud;
    
    /**
     * Construtor para objetos da classe Fase_1.
     * Inicializa um novo jogador e chama o método prepare() para construir o nível.
     */
    
    public Fase_1()
    {    
        jogador = new Jogador();
        
        Som.obterInstancia().tocarTrilha("Tema1.wav");
        prepare();
    }    
    
    /**
     * Prepara o mundo da Fase 1.
     * Este método é responsável por criar e adicionar todos os atores 
     * (jogador, plataformas, moedas, inimigos, chave, portal e HUD) 
     * em suas posições iniciais no mundo.
     */
    
    private void prepare(){
        Chao chao = new Chao(230, 80);
        addObject(chao,115,562);

        Chao chao2 = new Chao(230, 80);
        addObject(chao2, 344, 562);

        Chao chao3 = new Chao(230, 80);
        addObject(chao3, 573, 562);

        Chao chao4 = new Chao(230, 80);
        addObject(chao4, 802, 562);
        
        Chao_Falso chao5 = new Chao_Falso(80, 80);
        addObject(chao5,956,562);

        Chao chao6 = new Chao(160, 80);
        addObject(chao6, 1076, 562);
        
        addObject(jogador,24,503);
        jogador.inserirPosicaoInicial(24, 503);
        
        Moeda moeda = new Moeda(jogador);
        addObject(moeda,382,418);

        Moeda moeda2 = new Moeda(jogador);
        addObject(moeda2,462,418);

        Moeda moeda3 = new Moeda(jogador);
        addObject(moeda3,542,418);
    
        Cacto cacto = new Cacto(jogador);
        addObject(cacto,830,493);

        Chao chao7 = new Chao(150, 50);
        addObject(chao7,1115,443);
        chao7.alterarDimensoes(70, 30);

        Chao chao8 = new Chao(150, 50);
        addObject(chao8,1003,367);
        chao8.alterarDimensoes(70, 30);

        Chao chao9 = new Chao(150, 50);
        addObject(chao9,1115, 281);
        chao9.alterarDimensoes(70, 30);

        Chao chao10 = new Chao(150, 50);
        addObject(chao10,1003, 195);
        chao10.alterarDimensoes(70, 30);

        Chao chao11 = new Chao(150, 50);
        addObject(chao11,1115, 109);
        chao11.alterarDimensoes(70, 30);

        Chao chao12 = new Chao(150, 50);
        addObject(chao12,903, 195);
        chao12.alterarDimensoes(70, 30);

        Chao_Falso chao13 = new Chao_Falso(70, 30);
        addObject(chao13,803, 195);

        Chao chao14 = new Chao(150, 50);
        addObject(chao14,703, 195);
        chao14.alterarDimensoes(70, 30);

        Chao chao15 = new Chao(150, 50);
        addObject(chao15,603, 195);
        chao15.alterarDimensoes(70, 30);

        Chao chao16 = new Chao(150, 50);
        addObject(chao16,503, 195);
        chao16.alterarDimensoes(70, 30);

        Chao_Falso chao17 = new Chao_Falso(70, 30);
        addObject(chao17,403, 195);

        Chao chao18 = new Chao(150, 50);
        addObject(chao18,303, 195);
        chao18.alterarDimensoes(70, 30);

        Chao chao19 = new Chao(150, 50);
        addObject(chao19,203, 195);
        chao19.alterarDimensoes(70, 30);

        Chao_Falso chao20 = new Chao_Falso(70, 30);
        addObject(chao20,103, 150);

        Chao chao21 = new Chao(150, 50);
        addObject(chao21,34, 150);
        chao21.alterarDimensoes(70, 30);

        Chave chave = new Chave(jogador);
        addObject(chave,1134,75);
        chave.setLocation(1134,77);

        Portal portal = new Portal();
        addObject(portal,21,104);
        
        hud = new HUD(jogador);
        addObject(hud, 148, 45);
        
        showText("Capítulo 1 - Fase 1", getWidth() / 2, 20);
    }

    /**
     * Define a transição para a próxima fase.
     * Cria uma instância da Fase_2, passando o jogador atual (para manter o estado),
     * e define o mundo Greenfoot para esta nova fase.
     */
    
    public void irParaProximaFase(){
        Pontuacao.obterInstancia().adicionarPontuacao("Fase_1",hud.obterPontos());
        
        Som.obterInstancia().mutarTrilha();
        
        Fase_2 proximaFase = new Fase_2(jogador);
        
        Greenfoot.setWorld(proximaFase);
    }
}

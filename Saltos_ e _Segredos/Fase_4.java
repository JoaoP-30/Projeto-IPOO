import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a sexta fase do jogo.
 * Esta fase é caracterizada por uma disposição específica de plataformas, chão e
 * a presença do {@link Boss}. Ela herda funcionalidades básicas de {@link Fases}.
 * @version 2.0
 */

public class Fase_4 extends Fases
{
    //O objeto Jogador que está sendo controlado na fase.
    private Jogador jogador;
    //Instância da classe HUD, usada para exibir as informações do jogador 
    private HUD hud;

    /**
     * Construtor para objetos da classe Fase_6.
     * Este construtor é usado para carregar o estado de um {@link Jogador} existente
     * (por exemplo, ao avançar de uma fase anterior).
     * @param jogador O objeto Jogador a ser usado nesta fase.
     */
    
    public Fase_4(Jogador jogador)
    {
        this.jogador = jogador;
        
        jogador.definirVida(jogador.obterVida() + 1);
        
        Som.obterInstancia().tocarTrilha("Tema1.wav");
        
        prepare();
    }

    /**
     * Prepara o mundo para o início do programa.
     * Cria e adiciona os objetos iniciais (plataformas, chão, jogador, boss e HUD)
     * ao mundo.
     */
    private void prepare()
    {
        // Criação de plataformas móveis
        Plataforma plataforma = new Plataforma(90, 25);
        addObject(plataforma,236,429);
        plataforma.alterarVelocidade(2); // Altera a velocidade da plataforma

        Plataforma plataforma2 = new Plataforma(90, 25);
        addObject(plataforma2,196,229);
        plataforma2.alterarVelocidade(2);

        Plataforma plataforma3 = new Plataforma(90, 25);
        addObject(plataforma3,156,329);
        plataforma3.alterarVelocidade(2);

        Plataforma plataforma4 = new Plataforma(90, 25);
        addObject(plataforma4,126,129);
        plataforma4.alterarVelocidade(2);

        // Criação das áreas de chão (plataformas fixas)
        Chao chao = new Chao(70,25);
        addObject(chao, 25, 68);

        Chao chao2 = new Chao(200, 75);
        addObject(chao2,1050,562);

        Chao chao3 = new Chao(200,75);
        addObject(chao3, 100, 562);

        Chao chao4 = new Chao(70,25);
        addObject(chao4, 1120, 68);

        Fruta_1 fruta = new Fruta_1(jogador);
        addObject(fruta, 1120, 38);

        Chao chao5 = new Chao(120,25);
        addObject(chao5, 388, 588);

        Chao chao7 = new Chao(120,25);
        addObject(chao7, 588, 588);

        Chao chao9 = new Chao(120,25);
        addObject(chao9, 788, 588);

        // Adiciona o jogador (posição inicial)
        addObject(jogador, 25, 500);
        jogador.inserirPosicaoInicial(25, 500);

        // Adiciona o Boss à fase
        Boss boss = new Boss(jogador);
        addObject(boss, 40, 38);

        // Adiciona o HUD
        hud = new HUD(jogador);
        addObject(hud, 148, 45);       

        Barreira barreira = new Barreira();
        addObject(barreira,185,524);

        Barreira barreira2 = new Barreira();
        addObject(barreira2,185,494);

        Barreira barreira3 = new Barreira();
        addObject(barreira3,965,524);

        Barreira barreira4 = new Barreira();
        addObject(barreira4,965,494);

        Barreira barreira5 = new Barreira();
        addObject(barreira5,185,464);
        
        Barreira barreira6 = new Barreira();
        addObject(barreira6,965,464);
        
        showText("Fase 4 - A Ultima Aventura", getWidth() / 2, 20);
    }

    /**
     * Executa as ações necessárias para avançar para a próxima fase (Tela de Vitória).
     * Salva a pontuação da fase atual, muta a trilha sonora, calcula a pontuação
     * final e o tempo final, e então muda o mundo para a {@link Tela_Vitoria}.
     */
    public void irParaProximaFase(){
        // Salva a pontuação desta fase
        Pontuacao.obterInstancia().adicionarPontuacao("Fase_4",jogador.calcularPontuacaoBase());
        
        // Muta a trilha sonora
        Som.obterInstancia().mutarTrilha();

        // Obtém a pontuação e o tempo finais
        int pontuacaoFinal = jogador.calcularPontuacaoFinal();
        int tempoFinal = jogador.obterTempo();

        // Muda para a Tela de Vitória, passando a pontuação e tempo finais
        Greenfoot.setWorld(new Tela_Vitoria(pontuacaoFinal, tempoFinal));
    }

    /***
     * Sobrescreve o método responsável por armazenar a pontuação atual em caso de derrota.  
     */
    
    @Override
    public void setarPontuacaoDaFase(){
        Pontuacao.obterInstancia().adicionarPontuacao("Fase_4", jogador.calcularPontuacaoBase());
    }
}
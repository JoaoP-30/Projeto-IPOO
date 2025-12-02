import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela de Vitória: Exibe a pontuação final e estatísticas.
 * @version 2.0
 */

public class Tela_Vitoria extends Fases
{
    // Variáveis para armazenar os dados recebidos
    private int pontosTotal;
    private int tempoTotal;

    /**
     * Construtor atualizado para receber os dados do jogo.
     * @param moedas O número total de moedas/pontos.
     * @param tempo O tempo final do jogador.
     */
    public Tela_Vitoria(int pnts, int tempo)
    {    
        this.pontosTotal = pnts;
        this.tempoTotal = tempo;
        
        prepararVisual();
    }
      
    /**
     * Método separado para organizar a lógica visual.
     */
    private void prepararVisual() 
    {
        // 1. Configura a imagem de fundo
        GreenfootImage fundo = new GreenfootImage("como_jogar.png");
        fundo.scale(getWidth(), getHeight());
        
        setBackground(fundo);
        
        // 3. Título "VOCÊ VENCEU!"
        fundo.setColor(new Color(50, 255, 50)); // Verde mais brilhante
        fundo.setFont(new Font("Impact", true, false, 60));
        
        // Centraliza o texto horizontalmente
        fundo.drawString("VOCÊ VENCEU!", 360, 150);
        
        // 4. Pontuação Principal
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Comic Sans MS", true, false, 30));
        fundo.drawString("Pontuação Final: " + pontosTotal + " pnts", 400, getHeight() / 2 - 80);
        fundo.drawString("Tempo total: " + tempoTotal + "s", 460, getHeight() / 2 - 40);
        
        // 5. Detalhes das Fases
        fundo.setFont(new Font("Comic Sans MS", false, false, 20));
        Color corFases = new Color(0, 0, 0);
        fundo.setColor(corFases);

        int coluna1_X = getWidth() / 2 - 150;
        int coluna2_X = getWidth() / 2 + 50;
        int inicioY = getHeight() / 2 + 30;
        int espacoY = 30;
            
        fundo.drawString("Fase 1: " + Pontuacao.obterInstancia().obterPontuacaoTotalLiquidaFase("Fase_1") + " pnts", coluna1_X, inicioY);
        fundo.drawString("Fase 2: " + Pontuacao.obterInstancia().obterPontuacaoTotalLiquidaFase("Fase_2")  + " pts", coluna2_X, inicioY);
        
        fundo.drawString("Fase 3: " + Pontuacao.obterInstancia().obterPontuacaoTotalLiquidaFase("Fase_3") + " pts", coluna1_X, inicioY + espacoY);
        fundo.drawString("Fase 4: " + Pontuacao.obterInstancia().obterPontuacaoTotalLiquidaFase("Fase_4") + " pts", coluna2_X, inicioY + espacoY);

        // 6. Botão Voltar
        PainelJogo btnMenu = new PainelJogo("Voltar ao Menu", 100);
        // Posiciona o botão centralizado na parte inferior
        addObject(btnMenu, getWidth() / 2, getHeight() - 100);
        
        // Som
        Som.obterInstancia().tocarTrilha("Intro.wav");
    }
    
    /**
     * Verifica o clique no botão.
     */
    public void botaoClicado(int id)
    {
        if (id == 100) 
        {   
            Greenfoot.setWorld(new Tela_Inicial());
        }
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  A tela de vitoria aparece quando o jogador completa a última fase.
 * Exibe a pontuação final (moedas e tempo).
 * @author (Seu Nome / Joao Fernandes / Maria Clara O Pereira) 
 * @version 1.0
 */
public class Tela_Vitoria extends Fases
{
    /**
     * Construtor.
     * @param moedas O número de moedas que o jogador coletou.
     * @param tempo O tempo final do jogador.
     */
    public Tela_Vitoria(int pontos, int tempo)
    {    
        // Mesmo fundo do menu instrucoes
        GreenfootImage fundo = new GreenfootImage("como_jogar.png");
        fundo.scale(getWidth(), getHeight());
        setBackground(fundo);
        
        fundo.setColor(new Color(50, 205, 50));
        fundo.setFont(new Font("Impact", true, false, 80));
        fundo.drawString("VOCÊ VENCEU!", 320, 200);
        
        // Pontuação Final
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Comic Sans MS", false, false, 30));
        
        fundo.drawString("Pontuação: " + pontos + " pnts", 450, 300);
        fundo.drawString("Tempo total: " + tempo + "s", 450, 350);
        
        // Botão (id 100)
        PainelJogo btnMenu = new PainelJogo("Voltar ao Menu", 100);
        addObject(btnMenu, 575, 500);
    }
    
    /**
     * Verifica o clique no botão "Voltar" igual a logica do menu de intrucoes.
     */
    public void botaoClicado(int id)
    {
            if (id == 100) // id 100 = Voltar ao Menu
        {
            Som.obterInstancia().mutarTrilha();
            Som.obterInstancia().tocarTrilha("Intro.wav");
            Greenfoot.setWorld(new Tela_Inicial());
        }
    }
}
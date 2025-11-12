import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela de "Game Over" aparece quando a vida do jogador chega a zero.
 * @author (Seu Nome / Joao Fernandes / Maria Clara O Pereira) 
 * @version 1.0
 */
public class Tela_Derrota extends Fases
{
    /**
     * Construtor da Tela_Derrota.
     */
    public Tela_Derrota(int pontos, int tempo)
    {     
        // Usa o mesmo fundo do menu instrucoes
        GreenfootImage fundo = new GreenfootImage("como_jogar.png");
        fundo.scale(getWidth(), getHeight());
        setBackground(fundo);
        
        // Escreve "Game Over"
        fundo.setColor(new Color(178, 34, 34));
        fundo.setFont(new Font("Impact", true, false, 80));
        fundo.drawString("GAME OVER", 350, 200);
        
        // Pontuação Final
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Comic Sans MS", false, false, 30));
        
        fundo.drawString("Pontuação: " + pontos + " pnts", 450, 300);
        fundo.drawString("Tempo total: " + tempo + "s", 450, 350);
        
        // Cria um botão para voltar ao menu (id 100)
        PainelJogo btnMenu = new PainelJogo("Voltar ao Menu", 100);
        addObject(btnMenu, 575, 500);
    }
    
    /**
     * Verifica o clique no botão "Voltar" igual a logica do menu de intruções.
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
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dicas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dicas extends Fases
{

    /**
     * Constructor for objects of class Dicas.
     * 
     */
    public Dicas()
    {
        background();
    
        desenharTutorial();
        
        adicionarBotaoVoltar();
    }

    private void background(){
        // Imagem de fundo
        GreenfootImage fundoLayout = new GreenfootImage("como_jogar.png");
        fundoLayout.scale(getWidth(), getHeight());
        setBackground(fundoLayout);
    }
    
    /**
     * Imprime os textos do tutorial.
     */
    private void desenharTutorial()
    {
        GreenfootImage fundo = getBackground();
        
        // Título da Página
        fundo.setColor(Color.WHITE); 
        fundo.setFont(new Font("Comic Sans MS", true, false, 40)); 
        fundo.drawString("    Dicas   ", 465, 60);
        
        int xTexto = 50; // Posição horizontal
        int yTexto = 120; // Posição vertical
        int espacoLinha = 35; // Espaço entre as linhas
        
        // Frase de comandos
        fundo.setFont(new Font("Verdana", false, false, 22));
        fundo.setColor(Color.BLACK); 
            
        int xComando = xTexto + 20;
        int xDescricao = xComando + 10;
        
        //--- Queda ---
        
        fundo.drawString("•", xComando, yTexto);
        fundo.drawString("Queda no void:", xComando + 30, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Se cair no void e ainda tiver vidas, você será teletransportado para o início.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Caso contrário, você perde a partida.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        
        //--- Invulnerabilidade ---
        
        fundo.drawString("•", xComando, yTexto);
        fundo.drawString("Invulnerabilidade Temporária:", xComando + 30, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Após tomar dano, você terá 3 segundos de invulnerabilidade.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        
        //--- Bônus ----
        
        fundo.drawString("•", xComando, yTexto);
        fundo.drawString("Bônus:", xComando + 30, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Em caso de vitória, quanto menor a duração da partida, maior será o seu bônus de pontuação.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Em caso de derrota, não há bônus.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        
        //-- Inimigos ---
        
        fundo.drawString("•", xComando, yTexto);
        fundo.drawString("Atenção aos Obstáculos/Inimigos", xComando + 30, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Nem todos são eliminados pelo ataque. Tome cuidado!", xDescricao + 50, yTexto);
    }
    
    /**
     * Adiciona um botão "Voltar" (usando a classe PainelJogo).
     */
    private void adicionarBotaoVoltar()
    {
        // Usamos um id que não conflite com os id´s 1 e 2
        PainelJogo btnVoltar = new PainelJogo("Voltar", 99);
        addObject(btnVoltar, 565, 500); // Centralizado na parte inferior
    }
    
    /**
     * Gerencia o clique no botão "Voltar".
     * Este método será chamado pelo PainelJogo.
     */
    public void botaoClicado(int id)
    {
        // Se o botão voltar (ID 99) for clicado
        if (id == 99)
        {
            // Volta para a Tela Inicial
            Greenfoot.setWorld(new Tela_Inicial());
        }
    }
}
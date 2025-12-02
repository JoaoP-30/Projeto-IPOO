import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a tela de Dicas ou Tutorial do jogo.
 * Esta tela exibe informações úteis sobre a jogabilidade, como regras de queda,
 * invulnerabilidade temporária e bônus de pontuação.
 * @version 1.5
 */
public class Dicas extends Fases
{

    /**
     * Construtor para objetos da classe Dicas.
     * * Configura o plano de fundo, desenha o conteúdo do tutorial e adiciona
     * o botão de voltar.
     */
    public Dicas()
    {
        background();
    
        desenharTutorial();
        
        adicionarBotaoVoltar();
    }

    /**
     * Define a imagem de fundo para a tela de Dicas.
     * A imagem "como_jogar.png" é carregada e escalada para cobrir toda a área do mundo.
     */
    private void background(){
        // Imagem de fundo
        GreenfootImage fundoLayout = new GreenfootImage("como_jogar.png");
        // Escala a imagem de fundo para as dimensões atuais do mundo
        fundoLayout.scale(getWidth(), getHeight());
        setBackground(fundoLayout);
    }
    
    /**
     * Imprime os textos informativos (dicas) do tutorial na imagem de fundo.
     * Inclui o título da página e diversos pontos sobre a jogabilidade.
     */
    private void desenharTutorial()
    {
        GreenfootImage fundo = getBackground();
        
        // Título da Página
        fundo.setColor(Color.WHITE); 
        // Define a fonte para o título
        fundo.setFont(new Font("Comic Sans MS", true, false, 40)); 
        fundo.drawString("    Dicas   ", 465, 60);
        
        int xTexto = 50; // Posição horizontal inicial para o texto
        int yTexto = 120; // Posição vertical inicial para o texto
        int espacoLinha = 35; // Espaço em pixels entre as linhas de texto
        
        // Define a fonte e cor para o corpo do texto
        fundo.setFont(new Font("Verdana", false, false, 22));
        fundo.setColor(Color.BLACK); 
            
        int xComando = xTexto + 20; // Posição X para o marcador de tópico (•)
        int xDescricao = xComando + 10; // Posição X para o texto de descrição
        
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
        fundo.drawString("Em caso de vitória, quanto menor a duração da partida e maior a quantiade de vidas", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("restantes maior será o seu bônus de pontuação. Em caso de derrota, não há bônus.", xDescricao + 50, yTexto);
        yTexto += espacoLinha;
        
        //-- Inimigos ---
        
        fundo.drawString("•", xComando, yTexto);
        fundo.drawString("Atenção aos Obstáculos/Inimigos", xComando + 30, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("Nem todos são eliminados pelo ataque. Tome cuidado!", xDescricao + 50, yTexto);
    }
    
    /**
     * Adiciona um botão "Voltar" à tela.
     * O botão é uma instância da classe {@link PainelJogo} com um ID específico (99)
     * para gerenciar seu clique.
     */
    private void adicionarBotaoVoltar()
    {
        PainelJogo btnVoltar = new PainelJogo("Voltar", 99);
        // Adiciona o botão centralizado na parte inferior do mundo
        addObject(btnVoltar, 565, 500); 
    }
    
    /**
     * Gerencia a ação de clique nos botões presentes nesta tela.
     * Este método é tipicamente chamado por um objeto {@link PainelJogo} quando clicado.
     * @param id O identificador único do botão que foi clicado.
     */
    public void botaoClicado(int id)
    {
        // Se o botão voltar (ID 99) for clicado
        if (id == 99)
        {
            // Volta para a Tela Inicial, carregando um novo mundo
            Greenfoot.setWorld(new Tela_Inicial());
        }
    }
}
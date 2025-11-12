import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Tela Inicial do jogo.
 * @author (Seu Nome / Joao Fernandes / Maria Clara O Pereira) 
 * @version 1.0
 */
public class Tela_Inicial extends Fases
{
    public Tela_Inicial()
    {    
        background();
        adicionarBotoes();
        prepare();
    }

    private void background(){
        GreenfootImage fundoLayout = new GreenfootImage("painel_inicial.png");
        fundoLayout.scale(getWidth(), getHeight());
        setBackground(fundoLayout);
    }

    /**
     * MUDANÇA: Adiciona os botões empilhados verticalmente no centro.
     */
    private void adicionarBotoes()
    {
        // Define a mesma posição horizontal pra todos os botões
        int xCentro = 575; //centro do mundo
        
        // Define as alturas dos botões
        int yBotao1 = 270; // Botão de cima
        int yBotao2 = 350; // Botão do meio
        int yBotao3 = 430; // Botão de baixo
        
        // Botão 1: 1 Jogador (id 1)
        PainelJogo btn1 = new PainelJogo("1 Jogador", 1);
        addObject(btn1, xCentro, yBotao1);
        
        // Botão 2: 2 Jogadores (id 2)
        PainelJogo btn2 = new PainelJogo("2 Jogadores", 2);
        addObject(btn2, xCentro, yBotao2);
        
        // Botão 3: Como Jogar? (id 3)
        PainelJogo btnComoJogar = new PainelJogo("Como Jogar?", 3); 
        addObject(btnComoJogar, xCentro, yBotao3);
    }

    public void botaoClicado(int id)
    {
        if (id == 1)
        {
            Som.obterInstancia().mutarTrilha();
            Greenfoot.setWorld(new Fase_1());
        }
        else if (id == 2)
        {
            //Atualmente não faz nada
        }
        // Verifica se o botão "Como Jogar?" foi clicado
        else if (id == 3) 
        {
            // Vai para a tela de instruções que acabamos de criar
            Greenfoot.setWorld(new Tela_Instrucoes());
        }
    }

    /**
     * Prepara o mundo para o início do programa.
     * criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
    }

    public void started(){
        Som.obterInstancia().tocarTrilha("Intro.wav");
    }
}

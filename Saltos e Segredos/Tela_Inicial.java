import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Tela Inicial do jogo.
 * @author (Seu Nome / Joao Fernandes / Maria Clara O Pereira) 
 * @version 1.0
 */
public class Tela_Inicial extends World
{
    private static GreenfootSound trilha;
    
    public Tela_Inicial()
    {    
        // Cria um novo mundo com 1150x600 células com um tamanho de célula de 1x1 pixels.
        super(1150, 600, 1); 
        
        background();
        desenharTextos();
        adicionarBotoes();
        prepare();
    }

    private void background(){
        GreenfootImage fundoLayout = new GreenfootImage("painel_inicial.png");
        fundoLayout.scale(getWidth(), getHeight());
        setBackground(fundoLayout);
    }

    /**
     * MUDANÇA: Agora este método está VAZIO.
     * O título agora faz parte da imagem de fundo.
     */
    private void desenharTextos()
    {
        // O nome do jogo foi implementado direto na imagem de fundo
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
            trilha.stop();
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
        trilha = new GreenfootSound("first.mp3");
        trilha.playLoop();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este Mundo mostra as instruções do jogo e um botão "Voltar".
 * @author (Maria Clara O Pereira) 
 * @version 1.0
 */
public class Tela_Instrucoes extends Fases
{
    /**
     * Construtor da Tela_Instrucoes.
     */
    public Tela_Instrucoes()
    {    
        // A mesma imagem de fundo
        background();
        
        // O texto do tutorial
        desenharTutorial();
        
        // Adiciona o botão para voltar
        adicionarBotaoVoltar();
    }
    
    /**
     * Define o fundo da imagem parecido com a Tela Inicial.
     */
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
        fundo.drawString("--- Como Jogar ---", 370, 100);
        
        // Texto de introdução
        fundo.setColor(Color.WHITE); 
        fundo.setFont(new Font("Comic Sans MS", true, false, 24)); // true = NEGRITO
        
        int xTexto = 250; // Posição horizontal
        int yTexto = 200; // Posição vertical
        int espacoLinha = 35; // Espaço entre as linhas
        
        fundo.drawString("Sua missão é explorar este mundo, desviar dos monstros", xTexto, yTexto);
        yTexto += espacoLinha;
        fundo.drawString("e coletar todos os itens para encontrar a saída!", xTexto, yTexto);
        
        yTexto += espacoLinha * 2;

        // Frase de comandos
        fundo.setFont(new Font("Verdana", false, false, 22));
        fundo.setColor(Color.WHITE); 
        
        int xComando = xTexto + 20;
        int xDescricao = xComando + 350;
        
        fundo.drawString("Setas Esquerda/Direita:", xComando, yTexto);
        fundo.drawString("Movem o personagem.", xDescricao, yTexto);
        yTexto += espacoLinha;
        
        fundo.drawString("Seta Cima:", xComando, yTexto);
        fundo.drawString("Pular.", xDescricao, yTexto);
        yTexto += espacoLinha;
        
        fundo.drawString("Tecla 'C':", xComando, yTexto);
        fundo.drawString("Entrar no portal (sobre ele).", xDescricao, yTexto);
        yTexto += espacoLinha;
        
        fundo.drawString("Tecla 'M':", xComando, yTexto);
        fundo.drawString("Mutar a música.", xDescricao, yTexto);
        yTexto += espacoLinha;
        
        fundo.drawString("Tecla 'P':", xComando, yTexto);
        fundo.drawString("Desmutar a música.", xDescricao, yTexto);
    }
    
    /**
     * Adiciona um botão "Voltar" (usando a classe PainelJogo).
     */
    private void adicionarBotaoVoltar()
    {
        // Usamos um id que não conflite com os id´s 1 e 2
        PainelJogo btnVoltar = new PainelJogo("Voltar", 99);
        addObject(btnVoltar, 575, 500); // Centralizado na parte inferior
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
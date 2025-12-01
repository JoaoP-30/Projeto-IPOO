import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um item coletável do tipo Fruta, que serve para aumentar a vida do jogador.
 * Herda o comportamento básico de coleta da classe Coletaveis.
 * @version 2.0
 */

public class Fruta_1 extends Coletaveis
{
    /**
     * Construtor para objetos da classe Fruta_1.
     * @param jogador A instância do jogador que pode coletar este item.
     */
    
    public Fruta_1(Jogador jogador)
    {
        super(jogador);
        // Define o tamanho da imagem da fruta.
        getImage().scale(34,36);
    }
    
    /**
     * Sobrescreve o método da superclasse para aplicar o efeito da Fruta.
     * Aumenta a vida do jogador.
     */
    
    @Override
    protected void aplicarEfeito()
    {
        obterJogador().aumentarVida();
    }
    
    /**
     * Sobrescreve o método da superclasse para obter o nome do som de coleta.
     * @return O nome do arquivo de som de 'power-up'.
     */
    
    @Override
    protected String obterNomeEfeitoSonoro()
    {
        return "power_up.wav";
    }
    
    /**
     * O método 'act' é executado a cada frame.
     * Chama o método para verificar a coleta do item.
     */
    
    public void act()
    {
        coletar();
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um item coletável do tipo Chave.
 * A chave geralmente é usada para desbloquear o portal e tem um efeito sonoro de moeda.
 * Herda o comportamento básico de coleta da classe Coletaveis.
 * @version 2.0
 */

public class Chave extends Coletaveis{

    /**
     * Construtor para objetos da classe Chave.
     * @param jogador A instância do jogador que pode coletar este item.
     */

    public Chave(Jogador jogador)
    {
        super(jogador);
    }

    /**
     * Sobrescreve o método da superclasse para aplicar o efeito da Chave.
     */

    @Override
    protected void aplicarEfeito()
    {

    }

    /**
     * Sobrescreve o método da superclasse para obter o nome do som de coleta.
     * @return O nome do arquivo de som de 'moeda'.
     */

    @Override
    protected String obterNomeEfeitoSonoro()
    {
        return "coin.wav";
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
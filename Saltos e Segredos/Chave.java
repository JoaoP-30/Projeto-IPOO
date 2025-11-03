import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um item "Chave" que pode ser coletado pelo jogador.
 * Esta é uma implementação concreta da classe {@link Coletaveis}.
 * @author Joao Fernandes
 * @version 1.0
 */
public class Chave extends Coletaveis
{
    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Chave.
     * A cada ciclo, ele chama o método {@link Coletaveis#coletar()}
     */
    public void act()
    {
        // Chama o método herdado da classe Coletaveis
        coletar();
    }
}

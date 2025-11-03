import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe abstrata base para todos os itens coletáveis no jogo.
 * Define o comportamento padrão que ocorre quando um jogador "coleta" o item.
 * @author Joao Fernandes 
 * @version 1.0
 */
public abstract class Coletaveis extends Actor
{
    //Instância da classe Som, usada para tocar o efeito sonoro da coleta
    private Som som;

    /**
     * Construtor da classe Coletaveis.
     * Inicializa o objeto 'som' para preparar o efeito sonoro.
     */

    public Coletaveis(){
        som = new Som();
    }

    /**
     *  Verifica se o {@link Jogador} tocou neste objeto e, em caso afirmativo,
     *  executa a lógica de coletar.
     *  Este método é chamado dentro do método 'act()' das subclasses.
     */

    public void coletar(){
        Actor jogador = getOneIntersectingObject(Jogador.class);

        if(jogador != null){
            som.tocarEfeito("coin.wav");
            getWorld().removeObject(this);
        }
    }
}

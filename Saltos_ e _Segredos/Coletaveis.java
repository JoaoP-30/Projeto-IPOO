import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse abstrata para todos os itens coletáveis no jogo (Moedas, Frutas, Chaves, etc.).
 * Esta classe define o comportamento básico de coleta, a aplicação de efeitos e a reprodução
 * de som ao ser coletada.
 * @version 2.0
 */

public abstract class Coletaveis extends Actor
{
    //Referência ao jogador principal, usada para aplicar os efeitos da coleta (ex: vida, pontos).
    private Jogador jogador;

    /**
     * Construtor para objetos da classe Coletaveis.
     * @param jogador A instância do jogador que pode coletar este item.
     */

    public Coletaveis(Jogador jogador)
    {
        this.jogador = jogador;
    }

    /**
     * Método abstrato a ser implementado pelas subclasses.
     * Define o efeito específico que o item coletável aplica ao jogador (ex: aumentar vida, pontuar).
     */

    protected abstract void aplicarEfeito();

    /**
     * Método abstrato a ser implementado pelas subclasses.
     * Retorna o nome do arquivo de efeito sonoro que deve ser tocado na coleta.
     * @return O nome do arquivo de som (ex: "coin.wav").
     */

    protected abstract String obterNomeEfeitoSonoro();

    /**
     * Verifica se o item coletável está em contato (intersecção) com o jogador.
     * Se estiver, aplica o efeito, toca o som e remove o objeto do mundo.
     */

    protected void coletar()
    {
        Actor player = getOneIntersectingObject(Jogador.class);

        if(player != null){
            aplicarEfeito();

            Som.obterInstancia().tocarEfeito(obterNomeEfeitoSonoro());

            getWorld().removeObject(this);
        }
    }

    /**
     * Retorna a referência do objeto Jogador.
     * @return A instância do jogador.
     */

    protected Jogador obterJogador()
    {
        return jogador;
    }
}

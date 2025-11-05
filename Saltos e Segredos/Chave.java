import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um item "Chave" que pode ser coletado pelo jogador.
 * Esta é uma implementação concreta da classe {@link Coletaveis}.
 * @author Joao Fernandes
 * @version 1.0
 */
public class Chave extends Coletaveis
{
    // Define a ação que esta fruta executará ao ser coletada (3 = pegar chave).
    private int acao;

    /**
     * Construtor da classeChave
     * <p>
     * Inicializa o coletável, define sua ação específica como '3' (que, na classe 
     * {@link Coletaveis}, corresponde a {@link Jogador#pegouAChave();}) e 
     * ajusta o tamanho da imagem do ator.
     * * @param jogador A referência ao jogador, passada para a superclasse {@link Coletaveis}.
     */
    
    public Chave(Jogador jogador){
        super(jogador);
        acao = 3;
    }

    /**
     * Construtor auxiliar afim de facilitar testes e criação de novas fases.
     */
    
    public Chave(){
        super(new Jogador());
        acao = 3;
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Chave.
     * Define sua ação específica como '3' (que, na classe 
     * {@link Coletaveis}, corresponde a {@link Jogador#pegarChave()}) e 
     * @param jogador A referência ao jogador, passada para a superclasse {@link Coletaveis}.
     */
    public void act()
    {
        // Chama o método herdado da classe Coletaveis
        coletar(acao, "coin.wav");
    }
}

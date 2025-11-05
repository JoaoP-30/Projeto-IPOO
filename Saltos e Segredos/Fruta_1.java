import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruta_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruta_1 extends Coletaveis
{
    // Define a ação que esta fruta executará ao ser coletada (2 = aumentar vida).
    private int acao;
    
    
    /**
     * Construtor da classe Fruta_1.
     * <p>
     * Inicializa o coletável, define sua ação específica como '2' (que, na classe 
     * {@link Coletaveis}, corresponde a {@link Jogador#aumentarVida()}) e 
     * ajusta o tamanho da imagem do ator.
     * * @param jogador A referência ao jogador, passada para a superclasse {@link Coletaveis}.
     */
    
    public Fruta_1(Jogador jogador){
        super(jogador);
        
        acao = 2;
        
        getImage().scale(34,36);
    }
    
    /**
     * Construtor auxiliar afim de facilitar testes e criação de novas fases.
     */
    
    public Fruta_1(){
        super(new Jogador());
        acao = 2;
    }
    
    
    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Fruta_1.
     * <p>
     * A cada ciclo, ele chama o método {@link Coletaveis#coletar(int, String)},
     * passando a ação '2' (aumentar vida) e o efeito sonoro "power_up.wav".
     */
    
    public void act()
    {
        coletar(acao, "power_up.wav");
    }
}

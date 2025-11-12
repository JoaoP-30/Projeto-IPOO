import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa uma Moeda coletável que possui uma animação de rotação.
 * * Ela herda da classe {@link Coletaveis}, utilizando o método {@link Coletaveis#coletar()} 
 * * para a lógica de coleta, e adiciona uma lógica de animação própria.
 * @author Joao Fernandes 
 * @version 1.0
 */

public class Moeda extends Coletaveis
{
    //Array que armazena todas as imagens (frames) da animação da moeda.
    private GreenfootImage[] moedas;
    //Índice do frame atual exibido.
    private int frame;
    //Define a velocidade da animação.
    private final int velAnimacao;
    //Contador para controlar o delay até a próxima troca de frame.
    private int contAnimacao;
    // Define a ação que esta fruta executará ao ser coletada (1 = pegar moeda).
    private int acao;
    
    /**
     * Construtor da classe Moeda.
     * Preenche o vetor moedas para as imagens da animação e 
     * inicializa a variáveis de controle de animação.
     * Define sua ação específica como '1' (que, na classe 
     * {@link Coletaveis}, corresponde a {@link Jogador#pegarMoeda()}) e 
     * @param jogador A referência ao jogador, passada para a superclasse {@link Coletaveis}.
     */
    
    public Moeda(Jogador jogador){
        super(jogador);
        
        moedas = new GreenfootImage[12];

        for (int i = 0; i < moedas.length; i++){
            // O Greenfoot automaticamente procura na pasta "images/"
            moedas[i] = new GreenfootImage("/coins/coin" + (i + 1) + ".png");
        }

        frame = 0;
        velAnimacao = 14;
        contAnimacao = 0;
    
        acao = 1;
    }

    /**
     * Construtor auxiliar afim de facilitar testes e criação de novas fases.
     */
    
    public Moeda(){
        super(new Jogador());
        
          moedas = new GreenfootImage[12];

        for (int i = 0; i < moedas.length; i++){
            // O Greenfoot automaticamente procura na pasta "images/"
            moedas[i] = new GreenfootImage("/coins/coin" + (i + 1) + ".png");
        }

        frame = 0;
        velAnimacao = 14;
        contAnimacao = 0;
    
        acao = 1;
    }
    
    
    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Moeda.
     * <p>
     * A cada ciclo, ele executa duas coisas:
     * 1. Chama {@link #animacao()} para atualizar o frame da animação.
     * 2. Chama {@link Coletaveis#coletar()} para verificar se foi coletada.
     */
    
    public void act()
    {
        animacao();
        // Chama o método herdado da classe Coletaveis
        coletar(acao, "coin.wav");
    }
    
    /**
     * Controla a lógica de animação da moeda.
     * Troca a imagem (frame) da moeda em intervalos definidos por 'velAnimacao'.
     */
    
    private void animacao(){
        // Incrementa o contador responsável pelo 'delay'
        contAnimacao++;

        if(contAnimacao >= velAnimacao){
            // Zera o contador para o próximo ciclo de delay
            contAnimacao = 0;
             
            //Incrementa o frame 
            frame++;
            
            //Impede que posições inválidas sejam buscadas no array moedas, criando um loop
            if(frame >= moedas.length){
                frame = 0;
            }

            // Define imagem atual do ator para o novo frame
            setImage(moedas[frame]);
        }
    }
}

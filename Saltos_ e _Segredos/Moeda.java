import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um item coletável do tipo Moeda.
 * Além de ser coletável, este item possui uma animação de rotação.
 * @version 2.0
 */

public class Moeda extends Coletaveis{
    //Array que armazena todas as imagens (frames) da animação da moeda.
    private GreenfootImage[] moedas;
    //Índice do frame atual exibido.
    private int frame;
    //Define a velocidade da animação (quanto maior o valor, mais lenta a animação). 
    private final int velAnimacao;
    //Contador para controlar o delay até a próxima troca de frame.
    private int contAnimacao;
       
    /**
     * Construtor para objetos da classe Moeda.
     * Inicializa os frames da animação, a velocidade e o contador.
     * @param jogador A instância do jogador que pode coletar este item.
     */
    
    public Moeda(Jogador jogador){
        super(jogador);
        
        moedas = new GreenfootImage[12];

        // Carrega todas as 12 imagens da animação
        for (int i = 0; i < moedas.length; i++){
            // O Greenfoot automaticamente procura na pasta "images/"
            moedas[i] = new GreenfootImage("/coins/coin" + (i + 1) + ".png");
        }

        frame = 0;
        velAnimacao = 14; // A cada 14 ciclos do 'act', a imagem muda
        contAnimacao = 0;
    }

    /**
     * Sobrescreve o método da superclasse para aplicar o efeito da Moeda.
     * Adiciona uma moeda/pontos ao jogador.
     */
    
    @Override
    protected void aplicarEfeito(){
        obterJogador().pegarMoeda();
    }
    
    /**
     * Sobrescreve o método da superclasse para obter o nome do som de coleta.
     * @return O nome do arquivo de som de 'moeda'.
     */
    
    @Override
    protected String obterNomeEfeitoSonoro(){
        return "coin.wav";
    }
    
    
    /**
     * O método 'act' é executado a cada frame.
     * Controla a animação e verifica a coleta do item.
     */
    
    public void act()
    {
        animacao();
        coletar();
    }
    

    /**
     * Responsável por gerenciar a troca de frames para criar o efeito de animação.
     */
    
    private void animacao(){
        // Incrementa o contador responsável pelo 'delay'
        contAnimacao++;

        if(contAnimacao >= velAnimacao){
            // Zera o contador para o próximo ciclo de delay
            contAnimacao = 0;
             
            // Incrementa o índice do frame 
            frame++;
            
            // Impede que posições inválidas sejam buscadas no array moedas, criando um loop na animação
            if(frame >= moedas.length){
                frame = 0;
            }

            // Define imagem atual do ator para o novo frame
            setImage(moedas[frame]);
        }
    }
}
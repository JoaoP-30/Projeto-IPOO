import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A classe HUD é um Ator responsável por exibir 
 * informações vitais do jogo na tela, como a vida do jogador, 
 * a contagem de moedas e o tempo decorrido.
 * * Ele atualiza essas informações a cada ciclo do jogo (frame).
 */

public class HUD extends Actor {
    //Referência ao jogador para obter os dados (vida, moedas, tempo) a serem exibidos.
    private Jogador jogador;
    //Armazena a imagem do ícone de coração para ser desenhada.
    private GreenfootImage coracao = new GreenfootImage("coracao.png");
    //Armazena a imagem do ícone de moeda para ser desenhada.
    private GreenfootImage moeda = new GreenfootImage("moeda.png");
    //Armazena a quantidade de pontos durante uma partida
    private int pontos;
    
    private int inimigosMortos;
    
    private int pontosFaseAtual;
    
    /**
     * Construtor da classe HUD.
     * * @param jogador A instância do Jogador que está no mundo. 
     * É necessário para que o HUD possa consultar 
     * os status (vida, moedas, etc.) do jogador.
     */
    
    public HUD(Jogador jogador) {
        this.jogador = jogador;

        coracao = new GreenfootImage("coracao.png");
        moeda = new GreenfootImage("moeda.png");
        
        pontos = 0;
        
        inimigosMortos = 0;
        
        pontosFaseAtual = 0;
        
        // Chama o método de atualização uma vez no construtor 
        // para exibir o HUD inicial assim que ele é criado.
        atualizarHUD();
    }
    
    
    public HUD() {
        jogador = new Jogador();

        coracao = new GreenfootImage("coracao.png");
        moeda = new GreenfootImage("moeda.png");
        
        pontos = 0;
        
        pontosFaseAtual = 0;
        
        // Chama o método de atualização uma vez no construtor 
        // para exibir o HUD inicial assim que ele é criado.
        atualizarHUD();
    }
    
    
    /**
     * Método principal de atuação (loop) do HUD.
     * A cada ciclo do jogo, ele chama {@link #atualizarHUD()} para 
     * redesenhar as informações, garantindo que a tela esteja sempre 
     * atualizada.
     */
    
    public void act() {
        atualizarHUD();
    }

    /**
     * Método central que desenha todas as informações do HUD.
     * Ele cria uma nova imagem transparente (`GreenfootImage`), desenha
     * os ícones (corações, moeda) e o texto (contador de moedas, tempo)
     * nela, e então define essa imagem composta como a imagem do Ator HUD.
     */
    
    private void atualizarHUD() {
        // Cria uma nova imagem de fundo para o HUD (300x80 pixels)
        GreenfootImage img = new GreenfootImage(300, 80);
        // Define a cor e a fonte para o texto
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", true, false, 18));

        // --- Desenha os Coraões (Vida) ---
        for (int i = 0; i < jogador.obterVida(); i++) {
            img.drawImage(coracao, 10 + i * 25, 5);
        }

        // --- Desenha as Moedas ---
        img.drawImage(moeda, 20, 35);
        img.drawString("x " + jogador.obterMoedas(), 50, 53);        
        
        // --- Desenha o Tempo ---
        img.drawString("Tempo: " + jogador.obterTempo() + "s", 90 , 53);
        
        //-- Desenha a Pontuação --
        
        calcPontos();
        
        img.drawString("Pontos: " + pontos, 90,73);
        
        setImage(img);
    }

    private void calcPontos(){
        pontos = (jogador.obterMoedas() * 10) + (jogador.obterVida() * 20) + (inimigosMortos * 30);
        pontosFaseAtual = (jogador.obterMoedas() * 10) + (jogador.obterVida() * 20) + (inimigosMortos * 30);
    }

    public int obterPontuacaoFinal(boolean estaVivo){
        if(!estaVivo){
            int bonus = 0;
        
            if(jogador.obterTempo() <= 120){
                bonus = 100;
            }
            else if(jogador.obterTempo() <= 180){
                bonus = 50;
            }
            else if(jogador.obterTempo() <= 300){
                bonus = 25;
            }
            else {
                bonus = 5;
            }
            
            return pontos *= (int)(bonus / 2.5);
        }
    
        return pontos;
    }

    public void pontuarMorteInimigo(){
        inimigosMortos++;
    }
 
    public int obterPontos(){
        return pontos;
    }
}

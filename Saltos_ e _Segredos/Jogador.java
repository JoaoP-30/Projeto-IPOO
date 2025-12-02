import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o jogador principal no jogo.
 * Esta classe controla o movimento (horizontal e vertical), as animações e estado (como vida, moedas)
 * e as interações de físcia (salto, gravidade) do personagem controlado pelo usuário.
 * @version 3.5 - Lógica de pontuação movida do HUD para o Jogador.
 */

public class Jogador extends Actor
{
    // Array de imagens para a animação do jogador movendo-se para a direita.
    private GreenfootImage[] animacaoD;
    // Array de imagens para a animação do jogador movendo-se para a esquerda.
    private GreenfootImage[] animacaoE;
    // Contador para controlar o frame atual da animao.
    private int frame;
    // Contador de vida do jogador
    private int vida;
    // Contador de moedas do jogador
    private int moedas;
    // Adicionado: Contador de inimigos mortos para cálculo da pontuação
    private int inimigosMortos;
    // Conta o tempo em que o jogador fica invulnerável apos tomar um dano
    private int tempoInvulneravel;
    // Velocidade de movimento horizontal do jogador
    private int velMovimento;
    // Indica se o jogador está no ar (pulando ou caindo)
    private boolean estaPulando;
    // Velocidade vertical atual do jogador
    private int velVertical;
    // Simula ação da agravidade 
    private int aceleracao;
    // Força aplicada quando o jogador pula
    private int forcaDoSalto;
    // Posição inicial do jogador no eixo x
    private int posX;
    // Posição inicial do jogador no eixo y
    private int posY;
    // Duração da partida em segundos
    private int tempo;
    // Contador para segundos, quando chega a 60 o 'tempo' é incrementado em 1
    private int cont;
    // Direção que o ataque vai ser executado
    private int direcaoAtaque;
    // Tempo de espera para executar o próximo ataque
    private int tempoDeAtaque;

    /**
     * Construtor da classe Jogador.
     * Inicializa os arrays de animação carregando as imagens.
     * Define os valores iniciais para todos os atributos.
     */
    public Jogador(){
        animacaoD = new GreenfootImage[4];
        animacaoE = new GreenfootImage[4];

        for (int i = 0; i < animacaoD.length; i++){
            animacaoD[i] = new GreenfootImage("/jogador/run" + (i + 1) + "r.png");
            animacaoE[i] = new GreenfootImage("/jogador/run" + (i + 1) + "l.png");
        }

        frame = 0;

        vida = 2;
        moedas = 0;
        inimigosMortos = 0; // Inicialização do novo campo
        tempoInvulneravel = 180;

        velMovimento = 5;

        velVertical = 0;
        aceleracao = 1;
        forcaDoSalto = 16;

        tempo = 0;
        cont = 0;

        direcaoAtaque = -1;
        tempoDeAtaque = 60;
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     */
    public void act()
    {
        verificarMorte();
        contarTempo();
        ataque();
        tempoInvulneravel();
        movimento();
        verificaQueda();
        teto();
    }

    // --- MÉTODOS QUE DEFINEM AS AÇÕES DO JOGADOR --- 

    /**
     * Verifica a entrada do teclado (teclas "right" e "left", e "up").
     */
    private void movimento(){
        if(!estaNoFundo()){    
            if(Greenfoot.isKeyDown("right") && !verficaObstaculoAFrente()){
                moverDireita();
                direcaoAtaque = 1;
            }
            if(Greenfoot.isKeyDown("left") && !verficaObstaculoAtras()){
                moverEsquerda();
                direcaoAtaque = 0;
            }
            if(Greenfoot.isKeyDown("up") && !estaPulando){
                salto();
            }
        }
        else{
            receberDano();
            Som.obterInstancia().tocarEfeito("hurt.wav");
            setLocation(posY,posX);
        }
    }

    /**
     * Executa o movimento do jogador para a direita.
     */
    private void moverDireita(){
        move(velMovimento);

        if(frame % 4 == 0){
            frame = 0;
        }

        setImage(animacaoD[frame]);
        frame++;
    }

    /**
     * Executa o movimento do jogador para a esquerda.
     */
    private void moverEsquerda(){
        move(-velMovimento);

        if(frame % 4 == 0){
            frame = 0;
        }

        setImage(animacaoE[frame]);
        frame++;
    }

    /**
     * Inicia o salto do jogador.
     */
    private void salto()
    {
        velVertical -= forcaDoSalto;

        estaPulando = true;

        queda();

        Som.obterInstancia().tocarEfeito("jump.wav");
    }

    /**
     * Simula a física da gravidade e do movimento vertical.
     */
    private void queda(){
        setLocation(getX(), getY() + velVertical);

        if(velVertical <= 9)
        {
            velVertical += aceleracao;
        }

        estaPulando = true;
    }

    /**
     * Gerencia o estado de pulo/queda do jogador a cada chamada do método 'act'.
     */
    private void verificaQueda()
    {
        if(estaNoSolo())
        {
            velVertical = 0;
        }
        else
        {
            queda();
        }
    }

    /**
     * Verifica se o jogador está colidindo com um ator 'Solo' abaixo dele.
     * @return true se estiver no solo, false caso contrário.
     */
    private boolean estaNoSolo()
    {
        Actor solo = getOneObjectAtOffset(0, getImage().getHeight()/2, Solo.class);

        if(solo == null)
        {
            estaPulando = true;
            return false;
        }
        else{
            // Tocou no solo 
            moverParaSolo(solo);// Corrige a posição para ficar em cima do solo
            return true;
        }
    }

    /**
     * Corrige a posição Y do jogador para que ele fixe perfeitamente 
     * em cima do ator 'solo' em que ele aterrissou.
     * @param solo O ator 'Solo' com o qual o jogador colidiu.
     */
    private void moverParaSolo(Actor solo){
        int soloAltura = solo.getImage().getHeight();
        // Calcula o Y exato para o jogador ficar em cima do solo
        int novoY = solo.getY() - (soloAltura + getImage().getHeight()) / 2;
        setLocation(getX(), novoY);

        // Permite pular novamente
        estaPulando = false; 
    }

    /**
     * Verifica se o jogador colidiu com um ator 'Solo' acima dele (teto).
     * @return true se bateu no teto, false caso contrário.
     */
    private boolean teto(){
        int jogAltura = getImage().getHeight();
        // Ponto de verificação (acima do centro da cabeça do jogador)
        int deltaY = (int)(jogAltura / (-2));

        Actor teto = getOneObjectAtOffset(0, deltaY, Solo.class);

        if(teto != null){
            velVertical = 1; // Força o jogador a começar a cair
            bateuNoTeto(teto); // Corrige a posição para baixo do teto
            return true;
        }

        return false;
    }

    /**
     * Corrige a posição Y do jogador para que ele fixe corretamente
     * abaixo do ator 'teto' (Solo) em que ele bateu a cabeça.
     * @param teto O ator 'Solo' (usado como teto) com o qual o jogador colidiu.
     */
    private void bateuNoTeto(Actor teto){
        int tetoAltura = teto.getImage().getHeight();
        // Calcula o Y exato para o jogador ficar abaixo do teto
        int novoY = teto.getY() + (tetoAltura + getImage().getHeight()) / 2;

        setLocation(getX(), novoY);
    }

    /**
     * Verifica se o jogador caiu abaixo do limite inferior do mundo.
     * @return true se o jogador caiu (Y >= 599), false caso contrário.
     */
    private boolean estaNoFundo(){
        int posY = getY();

        if(posY >= 599){
            return true;
        }

        return false;
    }

    /***
     * Método que verifica se há alguma barreira a frente do jogador.
     * @return true se houver uma barreira, false caso contrário.
     */

    private boolean verficaObstaculoAFrente()
    {
        int larguraJogador = getImage().getWidth();
        int xDistancia = (int)(larguraJogador/2);

        Actor barreira = getOneObjectAtOffset(xDistancia, 0, Barreira.class);

        return barreira != null;
    }

    /***
     * Método que verifica se há alguma barreira atrás do jogador.
     * @return true se houver uma barreira, false caso contrário.
     */
    private boolean verficaObstaculoAtras()
    {
        int larguraJogador = getImage().getWidth();
        int xDistancia = (int)(larguraJogador/-2);

        Actor barreira = getOneObjectAtOffset(xDistancia, 0, Barreira.class);

        return barreira != null;
    }

    /***
     * Método responsável por exercutar o ataque.
     */
    
    public boolean ataque()
    {
        tempoDeAtaque--;

        if(Greenfoot.isKeyDown("space") && tempoDeAtaque <= 0 && direcaoAtaque ==1)
        {
            getWorld().addObject(new AtaqueDireito(), getX(), getY());
            tempoDeAtaque = 60;
            return true;
        }
        if(Greenfoot.isKeyDown("space") && tempoDeAtaque <= 0 && direcaoAtaque ==0)
        {
            getWorld().addObject(new AtaqueEsquerdo(), getX(), getY());
            tempoDeAtaque = 60;
            return true;
        }
        return false;
    }
    
    
    // --- MÉTODOS QUE MODIFCAM O ESTADO DO JOGADOR ---

    /**
     * Define as posições inicias no eixo x e y.
     * @param posY A posião no eixo Y inicial.
     * @param posX A posião no eixo X inicial.
     */
    public void inserirPosicaoInicial(int posY, int posX){
        this.posY= posY;
        this.posX = posX;
    }

    /**
     * Aplica dano ao jogador.
     */
    public void receberDano(){
        vida--;
        tempoInvulneravel = 180;
    }

    /**
     * Contagem regressiva do tempo de invulnerabilidade.
     */
    private void tempoInvulneravel(){
        if(tempoInvulneravel > 0){
            tempoInvulneravel--;
        }
    }

    /**
     * Aumenta a vida do jogador em 1.
     */
    public void aumentarVida(){
        vida++;
    }

    /**
     * Método que modifca a vida
     */

    public void definirVida(int novaVida){
        this.vida = novaVida;
    }

    /**
     * Incrementa a contagem de moedas do jogador em 1.
     */
    public void pegarMoeda(){
        moedas++;
    }

    /**
     * Incrementa o contador de inimigos mortos.
     * Chamado quando o jogador derrota um inimigo.
     */
    public void incrementarInimigosMortos(){
        inimigosMortos++;
    }

    /**
     * Mecanismo interno de contagem de tempo.
     */
    private void contarTempo(){
        if(cont == 60){
            tempo++;
            cont = 0;
        }
        else{
            cont++;
        }
    }

    // --- MÉTODOS QUE RETORNAM O ESTADO DO JOGADOR ---

    /**
     * Verifica se o jogador está atualmente invulnerável a dano.
     * @return true se 'tempoInvulneravel' for maior que 0, false caso contrário.
     */
    public boolean estaInvulneravel(){
        return tempoInvulneravel != 0;
    }

    /**
     * Obtém a contagem atual de vida do jogador.
     * @return O valor inteiro da vida atual.
     */
    public int obterVida(){
        return vida;
    }

    /**
     * Obtém a contagem atual de moedas do jogador.
     * @return O valor inteiro das moedas atuais.
     */
    public int obterMoedas(){
        return moedas;
    }

    /**
     * Obtém o tempo total de partida decorrido, em segundos.
     * @return O tempo total em segundos.
     */
    public int obterTempo(){
        return tempo;
    }

    /**
     * Obtém a contagem atual de inimigos mortos.
     * @return O valor inteiro dos inimigos mortos.
     */
    public int obterInimigosMortos(){
        return inimigosMortos;
    }

    /***
     * Retorna a posição do jogador no eixo X.
     */
    public int obterPosX(){
        return getX();
    }

    /***
     * Retorna a posição do jogador no eixo Y.
     */
    public int obterPosY(){
        return getY();
    }

    // --- MÉTODOS PARA VERIFICAR ESTADO DO JOGADOR ---

    /**
     * Calcula a pontuação base do jogador usando os status atuais.
     * (Moedas * 10) + (Vida * 20) + (Inimigos Mortos * 30).
     * @return A pontuação base atual.
     */
    public int calcularPontuacaoBase(){
        return (moedas * 10) + (inimigosMortos * 30);
    }

    /**
     * Calcula a pontuação final (com bônus de tempo) ao fim de uma partida
     * (derrota ou vitória de fase).
     * @return A pontuação total com o bônus de tempo aplicado.
     */
    public int calcularPontuacaoFinal(){
        int pontosBase = calcularPontuacaoBase();
        int bonus = 0;

        // Lógica de bônus por tempo (tempo está em segundos)
        if(tempo <= 180){ // 3 minutos
            bonus = 10 * (obterVida() * 10);
        }
        else if(tempo <= 300){ // 5 minutos
            bonus = 8 * (obterVida() * 10);
        }
        else if(tempo <= 420){ // 7 minutos
            bonus = 5 * (obterVida() * 10);
        }
        else {
            bonus = 2 * (obterVida() * 10);
        }

        // Aplica o bônus: pontos *= (int)(bonus / 2.5);
        // O valor base é multiplicado pelo fator de bônus.
        return pontosBase * (int)(bonus / 2.5); 
    }

    /**
     * Verifica se a quantidade vidas do jogador é menor do que 0,
     * em caso afirmativo "GAME OVER" é decretado, e a pontuação final é calculada.
     */
    private void verificarMorte(){
        if(vida <= 0){
            // O jogador é responsável por passar a pontuação para a tela de derrota
            Som.obterInstancia().mutarTrilha();

            World mundo = getWorld();

            if (mundo instanceof Fases)
            {
                ((Fases)mundo).setarPontuacaoDaFase();
            }
            
            
            // Passa a pontuação final calculada para a Tela_Derrota
            Greenfoot.setWorld(new Tela_Derrota(calcularPontuacaoBase(), obterTempo()));
        }
    }
}
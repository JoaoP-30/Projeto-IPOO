import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o jogador principal no jogo.
 * Esta classe controla o movimento (horizontal e vertical), as animações e estado (como vida, moedas)
 * e as interações de físcia (salto, gravidade) do personagem controlado pelo usuário.
 * @author Joao Fernandes 
 * @version 1.1 
 */

public class Jogador extends Actor
{
    //Array de imagens para a animação do jogador movendo-se para a direita.
    private GreenfootImage[] animacaoD;
    //Array de imagens para a animação do jogador movendo-se para a esquerda.
    private GreenfootImage[] animacaoE;
    //Contador para controlar o frame atual da animao.
    private int frame;
    //Contador de vida do jogador
    private int vida;
    //Contador de moedas do jogador
    private int moedas;
    //Conta o tempo em que o jogador fica invulnerável apos tomar um dano
    private int tempoInvulneravel;
    //Velocidade de movimento horizontal do jogador
    private int velMovimento;
    //Indica se o jogador está no ar(pulando ou caindo)s 
    private boolean estaPulando;
    //Velocidade vertical atual do jogador
    private int velVertical;
    //Simula ação da agravidade 
    private int aceleracao;
    //Força aplicada quando o jogador pula
    private int forcaDoSalto;
    //Posição inicial do jogador no eixo x
    private int posX;
    //Posição inicial do jogador no eixo y
    private int posY;
    //Duração da partida em segundos
    private int tempo;
    //Contador para segundos, quando chega a 60 o 'tempo' é incrementado em 1
    private int cont;
    //Objeto para gerenciar e tocar efeitos sonoros
    private Som som;

    /**
     * Construtor da classe Jogador.
     * Inicializa os arrays de animação carregando as imagens.
     * Define os valores iniciais para todos os atributos:
     * - Status (vida, moedas, ).    
     * - Física (velocidade, "gravidade", força do salto).
     * - Animação (frame).
     * - Som.
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
        tempoInvulneravel = 180;

        velMovimento = 5;

        velVertical = 0;
        aceleracao = 1;
        forcaDoSalto = 16;

        tempo = 0;
        cont = 0;
        
        som = new Som();
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Jogador.
    * Ele gerencia o estado do jogador chamando:
     * 1. {@link #contarTempo()} - Incrementa o relógio do jogo.
     * 2. {@link #tempoInvulneravel()} - Decrementa o timer de invulnerabilidade.
     * 3. {@link #movimento()} - Verifica entradas do teclado
     * 4. {@link #verificaQueda()} - Aplica gravidade se estiver no ar.
     * 5. {@link #teto()} - Verifica colisão com o teto
     */

    public void act()
    {
        verificarMorte();
        contarTempo();
        tempoInvulneravel();
        movimento();
        verificaQueda();
        teto();
    }

    /**
     * Verifica a entrada do teclado (teclas "right" e "left", e "up").
     * - Se "right"/"left: chama {@link #moverDireita()} ou {@link #moverEsquerda()}.
     * - Se "up": chama {@link #salto()} (apenas se não estiver pulando).
     * * Também verifica se o jogador caiu no fundo do mundo {@link #estaNoFundo()},
     * e o reposiciona na posição inicial.
     */

    private void movimento(){
        if(!estaNoFundo()){    
            if(Greenfoot.isKeyDown("right")){
                moverDireita();
            }
            if(Greenfoot.isKeyDown("left")){
                moverEsquerda();
            }
            if(Greenfoot.isKeyDown("up") && !estaPulando){
                salto();
            }
        }
        else{
            receberDano();
            som.tocarEfeito("hurt.wav");
            setLocation(posY,posX);
        }
    }

    /**
     * Executa o movimento do jogador para a direita.
     * Move o ator 'velMovimento' pixels e atualiza o sprite (imagem)
     * para o próximo quadro da animação 'animacaoD'.
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
     * Move o ator '-velMovimento' pixels (para trás) e atualiza o sprite (imagem)
     * para o próximo quadro da animação 'animacaoE'.
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
     * Aplica um foça negativa ('forcaDoSalto) à 'velVertical'.
     * Define 'estaPulando' como true, aplica o primeiro movimento
     * de {@link #queda()} e toca o som de pulo.
     */

    private void salto()
    {
        velVertical -= forcaDoSalto;

        estaPulando = true;

        queda();

        som.tocarEfeito("jump.wav");
    }

    /**
     * Simula a física da gravidade e do movimento vertical.
     * Move o jogador na posição Y com base na 'velVertical' atual.
     * Em, aumenta a 'velVertical' pela 'aceleracao' (gravidade),
     * até um limite (9).
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
     * Se o jogador estiver no solo ({@link #estaNoSolo()}), zera a velocidade 
     * vertical e permite um novo pulo.
     * Caso contrário (está no ar), chama {@link #queda()} para aplicar a gravidade.
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
     * Usa 'getOneObjectAtOffset' para verificar logo abaixo dos "pés" do jogador.
     * * @return true se estiver no solo, false caso contrário.
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
     * Isso evita que o jogador afunde parcialmente no chão.
     * * @param solo O ator 'Solo' com o qual o jogador colidiu.
     */

    private void moverParaSolo(Actor solo){
        int soloAltura = solo.getImage().getHeight();
        // Calcula o Y exato para o jogador ficar em cima do solo
        int novoY = solo.getY() - (soloAltura + getImage().getHeight()) / 2;
        setLocation(getX(), novoY);

        //Permite pular novamente
        estaPulando = false; 
    }

    /**
     * Verifica se o jogador colidiu com um ator 'Solo' acima dele (teto).
     * Usa 'getOneObjectAtOffset' para verificar acima da "cabeça" do jogador.
     * * @return true se bateu no teto, false caso contrário.
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
     * Isso evita que o jogador atravesse o teto.
     * * @param teto O ator 'Solo' (usado como teto) com o qual o jogador colidiu.
     */

    private void bateuNoTeto(Actor teto){
        int tetoAltura = teto.getImage().getHeight();
        // Calcula o Y exato para o jogador ficar abaixo do teto
        int novoY = teto.getY() + (tetoAltura + getImage().getHeight()) / 2;

        setLocation(getX(), novoY);
    }

    /**
     * Verifica se o jogador caiu abaixo do limite inferior do mundo.
     * (Levando em consideraçãp que o mundk possui 600 pixels de altura).
     * * @return true se o jogador caiu (Y >= 599), false caso contrário.
     */

    private boolean estaNoFundo(){
        int posY = getY();

        if(posY >= 599){
            return true;
        }

        return false;
    }

    /**
     * Define as posições inicias no eixo x e y. Este método é chamado quando o jogador é
     * adicionado ao mundo.
     * @param posY A posião no eixo Y inicial (é a mesma que o jogador é adicionado ao mundo).
     * @param posX A posião no eixo X inicial (é a mesma que o jogador é adicionado ao mundo).
     */

    public void inserirPosicaoInicial(int posY, int posX){
        this.posY= posY;
        this.posX = posX;
    }

    /**
     * Aplica dano ao jogador.
     * Reduz a 'vida' em 1 e reinicia o 'tempoInvulneravel' para 180 ciclos (3 segundos).
     * Chamado geralmente por um 'Inimigo'.
     */
    
    public void receberDano(){
        vida--;
        tempoInvulneravel = 180;
    }

    /**
     * Contagem regressiva do tempo de invulnerabilidade.
     * Chamado a cada 'act', reduz o contador 'tempoInvulneravel' até que chegue a 0.
     */
    
    private void tempoInvulneravel(){
        if(tempoInvulneravel > 0){
            tempoInvulneravel--;
        }
    }

    /**
     * Verifica se o jogador está atualmente invulnerável a dano.
     * Usado por inimigos para saber se podem aplicar dano.
     * @return true se 'tempoInvulneravel' for maior que 0, false caso contrário.
     */
    
    public boolean estaInvulneravel(){
        return tempoInvulneravel != 0;
    }
    
    /**
     * Aumenta a vida do jogador em 1.
     * Geralmente chamado por um item coletável (ex: Coração).
     */
    
    public void aumentarVida(){
        vida++;
    }

    /**
     * Obtém a contagem atual de vida do jogador.
     * Usado pelo 'Mundo' para exibir na tela.
     * @return O valor inteiro da vida atual.
     */
    
    public int obterVida(){
        return vida;
    }

    /**
     * Incrementa a contagem de moedas do jogador em 1.
     * Geralmente chamado por um item coletável (ex: Moeda).
     */
    
    public void pegarMoeda(){
        moedas++;
    }

    /**
     * Obtém a contagem atual de moedas do jogador.
     * Usado pelo 'Mundo' para exibir na tela.
     * @return O valor inteiro das moedas atuais.
     */
    
    public int obterMoedas(){
        return moedas;
    }
    
    /**
     * Mecanismo interno de contagem de tempo.
     * Usa 'cont' para contar os ciclos (frames) do 'act'.
     * A cada 60 ciclos (aproximadamente 1 segundo), incrementa a 
     * variável 'tempo' (segundos) e zera 'cont'.
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

    /**
     * Obtém o tempo total de partida decorrido, em segundos.
     * Usado pelo 'Mundo' para exibir na tela.
     * @return O tempo total em segundos.
     */
    
    public int obterTempo(){
        return tempo;
    }

    private void verificarMorte(){
        if(vida < 0){
            vida = 0;
                
            HUD hud = new HUD(this);
            
            Greenfoot.setWorld(new Tela_Derrota(hud.obterPontuacaoFinal(), obterTempo()));
        }
    }
}

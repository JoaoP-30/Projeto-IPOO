import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o ator que exibe a mensagem de derrota ("Você Perdeu") e a 
 * pontuação final quando o jogador perde o jogo.
 * *Este ator é estático; ele apenas exibe a imagem criada em seu construtor
 * e não realiza ações no método act().
 *@version 1.0
 */

public class Perdedor extends Actor
{
    /**
     * Construtor da classe Perdedor.
     * Chama o método imagem() para criar e exibir a tela de derrota
     * com a pontuação fornecida.
     * * @param pontos A pontuação final do jogador a ser exibida.
     */

    public Perdedor(int pontos){
        imagem(pontos);
    }

    /**
     * Método Act - Este método é chamado automaticamente pelo Greenfoot.
     * Para esta classe, nenhuma ação é necessária após a criação,
     * pois a imagem é estática.
     */
    public void act()
    {
        // Nenhuma ação necessária.
    }

    /**
     * Método privado para criar a imagem de "Derrota".
     * Cria uma imagem de fundo transparente, desenha o texto de derrota
     * e a pontuação final, e define essa imagem composta como a imagem do ator.
     * @param pontos A pontuação a ser desenhada na imagem.
     */

    private void imagem(int pontos){
        GreenfootImage imagemDeFundo = new GreenfootImage(400, 200); // imagem maior
        imagemDeFundo.clear(); // garante fundo transparente
        GreenfootImage texto = new GreenfootImage("VOCÊ PERDEU !!!", 45, Color.BLACK, null);
        imagemDeFundo.drawImage(texto, (365 - texto.getWidth()) / 2, (180 - texto.getHeight()) / 2);// centraliza
        GreenfootImage texto2 = new GreenfootImage("PONTUAÇÃO: " + pontos + " pnts", 45, Color.BLACK, null);
        imagemDeFundo.drawImage(texto2, (300 - texto.getWidth()) / 2, (280 - texto.getHeight()) / 2);
        setImage(imagemDeFundo);
    }
}

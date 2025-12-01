import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclasse abstrata para todas os tipos de "Solo" (Chão, Plataforma) no mundo.
 * Esta classe serve como base para diferentes tipos de superfícies, gerenciando principalmente o
 * redimensionameto da imagem.
 * @author Joao Fernandes 
 * @version 1.0
 */
public abstract class Solo extends Actor
{
    /**
     * Construtor para objetos da superclasse Solo.
     * Redimensiona a imagem do ator para a largura e altura especificadas.
     * @param largura A largura desejada para a imagem do solo.
     * @param altura A altura desejada para a imagem do solo.
     */
    
    public Solo(int largura, int altura){
        getImage().scale(largura, altura);
    }

    /**
     * Construtor para objeto da superclasse Solo.
     * Este é usado pelas subclasses que não necessitam
     * redimensionar sua altura/largura.
     */
    
    public Solo(){
    
    }
    
    /**
     *  Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     *  Método principal de atuação (loop) da classe Solo. 
     */
    public void act()
    {
        
    }

    /**
     * Permite alterar as dimensões (escala) da imagem deste ator após a sua criação.
     * @param novaLargura A nova largura para a imagem.
     * @param novaAltura A nova altura para a imagem.
     */
    
    public void alterarDimensoes(int novaLargura, int novaAltura){
        getImage().scale(novaLargura,novaAltura);
    }
}

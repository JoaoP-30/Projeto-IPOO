import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa um portal de transição de fase.
 * Este ator verifica se o {@link Jogador} está tocando-o e, ao mesmo tempo,
 * pressionando a tecla "c". Se ambas as condições forem verdadeiras,
 * ele aciona a mudança para o próximo nível (Fase).
 * @author Joao Fernandes 
 * @version 1.0
 */
public class Portal extends Actor
{
    /**
     * Construtor da classe Portal.
     * Espelha a imagem do portal horizontalmente no momento da sua criação.
     * (Útil caso a imagem original esteja virada para o lado oposto ao desejado).
     */
    
    public Portal(){
        getImage().mirrorHorizontally();
    }

    /**
     * Método chamado automaticamente pelo Greenfoot a cada ciclo de execução.
     * Método principal de atuação (loop) da classe Portal.
     * A cada passo (act), verifica se o jogador ativou o portal.
     */
    
    public void act()
    {
        entrouNoPortal();
    }

    /**
     * Verifica se o jogador está tocando o portal e pressionando a tecla "c".
     * Se as condições forem atendidas, ele identifica qual é a Fase (Mundo) atual
     * e chama o método {@code irParaProximaFase()} específico daquela fase.
     */
    
    private void entrouNoPortal(){
        Actor jogador = getOneIntersectingObject(Jogador.class);
        
        List <Chave> chaves = getWorld().getObjects(Chave.class);
        
        if(Greenfoot.isKeyDown("c") && jogador != null && chaves.size() <= 0){
            World faseAtual = getWorld();
            
            // Verifica o tipo do mundo atual para chamar o método correto
            if (faseAtual instanceof Fase_1){
                // Converte (cast) o mundo para Fase_1 e chama o método
                ((Fase_1) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_2){
                // Converte (cast) o mundo para Fase_2 e chama o método
                ((Fase_2) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_3){
                ((Fase_3) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_6){
                ((Fase_6) faseAtual).irParaProximaFase();
            }

        }
    }
}

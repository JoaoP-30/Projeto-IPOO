import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa um Portal de transição entre fases (mundos) no jogo.
 * O Portal só permite a passagem do jogador quando este está sobre ele,
 * pressiona a tecla 'c' e todas as chaves da fase atual foram coletadas.
 * @version 2.5
 */
public class Portal extends Actor
{
    
    /**
     * Construtor para objetos da classe Portal.
     * Inverte horizontalmente a imagem do portal, presumivelmente para
     * dar um visual específico ou corrigir a orientação.
     */
    public Portal(){
        // Espelha a imagem do portal horizontalmente.
        getImage().mirrorHorizontally();
    }
    
    /**
     * É responsável por verificar a condição de passagem para a próxima fase.
     */
    public void act()
    {
        entrouNoPortal();
    }
 
    /**
     * Verifica se o jogador está sobre o portal e se as condições para
     * a transição de fase foram atendidas (pressionar 'c' e não haver mais chaves).
     */
    private void entrouNoPortal(){
        // Tenta obter o objeto Jogador que está intersectando (sobrepondo) o Portal.
        Actor jogador = getOneIntersectingObject(Jogador.class);
        
        // Obtém uma lista de todos os objetos Chave presentes no mundo atual.
        List <Chave> chaves = getWorld().getObjects(Chave.class);
        
        // Condição de transição:
        // 1. A tecla 'c' está pressionada.
        // 2. Um objeto Jogador está sobre o portal.
        // 3. A lista de chaves (chaves.size()) está vazia (todas as chaves foram coletadas).
        
        if(Greenfoot.isKeyDown("c") && jogador != null && chaves.size() <= 0){
            World faseAtual = getWorld();
            
            // Verifica o tipo do mundo atual para chamar o método de transição correto.
            // O uso de 'instanceof' e 'cast' permite chamar métodos específicos de cada fase.
            
            if (faseAtual instanceof Fase_1){
                // Converte (cast) o mundo para Fase_1 e chama o método de avanço.
                ((Fase_1) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_2){
                // Converte (cast) o mundo para Fase_2 e chama o método de avanço.
                ((Fase_2) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_3){
                // Converte (cast) o mundo para Fase_3 e chama o método de avanço.
                ((Fase_3) faseAtual).irParaProximaFase();
            }
            else if(faseAtual instanceof Fase_4){
                // Converte (cast) o mundo para Fase_4 e chama o método de avanço (fim de jogo ou fase final).
                ((Fase_4) faseAtual).irParaProximaFase();
            }

        }
    }
}
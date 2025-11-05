import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe abstrata base para todos os itens coletáveis no jogo.
 * Define o comportamento padrão que ocorre quando um jogador "coleta" o item.
 * @author Joao Fernandes 
 * @version 1.0
 */
public abstract class Coletaveis extends Actor
{
    //Referência ao jogador principal, usada para aplicar os efeitos da coleta (ex: vida, pontos).
    private Jogador jogador;
    //Instância da classe Som, usada para tocar o efeito sonoro da coleta
    private Som som;

    
    /**
     * Construtor da classe Coletaveis.
     * Inicializa o coletável, armazenando a referência do jogador e 
     * criando a instância do objeto de Som.
     * * @param jogador A instância do jogador que está no mundo, 
     * necessária para que o coletável possa interagir com ele.
     */
    
    public Coletaveis(Jogador jogador){
        this.jogador = jogador; 
        som = new Som();
    }
    
    /**
     * Método genérico de coleta, chamado pelas subclasses (geralmente dentro do 'act').
     * * Verifica se o ator está tocando no jogador. Se estiver, aplica uma
     * ação específica baseada no parâmetro 'acao', toca um som e, por fim,
     * remove este objeto coletável do mundo.
     * * @param acao   Um código inteiro que define a ação a ser executada:
     * (ex: 1 para "pegar moeda", 2 para "aumentar vida").
     * @param efeito O nome do arquivo de som (String) a ser tocado 
     * ao coletar.
     */

    public void coletar(int acao, String efeito){
        Actor player = getOneIntersectingObject(Jogador.class);
        
        if(player != null){
            
            if(acao == 1){
                jogador.pegarMoeda();
            }
            else if(acao == 2){
                jogador.aumentarVida();
            }
            else if(acao == 3){
                //jogador.pegouAChave();
            }
            
            som.tocarEfeito(efeito);
            getWorld().removeObject(this);
        }
    }
}

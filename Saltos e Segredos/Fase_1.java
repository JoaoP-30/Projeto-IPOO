import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fase_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fase_1 extends Fases
{
    private Jogador jogador;
    
    /**
     * Constructor for objects of class Fase_1.
     * 
     */
    public Fase_1()
    {    
        jogador = new Jogador();
        
        prepare();
    }

    public void started(){
        //iniciaTrilha("time_for_adventure.mp3");
    }
    
    private void prepare(){
        Chao chao = new Chao(230, 80);
        addObject(chao,115,562);

        Chao chao2 = new Chao(230, 80);
        addObject(chao2, 344, 562);

        Chao chao3 = new Chao(230, 80);
        addObject(chao3, 573, 562);

        Chao chao4 = new Chao(230, 80);
        addObject(chao4, 802, 562);
        
        Chao_Falso chao5 = new Chao_Falso(80, 80);
        addObject(chao5,956,562);

        Chao chao6 = new Chao(160, 80);
        addObject(chao6, 1076, 562);
    
        addObject(jogador,24,503);
    
        Moeda moeda = new Moeda();
        addObject(moeda,382,418);

        Moeda moeda2 = new Moeda();
        addObject(moeda2,462,418);

        Moeda moeda3 = new Moeda();
        addObject(moeda3,542,418);
    
        //Cacto cacto = new Cacto();
        //addObject(cacto,830,493);

        Chao chao7 = new Chao(150, 50);
        addObject(chao7,1115,443);
        chao7.alterarDimensoes(70, 30);

        Chao chao8 = new Chao(150, 50);
        addObject(chao8,1003,367);
        chao8.alterarDimensoes(70, 30);

        Chao chao9 = new Chao(150, 50);
        addObject(chao9,1115, 281);
        chao9.alterarDimensoes(70, 30);

        Chao chao10 = new Chao(150, 50);
        addObject(chao10,1003, 195);
        chao10.alterarDimensoes(70, 30);

        Chao chao11 = new Chao(150, 50);
        addObject(chao11,1115, 109);
        chao11.alterarDimensoes(70, 30);

        Chao chao12 = new Chao(150, 50);
        addObject(chao12,903, 195);
        chao12.alterarDimensoes(70, 30);

        Chao_Falso chao13 = new Chao_Falso(70, 30);
        addObject(chao13,803, 195);
        //chao13.alterarDimensoes(70, 30);

        Chao chao14 = new Chao(150, 50);
        addObject(chao14,703, 195);
        chao14.alterarDimensoes(70, 30);

        Chao chao15 = new Chao(150, 50);
        addObject(chao15,603, 195);
        chao15.alterarDimensoes(70, 30);

        Chao chao16 = new Chao(150, 50);
        addObject(chao16,503, 195);
        chao16.alterarDimensoes(70, 30);

        Chao_Falso chao17 = new Chao_Falso(70, 30);
        addObject(chao17,403, 195);

        Chao chao18 = new Chao(150, 50);
        addObject(chao18,303, 195);
        chao18.alterarDimensoes(70, 30);

        Chao chao19 = new Chao(150, 50);
        addObject(chao19,203, 195);
        chao19.alterarDimensoes(70, 30);

        Chao_Falso chao20 = new Chao_Falso(70, 30);
        addObject(chao20,103, 150);
        //chao20.alterarDimensoes(70, 30);

        Chao chao21 = new Chao(150, 50);
        addObject(chao21,34, 150);
        chao21.alterarDimensoes(70, 30);

        Chave chave = new Chave();
        addObject(chave,1134,75);
        chave.setLocation(1134,77);

        Portal portal = new Portal();
        addObject(portal,21,104);
    }

    public void irParaProximaFase(){
        paraTrilha();
        Fase_2 proximaFase = new Fase_2(jogador);
        Greenfoot.setWorld(proximaFase);
    }
    
    public void stopped(){
        paraTrilha();
    }
}

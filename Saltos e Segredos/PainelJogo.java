import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o painel inicial com botoes para a Interface de Usuário.
 * @author (Seu Nome / Joao Fernandes / Maria Clara O Pereira) 
 * @version 1.0
 */
public class PainelJogo extends Actor
{
    private String texto;
    private int id; 

    public PainelJogo(String texto, int id)
    {
        this.texto = texto;
        this.id = id;
        criarImagem();
    }
    
    private void criarImagem()
    {
        GreenfootImage image = new GreenfootImage(250, 60);
        image.setColor(new Color(0, 0, 100, 150));
        image.fill();
        
        image.setColor(Color.GREEN);
        image.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        
        image.setColor(Color.WHITE);
        
        // Usando a classe Font do Greenfoot.
        // Logica: (Nome da fonte, negrito?, itálico?, tamanho)
        image.setFont(new Font("Comic Sans MS", true, false, 28)); 
        
        // Font temporário pra imgTexto
        GreenfootImage imgTexto = new GreenfootImage(texto, 28, Color.WHITE, new Color(0,0,0,0));
        
        int x = (image.getWidth() - imgTexto.getWidth()) / 2;
        int y = (image.getHeight() - imgTexto.getHeight()) / 2;
        
        image.drawImage(imgTexto, x, y);
        setImage(image);
    }

    public void act()
    {
        // Verifica se o mouse clicou
        if (Greenfoot.mouseClicked(this))
        {
            // Pega uma referência do mundo onde o botão está
            World mundo = getWorld();
            
            // Verifica em qual mundo o botão está
            if (mundo instanceof Tela_Inicial)
            {
                // Se estiver na Tela_Inicial, chama o método dela
                ((Tela_Inicial) mundo).botaoClicado(id);
            }
            else if (mundo instanceof Tela_Instrucoes)
            {
                // Se estiver na Tela_Instrucoes, chama o método dela
                ((Tela_Instrucoes) mundo).botaoClicado(id);
            }
            
            // (opcao de else caso a gente quiser criar mais mundos)
        }
    }
}
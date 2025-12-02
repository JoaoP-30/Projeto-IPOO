import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o painel inicial com botoes para a Interface de Usuário.
 * @version 2.0
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

    public void act(){
        if (Greenfoot.mouseClicked(this))
        {
            World mundo = getWorld();

            if (mundo instanceof Fases)
            {
                ((Fases)mundo).botaoClicado(id);
            }
        }
    }
}
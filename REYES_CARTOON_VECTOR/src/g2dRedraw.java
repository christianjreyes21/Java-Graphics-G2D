
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christianreyes
 */
public class g2dRedraw {
    public void redraw(Graphics g,int frame)
    {
        try {
            Image image = ImageIO.read(this.getClass().getResource("img/"+frame+".gif"));
            g.drawImage(image, 0, 0, 500, 218, null);
        } catch (IOException ex) {
            Logger.getLogger(Animation_Polvoriza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

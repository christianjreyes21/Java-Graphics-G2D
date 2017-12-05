/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** å
 *
 * @author
 */
import java.awt.*;
import java.awt.geom.*;

public class ACTIVITY7_REYES extends Frame {

    public Graphics2D g2d;

    public void paint(Graphics g) {

        g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(2.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);


//BOAT
        GeneralPath gp3 = new GeneralPath();
        gp3.moveTo(200, 300);
        gp3.lineTo(250, 400);
        gp3.lineTo(550, 400);
        gp3.lineTo(600, 300);
        gp3.lineTo(405, 300);
        gp3.lineTo(395, 300);
        gp3.lineTo(200, 300);

        gp3.moveTo(395, 300);
        gp3.lineTo(395, 100);
        gp3.lineTo(405, 100);
        gp3.lineTo(405, 300);

        gp3.moveTo(405, 100);
        gp3.lineTo(500, 150);
        gp3.lineTo(405, 150);

        // g2d.draw(gp3);
        g2d.setColor(Color.BLACK);
        g2d.fill(gp3);
        //g2d.draw(gp3);

  
        // TRANSLATE (dx = 100, dy = 150)
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(100, 150);
        g2d.setColor(Color.red);
        //g2d.fill(translate.createTransformedShape(gp3));
        
        // ROTATE (30 degrees)
        AffineTransform rotate = new AffineTransform();
        rotate.setToRotation(Math.PI/6);
        g2d.setColor(Color.CYAN);
        //g2d.fill(rotate.createTransformedShape(gp3));
        
        // SCALE (1/4, 3)
        AffineTransform scale = new AffineTransform();
        scale.setToScale(0.25, 3);
        g2d.setColor(Color.BLUE);
        g2d.fill(scale.createTransformedShape(gp3));
        
        // SHEAR (1/2, 0)
        AffineTransform shear = new AffineTransform();
        shear.setToShear(0.5, 0);
        g2d.setColor(Color.yellow);
        //g2d.fill(shear.createTransformedShape(gp3));
        //
        // ROTATE TRANSLATED (30 degrees)
        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation(Math.PI/6);
        g2d.setColor(Color.green);
        //g2d.fill(rotate1.createTransformedShape(translate.createTransformedShape(gp3)));
        
        // SCALE SHEARED(1/4, 3)
        AffineTransform scale1 = new AffineTransform();
        scale1.setToScale(0.25, 3);
        g2d.setColor(Color.MAGENTA);
        //g2d.fill(scale1.createTransformedShape(shear.createTransformedShape(gp3)));
        
        

    }
    
    
    
    

    public static void main(String[] argv) {
        ACTIVITY7_REYES s = new ACTIVITY7_REYES();
        s.setTitle(""); //title of frame
        s.setBackground(Color.white); //bgcolor
        s.setSize(800, 800); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
import java.awt.*;
import java.awt.geom.*;

public class Example extends Frame{
    public Graphics2D g2d;
    public void paint (Graphics g)
    {
        g2d = (Graphics2D)g;
        BasicStroke bs = new BasicStroke (7.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.cyan);
        Line2D.Double line = new Line2D.Double (20,60,200,300);
        g2d.draw(line);
        //g2d.setFont(new Font("Arial", Font.BOLD, 100)); //font, style, size
        //g2d.drawString("I LOVE CS 208", 50, 170); //text, pangcenter, pangbaba
        Rectangle2D.Double rect = new Rectangle2D.Double(100,200,300,400);
        g2d.draw(rect);
        Arc2D.Double elli = new Arc2D.Double(rect,500,100,Arc2D.PIE);
        g2d.draw(elli);
        g2d.setPaint(Color.black);
        g2d.fill(elli);
        //jollibeeHat();
        
    }
    
    public void jollibeeHat ()
    {
        //Line2D.Double line1 = new Line2D.Double (50, 200, 250, 300); // first two is the first point, second two is the second point
        //g2d.draw(line1);
        CubicCurve2D.Double q1 = new CubicCurve2D.Double (361, 299, 361, 282, 358, 259, 353, 233); // first two is the first point, second two is the second point
        g2d.draw(q1);
        CubicCurve2D.Double q2 = new CubicCurve2D.Double (360, 270, 352, 271, 343, 268, 338, 266); // first two is the first point, second two is the second point
        g2d.draw(q2);
        CubicCurve2D.Double q3 = new CubicCurve2D.Double (338, 266, 333, 264, 329, 261, 325, 258); 
        g2d.draw(q3);
        CubicCurve2D.Double q4 = new CubicCurve2D.Double (325, 258, 321, 254, 318, 249, 316, 245);
        g2d.draw(q4);
    }
    public static void main (String[] argv)
    {
        Example s = new Example ();
        s.setTitle("String in Java"); //title of frame
        s.setBackground(Color.gray); //bgcolor
        s.setSize(1000,1000); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**å
 *
 * @author 
 */
import java.awt.*;
import java.awt.geom.*;

public class Activity2_Reyes extends Frame{
    public Graphics2D g2d;
    public void paint (Graphics g)
    {
        
        g2d = (Graphics2D)g;
        BasicStroke bs = new BasicStroke (7.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.black);
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("LINE", 40, 450); //text, pangcenter, pangbaba
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("QUAD CURVE", 260, 500); //text, pangcenter, pangbaba
        
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("CUBIC CURVE", 390, 400); //text, pangcenter, pangbaba
        
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("RECTANGLE", 200, 80); //text, pangcenter, pangbaba
        
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("CIRCLE", 150, 50); //text, pangcenter, pangbaba
        
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("ELLIPSE", 230, 250); //text, pangcenter, pangbaba
        
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); //font, style, size
        g2d.drawString("ARC", 400, 500); //text, pangcenter, pangbaba
        Line2D.Double line1 = new Line2D.Double (40, 490, 600, 130); 
        g2d.draw(line1);
        Line2D.Double line2 = new Line2D.Double (600, 130, 400, 300); 
        g2d.draw(line2);
        Line2D.Double line3 = new Line2D.Double (400, 300, 450, 600); 
        g2d.draw(line3);
        Line2D.Double line4 = new Line2D.Double (450, 600, 300, 390); 
        g2d.draw(line4);
        Line2D.Double line5 = new Line2D.Double (300, 390, 40, 490); 
        g2d.draw(line5);
        
        
        
        g2d.setPaint(Color.green);
        
        QuadCurve2D.Double q1 = new QuadCurve2D.Double (270,500,380,300,600,550);
        g2d.draw(q1);
        
        
        g2d.setPaint(Color.blue);
        CubicCurve2D.Double c1 = new CubicCurve2D.Double (390,400,490,650,580,550,575,350);
        g2d.draw(c1);
        
        g2d.setPaint(Color.red);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(200,100,350,200);
        g2d.draw(rect1);
        
        g2d.setPaint(Color.yellow);
        Ellipse2D.Double elli1 = new Ellipse2D.Double (-50,60,700,700);
        g2d.draw(elli1);
        
        g2d.setPaint(Color.yellow);
        Ellipse2D.Double elli2 = new Ellipse2D.Double (230,250,240,300);
        g2d.draw(elli2);
        
        g2d.setPaint(Color.orange);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(300,500,300,100);
        Arc2D.Double arc1 = new Arc2D.Double(rect2,25,65,Arc2D.PIE);
        g2d.draw(arc1);
        
        
        
        
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
        Activity2_Reyes s = new Activity2_Reyes ();
        s.setTitle("String in Java"); //title of frame
        s.setBackground(Color.gray); //bgcolor
        s.setSize(1024,1024); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

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

public class Union_Reyes1 extends Frame{
    public Graphics2D g2d;
    public void paint (Graphics g)
    {
        
        g2d = (Graphics2D)g;
        BasicStroke bs = new BasicStroke (7.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        
        
        Ellipse2D.Double e = new Ellipse2D.Double(40,40,400,500);
        Ellipse2D.Double f = new Ellipse2D.Double(80,100,500,500);
        Rectangle2D.Double r = new Rectangle2D.Double(150,100,600,500);
        Rectangle2D.Double s = new Rectangle2D.Double(200,150,600,600);
        //g2d.fill(f);
        //g2d.fill(e);
        //g2d.fill(r);
        //g2d.fill(s);
        
        Area E = new Area(e);
        Area F = new Area(f);
        Area R = new Area(r);
        Area S = new Area(s);
        
        //S.add(E);
        //g2d.fill(S);
        
        g2d.setPaint(Color.red);
        //S.intersect(F);
        //g2d.fill(S);
        
        F.exclusiveOr(E);
        g2d.fill(F);
        
    }
    
 
    public static void main (String[] argv)
    {
        Union_Reyes1 s = new Union_Reyes1 ();
        s.setTitle("String in Java"); //title of frame
        s.setBackground(Color.gray); //bgcolor
        s.setSize(1024,1024); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

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

public class Area_Reyes extends Frame {

    public Graphics2D g2d;

    public void paint(Graphics g) {

      g2d = (Graphics2D)g;
        BasicStroke bs =  new BasicStroke (4.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        
        GeneralPath t = new GeneralPath();
        t.moveTo(100,250);
        t.lineTo(150,250); //AB
        t.lineTo(150,200); //BC
        t.lineTo(200,200); //CD
        t.lineTo(200,500); //DE
        t.lineTo(400,500); //EF
        t.lineTo(400,200); //FG
        t.lineTo(450,200); //GH
        t.lineTo(450,250); //HI
        t.lineTo(500,250); //IJ
        t.lineTo(500,150); //JK
        t.lineTo(450,100); //KL
        t.lineTo(150,100); //LM
        t.lineTo(100,150);
        t.lineTo(100,250);
        
        GeneralPath boat = new GeneralPath();
        boat.moveTo(100,350);
        boat.lineTo(150,450);
        boat.lineTo(450,450);
        boat.lineTo(500,350); 
        boat.lineTo(305,350); 
        boat.lineTo(295,350); 
        boat.lineTo(100,350); 
        boat.moveTo(295,350); 
        boat.lineTo(295,150); 
        boat.lineTo(305,150); 
        boat.lineTo(305,350);
        boat.moveTo(305,150); 
        boat.lineTo(400,200);
        boat.lineTo(305,200);
        
        GeneralPath gp1 = new GeneralPath();
        gp1.moveTo(300, 140);
        gp1.lineTo(350,290);
        gp1.lineTo(330,290);
        gp1.lineTo(400,440);
        gp1.lineTo(380,440);
        gp1.lineTo(450,590);
        gp1.lineTo(150, 590);
        gp1.lineTo(220,440);
        gp1.lineTo(200,440);
        gp1.lineTo(270,290);
        gp1.lineTo(250, 290);
        gp1.lineTo(300,140);
        g2d.setPaint(Color.green);
        
        GeneralPath car = new GeneralPath();
        car.moveTo(120,240);
        car.lineTo(160,240);
        car.quadTo(180,280,200,240);
        car.lineTo(320,240);
        car.quadTo(340,280,360,240);
        car.lineTo(400,240);
        car.curveTo(390,200,400,160,320,160);
        car.lineTo(220, 160);
        car.lineTo(180,200);
        car.lineTo(120, 200);
        car.lineTo(120, 240);
        g2d.setPaint(Color.orange);
        
        
        Area a = new Area(t); //t
        Area b = new Area(boat); //boat
        Area c = new Area(gp1); //tree
        Area d = new Area(car); //car
        
       //c.add(b);
       // g2d.draw(c);
        
        d.add(a);
        g2d.draw(d);
        /*
        c.intersect(a);
      g2d.draw(c);
        
        b.subtract(d);
        g2d.draw(b);
        
        c.exclusiveOr(a);
        g2d.fill(c)
*/
        
//       Rectangle2D.Double rectangle = new Rectangle2D.Double(20, 20, 1000, 1000);
//        Area e = new Area(rectangle);
//        e.subtract(d);
//        g2d.fill(e);

    }

    public static void main(String[] argv) {
        Area_Reyes s = new Area_Reyes();
        s.setTitle(""); //title of frame
        s.setBackground(Color.white); //bgcolor
        s.setSize(800, 800); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

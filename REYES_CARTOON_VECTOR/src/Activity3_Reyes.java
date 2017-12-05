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

public class Activity3_Reyes extends Frame {

    public Graphics2D g2d;

    public void paint(Graphics g) {

        g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(2.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);

//T-SHIRT
        GeneralPath gp1 = new GeneralPath();
        gp1.moveTo(150, 200);
        gp1.lineTo(200, 200);
        gp1.lineTo(200, 150);
        gp1.lineTo(250, 150);
        gp1.lineTo(250, 450);
        gp1.lineTo(450, 450);
        gp1.lineTo(450, 150);
        gp1.lineTo(500, 150);
        gp1.lineTo(500, 200);
        gp1.lineTo(550, 200);
        gp1.lineTo(550, 100);
        gp1.lineTo(500, 50);
        gp1.lineTo(200, 50);
        gp1.lineTo(150, 100);
        gp1.lineTo(150, 200);
g2d.setColor(new Color(0, 0, 255));
//g2d.fill(gp1);
        g2d.setPaint(new Color(0, 0, 255));
        //g2d.draw(gp1);

//CROSS
        GeneralPath gp2 = new GeneralPath();
        gp2.moveTo(300, 300);
        gp2.lineTo(300, 200);
        gp2.quadTo(300, 160, 340, 160);
        gp2.lineTo(360, 160);
        gp2.quadTo(400, 160, 400, 200);
        gp2.lineTo(400, 300);
        gp2.lineTo(500, 300);
        gp2.quadTo(540, 300, 540, 340);
        gp2.lineTo(540, 360);
        gp2.quadTo(540, 400, 500, 400);
        gp2.lineTo(400, 400);
        gp2.lineTo(400, 500);
        gp2.quadTo(400, 540, 360, 540);
        gp2.lineTo(340, 540);
        gp2.quadTo(300, 540, 300, 500);
        gp2.lineTo(300, 400);
        gp2.lineTo(200, 400);
        gp2.quadTo(160, 400, 160, 360);
        gp2.lineTo(160, 340);
        gp2.quadTo(160, 300, 200, 300);
        gp2.lineTo(300, 300);

        g2d.setColor(Color.RED);
        //g2d.fill(gp2);
       // g2d.draw(gp2);

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

      
//TREE
        GeneralPath treeMain = new GeneralPath();
        treeMain.moveTo(400, 170);
        treeMain.lineTo(450, 320);
        treeMain.lineTo(430, 320);
        treeMain.lineTo(500, 470);
        treeMain.lineTo(480, 470);
        treeMain.lineTo(550, 620);
        treeMain.lineTo(250, 620);
        treeMain.lineTo(320, 470);
        treeMain.lineTo(300, 470);
        treeMain.lineTo(370, 320);
        treeMain.lineTo(350, 320);
        treeMain.lineTo(400, 170);
        g2d.setColor(new Color(0, 255, 0));
        //g2d.fill(treeMain);
        g2d.setPaint(new Color(0, 255, 0));
        //g2d.draw(treeMain);

        GeneralPath treeStar = new GeneralPath();
        treeStar.moveTo(400, 150);
        treeStar.lineTo(410, 160);
        treeStar.lineTo(400, 170);
        treeStar.lineTo(390, 160);
        treeStar.lineTo(400, 150);
        g2d.setColor(Color.yellow);
        //g2d.fill(treeStar);
        g2d.setPaint(Color.yellow);
        //g2d.draw(treeStar);

        GeneralPath treeBase = new GeneralPath();
        treeBase.moveTo(390, 620);
        treeBase.lineTo(420, 620);
        treeBase.lineTo(420, 650);
        treeBase.lineTo(390, 650);
        treeBase.lineTo(390, 620);
        g2d.setColor(Color.gray);
        //g2d.fill(treeBase);
        g2d.setPaint(Color.gray);
        //g2d.draw(treeBase);
        
        Area a = new Area(gp1);//tshirt
        Area b = new Area(gp2);//cross
        Area c = new Area(gp3);//boat
        Area d = new Area(treeMain);//tree
        
        
        
        /*
        g2d.setPaint(Color.red);
        d.add(b);
        g2d.fill(d);
        
        /*
        g2d.setPaint(Color.blue);
        c.add(a);
        g2d.fill(c);*/
        
        /*
        g2d.setPaint(Color.magenta);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(20,20,1000,800);
        Area e = new Area(ellipse);
        e.subtract(c);
        g2d.fill(e);*/
        
        /*
        g2d.setPaint(Color.yellow);
        c.intersect(d);
        g2d.fill(c);*/
        
        /*
        g2d.setPaint(Color.pink);
        d.subtract(c);
        g2d.fill(d);*/
        
        /*
        g2d.setPaint(Color.green);
        b.subtract(a);
        g2d.fill(b);*/
        
        /*
        g2d.setPaint(Color.cyan);
        c.exclusiveOr(b);
        g2d.fill(c);*/
        
        // TRANSLATE (dx = 100, dy = 150)
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(100, 150);
        g2d.setColor(Color.red);
        g2d.fill(translate.createTransformedShape(gp3));
        
        // ROTATE (30 degrees)
        AffineTransform rotate = new AffineTransform();
        rotate.setToRotation(Math.PI/6);
        g2d.setColor(Color.CYAN);
        g2d.fill(rotate.createTransformedShape(gp3));
        
        // SCALE (1/4, 3)
        AffineTransform scale = new AffineTransform();
        scale.setToScale(0.25, 3);
        g2d.setColor(Color.BLUE);
        g2d.fill(scale.createTransformedShape(gp3));
        
        // SHEAR (1/2, 0)
        AffineTransform shear = new AffineTransform();
        shear.setToShear(0.5, 0);
        g2d.setColor(Color.yellow);
        g2d.fill(shear.createTransformedShape(gp3));
        
        // ROTATE TRANSLATED (30 degrees)
        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation(Math.PI/6);
        g2d.setColor(Color.green);
        g2d.fill(rotate1.createTransformedShape(translate.createTransformedShape(gp3)));
        
        // SCALE SHEARED(1/4, 3)
        AffineTransform scale1 = new AffineTransform();
        scale1.setToScale(0.25, 3);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(scale1.createTransformedShape(shear.createTransformedShape(gp3)));
        
        

    }
    
    
    
    

    public static void main(String[] argv) {
        Activity3_Reyes s = new Activity3_Reyes();
        s.setTitle(""); //title of frame
        s.setBackground(Color.white); //bgcolor
        s.setSize(800, 800); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

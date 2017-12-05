/*
  Santos, Chris Micael C.
  4CSA - CS 208
  FourWayTraffic_SantosC
*/

/**
 *
 * @author ChrisSantos
*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;


public class FourWayTraffic_SantosC extends Frame{
    
    boolean moveRtoL = false;
    static String flag = "";
    static String flag2 = "";
    static String flag3 = "yellowtop";
    int counter = 0;
    int xValLMove = 150;
    int yValTMove= 600;
    int yValBMove= 100;
    int xValRMove = 650;
    
    public FourWayTraffic_SantosC() {
    Timer count;
        count = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (counter == 0) {
                    flag = "redTop";
                    flag2 = "greenTop";
                    flag3 = "";
                    counter++;
                    
                    Timer count3;
                    count3 = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg1) {
                            xValLMove += 100;
                            xValRMove -= 100;
                            repaint();
                            if(xValLMove == 600){ //if(xValRMove < 0){ 
                            ((Timer) arg1.getSource()).stop();
                            }
                            }
                        });
                    count3.start();
                    repaint();
                    
                } else if (counter == 1) {
                    flag = "redRight";
                    flag2 = "greenRight";
                    flag3 = "";
                    counter++;
                    Timer count3;
                    count3 = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg1) {
                            yValTMove -= 100;
                            yValBMove += 100;
                            repaint();
                            if(yValBMove == 800){
                            ((Timer) arg1.getSource()).stop();
                            }
                            }
                        });
                    count3.start();
                    repaint();
                } else {
                    flag3 = "yellowtop";
                    flag = "";
                    flag2 = "";
                    counter = 0;
                    repaint();
                    
                }
            }
        });
        count.start();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
        }
      });
    
    
    }
    
    public void clearWindow(Graphics2D g2d){
        road(g2d);
    }
    
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        road(g2d);
        //if(moveRtoL==true){
        train(g2d, 0.22, 0.22, xValRMove, 330, 1, 1, 0); //right //510, 220
        train(g2d, 0.22, 0.22, xValLMove, 230, -1, 1, 0);//left //300, 330
        train(g2d, 0.22, 0.22, 400, yValBMove, -1, -1, 90);//up //270 240
        train(g2d, 0.22, 0.22, 400, yValTMove, -1, -1, -90);//down //510 450
   }
   
    public static void main(String[] args) {
        FourWayTraffic_SantosC s = new FourWayTraffic_SantosC();
        s.setTitle("Four Way Traffic - Santos C"); 
        s.setBackground(new Color(192, 205, 224)); 
        s.setSize(810,668); 
        //s.setForeground(Color.black); 
        s.setVisible(true); 
    }
    
    public void road (Graphics2D g2d){
        BasicStroke bs = new BasicStroke(5.0f); 
        BasicStroke line = new BasicStroke(12.0f);
        g2d.setStroke(bs);
       
        Rectangle2D.Double v = new Rectangle2D.Double(300, 0, 200, 800);
        Rectangle2D.Double h = new Rectangle2D.Double(0, 250, 900, 200);

        g2d.setColor(new Color(19, 113, 206));
        g2d.fill(v);
        g2d.fill(h);

        Rectangle2D.Double stp1 = new Rectangle2D.Double(100, 170, 180, 60); //upper left
        Ellipse2D.Double top1 = new Ellipse2D.Double(110, 175, 50, 50); //7 sec
        Ellipse2D.Double mid1 = new Ellipse2D.Double(165, 175, 50, 50); //3 sec
        Ellipse2D.Double bot1 = new Ellipse2D.Double(220, 175, 50, 50); //7 sec

        Rectangle2D.Double stp2 = new Rectangle2D.Double(520, 50, 60, 180); //upper right
        Ellipse2D.Double top2 = new Ellipse2D.Double(525, 55, 50, 50); //7 sec
        Ellipse2D.Double mid2 = new Ellipse2D.Double(525, 110, 50, 50); //3 sec
        Ellipse2D.Double bot2 = new Ellipse2D.Double(525, 170, 50, 50); //7 sec

        Rectangle2D.Double stp3 = new Rectangle2D.Double(220, 460, 60, 180); //lower left
        Ellipse2D.Double bot3 = new Ellipse2D.Double(225, 465, 50, 50); //7 sec
        Ellipse2D.Double mid3 = new Ellipse2D.Double(225, 520, 50, 50); //3 sec
        Ellipse2D.Double top3 = new Ellipse2D.Double(225, 575, 50, 50); //7 sec

        Rectangle2D.Double stp4 = new Rectangle2D.Double(520, 460, 180, 60); //lower right
        Ellipse2D.Double top4 = new Ellipse2D.Double(640, 465, 50, 50); //7 sec
        Ellipse2D.Double mid4 = new Ellipse2D.Double(585, 465, 50, 50); //3 sec
        Ellipse2D.Double bot4 = new Ellipse2D.Double(525, 465, 50, 50); //7 sec

        Line2D.Double l1 = new Line2D.Double(400, 50, 400, 100); //up
        Line2D.Double l2 = new Line2D.Double(400, 150, 400, 220); //up
        Line2D.Double l3 = new Line2D.Double(400, 470, 400, 540); //down
        Line2D.Double l4 = new Line2D.Double(400, 590, 400, 650); //down
        Line2D.Double l5 = new Line2D.Double(50, 350, 100, 350); //left
        Line2D.Double l6 = new Line2D.Double(150, 350, 270, 350);//left
        Line2D.Double l7 = new Line2D.Double(530, 350, 650, 350); //right
        Line2D.Double l8 = new Line2D.Double(700, 350, 750, 350); //right

        g2d.setColor(Color.black);
        g2d.fill(stp1);
        g2d.fill(stp2);
        g2d.fill(stp3);
        g2d.fill(stp4);

        g2d.setStroke(line);
        g2d.setColor(Color.white);
        g2d.draw(l1);
        g2d.draw(l2);
        g2d.draw(l3);
        g2d.draw(l4);
        g2d.draw(l5);
        g2d.draw(l6);
        g2d.draw(l7);
        g2d.draw(l8);

        g2d.setStroke(bs);
        
        /*g2d.setColor(Color.red);
        g2d.fill(top1);
        g2d.fill(top2);
        g2d.fill(top3);
        g2d.fill(top4);

        g2d.setColor(Color.yellow);
        g2d.fill(mid1);
        g2d.fill(mid2);
        g2d.fill(mid3);
        g2d.fill(mid4);

        g2d.setColor(Color.green);
        g2d.fill(bot1);
        g2d.fill(bot2);
        g2d.fill(bot3);
        g2d.fill(bot4);*/
        
        System.out.println(flag);
        if (flag.equals("redTop")) {
            g2d.setColor(Color.red); //red on
            g2d.fill(top2);
            g2d.fill(top3);
            g2d.setColor(new Color(82, 0, 0)); //red off
            g2d.fill(top1);
            g2d.fill(top4);
            g2d.setColor(new Color(99, 82, 0)); //yellow off
            g2d.fill(mid1);
            g2d.fill(mid2);
            g2d.fill(mid3);
            g2d.fill(mid4);
        }

        if (flag.equals("redRight")) {
            g2d.setColor(Color.red); //red off
            g2d.fill(top1);
            g2d.fill(top4);
            g2d.setColor(new Color(82, 0, 0)); //red off
            g2d.fill(top2);
            g2d.fill(top3);
            g2d.setColor(new Color(99, 82, 0)); //yellow off
            g2d.fill(mid1);
            g2d.fill(mid2);
            g2d.fill(mid3);
            g2d.fill(mid4);
        }
        if (flag2.equals("greenTop")) {
            g2d.setColor(Color.green); //green on
            g2d.fill(bot1);
            g2d.fill(bot4);
            g2d.setColor(new Color(0, 105, 0)); //green off
            g2d.fill(bot2);
            g2d.fill(bot3);
            g2d.setColor(new Color(99, 82, 0)); //yellow off
            g2d.fill(mid1);
            g2d.fill(mid2);
            g2d.fill(mid3);
            g2d.fill(mid4);
        }

        if (flag2.equals("greenRight")) {
            g2d.setColor(Color.green); //green on
            g2d.fill(bot2);
            g2d.fill(bot3);
            g2d.setColor(new Color(0, 105, 0)); //green off
            g2d.fill(bot1);
            g2d.fill(bot4);
            g2d.setColor(new Color(99, 82, 0)); //yellow off
            g2d.fill(mid1);
            g2d.fill(mid2);
            g2d.fill(mid3);
            g2d.fill(mid4);
        }
        if (flag3.equals("yellowtop")) {
            g2d.setColor(Color.yellow); //yellow on
            g2d.fill(mid1);
            g2d.fill(mid2);
            g2d.fill(mid3);
            g2d.fill(mid4);
            g2d.setColor(new Color(82, 0, 0)); //red off
            g2d.fill(top1);
            g2d.fill(top4);
            g2d.setColor(new Color(0, 105, 0)); //green off
            g2d.fill(bot1);
            g2d.fill(bot4);
            g2d.setColor(new Color(0, 105, 0)); //green off
            g2d.fill(bot2);
            g2d.fill(bot3);
            g2d.setColor(new Color(82, 0, 0)); //red off
            g2d.fill(top2);
            g2d.fill(top3);
        }
        /*
        g2d.setColor(new Color(99,82,0)); //yellow off
        g2d.fill(mid1);
        g2d.fill(mid2);
        g2d.fill(mid3);
        g2d.fill(mid4);*/
    }
  
    public void train (Graphics2D g2d, double scx, double scy, int tx, int ty, int sx, int sy, double angle){
        BasicStroke bs = new BasicStroke (4.0f);
        g2d.setStroke(bs);
        
        AffineTransform a = new AffineTransform();
        a.setToScale(scx, scy);
        
        AffineTransform trans = new AffineTransform();
        trans.setToTranslation(tx, ty);
        trans.scale(sx, sy);
        
        AffineTransform rot = new AffineTransform();
        rot.setToRotation(Math.toRadians(angle));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath redbox2 = new GeneralPath();
        redbox2.moveTo(87,337);
        redbox2.curveTo(85,350,89,359,93,362);
        redbox2.lineTo(327,363);
        redbox2.lineTo(330,325);
        redbox2.quadTo(285,324,235,324);
        redbox2.quadTo(235,331,233,337);
        redbox2.quadTo(162,336,87,337);
        //g2d.draw(redbox2);
        //g2d.fill(redbox2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox2))));
        g2d.setPaint(new Color(208,24,24));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(58,386);
        triangle.lineTo(79,350);
        triangle.quadTo(88,344,97,341);
        triangle.quadTo(102,365,105,391);
        triangle.curveTo(87,392,69,390,58,386);
        //g2d.draw(triangle);
        //g2d.fill(triangle);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(triangle))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(triangle))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath redbox = new GeneralPath();
        redbox.moveTo(220,192);
        redbox.lineTo(228,312);
        redbox.quadTo(282,311,330,313);
        redbox.lineTo(337,193);
        redbox.quadTo(282,191,220,192);
        //g2d.draw(redbox);
        //g2d.fill(redbox);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox))));
        g2d.setPaint(new Color(208,24,24));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath bluebox = new GeneralPath();
        bluebox.moveTo(103,262);
        bluebox.quadTo(99,300,100,338);
        bluebox.lineTo(233,339);
        bluebox.curveTo(236,315,235,287,229,264);
        bluebox.curveTo(186,260,138,261,103,262);
        //g2d.draw(bluebox);
        //g2d.fill(bluebox);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox))));
        g2d.setPaint(new Color(23,113,212));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath bluebox2 = new GeneralPath();
        bluebox2.moveTo(127,201);
        bluebox2.quadTo(128,228,131,255);
        bluebox2.lineTo(166,255);
        bluebox2.quadTo(171,227,172,200);
        bluebox2.quadTo(151,200,127,201);
        //g2d.draw(bluebox2);
        //g2d.fill(bluebox2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox2))));
        g2d.setPaint(new Color(23,113,212));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath bluebox3 = new GeneralPath();
        bluebox3.moveTo(177,246);
        bluebox3.lineTo(177,260);
        bluebox3.quadTo(183,260,190,260);
        bluebox3.lineTo(191,247);
        bluebox3.lineTo(177,246);
        //g2d.draw(bluebox3);
        //g2d.fill(bluebox3);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox3))));
        g2d.setPaint(new Color(23,113,212));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath bluebox4 = new GeneralPath();
        bluebox4.moveTo(202,247);
        bluebox4.lineTo(201,260);
        bluebox4.quadTo(208,261,215,261);
        bluebox4.lineTo(215,247);
        bluebox4.lineTo(202,247);
        //g2d.draw(bluebox4);
        //g2d.fill(bluebox4);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox4))));
        g2d.setPaint(new Color(23,113,212));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(bluebox4))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath greenbox = new GeneralPath();
        greenbox.moveTo(356,243);
        greenbox.quadTo(450,239,538,241);
        greenbox.lineTo(529,334);
        greenbox.lineTo(361,333);
        greenbox.lineTo(356,243);
        //g2d.draw(greenbox);
        //g2d.fill(greenbox);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox))));
        g2d.setPaint(new Color(114,191,33));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath pinkbox = new GeneralPath();
        pinkbox.moveTo(552,242);
        pinkbox.quadTo(645,239,736,242);
        pinkbox.lineTo(726,334);
        pinkbox.lineTo(559,333);
        pinkbox.lineTo(552,242);
        //g2d.draw(pinkbox);
        //g2d.fill(pinkbox);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(pinkbox))));
        g2d.setPaint(new Color(217,111,216));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(pinkbox))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath greenbox2 = new GeneralPath();
        greenbox2.moveTo(371,344);
        greenbox2.lineTo(520,344);
        greenbox2.lineTo(520,363);
        greenbox2.lineTo(371,363);
        greenbox2.lineTo(371,344);
        //g2d.draw(greenbox2);
        //g2d.fill(greenbox2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox2))));
        g2d.setPaint(new Color(114,191,33));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath pinkbox2 = new GeneralPath();
        pinkbox2.moveTo(567,344);
        pinkbox2.lineTo(716,344);
        pinkbox2.lineTo(716,364);
        pinkbox2.lineTo(568,364);
        pinkbox2.lineTo(567,344);
        //g2d.draw(pinkbox2);
        //g2d.fill(pinkbox2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(pinkbox2))));
        g2d.setPaint(new Color(217,111,216));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(pinkbox2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        Ellipse2D.Double c1 = new Ellipse2D.Double(107,346,46,46);
        Ellipse2D.Double c2 = new Ellipse2D.Double(170,346,46,46);
        Ellipse2D.Double c3 = new Ellipse2D.Double(222,335,60,60);
        Ellipse2D.Double c4 = new Ellipse2D.Double(288,335,60,60);
        Ellipse2D.Double c5 = new Ellipse2D.Double(378,347,46,46);
        Ellipse2D.Double c6 = new Ellipse2D.Double(464,347,46,46);
        Ellipse2D.Double c7 = new Ellipse2D.Double(576,346,46,46);
        Ellipse2D.Double c8 = new Ellipse2D.Double(663,346,46,46);
        /*g2d.draw(c1);
        g2d.draw(c2);
        g2d.draw(c3);
        g2d.draw(c4);
        g2d.draw(c5);
        g2d.draw(c6);
        g2d.draw(c7);
        g2d.draw(c8);*/
        /*g2d.fill(c1);
        g2d.fill(c2);
        g2d.fill(c3);
        g2d.fill(c4);
        g2d.fill(c5);
        g2d.fill(c6);
        g2d.fill(c7);
        g2d.fill(c8);*/
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c1))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c2))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c3))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c4))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c5))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c6))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c7))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c8))));
        g2d.setPaint(new Color(159,159,159));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c1))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c2))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c3))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c4))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c5))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c6))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c7))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c8))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox = new GeneralPath();
        orangebox.moveTo(91,261);
        orangebox.quadTo(96,260,100,261);
        orangebox.quadTo(97,263,103,263);
        orangebox.quadTo(99,300,100,338);
        orangebox.lineTo(90,338);
        orangebox.quadTo(88,300,91,261);
        //g2d.draw(orangebox);
        //g2d.fill(orangebox);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath redbox3 = new GeneralPath();
        redbox3.moveTo(89,285);
        redbox3.lineTo(83,284);
        redbox3.curveTo(80,295,81,310,84,320);
        redbox3.lineTo(88,319);
        redbox3.lineTo(89,285);
        //g2d.draw(redbox3);
        //g2d.setPaint(new Color(208,24,24));
        //g2d.fill(redbox3);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox3))));
        g2d.setPaint(new Color(208,24,24));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox2 = new GeneralPath();
        orangebox2.moveTo(121,188);
        orangebox2.quadTo(120,194,122,200);
        orangebox2.quadTo(149,201,174,200);
        orangebox2.quadTo(176,194,174,188);
        orangebox2.lineTo(121,188);
        //g2d.draw(orangebox2);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox2))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox3 = new GeneralPath();
        orangebox3.moveTo(218,179);
        orangebox3.quadTo(280,178,340,180);
        orangebox3.lineTo(339,193);
        orangebox3.quadTo(282,191,220,193);
        orangebox3.lineTo(218,179);
        //g2d.draw(orangebox3);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox3);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox3))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox4 = new GeneralPath();
        orangebox4.moveTo(351,229);
        orangebox4.quadTo(450,226,543,229);
        orangebox4.lineTo(543,242);
        orangebox4.quadTo(450,239,352,242);
        orangebox4.lineTo(351,229);
        //g2d.draw(orangebox4);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox4);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox4))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox4))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox5 = new GeneralPath();
        orangebox5.moveTo(548,228);
        orangebox5.quadTo(647,226,740,229);
        orangebox5.lineTo(739,242);
        orangebox5.quadTo(645,239,549,242);
        orangebox5.lineTo(548,228);
        //g2d.draw(orangebox5);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox5);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox5))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox5))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox6 = new GeneralPath();
        orangebox6.moveTo(129,255);
        orangebox6.lineTo(168,255);
        orangebox6.lineTo(168,259);
        orangebox6.quadTo(149,259,129,259);
        orangebox6.lineTo(129,255);
        //g2d.draw(orangebox6);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox6);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox6))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox6))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox7 = new GeneralPath();
        orangebox7.moveTo(175,239);
        orangebox7.lineTo(194,239);
        orangebox7.lineTo(192,246);
        orangebox7.quadTo(184,245,175,246);
        orangebox7.quadTo(174,243,174,239);
        //g2d.draw(orangebox7);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox7);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox7))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox7))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox8 = new GeneralPath();
        orangebox8.moveTo(200,241);
        orangebox8.lineTo(218,241);
        orangebox8.lineTo(217,246);
        orangebox8.quadTo(208,245,200,246);
        orangebox8.quadTo(199,243,199,241);
        //g2d.draw(orangebox8);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox8);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox8))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox8))));
                
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox9 = new GeneralPath();
        orangebox9.moveTo(236,312);
        orangebox9.curveTo(265,311,313,311,340,312);
        orangebox9.lineTo(339,325);
        orangebox9.curveTo(306,324,261,323,236,324);
        orangebox9.lineTo(236,312);
        //g2d.draw(orangebox9);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox9);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox9))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox9))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        Ellipse2D.Double c9 = new Ellipse2D.Double(119,359,21,21);
        Ellipse2D.Double c10 = new Ellipse2D.Double(183,359,21,21);
        Ellipse2D.Double c11 = new Ellipse2D.Double(237,351,28,28);
        Ellipse2D.Double c12 = new Ellipse2D.Double(304,351,28,28);
        Ellipse2D.Double c13 = new Ellipse2D.Double(390,359,21,21);
        Ellipse2D.Double c14 = new Ellipse2D.Double(477,359,21,21);
        Ellipse2D.Double c15 = new Ellipse2D.Double(589,359,21,21);
        Ellipse2D.Double c16 = new Ellipse2D.Double(675,359,21,21);
        /*g2d.draw(c9);
        g2d.draw(c10);
        g2d.draw(c11);
        g2d.draw(c12);
        g2d.draw(c13);
        g2d.draw(c14);
        g2d.draw(c15);
        g2d.draw(c16);
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(c9);
        g2d.fill(c10);
        g2d.fill(c11);
        g2d.fill(c12);
        g2d.fill(c13);
        g2d.fill(c14);
        g2d.fill(c15);
        g2d.fill(c16);*/
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c9))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c10))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c11))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c12))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c13))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c14))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c15))));
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c16))));
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c9))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c10))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c11))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c12))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c13))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c14))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c15))));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(c16))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath white = new GeneralPath();
        white.moveTo(91,349);
        white.quadTo(77,365,66,384);
        white.lineTo(73,384);
        white.quadTo(82,366,91,349);
        //g2d.draw(white);
        //g2d.setPaint(Color.white);
        //g2d.fill(white);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white))));
        g2d.setPaint(Color.white);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath white2 = new GeneralPath();
        white2.moveTo(95,351);
        white2.lineTo(80,384);
        white2.lineTo(87,384);
        white2.lineTo(95,362);
        white2.lineTo(95,351);
        //g2d.draw(white2);
        //g2d.setPaint(Color.white);
        //g2d.fill(white2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white2))));
        g2d.setPaint(Color.white);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath white3 = new GeneralPath();
        white3.moveTo(97,366);
        white3.lineTo(92,385);
        white3.lineTo(98,385);
        white3.lineTo(97,366);
        //g2d.draw(white3);
        //g2d.setPaint(Color.white);
        //g2d.fill(white3); 
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white3))));
        g2d.setPaint(Color.white);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(white3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath redbox4 = new GeneralPath();
        redbox4.moveTo(247,205);
        redbox4.quadTo(285,205,317,206);
        redbox4.lineTo(314,277);
        redbox4.lineTo(249,276);
        redbox4.lineTo(247,205);
        //g2d.draw(redbox4);
        //g2d.setPaint(new Color(126,0,0));
        //g2d.fill(redbox4);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox4))));
        g2d.setPaint(new Color(126,0,0));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox4))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath greenbox3 = new GeneralPath();
        greenbox3.moveTo(387,259);
        greenbox3.quadTo(415,257,506,259);
        greenbox3.lineTo(501,309);
        greenbox3.lineTo(390,309);
        greenbox3.lineTo(387,259);
        //g2d.draw(greenbox3);
        //g2d.setPaint(new Color(66,121,8));
        //g2d.fill(greenbox3);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox3))));
        g2d.setPaint(new Color(66,121,8));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(greenbox3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox10 = new GeneralPath();
        orangebox10.moveTo(330,328);
        orangebox10.curveTo(343,334,353,345,356,359);
        orangebox10.lineTo(352,360);
        orangebox10.curveTo(348,348,340,337,329,332);
        orangebox10.lineTo(330,328);
        //g2d.draw(orangebox10);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox10);  
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox10))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox10))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath gray = new GeneralPath();
        gray.moveTo(352,344);
        gray.lineTo(370,344);
        gray.lineTo(370,348);
        gray.lineTo(355,348);
        gray.quadTo(354,349,352,346);
        //g2d.draw(gray);
        //g2d.setPaint(new Color(70,71,71));
        //g2d.fill(gray);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray))));
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox11 = new GeneralPath();
        orangebox11.moveTo(359,332);
        orangebox11.lineTo(531,332);
        orangebox11.lineTo(531,343);
        orangebox11.lineTo(360,343);
        orangebox11.lineTo(359,332);
        //g2d.draw(orangebox11);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox11); 
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox11))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox11))));

        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath gray2 = new GeneralPath();
        gray2.moveTo(523,346);
        gray2.lineTo(565,346);
        gray2.lineTo(565,353);
        gray2.lineTo(523,353);
        gray2.lineTo(523,346);
        //g2d.draw(gray2);
        //g2d.setPaint(new Color(70,71,71));
        //g2d.fill(gray2);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray2))));
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray2))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath violet = new GeneralPath();
        violet.moveTo(583,259);
        violet.quadTo(644,258,702,259);
        violet.lineTo(698,309);
        violet.lineTo(586,309);
        violet.lineTo(583,259);
        //g2d.draw(violet);
        //g2d.setPaint(new Color(177,50,176));
        //g2d.fill(violet);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(violet))));
        g2d.setPaint(new Color(177,50,176));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(violet))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox12 = new GeneralPath();
        orangebox12.moveTo(555,332);
        orangebox12.lineTo(729,333);
        orangebox12.lineTo(728,344);
        orangebox12.lineTo(556,343);
        orangebox12.lineTo(555,332);
        //g2d.draw(orangebox12);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox12);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox12))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox12))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox13 = new GeneralPath();
        orangebox13.moveTo(130,368);
        orangebox13.quadTo(161,369,193,367);
        orangebox13.quadTo(194,369,193,372);
        orangebox13.quadTo(161,374,131,372);
        orangebox13.quadTo(130,370,130,368);
        //g2d.draw(orangebox13);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox13);  
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox13))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox13))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath orangebox14 = new GeneralPath();
        orangebox14.moveTo(254,360);
        orangebox14.quadTo(286,360,317,360);
        orangebox14.quadTo(318,363,317,365);
        orangebox14.quadTo(286,366,255,365);
        orangebox14.quadTo(254,363,254,360);
        //g2d.draw(orangebox14);
        //g2d.setPaint(new Color(231,116,4));
        //g2d.fill(orangebox14); 
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox14))));
        g2d.setPaint(new Color(231,116,4));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(orangebox14))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath gray3 = new GeneralPath();
        gray3.moveTo(130,187);
        gray3.curveTo(129,172,136,158,147,154);
        gray3.quadTo(151,147,157,142);
        gray3.curveTo(158,117,173,100,193,96); 
        gray3.curveTo(203,77,222,67,241,68);
        gray3.curveTo(277,44,313,65,313,97);
        gray3.curveTo(315,117,297,142,273,142);
        gray3.curveTo(264,149,249,150,240,145);
        gray3.curveTo(228,156,208,160,196,155);
        gray3.curveTo(192,164,182,170,171,171);
        gray3.quadTo(173,178,167,187);
        gray3.lineTo(130,187);
        //g2d.draw(gray3);
        //g2d.setPaint(new Color(106,106,106));
        //g2d.fill(gray3);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray3))));
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray3))));
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath gray4 = new GeneralPath();
        gray4.moveTo(343,65);
        gray4.curveTo(333,50,337,35,351,28);
        gray4.quadTo(360,28,365,34);
        gray4.curveTo(383,25,394,28,395,35); 
        gray4.curveTo(411,37,420,54,416,68);
        gray4.curveTo(419,80,410,94,399,95);
        gray4.curveTo(394,103,383,109,375,107);
        gray4.curveTo(359,112,336,93,344,76);
        gray4.quadTo(342,69,343,65);
        //g2d.draw(gray4);
        //g2d.setPaint(new Color(106,106,106));
        //g2d.fill(gray4); 
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray4))));
        g2d.setPaint(new Color(70,71,71));
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(gray4))));
    }
}    
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Shows animated bouncing balls.
 * 
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */
public class BounceThread {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}

/**
 * A runnable that animates a bouncing ball.
 */
class BallRunnable implements Runnable {
  /**
   * Constructs the runnable.
   * 
   * @aBall the ball to bounce
   * @aPanel the component in which the ball bounces
   */
  public BallRunnable(Ball aBall, Component aComponent) {
    ball = aBall;
    component = aComponent;
  }

  public void run() {
    try {
      for (int i = 1; i <= STEPS; i++) {
        ball.move(component.getBounds());
        component.repaint();
        Thread.sleep(DELAY);
      }
    } catch (InterruptedException e) {
    }
  }

  private Ball ball;

  private Component component;

  public static final int STEPS = 1000;

  public static final int DELAY = 5;
}

/**
 * The frame with panel and buttons.
 */
class BounceFrame extends JFrame {
  /**
   * Constructs the frame with the component for showing the bouncing ball and
   * Start and Close buttons
   */
  public BounceFrame() {
    setSize(800, 720);
    setTitle("BounceThread");

    comp = new BallComponent();
    add(comp, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    addButton(buttonPanel, "Start", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        addBall();
      }
    });

    addButton(buttonPanel, "Close", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    add(buttonPanel, BorderLayout.SOUTH);
  }

  /**
   * Adds a button to a container.
   * 
   * @param c
   *          the container
   * @param title
   *          the button title
   * @param listener
   *          the action listener for the button
   */
  public void addButton(Container c, String title, ActionListener listener) {
    JButton button = new JButton(title);
    c.add(button);
    button.addActionListener(listener);
  }

  /**
   * Adds a bouncing ball to the canvas and starts a thread to make it bounce
   */
  public void addBall() {
    Ball b = new Ball();
    comp.add(b);
    Runnable r = new BallRunnable(b, comp);
    Thread t = new Thread(r);
    t.start();
  }

  private BallComponent comp;

  public static final int DEFAULT_WIDTH = 450;

  public static final int DEFAULT_HEIGHT = 350;

  public static final int STEPS = 1000;

  public static final int DELAY = 3;
}

/*
 * This program is a part of the companion code for Core Java 8th ed.
 * (http://horstmann.com/corejava)
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * The component that draws the balls.
 * 
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */
class BallComponent extends JComponent {
  /**
   * Add a ball to the panel.
   * 
   * @param b
   *          the ball to add
   */
  public void add(Ball b) {
    balls.add(b);
  }

  
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    for (Ball b : balls) {
     b.getShape(g2d);
    }
    
  }

  private ArrayList<Ball> balls = new ArrayList<Ball>();
}

class Ball {
  /**
   * Moves the ball to the next position, reversing direction if it hits one of
   * the edges
   */
  public void move(Rectangle2D bounds) {
    x += dx;
    y += dy;
    if (x < bounds.getMinX()) {
      x = bounds.getMinX();
      dx = -dx;
    }
    if (x - XSIZE >= bounds.getMaxX()) {
      x = bounds.getMaxX() - XSIZE;
      dx = -dx;
    }
    if (y < bounds.getMinY()) {
      y = bounds.getMinY();
      dy = -dy;
    }
    if (y - YSIZE >= bounds.getMaxY()) {
      y = bounds.getMaxY() - YSIZE;
      dy = -dy;
    }
  }

  /**
   * Gets the shape of the ball at its current position.
   */
 public Graphics2D getShape( Graphics2D g2d) {
     
      BasicStroke bs = new BasicStroke(1.0f);
        g2d.setStroke(bs); 
        
        AffineTransform a = new AffineTransform();
        a.setToScale(-0.1, 0.1);
        
        AffineTransform trans = new AffineTransform();
        trans.setToTranslation(250,-30);
        
        GeneralPath flower = new GeneralPath(); 
        g2d.setPaint(Color.BLACK);
            flower.moveTo(335, 118);
            flower.curveTo(297, 18, 400, 20, 390, 110);
            flower.curveTo(460, 20, 530, 100, 435, 150);
            flower.curveTo(540, 195, 448, 286, 396, 190);
            flower.curveTo(390, 290, 287, 260, 340, 175);
            flower.curveTo(260, 190, 225, 105, 335, 118);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(flower)));
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(flower)));
         
        g2d.setPaint(Color.BLACK);
            flower.moveTo(335, 118);
            flower.curveTo(297, 18, 400, 20, 390, 110);
            flower.curveTo(460, 20, 530, 100, 435, 150);
            flower.curveTo(540, 195, 448, 286, 396, 190);
            flower.curveTo(390, 290, 287, 260, 340, 175);
            flower.curveTo(260, 190, 225, 105, 335, 118);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(flower)));
            
         
            GeneralPath innerbody = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            innerbody.moveTo(284, 437);
            innerbody.curveTo(271, 514, 424, 515, 408, 440);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(innerbody)));
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(innerbody)));
        GeneralPath face = new GeneralPath();
            face.moveTo(170, 180);
            face.curveTo(-20, 500, 665, 539, 536, 223);
            g2d.setPaint(Color.BLACK);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(face)));
        
        GeneralPath ears = new GeneralPath();
            ears.moveTo(152, 215);
            ears.quadTo(100, 20, 215, 110);
            ears.quadTo(270, 90, 325, 102);
            ears.moveTo(484, 102);
            ears.quadTo(620, 27, 535, 223);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(ears)));
         
         GeneralPath rarm = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            rarm.moveTo(445,429);
            rarm.quadTo(450, 465, 480, 504);
            rarm.lineTo(517, 460);
            rarm.lineTo(448,429);
            
            
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(rarm)));
            
            g2d.setPaint(Color.black);
            rarm.moveTo(517, 460);
            rarm.quadTo(527, 464, 529, 464);
            rarm.quadTo(565, 453, 552, 485);
            rarm.curveTo(627, 524, 512, 568, 481, 503);
            rarm.lineTo(517, 460);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(rarm)));    
            
            
        GeneralPath body = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            body.moveTo(250, 428);
            body.quadTo(130, 598, 167, 634);
            body.quadTo(356, 691, 507, 636);
            body.quadTo(536, 597, 444, 434);
            body.quadTo(425, 435, 407, 440);
            body.curveTo(428,504, 277, 529, 284, 434);
            body.quadTo(267, 431, 250, 428);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(body)));
            g2d.setPaint(Color.decode("#ff99bb"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(body)));
       
            g2d.setPaint(Color.BLACK);
            body.moveTo(250, 428);
            body.quadTo(130, 598, 167, 634);
            body.quadTo(356, 691, 507, 636);
            body.quadTo(536, 597, 444, 434);
            body.quadTo(425, 435, 407, 440);
            body.curveTo(428,504, 277, 529, 284, 434);
            body.quadTo(267, 431, 250, 428);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(body)));
            
        
        GeneralPath larm = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            larm.moveTo(251, 425);
            larm.quadTo(211,433,173,449);
            larm.lineTo(200,504);
            larm.quadTo(234,449,251,425);
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(larm)));
            
            g2d.setPaint(Color.black);
            larm.moveTo(173,449);
            larm.quadTo(165,450,158,456);
            larm.quadTo(119, 450, 136, 479);
            
            larm.curveTo(80, 523, 164, 555, 202, 499);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(larm)));
        
            
           
        GeneralPath feet = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            feet.moveTo(162, 632);
            feet.curveTo(160, 744, 362, 764, 338, 663);
            feet.moveTo(340, 667);
            feet.curveTo(330, 745, 500, 764, 510, 632);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(feet)));
            
        GeneralPath whiskers = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            whiskers.moveTo(186, 278);
            whiskers.lineTo(106, 250);
            whiskers.moveTo(182, 307);
            whiskers.lineTo(106, 307);
            whiskers.moveTo(186, 337);
            whiskers.lineTo(106, 357);
            whiskers.moveTo(506, 278);
            whiskers.lineTo(586, 250);
            whiskers.moveTo(506, 307);
            whiskers.lineTo(582, 307);
            whiskers.moveTo(506, 337);
            whiskers.lineTo(586, 357);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(whiskers)));
            
            
        
        g2d.setPaint(Color.BLACK);
            Ellipse2D.Double cir1 = new Ellipse2D.Double(356, 128, 49, 42);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(cir1)));
            g2d.setPaint(Color.yellow);
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(cir1)));
            
        g2d.setPaint(Color.BLACK);
            Ellipse2D.Double cir2 = new Ellipse2D.Double(356, 128, 49, 42);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(cir2)));
       
        g2d.setPaint(Color.BLACK);    
            Ellipse2D.Double elli1 = new Ellipse2D.Double(237, 294, 29, 39);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli1)));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli1)));
            Ellipse2D.Double elli2 = new Ellipse2D.Double(425, 294, 29, 39);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli2)));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli2)));
            
            Ellipse2D.Double elli3 = new Ellipse2D.Double(327, 344, 50, 33);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli3)));
            g2d.setPaint(Color.yellow);
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli3)));
            
        g2d.setPaint(Color.BLACK);  
            Ellipse2D.Double elli4 = new Ellipse2D.Double(327, 344, 50, 33);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli4)));
            
            AffineTransform trans1 = new AffineTransform();
            trans1.translate(-200 + x, -200 + y);
            trans1.translate(XSIZE,YSIZE);
            g2d.setTransform(trans1);
            
    return g2d;
  }

  private static final int XSIZE = 1;

  private static final int YSIZE = 1;

  private double x = 0;

  private double y = 0;

  private double dx = 5;

  private double dy = 1;
}
  
    /*public void kitty (Graphics2D g2d) {
      
        BasicStroke bs = new BasicStroke(5.0f);
        g2d.setStroke(bs); 
        
        AffineTransform a = new AffineTransform();
        a.setToScale(-0.37, 0.37);
        
        AffineTransform trans = new AffineTransform();
        trans.setToTranslation(470, 280);
        
        GeneralPath flower = new GeneralPath(); 
        g2d.setPaint(Color.BLACK);
            flower.moveTo(335, 118);
            flower.curveTo(297, 18, 400, 20, 390, 110);
            flower.curveTo(460, 20, 530, 100, 435, 150);
            flower.curveTo(540, 195, 448, 286, 396, 190);
            flower.curveTo(390, 290, 287, 260, 340, 175);
            flower.curveTo(260, 190, 225, 105, 335, 118);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(flower)));
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(flower)));
         
        g2d.setPaint(Color.BLACK);
            flower.moveTo(335, 118);
            flower.curveTo(297, 18, 400, 20, 390, 110);
            flower.curveTo(460, 20, 530, 100, 435, 150);
            flower.curveTo(540, 195, 448, 286, 396, 190);
            flower.curveTo(390, 290, 287, 260, 340, 175);
            flower.curveTo(260, 190, 225, 105, 335, 118);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(flower)));
            
         
            GeneralPath innerbody = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            innerbody.moveTo(284, 437);
            innerbody.curveTo(271, 514, 424, 515, 408, 440);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(innerbody)));
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(innerbody)));
        GeneralPath face = new GeneralPath();
            face.moveTo(170, 180);
            face.curveTo(-20, 500, 665, 539, 536, 223);
            g2d.setPaint(Color.BLACK);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(face)));
        
        GeneralPath ears = new GeneralPath();
            ears.moveTo(152, 215);
            ears.quadTo(100, 20, 215, 110);
            ears.quadTo(270, 90, 325, 102);
            ears.moveTo(484, 102);
            ears.quadTo(620, 27, 535, 223);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(ears)));
         
         GeneralPath rarm = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            rarm.moveTo(445,429);
            rarm.quadTo(450, 465, 480, 504);
            rarm.lineTo(517, 460);
            rarm.lineTo(448,429);
            
            
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(rarm)));
            
            g2d.setPaint(Color.black);
            rarm.moveTo(517, 460);
            rarm.quadTo(527, 464, 529, 464);
            rarm.quadTo(565, 453, 552, 485);
            rarm.curveTo(627, 524, 512, 568, 481, 503);
            rarm.lineTo(517, 460);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(rarm)));    
            
            
        GeneralPath body = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            body.moveTo(250, 428);
            body.quadTo(130, 598, 167, 634);
            body.quadTo(356, 691, 507, 636);
            body.quadTo(536, 597, 444, 434);
            body.quadTo(425, 435, 407, 440);
            body.curveTo(428,504, 277, 529, 284, 434);
            body.quadTo(267, 431, 250, 428);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(body)));
            g2d.setPaint(Color.decode("#ff99bb"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(body)));
       
            g2d.setPaint(Color.BLACK);
            body.moveTo(250, 428);
            body.quadTo(130, 598, 167, 634);
            body.quadTo(356, 691, 507, 636);
            body.quadTo(536, 597, 444, 434);
            body.quadTo(425, 435, 407, 440);
            body.curveTo(428,504, 277, 529, 284, 434);
            body.quadTo(267, 431, 250, 428);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(body)));
            
        
        GeneralPath larm = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            larm.moveTo(251, 425);
            larm.quadTo(211,433,173,449);
            larm.lineTo(200,504);
            larm.quadTo(234,449,251,425);
            g2d.setPaint(Color.decode("#FF1493"));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(larm)));
            
            g2d.setPaint(Color.black);
            larm.moveTo(173,449);
            larm.quadTo(165,450,158,456);
            larm.quadTo(119, 450, 136, 479);
            
            larm.curveTo(80, 523, 164, 555, 202, 499);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(larm)));
        
            
           
        GeneralPath feet = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            feet.moveTo(162, 632);
            feet.curveTo(160, 744, 362, 764, 338, 663);
            feet.moveTo(340, 667);
            feet.curveTo(330, 745, 500, 764, 510, 632);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(feet)));
            
        GeneralPath whiskers = new GeneralPath();
        g2d.setPaint(Color.BLACK);
            whiskers.moveTo(186, 278);
            whiskers.lineTo(106, 250);
            whiskers.moveTo(182, 307);
            whiskers.lineTo(106, 307);
            whiskers.moveTo(186, 337);
            whiskers.lineTo(106, 357);
            whiskers.moveTo(506, 278);
            whiskers.lineTo(586, 250);
            whiskers.moveTo(506, 307);
            whiskers.lineTo(582, 307);
            whiskers.moveTo(506, 337);
            whiskers.lineTo(586, 357);
            
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(whiskers)));
            
            
        
        g2d.setPaint(Color.BLACK);
            Ellipse2D.Double cir1 = new Ellipse2D.Double(356, 128, 49, 42);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(cir1)));
            g2d.setPaint(Color.yellow);
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(cir1)));
            
        g2d.setPaint(Color.BLACK);
            Ellipse2D.Double cir2 = new Ellipse2D.Double(356, 128, 49, 42);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(cir2)));
       
        g2d.setPaint(Color.BLACK);    
            Ellipse2D.Double elli1 = new Ellipse2D.Double(237, 294, 29, 39);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli1)));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli1)));
            Ellipse2D.Double elli2 = new Ellipse2D.Double(425, 294, 29, 39);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli2)));
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli2)));
            
            Ellipse2D.Double elli3 = new Ellipse2D.Double(327, 344, 50, 33);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli3)));
            g2d.setPaint(Color.yellow);
            g2d.fill(trans.createTransformedShape(a.createTransformedShape(elli3)));
            
        g2d.setPaint(Color.BLACK);  
            Ellipse2D.Double elli4 = new Ellipse2D.Double(327, 344, 50, 33);
            g2d.draw(trans.createTransformedShape(a.createTransformedShape(elli4)));
            
        
  
    }
  private static final int XSIZE = 15;

  private static final int YSIZE = 15;

  private double x = 0;

  private double y = 0;

  private double dx = 1;

  private double dy = 1;*/

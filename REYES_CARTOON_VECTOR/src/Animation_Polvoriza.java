
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christianreyes
 */
public class Animation_Polvoriza extends JPanel {
     
      int counter = 0;
    int liveTime = 0;
    int posX=21;
    int posY=0;
    int frame=0;
    boolean direction=true;
    boolean frame2=true;
    boolean enabled=false;
    //public Graphics g1;
    String fileName="/img/a.gif";
    public Animation_Polvoriza() throws IOException {
    
        Timer count;
        count = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (counter == 20) {
                    counter = 0;
                    liveTime++;
                    frame++;
                    System.out.println("live:" + liveTime);
                    repaint();
                }
                counter++;
                if (frame>16)
                    frame=0;
            }

            

        });
        count.start();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath gp1 = new GeneralPath();
         Ellipse2D.Double arm1 = new Ellipse2D.Double(269.8, 285.2, 93.3, 133);
     Ellipse2D.Double arm1a = new Ellipse2D.Double(283,295.6,70.1, 111.4);
     Ellipse2D.Double leftEye = new Ellipse2D.Double(194, 159, 48, 48);
     Ellipse2D.Double rightEye = new Ellipse2D.Double(402,87.9, 49, 49);
        BasicStroke bs = new BasicStroke(4.0f);
        BasicStroke bs1 = new BasicStroke(7.0f);
        //left foot
        gp1.moveTo(47.2, 342.8);
        gp1.curveTo(-45, 96, 107.2, 22.5, 96, 245.2);
        gp1.lineTo(116, 229);
        gp1.lineTo(124, 240);
        g2d.setColor(Color.BLACK);
        g2d.fill(gp1);
        
        GeneralPath gp2 = new GeneralPath(); 
        //right foot
        gp2.moveTo(79, 132.5);
        gp2.curveTo(83.2, 50, 148.5, 77, 153.8, 130.2);
        gp2.lineTo(153.8, 130.2);
        gp2.curveTo(155.2, 139, 156.5, 151.8, 157.5, 165.9);
        gp2.curveTo(159, 171.5, 149.5, 182.8, 145, 184);
        gp2.curveTo(146.8, 183.2, 145.2, 145, 141.2, 134.5);
        gp2.curveTo(116.5, 125.8, 97.5, 136.8, 89, 152);
        gp2.lineTo(79, 132.5);
        g2d.setColor(Color.BLACK);
        g2d.fill(gp2);
        
        GeneralPath gp3 = new GeneralPath();
        gp3.moveTo(93.5, 200.8);
        gp3.curveTo(145.5, 201.5, 142.8, 182.8, 157.8, 164.5);
        gp3.curveTo(203.8, 23, 395, -21, 498, 45);
        gp3.curveTo(550, 88, 563, 75, 593, 47);
        gp3.curveTo(621, 203, 540, 324, 362.5, 351.5);
        gp3.lineTo(356.2, 337.5);
        gp3.curveTo(514.5, 318.2, 625.5, 173.5, 505, 69);
        gp3.lineTo(485.4, 69.2);
        gp3.curveTo(569, 136, 488.6, 248.6, 399.4, 204.0);
        gp3.curveTo(385.8, 176, 376.8, 125.5, 384.8, 74.8);
        gp3.lineTo(364.2, 80);
        gp3.curveTo(360, 72.5, 332.2, 53, 326.5, 52);
        gp3.lineTo(335.2, 86);
        gp3.curveTo(309, 91.8, 244, 119, 240.8, 122.8);
        gp3.lineTo(283.5, 125);
    
        gp3.curveTo(363.8, 210.5, 253.8, 313.8, 171.5,  244.5);
        gp3.curveTo(205.5, 316.5, 252,315, 273, 329.5);
        gp3.lineTo(270, 348);
        gp3.lineTo(45, 341.5);
        gp3.lineTo(47, 334.5);
        gp3.lineTo(240.8, 336);
        gp3.curveTo(145.2, 299, 104.2, 218.2, 93.5, 200.8);
        gp3.moveTo(535, 264.5);
        gp3.curveTo(634.5, 258,524, 427, 393.5, 346.0);
        gp3.lineTo(535.5, 265);
        gp3.moveTo(120.5, 240.5);
        gp3.curveTo(66.8, 281.2, 65.8, 322.5, 48.8, 342.5);
       
        gp3.moveTo(386.5, 300.5);
        gp3.curveTo(397, 286.5, 410.5, 251, 431, 277);
        
        g2d.setColor(Color.BLACK);
        g2d.fill(gp3);
       
        
        GeneralPath gpd = new GeneralPath();
        gpd.moveTo(144.4, 269.6);
        gpd.curveTo(124.4, 285.3, 111.3, 323.3, 106.2, 331.7);
        gpd.lineTo(185.8, 332.9);
        gpd.curveTo(187.1, 322.4, 188.9, 318.2, 192.2, 311.1);
   
        g2d.setColor(Color.BLACK);
        g2d.fill(gpd);
        
        
        GeneralPath gp4 = new GeneralPath();
        
        gp4.moveTo(324.8, 51);
        gp4.lineTo(331.2, 85.5);
        gp4.lineTo(240.2, 119);
        gp4.lineTo(352.8, 129.5);
        gp4.lineTo(352.5, 116);
        gp4.lineTo(362.2, 136.5);
        gp4.lineTo(344.5, 134.8);
        gp4.curveTo(380.2, 210.8, 358.2, 248.8, 349.5, 271.5);
        gp4.lineTo(362, 274.5);
        gp4.curveTo(328, 270.5, 252.5, 279.8, 218, 300.5);
        gp4.curveTo(231.8, 312, 257,324.2, 270.8, 328);
        gp4.curveTo(293.5, 267.8, 354.2, 275.8, 363, 334.5);
        gp4.curveTo(446.8, 327.6, 506.9, 272.6, 522.8, 247.9);
        gp4.curveTo(425.5, 296.5, 376.5, 229.0, 379.2, 75.2);
        gp4.lineTo(361.5, 78.2);
        gp4.curveTo(354.2, 68.5, 336.0, 55.8, 324.8, 51);
        
        gp4.moveTo(518.5, 281.5);
        gp4.curveTo(623.5, 254, 509, 402.5, 411, 340.5);
        gp4.curveTo(434.5, 338.5, 498.5, 305, 518.5, 281.5);
      
        
        g.setColor(new Color(255,223,191));
        g2d.fill(gp4);
        
        GeneralPath gp5 = new GeneralPath();
        //green
        gp5.moveTo(120.2, 242);
        gp5.curveTo(91.2, 262, 77.5, 281.8, 57.3, 330.7);
        gp5.lineTo(107.1, 330.7);
        gp5.curveTo(109.3, 326.4, 127.5, 285.3, 144.5, 270.4);
        gp5.lineTo(120.2, 242);
        
        gp5.moveTo(190.7, 309.5);
        gp5.curveTo(191.3, 310, 219.8, 327.3, 238.9, 333.7);
        gp5.lineTo(185.6, 332.5);
        gp5.curveTo(186.9, 323.3, 186.7, 320.7, 190.7, 309.5);
        
        gp5.moveTo(334.2, 133.0);
        gp5.lineTo(285.5, 128.8);
        gp5.curveTo(355.8, 206.5, 252.5, 312.8,170.8, 241 );
        gp5.curveTo(192, 294.2, 217.6, 285.1, 232, 288.2);
        gp5.curveTo(244.9, 283.5, 256.9, 277.5, 299.1, 273.1);
        gp5.curveTo(351.9, 239.5, 357.5, 172.4, 334.2, 133);
        
        gp5.moveTo(486, 69);
        gp5.curveTo(572.5, 144, 482, 246, 398.5, 203.5);
        gp5.lineTo(414.5, 235.5);
        gp5.curveTo(500, 258.2, 539.2, 209.2, 553.5, 188.8);
        gp5.curveTo(564, 130.5, 536, 93.8, 506.5, 69.5);
        gp5.lineTo(486, 69);
        g.setColor(new Color(48, 191, 48));
        g2d.fill(gp5);
        
        GeneralPath gp6 = new GeneralPath();
        gp6.moveTo(242.5, 123);
        gp6.lineTo(358.0, 134.5);
        gp6.lineTo(358, 134);
       
        gp6.moveTo(385, 75);
        gp6.curveTo(375.5, 109.5, 379.5, 333.5, 532, 244);
        gp6.moveTo(342, 134);
        gp6.curveTo(374.5, 180.5, 365.5, 255.5, 348, 270);
        gp6.moveTo(217.5, 301.5);
        gp6.curveTo(235.5, 285.5, 277.5, 272, 361, 275.4);
        gp6.moveTo(48, 332);
        gp6.lineTo(274, 337);
        g2d.setStroke(bs1);
        g.setColor(Color.BLACK);
        g2d.draw(gp6);
        
        GeneralPath gp7= new GeneralPath();
        gp7.moveTo(387.4, 299.8);
        gp7.curveTo(398, 286.1, 414.1, 257.9, 429.1, 274.6);
        gp7.moveTo(359.5, 135.2);
        gp7.lineTo(354.1, 120.8);
        g2d.setStroke(bs);
        
        GeneralPath gp8 = new GeneralPath();
        gp8.moveTo(30, 186);
        gp8.curveTo(27.5, 195.5, 37, 272.5, 52.1, 318);
        gp8.curveTo(57, 304.5, 74.5, 267, 88, 257);
        gp8.curveTo(88.5, 237, 85.5, 179, 78.5, 168.5);
        gp8.curveTo(65.5, 165, 42.5, 175, 30, 186);
        g.setColor(Color.WHITE);
        g2d.fill(gp8);
         g.setColor(Color.BLACK);
        g2d.draw(gp7);
        
        g2d.setColor(Color.BLACK);
        g2d.fill(arm1);
        g2d.setColor(Color.WHITE);
        g2d.fill(rightEye);
        g2d.fill(leftEye);
        g.setColor(new Color(255,223,191));
        g2d.fill(arm1a);
        g2dRedraw redraw = new g2dRedraw();
        redraw.redraw(g,frame);
    }
    
    
    
    public static void main(String a[]) throws IOException
    {
        Frame f = new Frame();
        Animation_Polvoriza pst = new Animation_Polvoriza();
        f.setTitle("A");
        pst.setBackground(Color.gray);
        f.setSize(500, 218);
        pst.setForeground(Color.black);
        f.add(pst);
        f.setVisible(true);
        URL url = Animation_Polvoriza.class.getResource("img/a.gif");
ImageIcon imageIcon = new ImageIcon(url);
JLabel label = new JLabel(imageIcon);
f.add(label);
    }

}
    


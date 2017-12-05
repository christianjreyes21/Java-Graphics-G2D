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

public class Reyes1_Practice extends Frame {

    public Graphics2D g2d;

    public void paint(Graphics g) {

        g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(2.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);

/*
      
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
        */

/*
Tree starts at (400,300)
H=400, W=400
levels=4
horizontal offset = 40

base starts at the bottom center of the tree
H=100
W=80

star above the tree
h,w=80

string christmas tree
30 above star

balls
3 balls first level
5 balls 2nd-4th level
*/


        GeneralPath treeStar = new GeneralPath();
        treeStar.moveTo(400,300);
        treeStar.lineTo(360,260);
        treeStar.lineTo(400, 220);
        treeStar.lineTo(440,260);
        treeStar.lineTo(400, 300);
        g2d.setColor(Color.YELLOW);
        g2d.fill(treeStar);
        
        GeneralPath treeMain = new GeneralPath();
        treeMain.moveTo(400, 300);
        treeMain.lineTo(450,400);
        treeMain.lineTo(410,400);
        treeMain.lineTo(500,500);
        treeMain.lineTo(460,500);
        treeMain.lineTo(550,600);
        treeMain.lineTo(510,600);
        treeMain.lineTo(600,700);
        treeMain.lineTo(200,700);
        treeMain.lineTo(290,600);
        treeMain.lineTo(250,600);
        treeMain.lineTo(340,500);
        treeMain.lineTo(300,500);
        treeMain.lineTo(390,400);
        treeMain.lineTo(350,400);
        treeMain.lineTo(400,300);
        g2d.setColor(Color.green);
        g2d.fill(treeMain);
        
        GeneralPath treeBase = new GeneralPath();
        treeBase.moveTo(360, 700);
        treeBase.lineTo(440, 700);
        treeBase.lineTo(440, 800);
        treeBase.lineTo(360, 800);
        treeBase.lineTo(360, 700);
        g2d.setColor(Color.gray);
        g2d.fill(treeBase);
        
        
        

    }
    
    
    
    

    public static void main(String[] argv) {
        Reyes1_Practice s = new Reyes1_Practice();
        s.setTitle(""); //title of frame
        s.setBackground(Color.white); //bgcolor
        s.setSize(800, 800); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }
}

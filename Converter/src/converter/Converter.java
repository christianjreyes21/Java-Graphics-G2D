/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author christianreyes
 */
public class Converter extends JComponent implements MouseListener{

    /**
     * @param args the command line arguments
     */
    public Graphics2D g2d;
    public void paintComponent (Graphics g)
    {
        //this.add(new JLabel(new ImageIcon("Users/christianreyes/Documents/GRAPHICS/jollibee.png")));
        g2d = (Graphics2D)g;
        BasicStroke bs = new BasicStroke (5.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.cyan);
        
    }
    public static void main(String[] args) {
        Converter s = new Converter();
//        s.setTitle("String in Java"); //title of frame
        s.setBackground(Color.gray); //bgcolor
        s.setSize(892,1440); //size of frame
        s.setForeground(Color.cyan); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());
        Line2D.Double line1 = new Line2D.Double (e.getX(), e.getY(), e.getX(), e.getY()); 
        g2d.draw(line1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setTitle(String string_in_Java) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

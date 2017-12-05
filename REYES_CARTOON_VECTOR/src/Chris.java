/*
  Santos, Chris Micael C.
  4CSA - CS 208
  Activity 8
*/

/**
 *
 * @author ChrisSantos
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Chris extends Frame implements ActionListener{
    public Graphics2D g2d;
    Calendar calendar = GregorianCalendar.getInstance();
    Date date = new Date();
    public JTextField inputHour, inputMinute;
    public JLabel lblTime, lblColon;
    public JButton btnSet;
    double hourValue = calendar.get(Calendar.HOUR);
    double minuteValue = calendar.get(Calendar.MINUTE);
    double secondsValue = calendar.get(Calendar.SECOND);
    
    Chris(){
        //addWindowListener((WindowListener) new Chris.MyFinishWindow());
        
        Panel pane = new Panel();
        Panel inputPane = new Panel();
       
        inputHour = new JTextField(""+(int)hourValue,2);
        inputMinute = new JTextField(""+(int)minuteValue,2);
        lblTime = new JLabel("Time: ");
        lblColon = new JLabel(" : ");
        btnSet = new JButton("Set Time");
        btnSet.addActionListener(this);
        inputPane.add(lblTime);
        inputPane.add(inputHour);
        inputPane.add(lblColon);
        inputPane.add(inputMinute);
        inputPane.add(btnSet);
        pane.add(inputPane, BorderLayout.SOUTH);
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        
        try{
        btnSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar = GregorianCalendar.getInstance();
                hourValue = Double.parseDouble(inputHour.getText());
                minuteValue = Double.parseDouble(inputMinute.getText());
                secondsValue = calendar.get(Calendar.SECOND);
                System.out.println(secondsValue);
                if(hourValue <= 12 && hourValue >= 1 && minuteValue <= 59 && minuteValue >= 0)
                repaint();
                else
                    JOptionPane.showMessageDialog(null, "INVALID INPUT!");
                
            }
         });
        }
        catch(Exception e){}
        
        Timer timer;
        timer = new Timer (1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                calendar = GregorianCalendar.getInstance();
                secondsValue = calendar.get(Calendar.SECOND);
                System.out.println(secondsValue);
                if(secondsValue==0)
                {
                    minuteValue++;
                    if(minuteValue==60)
                        hourValue++;
                }
                repaint();
            }

        });
        timer.start();
        
    }
    
    public void paint (Graphics g)
    {
        super.paint(g);
        g2d = (Graphics2D)g;
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        clockBody();
        clockLetters();
        hands();
    }
    
    public void hands(){
        
        BasicStroke bs =  new BasicStroke (7.0f);
        g2d.setStroke(bs);
        g2d.setPaint(Color.white);
        Line2D.Double line1 = new Line2D.Double (0,0,0,-120);
        g2d.draw(line1);
        g2d.setPaint(Color.white);
        Line2D.Double line2 = new Line2D.Double (0,0,0,-200);
        g2d.draw(line2);
        g2d.setPaint(new Color(19, 113, 206));
        Line2D.Double line3 = new Line2D.Double (0,0,0,-200);
        g2d.draw(line3);
        AffineTransform translate = new AffineTransform();
        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation((hourValue+(minuteValue/60))*(Math.PI/6));
        AffineTransform rotate2 = new AffineTransform();
        rotate2.setToRotation(minuteValue*(Math.PI/30));
        AffineTransform rotate3 = new AffineTransform();
        rotate3.setToRotation(secondsValue*(Math.PI/30));
        translate.setToTranslation(420, 430);
        g2d.draw(translate.createTransformedShape(rotate1.createTransformedShape(line1)));
        g2d.draw(translate.createTransformedShape(rotate2.createTransformedShape(line2)));
        bs =  new BasicStroke (3.0f);
        g2d.setStroke(bs);
        g2d.draw(translate.createTransformedShape(rotate2.createTransformedShape(line3)));
        g2d.setPaint(new Color(19, 113, 206));
        Ellipse2D.Double circle2 = new Ellipse2D.Double(400, 410, 40, 40);
        g2d.fill(circle2);
    }
    
    public void clockLetters(){
        
        g2d.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 30));
        g2d.setPaint(Color.white);
        g2d.drawString("CHRIS MICAEL SANTOS", 260, 640);
        g2d.setFont(new Font("MONOTYPE CORSIVA", Font.BOLD, 140));
        g2d.setPaint(Color.white);
        for(int i=1;i<=12;i++)
            g2d.drawString(Integer.toString(i),370-(i/12)*11+(int)(300*Math.sin(i*Math.PI/6)),485-(int)(300*Math.cos(i*Math.PI/6)));
        g2d.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 30));
        g2d.setPaint(new Color(52, 57, 60));
        g2d.drawString(""+(int)hourValue+" : "+(int)minuteValue+" : "+(int)secondsValue, 350, 750); 
    }
  
    public void clockBody(){
        
        BasicStroke bs =  new BasicStroke (4.0f);
        g2d.setStroke(bs);
        
        g2d.setPaint(new Color(19, 113, 206));
        Ellipse2D.Double r1 = new Ellipse2D.Double(15, 50, 800, 800);
        g2d.fill(r1);
        g2d.setPaint(new Color(52, 57, 60));
        g2d.draw(r1);
        
        
        g2d.setPaint(new Color(52, 57, 60));
        Ellipse2D.Double circle = new Ellipse2D.Double(50, 80, 730, 730);
        g2d.fill(circle);
        g2d.setPaint(Color.white);
        g2d.draw(circle);
        
    }

    public static void main (String[] argv)
    {
        Chris s = new Chris ();
        s.setTitle("Clock_Automatic_SantosC");
        s.setBackground(Color.WHITE);
        s.setSize(850, 1000);
        s.setForeground(Color.BLACK);
        s.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

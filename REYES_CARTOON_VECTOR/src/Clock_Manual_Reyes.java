/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Clock_Manual_Reyes extends Frame implements ActionListener{
    public Graphics2D g2d;
    Calendar calendar = GregorianCalendar.getInstance();
    Date date = new Date();
    public JTextField inputHour, inputMinute;
    public JLabel lblTime, lblColon;
    public JButton btnSet;
    
    double hourValue = calendar.get(Calendar.HOUR);
    double minuteValue = calendar.get(Calendar.MINUTE);
    double secondsValue = calendar.get(Calendar.SECOND);
    
    Clock_Manual_Reyes(){
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
        //this.setLayout(new BorderLayout());
        this.add(pane, BorderLayout.SOUTH);
        
       
        try{
        btnSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar = GregorianCalendar.getInstance();
                hourValue = Double.parseDouble(inputHour.getText());
                minuteValue = Double.parseDouble(inputMinute.getText());
                secondsValue = calendar.get(Calendar.SECOND);
                //System.out.println(secondsValue);
                if(hourValue <= 12 && hourValue >= 1 && minuteValue <= 59 && minuteValue >= 0)
                repaint();
                else
                    JOptionPane.showMessageDialog(null, "INVALID INPUT! PLEASE TRY AGAIN.");
                
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
                //hourValue = calendar.get(Calendar.HOUR);
                //minuteValue = calendar.get(Calendar.MINUTE);
                System.out.println(secondsValue);
                if(secondsValue==0)
                {
                    minuteValue++;
                    if(minuteValue==60){
                        minuteValue=0;
                        hourValue++;
                    }
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
        clockBody();
        clockLetters();
        hands();

    }
    
    public void hands(){
        BasicStroke bs = new BasicStroke (10.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.white);
        Line2D.Double hour = new Line2D.Double (0, 0, 0, -90);
        Line2D.Double minute = new Line2D.Double (0, 0, 0, -120);
        Line2D.Double seconds = new Line2D.Double (0, 0, 0, -120);
        AffineTransform translate = new AffineTransform();
        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation((hourValue+(minuteValue/60))*(Math.PI/6));
        AffineTransform rotate2 = new AffineTransform();
        rotate2.setToRotation(minuteValue*(Math.PI/30));
        AffineTransform rotate3 = new AffineTransform();
        rotate3.setToRotation(secondsValue*(Math.PI/30));
        translate.setToTranslation(407, 280);
        g2d.draw(translate.createTransformedShape(rotate1.createTransformedShape(hour)));
        g2d.draw(translate.createTransformedShape(rotate2.createTransformedShape(minute)));
        bs = new BasicStroke (5.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.red);
        g2d.draw(translate.createTransformedShape(rotate3.createTransformedShape(seconds)));
        Ellipse2D.Double pin = new Ellipse2D.Double(402,275,10,10);
        g2d.setColor(Color.red);
        g2d.fill(pin);
    }
    
    public void clockLetters(){
        BasicStroke bs = new BasicStroke (2.0f); //kung gano kakapal ang stroke
        g2d.setStroke(bs);
        g2d.setPaint(Color.white);
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.drawString("6*2", 380, 130); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("102,413", 470, 150);
        g2d.drawString("-102,412", 465, 165);
        Line2D.Double over = new Line2D.Double (470, 170, 528, 170); 
        g2d.draw(over);
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.drawString("4", 535, 230); 
        Line2D.Double sqrt1 = new Line2D.Double (520, 220, 525, 230); 
        g2d.draw(sqrt1);
        Line2D.Double sqrt2 = new Line2D.Double (525, 230, 530, 200);
        g2d.draw(sqrt2);
        Line2D.Double sqrt3 = new Line2D.Double (530, 200, 560, 200); 
        g2d.draw(sqrt3);
        
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("198/66", 520, 290); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("50   100", 515, 340); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString(" 2      X", 515, 360); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("---- = ----", 510, 348); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString(" ---- = ----", 510, 348); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("630/126", 470, 410); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("1   96",380 , 440); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("8    2", 380, 470); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("---   ---", 370, 453); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("---   ---", 375, 453); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("*", 403, 460); 
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("52-x +x=10", 280, 410); 
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.drawString("64", 250, 360); 
        Line2D.Double sqrt4 = new Line2D.Double (235, 350, 240, 360); 
        g2d.draw(sqrt4);
        Line2D.Double sqrt5 = new Line2D.Double (240, 360, 245, 330);
        g2d.draw(sqrt5);
        Line2D.Double sqrt6 = new Line2D.Double (245, 330, 290, 330); 
        g2d.draw(sqrt6);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("3(π-0.14)", 220, 290); 
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("-8=2-x", 240, 220); 
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("1221/111", 270, 165); 
        g2d.setFont(new Font("Arial", Font.BOLD, 11));
        g2d.drawString("I LOVE", 370, 350); 
        g2d.setFont(new Font("Arial", Font.BOLD, 11));
        g2d.setPaint(Color.RED);
        g2d.drawString("CS208", 410, 350); 
        g2d.setFont(new Font("Arial", Font.BOLD, 8));
        g2d.setPaint(Color.WHITE);
        g2d.drawString("CHRISTIAN JOSEPH REYES", 352, 360); 
        
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.setPaint(Color.gray);
        //g2d.drawString(""+(int)hourValue+" : "+(int)minuteValue+" : "+(int)secondsValue, 350, 550); 
    }
  
    public void clockBody(){
        Ellipse2D.Double body = new Ellipse2D.Double(207,80,400,400);
        g2d.setColor(new Color(50,50,50));
        g2d.fill(body);
        
        Ellipse2D.Double pin = new Ellipse2D.Double(392,265,30,30);
        g2d.setColor(Color.white);
        g2d.fill(pin);
    }

    
    
    
    public static void main (String[] argv)
    {
        Clock_Manual_Reyes s = new Clock_Manual_Reyes ();
        s.setTitle("Clock Manual"); //title of frame
        s.setBackground(Color.white); //bgcolor
        s.setSize(800,600); //size of frame
        s.setForeground(Color.black); //fontcolor
        s.setVisible(true); //para makita yung frame or not
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}

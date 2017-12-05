
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class carracing_Reyes extends JPanel {

    double scale=1;
    public carracing_Reyes() {
        Timer count;
        
        count = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //counter++;
                if (counter == 2) {
                    counter = 0;
                    liveTime++;
                    //System.out.println("live:" + liveTime);
                    repaint();
                }
                if (state == 1) {
                    pathTo(bufX, bufY, 259,552, liveTime);
                    scale=1;
                } else if (state == 2) {
                    pathTo(259,552, 486,546, liveTime);
                    scale=1;
                } else if (state == 3) {
                    pathTo(486,546, 540,342, liveTime);
                    scale=1;
                } else if (state == 4) {
                    pathTo(540,342, 215,99, liveTime);
                } else if (state == 5) {
                    pathTo(215,99, 660,95, liveTime);
                } else if (state == 6) {
                    pathTo(660,95, 665,643, liveTime);
                } else if (state == 7) {
                    pathTo(665,643, 713,647, liveTime);
                } else if (state == 8) {
                    pathTo(713,647, 1030,67, liveTime);
                }
                

                if (!distGreater) {
                    //System.out.println("traint" + liveTime);
                } else {
                    //System.out.println("state: " + liveTime);
                    state++;
                    liveTime = 0;
                }
                counter++;
                //repaint();

            }
        });
        count.start();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(10.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        g2d.drawString("Start Here", 60, 650);
        g2d.drawString("Finish Line", 1060, 80);

        GeneralPath a = new GeneralPath();
        a.moveTo(50, 600);
        a.lineTo(250, 500);
        a.lineTo(450, 500);
        a.lineTo(480, 350);
        a.lineTo(50, 50);
        a.lineTo(700, 50);
        a.lineTo(710, 600);
        a.lineTo(1000, 60);
        g2d.setPaint(Color.black);
        g2d.draw(a);

        GeneralPath b = new GeneralPath();
        b.moveTo(70, 700);
        b.lineTo(270, 600);
        b.lineTo(520, 600);
        b.lineTo(600, 330);
        b.lineTo(350, 150);
        b.lineTo(620, 150);
        b.lineTo(620, 680);
        b.lineTo(720, 680);
        b.lineTo(1050, 80);
        g2d.setPaint(Color.black);
        g2d.draw(b);
        angle(0, 0, 30, 30);

        train(g2d, 0.08, 0.08, resultX, resultY, 1, 1, angleZ);
        //repaint();
        //train(g2d, 0.08, 0.08, 50, 650, 1, 1, 0); //right //510, 220

    }
    int state = 1;
    int bufX = 50;
    int bufY = 650;

    int counter = 0;
    int liveTime = 0;
    int angleZ = 0;

    int resultX = 0;
    int resultY = 0;
    boolean distGreater = false;

    void pathTo(int x1, int y1, int x2, int y2, int dist) {
        double initDist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        //System.out.println(initDist);
        double xDist = dist * Math.cos(Math.toRadians(angle(x1, y1, x2, y2)));
        double yDist = dist * Math.sin(Math.toRadians(angle(x1, y1, x2, y2)));
        angleZ = (int) angle(x1, y1, x2, y2);
        //initDist += dist;
        resultX = (int) (x1 + xDist);
        resultY = (int) (y1 + yDist);
        //System.out.println(x2+" "+y2);
        //System.out.println("X "+resultX+" Y"+resultY+" T "+angleZ);
        if (dist < initDist) {
            distGreater = false;
        } else {
            distGreater = true;
        }
    }

    public double angle(int x1, int y1, int x2, int y2) {
        double angle = 0;
        angle = Math.atan2((y2 - y1) , (x2 - x1));
        angle = Math.toDegrees(angle);
        ////System.out.println("Angle: " + angle);
        return angle;
    }

    public static void main(String[] argv) {
        carracing_Reyes s = new carracing_Reyes();
        //s.setBackground(Color.MAGENTA);
        Frame f = new Frame();
        f.setTitle("carracing_Reyes");
        f.add(s);
        f.setSize(1300, 750);
        //s.setForeground(Color.blue);
        f.setVisible(true);
    }

    AffineTransform a = new AffineTransform();
    AffineTransform trans = new AffineTransform();
    AffineTransform rot = new AffineTransform();
    AffineTransform recenter = new AffineTransform();

    public void train(Graphics2D g2d, double scx, double scy, int tx, int ty, int sx, int sy, double angle) {
        //super.paintComponent();
        a.setToScale(scx, scy);
        trans.setToTranslation(tx, ty);
        trans.scale(sx, sy);
        recenter.setToTranslation(-700, -200);
        rot.setToRotation(Math.toRadians(angle));

        
        
        //carSpoiler(g2d, trans, rot, a, recenter);
        carBody(g2d, trans, rot, a, recenter);
        carWindow(g2d, trans, rot, a, recenter);
        carHeadlight(g2d, trans, rot, a, recenter);
        carTire(g2d, trans, rot, a, recenter);
        
        Ellipse2D.Double anchorPoint = new Ellipse2D.Double(-100, -100, 200, 200);
                //g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(anchorPoint))));

        //g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(redbox2))));
        //g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape())));
    }

    public void carTire(Graphics2D g2d, AffineTransform trans, AffineTransform rot, AffineTransform a, AffineTransform recenter) {
        Ellipse2D.Double carRearTire = new Ellipse2D.Double(207, 139, 147, 147);
        g2d.setColor(new Color(70, 70, 69));
        
        

//g2d.fill(carRearTire);//REAR TIRE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carRearTire)))));

        Ellipse2D.Double carFrontTire = new Ellipse2D.Double(767, 139, 147, 147);
//g2d.fill(carFrontTire);//FRONT TIRE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carFrontTire)))));

        Ellipse2D.Double carRearTireMug = new Ellipse2D.Double(215, 147, 131, 131);
        g2d.setColor(new Color(230, 229, 231));
//g2d.fill(carRearTireMug);//REAR TIRE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carRearTireMug)))));

        Ellipse2D.Double carFrontTireMug = new Ellipse2D.Double(775, 147, 131, 131);
//g2d.fill(carFrontTireMug);//FRONT TIRE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carFrontTireMug)))));

        Ellipse2D.Double carRearTireMugHole = new Ellipse2D.Double(226, 158, 108, 108);
        g2d.setColor(new Color(70, 70, 69));
//g2d.fill(carRearTireMugHole);//REAR TIRE

        Ellipse2D.Double carFrontTireMugHole = new Ellipse2D.Double(787, 158, 108, 108);
//g2d.fill(carFrontTireMugHole);//FRONT TIRE

//g2d.setColor(new Color(230,229,231));
        BasicStroke bs = new BasicStroke(1.0f); //kung gano kakapal ang stroke
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(bs);

        GeneralPath mugHole1 = new GeneralPath();
        mugHole1.moveTo(251, 149);
        mugHole1.lineTo(272, 184);
        mugHole1.lineTo(266, 144);
        Area mugArea1 = new Area(mugHole1);

        GeneralPath mugHole2 = new GeneralPath();
        mugHole2.moveTo(274, 143);
        mugHole2.lineTo(282, 197);
        mugHole2.lineTo(319, 156);
        Area mugArea2 = new Area(mugHole2);

        GeneralPath mugHole3 = new GeneralPath();
        mugHole3.moveTo(327, 161);
        mugHole3.lineTo(298, 193);
        mugHole3.lineTo(336, 173);
        Area mugArea3 = new Area(mugHole3);

        GeneralPath mugHole4 = new GeneralPath();
        mugHole4.moveTo(340, 182);
        mugHole4.lineTo(289, 207);
        mugHole4.lineTo(340, 229);
        Area mugArea4 = new Area(mugHole4);

        GeneralPath mugHole5 = new GeneralPath();
        mugHole5.moveTo(338, 238);
        mugHole5.lineTo(301, 221);
        mugHole5.lineTo(330, 250);
        Area mugArea5 = new Area(mugHole5);

        GeneralPath mugHole6 = new GeneralPath();
        mugHole6.moveTo(322, 256);
        mugHole6.lineTo(284, 218);
        mugHole6.lineTo(279, 272);
        Area mugArea6 = new Area(mugHole6);

        GeneralPath mugHole7 = new GeneralPath();
        mugHole7.moveTo(270, 272);
        mugHole7.lineTo(273, 232);
        mugHole7.lineTo(256, 268);
        Area mugArea7 = new Area(mugHole7);

        GeneralPath mugHole8 = new GeneralPath();
        mugHole8.moveTo(246, 263);
        mugHole8.lineTo(272, 215);
        mugHole8.lineTo(218, 227);
        Area mugArea8 = new Area(mugHole8);

        GeneralPath mugHole9 = new GeneralPath();
        mugHole9.moveTo(214, 218);
        mugHole9.lineTo(256, 210);
        mugHole9.lineTo(214, 203);
        Area mugArea9 = new Area(mugHole9);

        GeneralPath mugHole10 = new GeneralPath();
        mugHole10.moveTo(217, 194);
        mugHole10.lineTo(272, 202);
        mugHole10.lineTo(242, 155
        );
        Area mugArea10 = new Area(mugHole10);

        Area mugLinesRear = new Area(carRearTireMugHole);
        mugArea1.add(mugArea2);
        mugArea1.add(mugArea3);
        mugArea1.add(mugArea4);
        mugArea1.add(mugArea5);
        mugArea1.add(mugArea6);
        mugArea1.add(mugArea7);
        mugArea1.add(mugArea8);
        mugArea1.add(mugArea9);
        mugArea1.add(mugArea10);
        mugLinesRear.intersect(mugArea1);
//mugLinesRear.subtract(mugArea2);

//g2d.fill(mugLinesRear);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(mugLinesRear)))));

        GeneralPath mugHole11 = new GeneralPath();
        mugHole11.moveTo(833, 147);
        mugHole11.lineTo(842, 200);
        mugHole11.lineTo(878, 159);
        Area mugArea11 = new Area(mugHole11);

        GeneralPath mugHole12 = new GeneralPath();
        mugHole12.moveTo(886, 165);
        mugHole12.lineTo(857, 196);
        mugHole12.lineTo(895, 176);
        Area mugArea12 = new Area(mugHole12);

        GeneralPath mugHole13 = new GeneralPath();
        mugHole13.moveTo(898, 185);
        mugHole13.lineTo(848, 211);
        mugHole13.lineTo(898, 232);
        Area mugArea13 = new Area(mugHole13);

        GeneralPath mugHole14 = new GeneralPath();
        mugHole14.moveTo(896, 241);
        mugHole14.lineTo(860, 225);
        mugHole14.lineTo(889, 253);
        Area mugArea14 = new Area(mugHole14);

        GeneralPath mugHole15 = new GeneralPath();
        mugHole15.moveTo(882, 260);
        mugHole15.lineTo(843, 221);
        mugHole15.lineTo(838, 275);
        Area mugArea15 = new Area(mugHole15);

        GeneralPath mugHole16 = new GeneralPath();
        mugHole16.moveTo(830, 276);
        mugHole16.lineTo(832, 235);
        mugHole16.lineTo(815, 272);
        Area mugArea16 = new Area(mugHole16);

        GeneralPath mugHole17 = new GeneralPath();
        mugHole17.moveTo(806, 266);
        mugHole17.lineTo(831, 218);
        mugHole17.lineTo(778, 230);
        Area mugArea17 = new Area(mugHole17);

        GeneralPath mugHole18 = new GeneralPath();
        mugHole18.moveTo(774, 221);
        mugHole18.lineTo(815, 212);
        mugHole18.lineTo(773, 205);
        Area mugArea18 = new Area(mugHole18);

        GeneralPath mugHole19 = new GeneralPath();
        mugHole19.moveTo(776, 197);
        mugHole19.lineTo(831, 205);
        mugHole19.lineTo(802, 158);
        Area mugArea19 = new Area(mugHole19);

        GeneralPath mugHole20 = new GeneralPath();
        mugHole20.moveTo(810, 152);
        mugHole20.lineTo(831, 187);
        mugHole20.lineTo(825, 147);
        Area mugArea20 = new Area(mugHole20);

        Area mugLinesFront = new Area(carFrontTireMugHole);
        mugArea11.add(mugArea12);
        mugArea11.add(mugArea13);
        mugArea11.add(mugArea14);
        mugArea11.add(mugArea15);
        mugArea11.add(mugArea16);
        mugArea11.add(mugArea17);
        mugArea11.add(mugArea18);
        mugArea11.add(mugArea19);
        mugArea11.add(mugArea20);
//g2d.draw(mugArea11);
        mugLinesFront.intersect(mugArea11);
//mugLinesRear.subtract(mugArea2);

//g2d.fill(mugLinesFront);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(mugLinesFront)))));

    }

    public void carHeadlight(Graphics2D g2d, AffineTransform trans, AffineTransform rot, AffineTransform a, AffineTransform recenter) {
        GeneralPath carHeadlight = new GeneralPath();
        carHeadlight.moveTo(945, 150);
        carHeadlight.curveTo(962, 159, 978, 172, 996, 188);
        carHeadlight.curveTo(992, 190, 980, 191, 970, 190);
        carHeadlight.curveTo(962, 189, 952, 187, 942, 182);
        carHeadlight.curveTo(935, 178, 930, 173, 929, 170);
        carHeadlight.curveTo(929, 165, 930, 162, 932, 159);
        carHeadlight.curveTo(936, 156, 940, 153, 943, 152);
        g2d.setColor(new Color(251, 255, 249));
//g2d.fill(carHeadlight);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carHeadlight)))));
        g2d.setPaint(new Color(251, 255, 249));
//g2d.draw(carHeadlight);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carHeadlight)))));

    }

    public void carWindow(Graphics2D g2d, AffineTransform trans, AffineTransform rot, AffineTransform a, AffineTransform recenter) {
        GeneralPath carBodyWindowTint = new GeneralPath();
        carBodyWindowTint.moveTo(406, 113);
        carBodyWindowTint.curveTo(595, 113, 595, 113, 595, 113);
        carBodyWindowTint.curveTo(595, 113, 595, 113, 595, 113);
        carBodyWindowTint.curveTo(595, 113, 595, 113, 564, 56);
        carBodyWindowTint.curveTo(564, 56, 564, 56, 564, 56);
        carBodyWindowTint.curveTo(564, 56, 564, 56, 564, 56);
        carBodyWindowTint.curveTo(564, 56, 560, 55, 551, 53);
        carBodyWindowTint.curveTo(545, 53, 536, 53, 526, 52);
        carBodyWindowTint.curveTo(517, 52, 509, 52, 502, 53);
        carBodyWindowTint.curveTo(495, 54, 488, 55, 479, 57);
        carBodyWindowTint.curveTo(472, 58, 465, 59, 459, 61);
        carBodyWindowTint.curveTo(452, 64, 444, 66, 437, 69);
        carBodyWindowTint.curveTo(431, 72, 425, 76, 417, 80);
        carBodyWindowTint.curveTo(412, 84, 407, 87, 404, 93);
        carBodyWindowTint.curveTo(403, 96, 403, 99, 403, 103);
        carBodyWindowTint.curveTo(405, 108, 406, 111, 406, 112);
        carBodyWindowTint.curveTo(406, 112, 406, 112, 406, 112);
        g2d.setColor(new Color(203, 255, 255));
//g2d.fill(carBodyWindowTint);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyWindowTint)))));
        g2d.setPaint(new Color(203, 255, 255));
//g2d.draw(carBodyWindowTint);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyWindowTint)))));

        GeneralPath carBodyWindowTintDark = new GeneralPath();
        carBodyWindowTintDark.moveTo(593, 113);
        carBodyWindowTintDark.curveTo(729, 112, 729, 112, 729, 112);
        carBodyWindowTintDark.curveTo(729, 112, 729, 112, 728, 112);
        carBodyWindowTintDark.curveTo(728, 112, 724, 110, 716, 106);
        carBodyWindowTintDark.curveTo(706, 102, 696, 97, 687, 93);
        carBodyWindowTintDark.curveTo(679, 90, 668, 85, 659, 81);
        carBodyWindowTintDark.curveTo(650, 78, 641, 75, 634, 72);
        carBodyWindowTintDark.curveTo(626, 70, 619, 67, 611, 65);
        carBodyWindowTintDark.curveTo(601, 62, 593, 60, 582, 58);
        carBodyWindowTintDark.curveTo(575, 57, 567, 55, 563, 55);
        carBodyWindowTintDark.curveTo(561, 55, 561, 55, 561, 55);
        g2d.setColor(new Color(167, 198, 234));
//g2d.fill(carBodyWindowTintDark);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyWindowTintDark)))));
        g2d.setPaint(new Color(167, 198, 234));
//g2d.draw(carBodyWindowTintDark);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyWindowTintDark)))));

        BasicStroke bs = new BasicStroke(1.0f); //kung gano kakapal ang stroke
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(bs);
        GeneralPath carBodyWindowHole = new GeneralPath();
        carBodyWindowHole.moveTo(403, 114);
        carBodyWindowHole.curveTo(399, 100, 399, 100, 399, 100);
        carBodyWindowHole.curveTo(404, 90, 413, 81, 422, 75);
        carBodyWindowHole.curveTo(434, 69, 445, 64, 454, 61);
        carBodyWindowHole.curveTo(466, 57, 479, 53, 496, 51);
        carBodyWindowHole.curveTo(512, 50, 528, 50, 544, 50);
        carBodyWindowHole.curveTo(558, 52, 575, 55, 592, 59);
        carBodyWindowHole.curveTo(610, 64, 628, 69, 646, 75);
        carBodyWindowHole.curveTo(664, 81, 687, 91, 703, 98);
        carBodyWindowHole.curveTo(718, 105, 734, 112, 734, 112);
        carBodyWindowHole.curveTo(734, 112, 734, 112, 734, 112);
        g2d.setColor(new Color(149, 96, 6));
//g2d.fill(carBodyWindowHole);
        g2d.setPaint(new Color(149, 96, 6));
//g2d.draw(carBodyWindowHole);

        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyWindowHole)))));

        GeneralPath carWindowDoor = new GeneralPath();
        carWindowDoor.moveTo(625, 70);
        carWindowDoor.curveTo(658, 113, 658, 113, 658, 113);
        carWindowDoor.curveTo(670, 113, 670, 113, 670, 113);
        carWindowDoor.curveTo(670, 113, 640, 75, 640, 75);
        carWindowDoor.curveTo(640, 75, 640, 75, 640, 75);
        g2d.setColor(new Color(154, 100, 11));
//g2d.fill(carWindowDoor);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carWindowDoor)))));
        g2d.setPaint(new Color(154, 100, 11));
//g2d.draw(carWindowDoor);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carWindowDoor)))));

        GeneralPath carBodyCurve = new GeneralPath();
        carBodyCurve.moveTo(403, 126);
        carBodyCurve.curveTo(419, 195, 419, 195, 419, 195);
        carBodyCurve.curveTo(419, 195, 421, 202, 425, 209);
        carBodyCurve.curveTo(430, 216, 435, 222, 442, 227);
        carBodyCurve.curveTo(448, 230, 454, 232, 459, 232);
        carBodyCurve.curveTo(459, 232, 459, 232, 459, 232);
        carBodyCurve.curveTo(459, 232, 697, 232, 697, 232);
        carBodyCurve.curveTo(697, 232, 697, 232, 697, 232);
        carBodyCurve.curveTo(697, 232, 697, 232, 697, 232);
        carBodyCurve.curveTo(738, 139, 738, 139, 738, 139);
        carBodyCurve.curveTo(738, 139, 738, 139, 738, 139);
        carBodyCurve.curveTo(738, 139, 738, 139, 738, 139);
        g2d.setPaint(new Color(196, 142, 18));
//g2d.draw(carBodyCurve);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyCurve)))));

        GeneralPath carBodyGasDoor = new GeneralPath();
        carBodyGasDoor.moveTo(172, 142);
        carBodyGasDoor.lineTo(201, 142);
        carBodyGasDoor.lineTo(201, 159);
        carBodyGasDoor.lineTo(172, 159);
        g2d.setColor(new Color(228, 152, 25));
//g2d.fill(carBodyGasDoor);

        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyGasDoor)))));
//g2d.setPaint(new Color(228,152,25));
//g2d.draw(carBodyGasDoor);

    }

    public void carBody(Graphics2D g2d, AffineTransform trans, AffineTransform rot, AffineTransform a, AffineTransform recenter) {

        BasicStroke bs = new BasicStroke(.5f); //kung gano kakapal ang stroke
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(bs);
        GeneralPath carBodyBase = new GeneralPath();
        carBodyBase.moveTo(141, 132);
        carBodyBase.curveTo(142, 130, 145, 127, 150, 124);
        carBodyBase.curveTo(157, 121, 164, 119, 173, 116);
        carBodyBase.curveTo(173, 116, 177, 114, 182, 112);
        carBodyBase.curveTo(190, 110, 200, 108, 207, 106);
        carBodyBase.curveTo(211, 105, 219, 104, 228, 104);
        carBodyBase.curveTo(237, 103, 248, 102, 259, 101);
        carBodyBase.curveTo(272, 100, 282, 100, 292, 100);
        carBodyBase.curveTo(298, 100, 303, 101, 306, 100);
        carBodyBase.curveTo(310, 99, 313, 97, 317, 96);
        carBodyBase.curveTo(321, 93, 329, 89, 337, 84);
        carBodyBase.curveTo(347, 79, 358, 74, 366, 71);
        carBodyBase.curveTo(376, 67, 388, 62, 403, 59);
        carBodyBase.curveTo(423, 53, 434, 50, 447, 47);
        carBodyBase.curveTo(462, 44, 478, 42, 494, 40);
        carBodyBase.curveTo(506, 39, 521, 38, 533, 39);
        carBodyBase.curveTo(547, 38, 561, 39, 574, 40);
        carBodyBase.curveTo(592, 43, 607, 46, 623, 49);
        carBodyBase.curveTo(635, 52, 651, 57, 665, 62);
        carBodyBase.curveTo(676, 67, 689, 72, 700, 78);
        carBodyBase.curveTo(713, 83, 725, 89, 734, 93);
        carBodyBase.curveTo(746, 98, 756, 101, 766, 104);
        carBodyBase.curveTo(774, 106, 783, 107, 791, 107);
        carBodyBase.curveTo(800, 107, 815, 108, 830, 109);
        carBodyBase.curveTo(844, 111, 856, 113, 869, 115);
        carBodyBase.curveTo(883, 118, 895, 122, 909, 126);
        carBodyBase.curveTo(920, 130, 928, 134, 938, 139);
        carBodyBase.curveTo(947, 144, 955, 148, 963, 153);
        carBodyBase.curveTo(975, 161, 984, 167, 989, 173);
        carBodyBase.curveTo(996, 179, 1002, 185, 1007, 192);
        carBodyBase.curveTo(1011, 198, 1015, 202, 1018, 205);
        carBodyBase.curveTo(1020, 207, 1020, 210, 1019, 214);
        carBodyBase.curveTo(1017, 218, 1012, 224, 1008, 228);
        carBodyBase.curveTo(1004, 232, 1002, 233, 1001, 234);
        carBodyBase.curveTo(1002, 238, 1003, 238, 1004, 238);
        carBodyBase.curveTo(1004, 241, 1008, 245, 1009, 248);
        carBodyBase.curveTo(1009, 252, 1009, 254, 1008, 256);
        carBodyBase.curveTo(1006, 257, 1000, 258, 995, 258);
        carBodyBase.curveTo(995, 258, 995, 258, 995, 258);
        carBodyBase.curveTo(995, 258, 995, 258, 995, 258);
        carBodyBase.curveTo(995, 258, 208, 256, 208, 256);
        carBodyBase.curveTo(208, 256, 208, 256, 208, 256);
        carBodyBase.curveTo(208, 256, 208, 256, 208, 256);
        carBodyBase.curveTo(208, 256, 202, 255, 196, 251);
        carBodyBase.curveTo(191, 247, 184, 242, 177, 237);
        carBodyBase.curveTo(170, 230, 165, 225, 160, 221);
        carBodyBase.curveTo(156, 216, 151, 209, 147, 205);
        carBodyBase.curveTo(141, 199, 140, 196, 140, 194);
        carBodyBase.curveTo(139, 189, 140, 180, 140, 176);
        carBodyBase.curveTo(140, 167, 140, 161, 140, 153);
        carBodyBase.curveTo(139, 146, 139, 140, 140, 134);
        carBodyBase.curveTo(141, 132, 141, 132, 141, 132);
        g2d.setColor(new Color(254, 182, 33));
//g2d.fill(carBodyBase);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyBase)))));
        g2d.setPaint(new Color(254, 182, 33));
//g2d.draw(carBodyBase);

        GeneralPath carBumper = new GeneralPath();
        carBumper.moveTo(970, 211);
        carBumper.curveTo(1019, 211, 1019, 211, 1019, 211);
        carBumper.curveTo(1019, 211, 1018, 216, 1016, 220);
        carBumper.curveTo(1014, 223, 1011, 226, 1007, 229);
        carBumper.curveTo(1005, 231, 1003, 233, 1001, 235);
        carBumper.curveTo(999, 236, 999, 236, 999, 236);
        carBumper.curveTo(999, 236, 1002, 238, 1006, 240);
        carBumper.curveTo(1007, 242, 1008, 245, 1008, 246);
        carBumper.curveTo(1008, 247, 1008, 247, 1008, 247);
        carBumper.curveTo(1008, 247, 1008, 247, 949, 248);
        carBumper.curveTo(949, 248, 949, 248, 949, 248);
        carBumper.curveTo(952, 245, 956, 242, 960, 237);
        carBumper.curveTo(962, 232, 965, 228, 966, 224);
        carBumper.curveTo(968, 220, 969, 215, 970, 211);
        carBumper.curveTo(970, 210, 970, 210, 970, 210);
        g2d.setColor(new Color(216, 161, 58));
//g2d.fill(carBumper);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBumper)))));
        g2d.setPaint(new Color(216, 161, 58));
//g2d.draw(carBumper);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBumper)))));

        GeneralPath carBodyHighlight = new GeneralPath();
        carBodyHighlight.moveTo(140, 149);
        carBodyHighlight.curveTo(145, 145, 153, 142, 160, 138);
        carBodyHighlight.curveTo(168, 136, 176, 133, 185, 130);
        carBodyHighlight.curveTo(196, 127, 204, 124, 214, 122);
        carBodyHighlight.curveTo(226, 120, 238, 118, 251, 116);
        carBodyHighlight.curveTo(263, 114, 277, 114, 291, 114);
        carBodyHighlight.curveTo(309, 114, 327, 115, 346, 117);
        carBodyHighlight.curveTo(362, 120, 374, 122, 388, 126);
        carBodyHighlight.curveTo(400, 129, 416, 130, 440, 134);
        carBodyHighlight.curveTo(466, 137, 493, 137, 525, 138);
        carBodyHighlight.curveTo(548, 139, 566, 139, 580, 139);
        carBodyHighlight.curveTo(593, 139, 606, 139, 618, 138);
        carBodyHighlight.curveTo(639, 137, 656, 135, 667, 134);
        carBodyHighlight.curveTo(681, 133, 700, 132, 714, 129);
        carBodyHighlight.curveTo(729, 128, 741, 125, 753, 123);
        carBodyHighlight.curveTo(765, 122, 777, 121, 791, 121);
        carBodyHighlight.curveTo(800, 121, 812, 121, 828, 121);
        carBodyHighlight.curveTo(840, 122, 854, 124, 870, 128);
        carBodyHighlight.curveTo(881, 129, 896, 133, 908, 137);
        carBodyHighlight.curveTo(921, 141, 931, 145, 940, 149);
        carBodyHighlight.curveTo(947, 152, 956, 157, 962, 161);
        carBodyHighlight.curveTo(973, 168, 981, 174, 989, 181);
        carBodyHighlight.curveTo(997, 186, 1004, 190, 1005, 193);
        carBodyHighlight.curveTo(1011, 197, 1016, 204, 1018, 208);
        carBodyHighlight.curveTo(1019, 210, 1019, 210, 1019, 210);
        carBodyHighlight.curveTo(1019, 210, 1019, 210, 1019, 210);
        carBodyHighlight.curveTo(1019, 210, 1019, 210, 296, 208);
        carBodyHighlight.curveTo(296, 208, 296, 208, 296, 208);
        carBodyHighlight.curveTo(296, 208, 296, 208, 296, 208);
        carBodyHighlight.curveTo(296, 208, 199, 185, 199, 185);
        carBodyHighlight.curveTo(199, 185, 198, 185, 198, 185);
        carBodyHighlight.curveTo(198, 185, 198, 185, 198, 185);
        carBodyHighlight.curveTo(140, 174, 140, 174, 140, 174);
        carBodyHighlight.curveTo(140, 174, 140, 174, 140, 174);
        carBodyHighlight.curveTo(140, 174, 140, 174, 140, 174);
        g2d.setColor(new Color(255, 205, 72));
//g2d.fill(carBodyHighlight);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyHighlight)))));
        g2d.setPaint(new Color(255, 205, 72));
//g2d.draw(carBodyHighlight);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyHighlight)))));

        Ellipse2D.Double carRearTireHole = new Ellipse2D.Double(196, 128, 168, 168);
        Area carBodyMainArea = new Area(carBodyBase);
        Area carBodyMainArea1 = new Area(carBodyBase);
        Area carRearTireHoleArea = new Area(carRearTireHole);
        Ellipse2D.Double carFrontTireHole = new Ellipse2D.Double(756, 128, 168, 168);
        Area carFrontTireHoleArea = new Area(carFrontTireHole);
        g2d.setColor(new Color(141, 100, 34));
        carBodyMainArea.intersect(carRearTireHoleArea);
        carBodyMainArea1.intersect(carFrontTireHoleArea);

//g2d.fill(carBodyMainArea);//REAR TIRE HOLE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyMainArea)))));
//g2d.fill(carBodyMainArea1);//FRONT TIRE HOLE
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(recenter.createTransformedShape(carBodyMainArea1)))));

    }

    public void carSpoiler(Graphics2D g2d, AffineTransform trans, AffineTransform rot, AffineTransform a, AffineTransform recenter) {
        GeneralPath carSpoilerMount = new GeneralPath();
        carSpoilerMount.moveTo(172, 86);
        carSpoilerMount.curveTo(181, 115, 181, 115, 181, 115);
        carSpoilerMount.curveTo(181, 115, 181, 115, 181, 115);
        carSpoilerMount.curveTo(181, 115, 181, 115, 210, 106);
        carSpoilerMount.curveTo(210, 106, 210, 106, 210, 106);
        carSpoilerMount.curveTo(210, 106, 210, 106, 199, 91);
        carSpoilerMount.curveTo(199, 91, 199, 91, 199, 91);
        carSpoilerMount.curveTo(199, 91, 199, 91, 193, 86);
        carSpoilerMount.curveTo(183, 84, 179, 86, 174, 90);
        carSpoilerMount.curveTo(173, 91, 173, 91, 173, 91);
        g2d.setColor(new Color(70, 73, 73));
//g2d.fill(carSpoilerMount);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(carSpoilerMount))));
        g2d.setPaint(new Color(70, 73, 73));
//g2d.draw(carSpoilerMount);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(carSpoilerMount))));

        GeneralPath carSpoilerTop = new GeneralPath();
        carSpoilerTop.moveTo(130, 71);
        carSpoilerTop.curveTo(219, 72, 219, 72, 219, 72);
        carSpoilerTop.curveTo(219, 72, 219, 75, 218, 79);
        carSpoilerTop.curveTo(215, 84, 213, 87, 209, 89);
        carSpoilerTop.curveTo(205, 90, 201, 92, 195, 92);
        carSpoilerTop.curveTo(189, 92, 182, 91, 176, 91);
        carSpoilerTop.curveTo(171, 90, 165, 90, 160, 89);
        carSpoilerTop.curveTo(154, 88, 146, 86, 142, 84);
        carSpoilerTop.curveTo(138, 81, 134, 79, 133, 77);
        carSpoilerTop.curveTo(132, 74, 130, 73, 130, 72);
        carSpoilerTop.curveTo(130, 72, 130, 72, 130, 72);
        g2d.setColor(new Color(250, 182, 30));
//g2d.fill(carSpoilerTop);
        g2d.fill(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(carSpoilerTop))));
        g2d.setPaint(new Color(250, 182, 30));
//g2d.draw(carSpoilerTop);
        g2d.draw(trans.createTransformedShape(rot.createTransformedShape(a.createTransformedShape(carSpoilerTop))));

    }
}

package guibasic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MySwingAnimFaceOjb extends JPanel implements ActionListener {

    private Ellipse2D.Float ellipse = new Ellipse2D.Float();

    final int framespeed = 50;
    final private double MAXCounter = 500;

    private boolean isResetProcess = true;
    private double counter;
    private Timer timer;

    private int ballnum = 2;
    private BallRim[] myBalls = new BallRim[ballnum];

    public static void main(String[] args) {
        /* おまじない：開始 */
        MySwingAnimFaceOjb animation = new MySwingAnimFaceOjb();
        JFrame frame = new JFrame("SwingFaceObject");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(animation);
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        /* おまじない：終了 */
    }// main end

    ActionListener updateProBar;

    public MySwingAnimFaceOjb() {

        timer = new Timer(framespeed, this);
        timer.setInitialDelay(500);
        timer.start();

    }

    public void paint(Graphics g) {
        /* おまじない：開始 */

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        Dimension windowSize = getSize();

        if (isResetProcess) {
            initProcess(windowSize.width, windowSize.height);
            isResetProcess = false;
        }

        this.doNextStep(windowSize.width, windowSize.height);
        paintProcess(windowSize.width, windowSize.height, g2);
        /* おまじない：終了 */

    }// paint end

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setEllipseSize(double size, int w, int h) {
        counter = size;
        ellipse.setFrame(10, 10, size, size);
    }

    public void initProcess(int w, int h) {

        for (int i = 0; i < myBalls.length; i++) {
            myBalls[i] = new BallRim(w, h);
        }

        setEllipseSize(1, w, h);
    }

    public void doNextStep(int w, int h) {
        counter++;

        if (counter > MAXCounter) {
            initProcess(w, h);

        } else {

            for (int i = 0; i < myBalls.length; i++) {
                myBalls[i].move();
            }
            ellipse.x = w/2-(float)counter/2;
            ellipse.y = h/2-(float)counter/2;
            ellipse.setFrame(ellipse.getX(), ellipse.getY(), counter, counter);
        }
    }

    public void paintProcess(int w, int h, Graphics2D g2) {

        g2.setColor(Color.BLUE);
        g2.draw(ellipse);
        g2.drawString(counter + "Step経過", 10, 10);

        for (int i = 0; i < myBalls.length; i++) {
            myBalls[i].draw(g2);
        }

    }

    class BallRim {

        FaceObj fobj;

        String str = "";

        Random rdn;
        int w = 500;
        int h = 500;

        int x;
        int y;
        int radius; // 半径
        Color basicColor = Color.gray;
        Color eyeColor = Color.gray;
        Color highlightColor = Color.gray;

        double xDir = -1; // 1:+方向 -1: -方向
        double yDir = 1;
        private int strCounter;

        int attack = 0;

        BallRim(int w, int h) {

            rdn = new Random();
            xDir = rdn.nextDouble() * 2 - 1;
            yDir = rdn.nextDouble() * 2 - 1;
            this.w = w;
            this.h = h;
            setPosition(rdn.nextInt(w), rdn.nextInt(h));
            setRadius(rdn.nextInt(30) + 30);// 30-60のサイズの顔の輪郭

            int r = 255 - rdn.nextInt(100);
            int g = 255 - rdn.nextInt(100);
            int b = 255 - rdn.nextInt(100);
            setBasicColor(new Color(r, g, b));

            r = 3*r/7+20;
            g = 3*g/7+20;
            b = 3*b/7+20;
            setEyeColor(r, g, b);

            fobj = new FaceObj();

        }

        void setBasicColor(Color bcolor) {
            this.basicColor = bcolor;
        }

        void setEyeColor(int r, int g, int b) {
            this.eyeColor = new Color(r,g,b);
            int l = 30;
            this.highlightColor = new Color(Math.min(255,r*2+l),Math.min(255,g*2+l),Math.min(255,b*2+l));
        }

        public void setCollisionText(String str, int strCounter) {
            this.str = str;
            this.strCounter = strCounter;

        }

        void move() {
            if ((xDir > 0) && (x + this.radius * 2 >= w)) {
                xDir = -1 * xDir;
                setCollisionText("右のほっぺが痛い>_<", 10);
                attack=1;
            } else if ((xDir < 0) && (x <= 0)) {
                xDir = -1 * xDir;
                setCollisionText("左のほっぺがめちゃ痛い>_<", 10);
                attack=1;
            } else if (xDir > 0) {
                x = x + 10;
            } else {
                x = x - 10;
            }

            if ((yDir > 0) && (y + this.radius * 2 >= h)) {
                yDir = -1 * yDir;
                setCollisionText("顎が痛い>_<", 10);
                attack=1;
            }
            if ((yDir < 0) && (y <= 0)) {
                yDir = -1 * yDir;
                setCollisionText("頭がめちゃ痛い>_<", 10);
                attack=1;
            }

            if(0<attack&&attack<10) {
                attack++;
                fobj.setEmotionLevel(2);
            }else{
                attack=0;
                fobj.setEmotionLevel(1);
            }

            if (yDir > 0) {
                y = y + 10;
            } else {
                y = y - 10;
            }

        }

        void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setRadius(int r) {
            this.radius = r;
        }

        void draw(Graphics g) {
            // 耳
            g.setColor(basicColor);
            int mimi = radius*2/3;
            g.fillOval(x, y, mimi, mimi);
            g.fillOval(x+2*radius-mimi, y, mimi, mimi);
            // 顔
            g.fillOval(x, y, 2 * radius, 2 * radius); // rは半径なので2倍にする
            if (strCounter > 0) {
                g.setColor(Color.BLACK);
                g.drawString(str, x, y);
                g.setColor(basicColor);
                strCounter--;
            } else {
                str = "";
            }

            fobj.setXY(x, y);
            fobj.setSize(2 * radius, 2 * radius);
            fobj.makeFace(g, eyeColor, highlightColor);

        }

    }// ball end

    class FaceObj {
        // コンストラクタ

        int h = 100;
        int w = 100;

        int xStart = 0;
        int yStart = 0;
        int xEnd = 0;
        int yEnd = 0;
        int emo = 0;

        Random rdn;

        public void setEmotionLevel(int i){
            this.emo = i;
        }

        public void setXY(int x, int y) {
            this.xStart = x;
            this.yStart = y;
        }

        public void setSize(int h, int w) {
            this.h = h;
            this.w = w;
            this.xEnd = w + xStart;
            this.yEnd = h + yStart;
        }

        public FaceObj() {

        }

        // 個々にメソッドを追加

        public void makeFace(Graphics g, Color eyeColor, Color hlColor) {
            //makeRim(g);
            makeHoppe(g, w/13, w/8, 3*w/5);
            makeEyes(g, w/6, 2 * w/6, w/5, eyeColor, hlColor);
            makeNose(g, h / 16);
            makeBrow(g,w/6,w/4,7,w/7); // 眉 30,40,45
            makeMouth(g, w / 3);
        }

    
        public void makeRim(Graphics g) {
            g.drawLine(xStart, yStart, xStart + h, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + w);
            g.drawLine(xStart, yStart + w, xStart + h, yStart + w);
            g.drawLine(xStart + h, yStart, xStart + h, yStart + w);
        }
        
        public void makeBrow(Graphics g, int bx, int by, int r, int l) { // bxは目の幅, lは眉の長さ
            // 呼ばれる方(=定義する方)
            if(emo==0){ //まっすぐ
                g.drawLine(xStart+bx, yStart+by, xStart+bx+l, yStart+by);
                g.drawLine(xEnd-bx, yStart+by, xEnd-bx-l, yStart+by);
            }else if(emo==1){ //垂れ眉
                g.drawLine(xStart+bx, yStart+by, xStart+bx+l, yStart+by-r);
                g.drawLine(xEnd-bx, yStart+by, xEnd-bx-l, yStart+by-r);
            }else if(emo==2){ //釣り眉
                g.drawLine(xStart+bx, yStart+by-r, xStart+bx+l, yStart+by);
                g.drawLine(xEnd-bx, yStart+by-r, xEnd-bx-l, yStart+by);
            }
        }

        public void makeEyes(Graphics g, int ex, int ey, int r, Color eyeCol, Color hlCol) {
            if(emo==2){
                g.setColor(Color.BLACK);
                int centerY = yStart+ey+w/5;
                g.drawLine(xStart+ex, centerY+w/10, xStart+ex+w/5, centerY);
                g.drawLine(xStart+ex, centerY-w/10, xStart+ex+w/5, centerY);
                g.drawLine(xEnd-ex-w/5, centerY, xEnd-ex, centerY+w/10);
                g.drawLine(xEnd-ex-w/5, centerY, xEnd-ex, centerY-w/10);
            }else{
                g.setColor(eyeCol);
                g.fillOval(xStart + ex, yStart + ey, r, r + 5); // 目
                g.fillOval(xEnd - ex - r, yStart + ey, r, r + 5);
                g.setColor(Color.WHITE);
                g.fillOval(xStart + ex + ex / 5, yStart + ey, r / 3, (r + 5) / 3); // 白目
                g.fillOval(xEnd - ex - r + ex / 5, yStart + ey, r / 3, (r + 5) / 3);
                g.setColor(hlCol);
                g.fillOval(xStart + ex + 3 * ex / 5, yStart + ey + 6 * ex / 5, r / 4, r / 4); // hl
                g.fillOval(xEnd - ex - r + 3 * ex / 5, yStart + ey + 6 * ex / 5, r / 4, r / 4);
                g.setColor(Color.BLACK);
            }
        }

        public void makeHoppe(Graphics g, int r, int hx, int hy) { // rは目の半径
            int rx = 2*r;
            g.setColor(new Color(255,206,224));
            g.fillOval(xStart + hx, yStart + hy, rx, r);
            g.fillOval(xEnd - hx - rx, yStart + hy, rx, r);
            g.setColor(Color.BLACK);
        }

        public void makeNose(Graphics g, int noseSize) {
            g.drawLine(xStart + (w * 1 / 2), yStart + (h * 3 / 5),
                    xStart + (w * 1 / 2), yStart + (h * 3 / 5) + noseSize);
        }

        public void makeMouth(Graphics g, int mx) {
            int xMiddle = xStart + w/2;
            // int yMiddle = yStart + 3 * h / 4;
            // g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize
            // / 2, yMiddle);

            if (emo == 0) {
                int my = yEnd - h / 5;
                g.drawLine(xMiddle - mx / 2, my, xMiddle + mx / 2, my);
            } else if (emo == 1) { // にっこり
                int my = yEnd - 3 * h / 7;
                g.drawArc(xMiddle - mx / 2, my, mx, h / 4, 200, 140);
            } else if (emo == 2) { // 怒り
                int my = yEnd - h / 5;
                g.drawArc(xMiddle - mx / 2, my, mx, h / 4, 20, 140);
            }
        }
    }// FaceObj End

}
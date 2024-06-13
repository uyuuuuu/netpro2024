//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package myguichat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMikiSumire {

    public static void main(String[] args) {
        new FacesAWTMikiSumire();
    }

    FacesAWTMikiSumire() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {
        private FaceObj[] faces;

        FaceFrame() {
            faces = new FaceObj[9];
        }

        public void paint(Graphics g) {
            int dx = 200;
            int dy = 200;
            int sx = 50;
            int sy = 25;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    faces[i+j] = new FaceObj(g);
                    faces[i+j].setPosition(50+i*(dx+sx),50+j*(dy+sy),dx,dy);
                    drawFace(faces[i+j],i,j);
                }
            }
        }
        public void drawFace(FaceObj fobj, int i, int j){
            fobj.setEmotionLevel(i,j);
            fobj.drawRim(); // 輪郭
            fobj.drawBrow(30,40,45); // 眉
            fobj.drawEye(35,45,65); // 目
            fobj.drawHoppe(20,20,100); // ほっぺ
            fobj.drawNose(10,120); // 鼻
            fobj.drawMouth(100); // 口(0真顔,1にっこり,2怒り)
        }

    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int w;
        private int h;
        private int xStart;
        private int yStart;
        private int xEnd;
        private int yEnd;
        private int emo_i;
        private int emo_j;
        Graphics g;

        FaceObj(Graphics g){
            this.g = g;
        }
        public void setPosition(int x,int y,int dx, int dy){
            this.w = dx; //200
            this.h = dy; //200
            this.xStart = x; //50
            this.yStart = y; //50
            this.xEnd = w + xStart;
            this.yEnd = h + yStart;
        }
        public void setEmotionLevel(int i,int j){
            this.emo_i = i;
            this.emo_j = j;
        }
        public void drawRim() { // wが横幅、hが縦幅
            g.setColor(new Color(255,247,239));
            g.fillRect(xStart, yStart, w, h);
            g.setColor(Color.BLACK);
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(int bx, int by, int l) { // bxは目の幅, lは眉の長さ
            // 呼ばれる方(=定義する方)
            if(emo_j==0){ //まっすぐ
                g.drawLine(xStart+bx, yStart+by, xStart+bx+l, yStart+by);
                g.drawLine(xEnd-bx, yStart+by, xEnd-bx-l, yStart+by);
            }else if(emo_j==1){ //垂れ眉
                g.drawLine(xStart+bx, yStart+by, xStart+bx+l, yStart+by-20);
                g.drawLine(xEnd-bx, yStart+by, xEnd-bx-l, yStart+by-20);
            }else if(emo_j==2){ //釣り眉
                g.drawLine(xStart+bx, yStart+by-20, xStart+bx+l, yStart+by);
                g.drawLine(xEnd-bx, yStart+by-20, xEnd-bx-l, yStart+by);
            }
        }

        public void drawNose(int nx, int y) { // nxは鼻の長さ
            g.drawLine((xStart+xEnd)/2, yStart+y, (xStart+xEnd)/2, yStart+y+nx);
        }

        public void drawEye(int r, int ex, int ey) { // rは目の半径
            int out = 45+r-2;
            int in = 45-5;
            int t = 5;
            g.drawLine(xStart+in, yStart + ey +t, xStart+out, yStart + ey -t);
            g.drawLine(xEnd-out, yStart + ey -t, xEnd-in, yStart + ey +t);
            g.setColor(new Color(158,76,206));
            g.fillOval(xStart + ex, yStart + ey, r, r+5); //黒目
            g.fillOval(xEnd - ex - r, yStart + ey, r, r+5);
            g.setColor(Color.WHITE);
            g.fillOval(xStart + ex + 5, yStart + ey, r/3, (r+5)/3); //白目
            g.fillOval(xEnd - ex - r + 5, yStart + ey, r/3, (r+5)/3);
            g.setColor(new Color(149,239,236));
            g.fillOval(xStart + ex + 20, yStart + ey + 30, r/4, r/4); //水色
            g.fillOval(xEnd - ex - r + 20, yStart + ey + 30, r/4, r/4);
            g.setColor(Color.BLACK);
        }

        public void drawHoppe(int r, int hx, int hy) { // rは目の半径
            int rx = r+10;
            g.setColor(Color.PINK);
            g.fillOval(xStart + hx, yStart + hy, rx, r);
            g.fillOval(xEnd - hx - rx, yStart + hy, rx, r);
            g.setColor(Color.BLACK);
        }

        public void drawMouth(int mx) { // xは口の幅
            int xMiddle = xStart + w / 2; //四角の中心
            if(emo_i==0){
                int my = yEnd - 30;
                g.drawLine(xMiddle - mx / 2, my, xMiddle + mx / 2, my);
            }else if(emo_i==1){ //にっこり
                int my = yEnd - 70;
                g.drawArc(xMiddle - mx / 2, my, mx, 40, 200, 140 );
            }else if(emo_i==2){ //怒り
                int my = yEnd - 40;
                g.drawArc(xMiddle - mx / 2, my, mx, 40, 20, 140 );
            }
        }
    }
}// Faces class end

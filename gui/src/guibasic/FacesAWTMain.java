//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
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
            fobj.drawRim(); // 輪郭
            fobj.drawBrow(30,45,j); // 眉
            fobj.drawEye(35); // 目
            fobj.drawNose(20,100); // 鼻
            fobj.drawMouth(100,i); // 口(0真顔,1にっこり,2怒り)
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
        public void drawRim() { // wが横幅、hが縦幅
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void drawBrow(int bx, int l, int mode) { // bxは目の幅, lは眉の長さ
            // 呼ばれる方(=定義する方)
            if(mode==0){ //まっすぐ
                g.drawLine(xStart+bx, yStart+50, xStart+bx+l, yStart+50);
                g.drawLine(xEnd-bx, yStart+50, xEnd-bx-l, yStart+50);
            }else if(mode==1){ //垂れ眉
                g.drawLine(xStart+bx, yStart+50, xStart+bx+l, yStart+30);
                g.drawLine(xEnd-bx, yStart+50, xEnd-bx-l, yStart+30);
            }else if(mode==2){ //釣り眉
                g.drawLine(xStart+bx, yStart+30, xStart+bx+l, yStart+50);
                g.drawLine(xEnd-bx, yStart+30, xEnd-bx-l, yStart+50);
            }
        }

        public void drawNose(int nx, int y) { // xは鼻の長さ
            g.drawLine((xStart+xEnd)/2, yStart+y, (xStart+xEnd)/2, yStart+y+nx);
        }

        public void drawEye(int r) { // rは目の半径
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xEnd - 45 - r, yStart + 65, r, r);
        }

        public void drawMouth(int mx, int mode) { // xは口の幅
            int xMiddle = xStart + w / 2; //四角の中心
            if(mode==0){
                int yMiddle = yStart + h - 30;
                g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
            }else if(mode==1){ //にっこり
                int yMiddle = yStart + h - 60;
                g.drawArc(xMiddle - mx / 2, yMiddle, mx, 30, 180, 180 );
            }else if(mode==2){ //怒り
                int yMiddle = yStart + h - 60;
                g.drawArc(xMiddle - mx / 2, yMiddle, mx, 30, 0, 180 );
            }
        }
    }

}// Faces class end

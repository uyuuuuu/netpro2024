package myguichat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class GUIAnimationFaceLook {// 顔のオブジェクト
	int h = 100;
	int w = 100;

	int xStart = 0;
	int yStart = 0;
	int xEnd = 0;
	int yEnd = 0;
	int emo = 0;

	Random rdn;

	public void setEmotionLevel(int i) {
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

	public GUIAnimationFaceLook() {

	}

	// 個々にメソッドを追加

	public void makeFace(Graphics g, Color eyeColor, Color hlColor, int emotion) {
		// makeRim(g);
		setEmotionLevel(emotion);
		makeHoppe(g, w / 13, w / 8, 3 * w / 5);
		makeEyes(g, w / 6, 2 * w / 6, w / 5, eyeColor, hlColor);
		makeNose(g, h / 16);
		makeBrow(g, w / 6, w / 4, 7, w / 7); // 眉 30,40,45
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
		if (emo == 0) { // まっすぐ
			g.drawLine(xStart + bx, yStart + by, xStart + bx + l, yStart + by);
			g.drawLine(xEnd - bx, yStart + by, xEnd - bx - l, yStart + by);
		} else if (emo == 1) { // 垂れ眉
			g.drawLine(xStart + bx, yStart + by, xStart + bx + l, yStart + by - r);
			g.drawLine(xEnd - bx, yStart + by, xEnd - bx - l, yStart + by - r);
		} else if (emo == 2) { // 釣り眉
			g.drawLine(xStart + bx, yStart + by - r, xStart + bx + l, yStart + by);
			g.drawLine(xEnd - bx, yStart + by - r, xEnd - bx - l, yStart + by);
		}
	}

	public void makeEyes(Graphics g, int ex, int ey, int r, Color eyeCol, Color hlCol) {
		if (emo == 2) {
			g.setColor(Color.BLACK);
			int centerY = yStart + ey + w / 5;
			g.drawLine(xStart + ex, centerY + w / 10, xStart + ex + w / 5, centerY);
			g.drawLine(xStart + ex, centerY - w / 10, xStart + ex + w / 5, centerY);
			g.drawLine(xEnd - ex - w / 5, centerY, xEnd - ex, centerY + w / 10);
			g.drawLine(xEnd - ex - w / 5, centerY, xEnd - ex, centerY - w / 10);
		} else {
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
		int rx = 2 * r;
		g.setColor(new Color(255, 206, 224));
		g.fillOval(xStart + hx, yStart + hy, rx, r);
		g.fillOval(xEnd - hx - rx, yStart + hy, rx, r);
		g.setColor(Color.BLACK);
	}

	public void makeNose(Graphics g, int noseSize) {
		g.drawLine(xStart + (w * 1 / 2), yStart + (h * 3 / 5),
				xStart + (w * 1 / 2), yStart + (h * 3 / 5) + noseSize);
	}

	public void makeMouth(Graphics g, int mx) {
		int xMiddle = xStart + w / 2;
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
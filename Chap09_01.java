package Lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chap09_01 extends JFrame implements MouseListener {
    int x = 15, y = 160;
    int numClicked = 0;

    public Chap09_01() {
        super("Example using MouseListener");
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        super.paint(g);
        g.drawString("x = " + x + ", y = " + y, 15, 50);
        g.drawString(numClicked + " clicked", 15, 70);
        g.fillOval(x, y, 20, 20);
    }

    public void mousePressed(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Graphics g = getGraphics();
        g.drawString("[" + x + ", " + y + " ]", x, y);
    }

    public void mouseReleased(MouseEvent event) {

        repaint();
    }

    public void mouseClicked(MouseEvent event) {
        this.x = event.getX();
        this.y = event.getY();
        numClicked++;
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public static void main(String[] args) {
        Chap09_01 test = new Chap09_01();
        test.setSize(640, 480);

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        test.setVisible(true);
    }
}
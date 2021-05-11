package Lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chap09_03 extends JFrame implements KeyListener {
    int x = 20, y = 120;
    String text = "Text";

    public Chap09_03() {
        super("Example using KeyListener1");
        addKeyListener(this);
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.BLUE);
    }

    public void paint(Graphics g) {

        super.paint(g);
        g.drawString(text, x, y);
    }

    public void keyPressed(KeyEvent event) {
        text = "char = " + event.getKeyChar();
        text += ", " +

                event.getKeyText(event.getKeyCode());

        text += ", code = " + event.getKeyCode();
    }

    public void keyReleased(KeyEvent event) {
        repaint();
    }

    public void keyTyped(KeyEvent event) {

        Graphics g = getGraphics();
        g.drawOval(x, y, 50, 50);
    }

    public static void main(String[] args) {
        Chap09_03 test = new Chap09_03();
        test.setSize(640, 480);

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        test.setVisible(true);
    }
}

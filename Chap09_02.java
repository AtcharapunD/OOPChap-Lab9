package Lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chap09_02 extends JFrame implements MouseListener {
    int x = 160;
    int y = 120;
    int size = 40;
    String text = "Hello World";
    boolean type = true;

    public Chap09_02() {
        super("Example using MouseListener2");
        addMouseListener(this);
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.BLUE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(text, x, y);
    }

    public void mousePressed(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Graphics g = getGraphics();
        if (type)
            g.fillOval(x, y, size, size);
        else
            g.fillRect(x, y, size, size);
    }

    public void mouseReleased(MouseEvent event) {
        repaint();
    }

    public void mouseClicked(MouseEvent event) {
        this.x = event.getX();
        this.y = event.getY();
        type = !type;
    }

    public void mouseEntered(MouseEvent event) {
        text = "Welcome";
        repaint();
    }

    public void mouseExited(MouseEvent event) {
        text = "Bye bye!.";
        repaint();
    }

    public static void main(String[] args) {
        Chap09_02 obj = new Chap09_02();
        obj.setSize(640, 480);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        obj.setVisible(true);
    }
}

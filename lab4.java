import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintApp extends JFrame {
    private int x, y;
    private Color currentColor;

    public PaintApp() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        currentColor = Color.BLACK;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            x = e.getX();
            y = e.getY();
            repaint();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            changeColorRandomly();
        }
    }

    private void changeColorRandomly() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        currentColor = new Color(red, green, blue);
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(currentColor);
        g.fillOval(x, y, 10, 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaintApp app = new PaintApp();
            app.setSize(400, 400);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawingPanel extends JFrame implements ActionListener {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 800;
    private final int TIMER_DELAY = 10;
    private final Timer timer = new Timer(TIMER_DELAY, this);
    private int ticksFromStart = 0;

    public DrawingPanel() {
        setTitle("Мой проект");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // фон
        g2d.setColor(new Color(135, 206, 235));
        g2d.fillRect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        //  Координаты корабля
        int x = ticksFromStart;  // позиция по X
        int y = 250;             // позиция по Y
        // Корпус-трапеция
        g2d.setColor(new Color(235, 69, 30));
        int[] X = {x - 150, x + 150, x + 120, x - 120};
        int[] Y = {y + 100, y + 100, y + 180, y + 180};
        g2d.fillPolygon(X, Y, 4);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(X, Y, 4);
        // кабина
        g2d.setColor(new Color(255, 235, 5)); // золотой/жёлтый
        g2d.fillRect(x - 80, y + 40, 160, 60);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x - 80, y + 40, 160, 60);
        // окна
        g2d.setColor(new Color(138, 206, 235));
        g2d.fillOval(x - 60, y + 55, 25, 25);
        g2d.fillOval(x - 12, y + 55, 25, 25);
        g2d.fillOval(x + 36, y + 55, 25, 25);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x - 60, y + 55, 25, 25);
        g2d.drawOval(x - 12, y + 55, 25, 25);
        g2d.drawOval(x + 36, y + 55, 25, 25);

        // верхний прямоугольник
        g2d.setColor(new Color(30, 144, 255));
        g2d.fillRect(x - 40, y, 80, 40);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x - 40, y, 80, 40);

        // мачта
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(x + 40, y, x + 40, y - 60);

        // флаг
        g2d.setColor(new Color(235, 69, 30));
        g2d.fillRect(x + 40, y - 60, 50, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x + 40, y - 60, 50, 30);

        // Сбрасываем толщину линии
        g2d.setStroke(new BasicStroke(1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new DrawingPanel();
    }
}
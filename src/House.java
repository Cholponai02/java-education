import java.awt.*;

public class House extends Canvas {
    public void paint(Graphics g) {
        // Стены дома
        g.setColor(Color.ORANGE);
        g.fillRect(100, 150, 200, 150);

        // Крыша (треугольник)
        g.setColor(Color.RED);
        int[] xPoints = {100, 200, 300};
        int[] yPoints = {150, 50, 150};
        g.fillPolygon(xPoints, yPoints, 3);

        // Дверь
        g.setColor(Color.DARK_GRAY);
        g.fillRect(180, 220, 40, 80);

        // Окна
        g.setColor(Color.WHITE);
        g.fillRect(120, 180, 40, 40);
        g.fillRect(240, 180, 40, 40);

        // Солнце
        g.setColor(Color.YELLOW);
        g.fillOval(350, 50, 50, 50);
    }

//    public static void main(String[] args) {
//        Frame frame = new Frame();
//        House canvas = new House();
//        frame.add(canvas);
//        frame.setSize(500, 400);
//        frame.setVisible(true);
//    }
}

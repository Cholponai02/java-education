import java.awt.*;
import java.util.Random;

public class RandomShapes extends Canvas {
    Random random = new Random();

    public void paint(Graphics g) {
        for (int i = 0; i < 10; i++) {
            // Случайные координаты и размеры
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            int size = random.nextInt(50) + 30;

            // Случайный цвет
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            // Рисуем квадрат
            g.fillRect(x, y, size, size);
        }

        for (int i = 0; i < 10; i++) {
            // Случайные координаты и размеры
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            int size = random.nextInt(50) + 30;

            // Случайный цвет
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            // Рисуем круг
            g.fillOval(x, y, size, size);
        }
    }

}

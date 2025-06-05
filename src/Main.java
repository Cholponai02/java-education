//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {
    public Main() {
        setSize(400, 400);
        setVisible(true);

    }

    // Метод для рисования
    public void paint(Graphics g) {
        g.setColor(Color.RED);
//        g.drawLine(50, 50, 300, 300); // Линия из (50,50) в (300,300)
//        g.drawRect(100, 100, 200, 150); // Прямоугольник (x=100, y=100, ширина=200, высота=150)
//        g.fillRect(100, 100, 200, 150); // Закрашенный прямоугольник

//        g.drawOval(100, 100, 150, 150); // Окружность (x=100, y=100, ширина=150, высота=150)
//        g.fillOval(100, 100, 150, 150); // Закрашенный круг

//        g.drawArc(100, 100, 150, 150, 0, 180); // Дуговая линия от 0° до 180°
        // --------g.drawArc(x, y, width, height, startAngle, arcAngle);
        //-----------startAngle – начальный угол (в градусах).
        //------------arcAngle – угол дуги.

//        // Координаты точек многоугольника
//        int[] xPoints = {100, 200, 250, 150, 50};
//        int[] yPoints = {200, 100, 200, 300, 200};
//        int nPoints = 5; // Количество точек
//        g.drawPolygon(xPoints, yPoints, nPoints); // Рисуем многоугольник

        int[] xPoints = {100, 200, 250, 150, 50};
        int[] yPoints = {200, 100, 200, 300, 200};
        int nPoints = 5;
        g.fillPolygon(xPoints, yPoints, nPoints); // Закрашенный многоугольник

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g; // Преобразуем Graphics в Graphics2D

        // Создаем градиент от тёмно-серого к светло-серому
        GradientPaint gradient = new GradientPaint(180, 220, Color.DARK_GRAY, 220, 300, Color.LIGHT_GRAY);
        g2d.setPaint(gradient);

        // Рисуем градиентный прямоугольник
        g2d.fillRect(180, 220, 40, 80);

    }

    public static void main(String[] args) {
//   //     new Main();
        Frame frame = new Frame();
       House canvas = new House();
//        Smiley canvas = new Smiley();
//        RandomShapes canvas = new RandomShapes();
//        frame.add(canvas);
//        frame.setSize(500, 400);
//        frame.setVisible(true);



        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });


    }
}

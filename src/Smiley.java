import java.awt.*;

public class Smiley extends Canvas {
    public void paint(Graphics g) {
        // Голова
        g.setColor(Color.YELLOW);
        g.fillOval(100, 100, 200, 200);

        // Глаза
        g.setColor(Color.BLACK);
        g.fillOval(140, 150, 30, 30);
        g.fillOval(230, 150, 30, 30);

        // Рот (улыбка)
        g.drawArc(150, 180, 100, 50, 0, -180);
    }

//    public static void main(String[] args) {
//        Frame frame = new Frame();
//        Smiley canvas = new Smiley();
//        frame.add(canvas);
//        frame.setSize(400, 400);
//        frame.setVisible(true);
//    }
}

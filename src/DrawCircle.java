import java.awt.*;

public class DrawCircle extends Frame {
    public DrawCircle() {
        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.drawOval(100, 100, 150, 150); // Окружность (x=100, y=100, ширина=150, высота=150)
    }

//    public static void main(String[] args) {
//        new DrawCircle();
//    }
}

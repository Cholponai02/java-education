import java.awt.*;

public class ChessBoard extends Canvas {
    public void paint(Graphics g) {
        int tileSize = 50; // Размер одной клетки
        int boardSize = 8; // Размер доски (8x8)

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                // Вычисляем координаты клетки
                int x = col * tileSize;
                int y = row * tileSize;

                // Определяем цвет клетки (чередуем черный и белый)
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }

                // Рисуем квадрат
                g.fillRect(x, y, tileSize, tileSize);
            }
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        ChessBoard canvas = new ChessBoard();
        frame.add(canvas);
        frame.setSize(420, 440); // Делаем чуть больше, чтобы была рамка
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JFrame {
    public SnakeGame() {
        setTitle("Змейка"); // Устанавливаем заголовок окна
        setSize(600, 600); // Устанавливаем размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие программы при выходе
        setResizable(false); // Запрещаем изменение размера окна
        setLocationRelativeTo(null); // Размещаем окно по центру экрана
        add(new GamePanel()); // Добавляем игровую панель
        setVisible(true); // Делаем окно видимым
    }

    public static void main(String[] args) {
        new SnakeGame(); // Запускаем игру
    }
}

class GamePanel extends JPanel implements ActionListener {
    private final int SIZE = 600; // Размер игрового поля
    private final int DOT_SIZE = 20; // Размер одного сегмента змейки
    private final int ALL_DOTS = 900; // Максимальная длина змейки

    private int[] x = new int[ALL_DOTS]; // Массив для хранения координат X змейки
    private int[] y = new int[ALL_DOTS]; // Массив для хранения координат Y змейки
    private int dots = 3; // Начальная длина змейки

    private int appleX, appleY; // Координаты еды
    private Timer timer; // Таймер для обновления игры
    private boolean left = false, right = true, up = false, down = false; // Направления движения змейки
    private boolean inGame = true; // Флаг состояния игры
    private Random random = new Random(); // Генератор случайных чисел для размещения еды

    public GamePanel() {
        setBackground(Color.BLACK); // Задаем фон игрового поля
        setFocusable(true); // Делаем панель фокусируемой для обработки нажатий клавиш
        addKeyListener(new KeyAdapter() { // Добавляем слушатель клавиатуры
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && !right) { // Если нажата стрелка влево и змейка не движется вправо
                    left = true;
                    up = down = false;
                } else if (key == KeyEvent.VK_RIGHT && !left) { // Если нажата стрелка вправо и змейка не движется влево
                    right = true;
                    up = down = false;
                } else if (key == KeyEvent.VK_UP && !down) { // Если нажата стрелка вверх и змейка не движется вниз
                    up = true;
                    left = right = false;
                } else if (key == KeyEvent.VK_DOWN && !up) { // Если нажата стрелка вниз и змейка не движется вверх
                    down = true;
                    left = right = false;
                }
            }
        });

        startGame(); // Запуск игры
    }

    private void startGame() {
        // Устанавливаем начальное положение змейки
        for (int i = 0; i < dots; i++) {
            x[i] = 100 - i * DOT_SIZE;
            y[i] = 100;
        }
        spawnApple(); // Размещаем первое яблоко
        timer = new Timer(150, this); // Создаем таймер, который срабатывает каждые 150 мс
        timer.start(); // Запускаем таймер
    }

    private void spawnApple() {
        // Генерируем случайные координаты для яблока
        appleX = random.nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
        appleY = random.nextInt(SIZE / DOT_SIZE) * DOT_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Очищаем экран перед отрисовкой
        if (inGame) {
            // Отрисовка яблока
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, DOT_SIZE, DOT_SIZE);

            // Отрисовка змейки
            for (int i = 0; i < dots; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
            }
        } else {
            gameOver(g); // Отображаем сообщение об окончании игры
        }
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Игра окончена!", SIZE / 2 - 100, SIZE / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move(); // Двигаем змейку
            checkApple(); // Проверяем, съела ли змейка яблоко
            checkCollision(); // Проверяем столкновения
        }
        repaint(); // Перерисовываем экран
    }

    private void move() {//--------------------------------------
        // Двигаем все сегменты змейки вперед
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        // Двигаем голову змейки в выбранном направлении
        if (left) x[0] -= DOT_SIZE;
        if (right) x[0] += DOT_SIZE;
        if (up) y[0] -= DOT_SIZE;
        if (down) y[0] += DOT_SIZE;
    }

    private void checkApple() {  //-----------------------------
        // Проверяем, совпадают ли координаты головы змейки и яблока
        if (x[0] == appleX && y[0] == appleY) {
            dots++; // Увеличиваем длину змейки
            spawnApple(); // Спавним новое яблоко
        }
    }

    private void checkCollision() { /// ---------------------------
        // Проверка столкновения с границами экрана
        if (x[0] < 0 || x[0] >= SIZE || y[0] < 0 || y[0] >= SIZE) {
            inGame = false;
            timer.stop();
        }

        // Проверка на столкновение с самим собой
        for (int i = 1; i < dots; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
                timer.stop();
            }
        }
    }
}

import javax.swing.*; // Импортируем классы для создания графического интерфейса
import java.awt.*;    // Импортируем классы для работы с компоновкой (Layout)
import java.awt.event.*; // Импортируем классы для обработки событий (например, нажатий кнопок)

public class HangmanSwing extends JFrame {
    // Загаданное слово
    private final String wordToGuess = "КОМПЬЮТЕР";

    // Массив для отображения угаданных букв, остальные пока "_"
    private char[] guessed;

    // Количество жизней у игрока
    private int lives = 6;

    // Элементы интерфейса
    private JLabel wordLabel;     // Показывает текущее состояние слова
    private JLabel livesLabel;    // Показывает оставшиеся жизни
    private JTextField inputField; // Поле для ввода буквы
    private JButton guessButton;   // Кнопка "Угадать"

    // Конструктор — создаёт окно и настраивает интерфейс
    public HangmanSwing() {
        guessed = "_".repeat(wordToGuess.length()).toCharArray(); // Заполняем массив "_"

        setTitle("Виселица");              // Заголовок окна
        setSize(300, 200);                 // Размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Закрытие при нажатии на крестик
        setLayout(new GridLayout(4, 1));   // Сетка из 4 строк

        // Создаём элементы и добавляем их в окно
        wordLabel = new JLabel("Слово: " + new String(guessed));
        livesLabel = new JLabel("Жизни: " + lives);
        inputField = new JTextField();
        guessButton = new JButton("Угадать");

        add(wordLabel);     // Первая строка: слово
        add(livesLabel);    // Вторая: количество жизней
        add(inputField);    // Третья: поле для ввода
        add(guessButton);   // Четвёртая: кнопка

        // Обработчик нажатия на кнопку
        guessButton.addActionListener(e -> checkLetter());

        setVisible(true); // Показываем окно
    }

    // Метод для проверки введённой буквы
    private void checkLetter() {
        String input = inputField.getText().toUpperCase(); // Получаем введённую букву

        if (input.length() != 1) {
            JOptionPane.showMessageDialog(this, "Введите одну букву.");
            return;
        }

        char letter = input.charAt(0); // Берём первую букву
        boolean found = false;         // Флаг — была ли такая буква в слове

        // Проверяем, есть ли буква в слове
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter && guessed[i] == '_') {
                guessed[i] = letter; // Открываем букву
                found = true;
            }
        }

        // Если не нашли — теряем жизнь
        if (!found) {
            lives--;
        }

        // Обновляем интерфейс
        wordLabel.setText("Слово: " + new String(guessed));
        livesLabel.setText("Жизни: " + lives);
        inputField.setText(""); // Очищаем поле ввода

        // Проверка окончания игры
        if (new String(guessed).equals(wordToGuess)) {
            endGame("Вы победили!");
        } else if (lives <= 0) {
            endGame("Вы проиграли! Было слово: " + wordToGuess);
        }
    }

    // Метод завершения игры — отключает кнопки и показывает сообщение
    private void endGame(String msg) {
        inputField.setEnabled(false);    // Отключаем ввод
        guessButton.setEnabled(false);  // Отключаем кнопку
        JOptionPane.showMessageDialog(this, msg); // Показываем сообщение
    }

    // Главный метод — запускает игру
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HangmanSwing::new);
    }
}

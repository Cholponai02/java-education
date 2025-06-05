import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class SimpleDictionary extends JFrame {

    private JTextField wordField;
    private JTextField translationField;
    private JTextArea outputArea;

    private HashMap<String, String> dictionary = new HashMap<>();

    public SimpleDictionary() {
        setTitle("Словарь");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Поля ввода
        wordField = new JTextField(10);
        translationField = new JTextField(10);

        // Панель ввода
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Слово:"));
        topPanel.add(wordField);
        topPanel.add(new JLabel("Перевод:"));
        topPanel.add(translationField);

        add(topPanel, BorderLayout.NORTH);

        // Кнопки
        JButton addButton = new JButton("Добавить");
        JButton findButton = new JButton("Искать");
        JButton showButton = new JButton("Все слова");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(findButton);
        buttonPanel.add(showButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Поле вывода
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Действия кнопок
        addButton.addActionListener(e -> {
            String word = wordField.getText();
            String translation = translationField.getText();
            if (!word.isEmpty() && !translation.isEmpty()) {
                dictionary.put(word, translation);
                outputArea.setText("Добавлено: " + word + " — " + translation);
                wordField.setText("");
                translationField.setText("");
            }
        });

        findButton.addActionListener(e -> {
            String word = wordField.getText();
            if (dictionary.containsKey(word)) {
                outputArea.setText("Перевод: " + dictionary.get(word));
            } else {
                outputArea.setText("Слово не найдено.");
            }
        });

        showButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (String key : dictionary.keySet()) {
                sb.append(key).append(" — ").append(dictionary.get(key)).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDictionary();
    }
}

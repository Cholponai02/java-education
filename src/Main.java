// Импортируем необходимые классы
import java.net.URI;                         // Класс для представления URI (адреса API)
import java.net.http.HttpClient;            // HTTP-клиент для отправки запросов
import java.net.http.HttpRequest;           // Класс для создания HTTP-запросов
import java.net.http.HttpResponse;          // Класс для получения HTTP-ответов
import java.io.IOException;                 // Исключение, связанное с операциями ввода-вывода

public class Main {
    public static void main(String[] args) {

        // Создаем HTTP-клиент, с помощью которого будем отправлять запрос
        HttpClient client = HttpClient.newHttpClient();

        // Создаем HTTP-запрос типа GET к заданному URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))  // Адрес API, который возвращает случайную шутку
                .GET()                                                       // Указываем, что это GET-запрос
                .build();                                                    // Строим объект запроса

        try {
            // Отправляем запрос и получаем ответ от сервера в виде строки
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Выводим статус-код ответа (например, 200 — OK)
            System.out.println("Response code: " + response.statusCode());

            // Выводим тело ответа (в данном случае — JSON со шуткой)
            System.out.println("Body: " + response.body());

        } catch (IOException | InterruptedException e) {
            // Обработка возможных ошибок при отправке запроса
            e.printStackTrace();  // Печатаем информацию об ошибке
        }
    }
}

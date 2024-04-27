import exceptions.WrongFIleSizeException;
import exceptions.WrongFileExtensionException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class WordsCount {
    private static final long FILE_MAX_SIZE = 200;
    public static String countOfWords(String fileName) {
        File file = new File(fileName);
        try {
            if (!fileName.endsWith(".txt")) {
                throw new WrongFileExtensionException("Неверное расширение файла");
            }
            if (file.length() > FILE_MAX_SIZE) {
                throw new WrongFIleSizeException("Размер файла превышает допустимое значение");
            }
        } catch (WrongFileExtensionException | WrongFIleSizeException e) {
            return e.getMessage();
        }
        Map<String,Integer> map = new LinkedHashMap<>();
;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            bufferedReader.lines().flatMap(string -> Arrays.stream(string.split(" "))).
                    forEach(string -> map.merge(string,1,Integer::sum));
        } catch (FileNotFoundException e) {
            return "Файл не найден";
        } catch (IOException e) {
            return "Проблемы с чтением файла";
        }
        return map.entrySet().stream().map(entry -> entry.getKey() + " - " + entry.getValue() + "\n").collect(Collectors.joining());

    }
}

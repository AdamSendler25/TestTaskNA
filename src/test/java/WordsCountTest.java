
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class WordsCountTest {

    @Test
    public void countOfWordsTest() {
        String actual = WordsCount.countOfWords("src/main/resources/in.txt");
        String expected = "Возле - 1" + "\n"
                + "стола - 1" + "\n"
                + "стоял - 2" + "\n"
                + "стул. - 1" + "\n"
                + "Стул - 1" + "\n"
                + "возле - 1" + "\n"
                + "стола. - 1" + "\n";
        assertEquals(expected, actual);
    }
    @Test
    public void countOfWordsWrongFileNameTest() {
        String actual = WordsCount.countOfWords("src/main/resources/bigIn.txt");
        String expected = "Размер файла превышает допустимое значение";
        assertEquals(expected,actual);
    }
    @Test
    public void countOfWordsWrongFileExtensionsTest() {
        String actual = WordsCount.countOfWords("src/main/resources/in.nontxt");
        String expected = "Неверное расширение файла";
        assertEquals(expected,actual);
    }
    @Test
    public void countOfWordsFileNotFoundExceptionTest() {
        String actual = WordsCount.countOfWords("src/main/resources/in1.txt");
        String expected = "Файл не найден";
        assertEquals(expected,actual);
    }


}

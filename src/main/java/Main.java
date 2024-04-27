import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Путь к файлу не был передан");
            return;
        }
        System.out.println(WordsCount.countOfWords(args[0]));
    }
}

package reader;

import catalog.CatalogNegative;
import catalog.CatalogPositive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Reader for verifiable file (now - "src/resources/test.txt")
 */
public class TxtFileReader {
    public static Map readFile(String fileName, Map<String, Integer> map) {

        // где то был код с одним try - блоком, делающим тоже самое. Не помню почему тут коряво написано
        //try with resourses тут заделать и минус 10 строчек кода будет
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    int s;
                    while (((s = in.read()) != -1)) {
                        if (Character.isLetterOrDigit(s)) {
                            sb.append((char) s);
                        } else {
                            String slovo = String.valueOf(sb);
                            sb.delete(0, sb.length());

                            if ((map.get(slovo) == null) &&
                                    //тут подключаем/оключаем позитивныей и негативный листы
                                    CatalogPositive.getPositiveWord().contains(slovo) &&
                                    !CatalogNegative.getNegativeWord().contains(slovo)) {
                                map.put(slovo, 1);

                            } else if (map.get(slovo) != null) {
                                int newKey = map.get(slovo) + 1;
                                map.remove(slovo);
                                map.put(slovo, newKey);
                            }
                        }
                    }
                } finally {
                    in.close();
                }
            } catch (IOException e) {              // IO вперед FileNotFoundExc =)
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return map;
    }
}

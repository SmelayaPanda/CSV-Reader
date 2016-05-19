package start;

import reader.TxtFileReader;
import word.WordUnit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        ArrayList<WordUnit> list = new ArrayList<WordUnit>();

        TxtFileReader.readFile(args[0], map);

        WordUnit wordUnit = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordUnit = new WordUnit(entry.getKey(), entry.getValue());

            list.add(wordUnit);
        }
        Collections.sort(list, WordUnit::compareTo);

        for (WordUnit unit : list) {
            System.out.println(unit.toString());
        }
    }
}

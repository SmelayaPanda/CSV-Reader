package catalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CatalogPositive {
    public static Set getPositiveWord() {
        Set positiveSet = new HashSet<>();
        //1й способ, напрямую добавлять позитивные слова
        positiveSet.add("Java");
        positiveSet.add("My");
        positiveSet.add("You");
        positiveSet.add("Java");
        positiveSet.add("You");
        //2й способ - через текстовый файл, просто туда записывай слова
        MyCatalogReader.readCatalog("src/catalog/positive.txt", positiveSet);
        return positiveSet;
    }
}

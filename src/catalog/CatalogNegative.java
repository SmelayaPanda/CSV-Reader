package catalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CatalogNegative {


    public static Set getNegativeWord() {
        Set negativeSet = new HashSet<>();
        //1й способ, напрямую добавлять негатиные слова
        negativeSet.add("");
        negativeSet.add(" ");
        negativeSet.add("in");
        negativeSet.add("for");
        negativeSet.add("that");
        negativeSet.add("and");
        negativeSet.add("the");
        negativeSet.add("a");
        negativeSet.add("to");
        negativeSet.add("of");
        //2й способ - через текстовый файл, просто туда записывай слова
        MyCatalogReader.readCatalog("src/catalog/negative.txt", negativeSet);
        return negativeSet;
    }
}

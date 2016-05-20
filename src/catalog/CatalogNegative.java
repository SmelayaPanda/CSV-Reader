package catalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CatalogNegative {


    public static Set getNegativeWord() {
        Set negativeSet = new HashSet<>();
        //direct add
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


        MyCatalogReader.readCatalog("src/catalog/negative.txt", negativeSet);
        return negativeSet;
    }
}

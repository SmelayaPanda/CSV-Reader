package catalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Reader for CatalogPositive and Negative words
 */
public class MyCatalogReader {
    public static Set readCatalog(String fileName, Set setName) {
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
                            setName.add(slovo);
                            sb.delete(0, sb.length());

                        }
                    }
                } finally {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");

        }
        return setName;

    }
}


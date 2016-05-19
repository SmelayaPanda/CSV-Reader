package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TxtFileReader {
    public static Map readFile(String fileName, Map<String,Integer> map) {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();


        try {
            try {
                int s;
                int i = 0;
                while (((s = in.read()) != -1)) {

                    if (Character.isLetterOrDigit(s)) {
                        sb.append((char) s);
                    } else {
                        String slovo = String.valueOf(sb);
                        sb.delete(0, sb.length());
                        if (map.get(slovo) == null) {
                            map.put(slovo, 1);
                        } else {
                            int newKey = map.get(slovo) + 1;
                            map.remove(slovo);
                            map.put(slovo, newKey);
                            sb.delete(0, sb.length());
                        }
                        if ((char) s == '\n') {
                            sb.delete(0, sb.length());
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}


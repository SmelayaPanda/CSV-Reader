package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtFileReader {
    public static void readFile(String fileName){

        BufferedReader in = null;
        try {
            in = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[20];
        try {
            try {
                int s;
                int i = 0;
                while (((s = in.read()) != -1)) {

                    if (Character.isLetterOrDigit(s)) {
                        sb.append((char) s);
                    } else {
                        System.out.println(sb);
                        String slovo = String.valueOf(sb);
                        strings[i] = String.valueOf(slovo);
                        i++;
                        sb.delete(0, sb.length());
                    }
                    if ((char) s == '\n') {
                        sb.delete(0, sb.length());
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package word;

public class WordUnit implements Comparable<WordUnit> {

    private String word = null;
    private int count;

    public WordUnit(String wordNote, int count) {
        this.word = wordNote;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public int compareTo(WordUnit otherWord) {
        int c = otherWord.count -count;
        if (c != 0) {
            return c;
        } else {
            int nameDiff = word.compareTo(otherWord.getWord());
            return nameDiff;
        }
    }


    @Override
    public String toString() {
        return "WordUnit{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}

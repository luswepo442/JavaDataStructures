import java.util.LinkedList;

/**
 * Description: The implementation of WordList using a single LinkedList to store pairs of words and counts.
 * 
 * @author Luswepo Daniel Sinyinza
 * @version 3
 * 
 */
public class WordLinkedList extends WordList {
    private LinkedList<Pair<String, Integer>> wordCounts;

    /**
     * Public constructor method WordLinkedList
     */
    public WordLinkedList() {
        super();
        wordCounts = new LinkedList<>();
    }

    /**
     * Public method getWord
     *
     * @param inWord String
     * @return 0 if inWord not found, inWord count if found
     */
    @Override
    public int getWord(String inWord) {
        for (Pair<String, Integer> pair : wordCounts) {
            if (pair.getFirst().equals(inWord)) {
                return pair.getSecond();
            }
        }
        return 0;
    }

    /**
     * Public method existsWord
     *
     * @param inWord String
     * @return True if inWord exists in WordList
     */
    @Override
    public boolean existsWord(String inWord) {
        for (Pair<String, Integer> pair : wordCounts) {
            if (pair.getFirst().equals(inWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Public method addWord
     *
     * @param inWord String
     * @return 1 if inWord not found, incremented inWord count if found
     */
    @Override
    public int addWord(String inWord) {
        for (Pair<String, Integer> pair : wordCounts) {
            if (pair.getFirst().equals(inWord)) {
                super.incTotalAllWords();
                pair.setSecond(pair.getSecond() + 1);
                return pair.getSecond();
            }
        }
        super.incNumUniqueWords();
        super.incTotalAllWords();
        wordCounts.addLast(new Pair<>(inWord, 1));
        return 1;
    }

    /**
     * Public method incWord
     *
     * @param inWord String
     * @return 0 if inWord not found, incremented inWord count if found
     */
    @Override
    public int incWord(String inWord) {
        for (Pair<String, Integer> pair : wordCounts) {
            if (pair.getFirst().equals(inWord)) {
                super.incTotalAllWords();
                pair.setSecond(pair.getSecond() + 1);
                return pair.getSecond();
            }
        }
        return 0;
    }

    /**
     * Public method printWordList
     *
     * @param inMinimum int
     */
    @Override
    public void printWordList(int inMinimum) {
        System.out.println(super.toString());
        for (Pair<String, Integer> pair : wordCounts) {
            if (pair.getSecond() >= inMinimum) {
                System.out.println(pair.getFirst() + ":" + pair.getSecond());
            }
        }
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}

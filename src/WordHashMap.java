/**
 * Description: The implementation of WordList using HashMap.
 *
 * @author Luswepo Daniel Sinyinza
 * @version 2
 */
import java.util.HashMap;

/**
 * Description: The implementation of WordList using HashMap.
 * @author Luswepo Daniel Sinyinza
 * @version 4
 */
public class WordHashMap extends WordList {
    private HashMap<String, Integer> wordMap;

    /**
     * Public constructor method WordHashMap
     */
    public WordHashMap() {
        super();
        wordMap = new HashMap<>();
    }

    /**
     * Public method getWord
     *
     * @param inWord String
     * @return 0 if inWord not found, inWord count if found
     */
    @Override
    public int getWord(String inWord) {
        return wordMap.getOrDefault(inWord, 0);
    }

    /**
     * Public method existsWord
     *
     * @param inWord String
     * @return True if inWord exists in WordList
     */
    @Override
    public boolean existsWord(String inWord) {
        return wordMap.containsKey(inWord);
    }

    /**
     * Public method addWord
     *
     * @param inWord String
     * @return 1 if inWord not found, incremented inWord count if found
     */
    @Override
    public int addWord(String inWord) {
        int count = wordMap.getOrDefault(inWord, 0) + 1;
        wordMap.put(inWord, count);
        if (count == 1) {
            super.incNumUniqueWords();
        }
        super.incTotalAllWords();
        return count;
    }

    /**
     * Public method incWord
     *
     * @param inWord String
     * @return 0 if inWord not found, incremented inWord count if found
     */
    @Override
    public int incWord(String inWord) {
        int count = wordMap.getOrDefault(inWord, 0) + 1;
        wordMap.put(inWord, count);
        super.incTotalAllWords();
        return count;
    }

    /**
     * Public method printWordList
     *
     * @param inMinimum int
     */
    @Override
    public void printWordList(int inMinimum) {
        System.out.println(super.toString());
        for (String word : wordMap.keySet()) {
            int count = wordMap.get(word);
            if (count >= inMinimum) {
                System.out.println(word + ":" + count);
            }
        }
    }
}

import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

       try {
            List<Word> words = getTexts(inputStr);
            words = getWords(words);
            return buildResult(words);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private String buildResult(List<Word> words) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Word w : words) {
            String s = w.getText() + " " + w.getCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private List<Word> getWords(List<Word> words) {
        //get the map for the next step of sizing the same word
        Map<String, List<Word>> map = getListMap(words);

        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, List<Word>> entry : map.entrySet()) {
            Word word = new Word(entry.getKey(), entry.getValue().size());
            list.add(word);
        }
        words = list;

        words.sort((w1, w2) -> w2.getCount() - w1.getCount());
        return words;
    }

    private List<Word> getTexts(String inputStr) {
        //split the input string with 1 to n pieces of spaces
        String[] arr = inputStr.split("\\s+");

        List<Word> words = new ArrayList<>();
        for (String s : arr) {
            Word word = new Word(s, 1);
            words.add(word);
        }
        return words;
    }

    private Map<String, List<Word>> getListMap(List<Word> words) {
        Map<String, List<Word>> map = new HashMap<>();
        for (Word word : words) {
//       map.computeIfAbsent(word.getText(), k -> new ArrayList<>()).add(word);
            if (!map.containsKey(word.getText())) {
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                map.put(word.getText(), arr);
            } else {
                map.get(word.getText()).add(word);
            }
        }
        return map;
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

       try {
            return buildResult(getWords(getTexts(inputStr)));
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private String buildResult(List<Word> words) {
        return words.stream().sorted((w1, w2) -> w2.getCount() - w1.getCount()).map(w -> w.getText() + " " + w.getCount()).collect(Collectors.joining("\n"));
    }

    private List<Word> getWords(List<Word> words) {
        return getListMap(words).entrySet().stream().map(entry -> new Word(entry.getKey(), entry.getValue().size())).collect(Collectors.toList());
    }

    private List<Word> getTexts(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+")).map(s -> new Word(s, 1)).collect(Collectors.toList());
    }

    private Map<String, List<Word>> getListMap(List<Word> words) {
        return words.stream().collect(Collectors.groupingBy(Word::getText));
    }
}

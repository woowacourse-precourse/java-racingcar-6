package racingcar;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputValidator {
    public String validateInput(String input) {
        for (String word: divideByComma(input)) {
            if (!isCorrectLength(word) && !isAlphabetWord(word)) {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }

    private List<String> divideByComma(String input) {
        return List.of(input.split(","));
    }
    private boolean isCorrectLength(String word) {
        return word.length() <= 5;
    }

    private boolean isAlphabetWord(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}

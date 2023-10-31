package racingcar;

import java.util.List;

public class InputValidator {
    public String validateCarName(String input) {
        for (String word: divideByComma(input)) {
            if (!isCorrectCarNameLength(word) && !isAlphabetWord(word)) {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }

    private List<String> divideByComma(String input) {
        return List.of(input.split(","));
    }
    private boolean isCorrectCarNameLength(String word) {
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

    public int validateMatchCount(String s) {
        if (!(isCorrectMatchCountLength(s) && Character.isDigit(s.charAt(0)))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(s);
    }

    private boolean isCorrectMatchCountLength(String s) {
        return s.length() == 1;
    }
}

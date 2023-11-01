package racingcar.user;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static final String isNum = "^[1-9][0-9]*$";
    public static final String correctName = "^[0-9ㄱ-ㅎ가-힇A-Za-z]{1,5}";

    public void carNameCheck(String input) throws IllegalArgumentException {
        if (input.length() > 5) {
            throw new IllegalArgumentException();
        }
        if (!input.matches(correctName)) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicatedNameCheck(List<String> input) throws IllegalArgumentException {
        HashSet<String> duplicateCheck = new HashSet<>();
        for (String i : input) {
            if (!duplicateCheck.add(i)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void gameRoundCheck(String input) throws IllegalArgumentException {
        if (!input.matches(isNum)) {
            throw new IllegalArgumentException();
        }
    }
}

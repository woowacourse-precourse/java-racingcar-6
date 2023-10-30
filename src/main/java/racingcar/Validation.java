package racingcar;

import java.util.List;

public class Validation {
    public static boolean isNegative(int attemptNum) {
        if (attemptNum < 1) {
            return true;
        }
        return false;
    }

    public static boolean isNum(String input) {
        if (input.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBlank(String input) {
        if (input.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean isBlankContain(String input) {
        if (input.contains(" ")) {
            return true;
        }
        return false;
    }

    public static boolean isBlank(List<String> members) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).contains(" ")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicates(List<String> members, String input, int idx) {
        for (int i = idx + 1; i < members.size(); i++) {
            if (members.get(i).equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOverFiveWord(List<String> members) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).length() > 5) {
                return true;
            }
        }
        return false;
    }
}

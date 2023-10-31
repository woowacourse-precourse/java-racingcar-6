package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidInput {
    private ValidInput() {                      // 생성자
    }
    public static boolean isValidInput(String inputString) {
        if(true==hasComma(inputString));
        if(false==hasDoubleComma(inputString));
        if(false==startsOrEndsWithComma(inputString));
        return true;
    }
    public static boolean hasComma(String inputString) {
        return inputString.contains(",");
    }
    public static boolean hasDoubleComma(String inputString) {
        return inputString.contains(",,");
    }
    public static boolean startsOrEndsWithComma(String inputString) {
        if(inputString.startsWith(",")) {
            return true;
        }
        else if(inputString.endsWith(",")) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isNameLengthLessThanOrEqual5(List<String> NamesList) {
        for(String name : NamesList) {
            if(name.length() > 5) {
                return false;
            }
        }
        return true;
    }
    public static boolean hasDuplicateNames(List<String> NamesList) {
        Set<String> set = new HashSet<>(NamesList);
        if (set.size() == NamesList.size()) {
            return false;
        }
        else {
            return true;
        }
    }
}

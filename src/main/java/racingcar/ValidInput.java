package racingcar;

import java.util.List;

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

}

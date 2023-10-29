package racingcar;

import java.util.Arrays;
import java.util.List;

public class utils {
    public static List<String> convertToList(String value) {
        try {
            return Arrays.asList(value.split(","));
        } catch (Exception e){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    public static void checkCarNameUnderFiveLength(List<String> strings){
        for (String s: strings){
            if (s.length() > 5){
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }
        }
    }

    public static Integer convertToInteger(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }
}

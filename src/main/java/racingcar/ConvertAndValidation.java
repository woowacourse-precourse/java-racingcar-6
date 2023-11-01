package racingcar;

import java.util.Arrays;
import java.util.List;

public class ConvertAndValidation {
    public static List<String> convertToList(String value) {
        try {
            return Arrays.asList(value.split(","));
        } catch (Exception e){
            throw new IllegalArgumentException("올바른 입력값을 입력해주세요.");
        }
    }

    public static void checkCarName(List<String> strings){
        for (String name: strings){
            if(name.length() > 5){
                throw new IllegalArgumentException("올바른 입력값을 입력해주세요.");
            }
        }
    }

    public static int convertToInteger(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 입력값을 입력해주세요.");
        }
    }
}

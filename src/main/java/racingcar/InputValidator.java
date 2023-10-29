package racingcar;

import java.util.Arrays;

public class InputValidator {

    private static final int nameLength = 5;

    public static void checkNameLength(String[] names){
        if (Arrays.stream(names).anyMatch(name -> name.length() > nameLength)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다.");
        }
    }

    public static void checkNameNull(String[] names){
        if(Arrays.stream(names).anyMatch(name -> name.trim().isEmpty())){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public static String[] splitCarName(String name){
        return name.endsWith(",") ? name.split(",", -1) : name.split(",");
    }


}

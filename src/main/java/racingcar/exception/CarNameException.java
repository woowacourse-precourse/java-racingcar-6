package racingcar.exception;

import java.util.Arrays;

public class CarNameException {

    public static void carNameLengthException(String name){

        if (name.length() > 5 || name.length() < 1){
            throw new IllegalArgumentException("이름은 1이상 5이하의 길이만 가능합니다.");
        }

    }

    public static void carNameSameException(String[] name){

        String[] resultArr = Arrays.stream(name).distinct().toArray(String[]::new);
        for (int i = 0; i < name.length; i++) {
            name[i] = resultArr[i];
        }

    }

    public static void blankException(String name){
        for (int i = 0; i < name.length(); i++) {
            char check = name.charAt(i);
            if (check == ' '){
                throw new IllegalArgumentException("자동차 이름에는 공백이 들어갈 수 없습니다.");
            }
        }
    }
}

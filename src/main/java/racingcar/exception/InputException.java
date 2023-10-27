package racingcar.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException extends IllegalArgumentException {

    private static final int limitLength = 5;

    // 자동차 이름이 5자가 넘어갈 경우
    public static void limit(String[] carName){
        for(String name : carName){
            if(name.length() > limitLength){
                throw new IllegalArgumentException(" -> 이름은 5자 이하여야 합니다." );
            }
        }
    }

    // 자동차 이름을 구분하는 ','가 아닌 이외의 글자가 입력됐을 경우
    // 자동차 이름은 영어 대소문자, 한글만 입력 가능하다.
    public static void isValidInputFormat(String inputStr){
        if (!inputStr.matches("^[a-zA-Z가-힣,]+$")) {
            throw new IllegalArgumentException("올바른 형식의 입력이 아닙니다. ");
        }
    }

    // 이름이 중복되는 경우
    public static void sameName(String[] carName){
        Set<String> uniqueName = new HashSet<>();
        for (String name : carName) {
            if (!uniqueName.add(name)) {
                throw new IllegalArgumentException(name + " -> 이름이 중복됩니다. ");
            }
        }
    }

    // 자동차가 한 대만 입력된 경우



    // 횟수
    // 숫자가 아닌 경우
    public static void isNumber(int number){
        if (!String.valueOf(number).matches("\\d+")) {
            throw new IllegalArgumentException(number + " -> 숫자가 아닙니다. ");
        }
    }
}

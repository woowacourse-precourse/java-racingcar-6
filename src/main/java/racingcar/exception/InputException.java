package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException extends IllegalArgumentException {

    // 이름은 5글자 이하이다.
    private static final int LIMIT_LENGTH = 5;

    // 2대 이상의 carName이 입력되어야 한다.
    private static final int MIN_CARCOUNT = 2;


    // 자동차 이름이 5자가 넘어갈 경우
    public static void checkLimit(List<String> carNamesList){
        for(String name : carNamesList){
            if(name.length() > LIMIT_LENGTH){
                throw new IllegalArgumentException(" -> 이름은 5자 이하여야 합니다." );
            }
        }
    }

    // 입력되지 않은 경우
    public static void checkEmpty(List<String> carNamesList) {
        for (String carName : carNamesList) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
            }
        }
    }

    // 형식이 틀린 경우
        // 1. 자동차 이름을 구분하는 ','가 아닌 이외의 글자가 입력됐을 경우
        // 2. 자동차 이름은 영어 대소문자, 한글만 입력 가능하다.
    public static void checkFormat(List<String> carNamesList) {
        for (String carName : carNamesList) {
            if (!carName.matches("^[a-zA-Z가-힣]+$")) {
                throw new IllegalArgumentException("올바른 형식의 입력이 아닙니다. 자동차 이름은 영어 대소문자, 한글만 입력 가능합니다.");
            }
        }
    }

    // 자동차가 한 대만 입력된 경우
    public static void checkCarCount(List<String> carNamesList) {
        if (carNamesList.size() < MIN_CARCOUNT) {
            throw new IllegalArgumentException("적어도 두 대의 자동차 이름이 필요합니다.");
        }
    }

    // 이름이 중복되는 경우
    public static void checkSameName(List<String> carNamesList){
        Set<String> uniqueName = new HashSet<>();
        for (String name : carNamesList) {
            if (!uniqueName.add(name)) {
                throw new IllegalArgumentException(name + " -> 이름이 중복됩니다. ");
            }
        }
    }



    // 횟수
    // 숫자가 아닌 경우
    public static void isNotNumber(int number){

        if (!String.valueOf(number).matches("\\d+")) {
            throw new IllegalArgumentException(number + " -> 숫자만 입력해주세요.");
        }
    }

    // 0이거나 음수일 경우
    public static void isNotPositiveNumber(int count){
        if(count <= 0){
            throw new IllegalArgumentException(count + " -> 양의 정수만 입력해주세요. ");
        }
    }


}

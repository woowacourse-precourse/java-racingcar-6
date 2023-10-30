package racingcar.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.isLetterOrDigit;

public class UserInputException {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상, 5 이하로 입력해 주세요";
    private static final String BLANK_STRING_MESSAGE = "빈 문자를 입력하셨습니다.";
    private static final String DUPLICATE_MESSAGE = "자동차 이름은 중복되지 않게 입력해주세요";
    private static final String ONLY_COMMA = "구분자는 쉼표로만 작성해주세요";
    private static final String INPUT_MORE_THAN_TWO_CAR = "차를 두대 이상 입력해주세요";


    public static void isLength(String carName) {
        if(carName.length() > MAX_LENGTH || carName.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public static void isBlank(String carName) {
        if(carName.contains(" ")) {
            throw new IllegalArgumentException(BLANK_STRING_MESSAGE);
        }
    }

    public static void isDuplicate(String carName) {
        List<String> carNameList = Arrays.asList(carName.split(","));
        if(!(carNameList.size() == carNameList.stream().distinct().count())) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public static void isComma(String carName) {
        for (char c : carName.toCharArray())
        if(!isLetterOrDigit(c) && c != ','){
            throw new IllegalArgumentException(ONLY_COMMA);
        }
    }

    public static void isMoreThan(String carName) {
        List<String> carNameList = Arrays.asList(carName.split(","));
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException(INPUT_MORE_THAN_TWO_CAR);
        }
    }
}

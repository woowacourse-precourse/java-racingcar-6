package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private final static String CAR_NAME_LENGTH_ERROR = "자동차의 이름은 5글자 이하로 입력해야 합니다.";
    private final static String CAR_NAME_DUPLICATE_ERROR = "자동차의 이름이 중복되었습니다.";
    private final static int MAX_CAR_NAME_LENGTH = 5;

    public static List<String> validateCarNames(String input) {

        List<String> carNames = Arrays.asList(splitCarNames(input));

        if(!isNameLengthValid(carNames)){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
        if(!hasNoDuplicates(carNames)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
        return carNames;
    }

    private static String[] splitCarNames(String input) {
        return input.split(",");
    }

    private static boolean isNameLengthValid(List<String> carNames) {

        for (String carName : carNames) {
            if (carName.length() >= MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasNoDuplicates(List<String> carNames){
        return carNames.stream().distinct().count() >= carNames.size();
    }

}

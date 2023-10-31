package racingcar.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String CAR_NAMES_NULL_MESSAGE = "이름을 입력해주세요.";
    public static final String CAR_NAME_BLANK_MESSAGE = "빈 문자열은 입력이 불가능합니다.";
    public static final String CAR_NAME_WRONG_LENGTH_MESSAGE = "5자 이하만 가능합니다.";
    public static final int CAR_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNameList) {
        if(isContainsEmptyName(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_MESSAGE);
        }
        if(isNull(carNameList)){
            throw new IllegalArgumentException(CAR_NAMES_NULL_MESSAGE);
        }
        if(isOverLength(carNameList)) {
            throw new IllegalArgumentException(CAR_NAME_WRONG_LENGTH_MESSAGE);
        }
    }

    private static boolean isContainsEmptyName(List<String> carNameList) {
        if(carNameList == null) {
            return true;
        }
        return false;
    }

    private static boolean isOverLength(List<String> carNameList) {
        for(String name : carNameList) {
            if(name.length() > CAR_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNull(List<String> carNameList) {
        return carNameList.isEmpty();
    }
}

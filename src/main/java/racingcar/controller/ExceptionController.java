package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import racingcar.Constant;

public class ExceptionController {

    public static void carNameMaxLengthException(List<String> carNames) {
        for (String userCar : carNames) {
            if (userCar.length() > Constant.MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
    }

    public static void multiCommaException(List<String> carNames) {
        for (String userCar : carNames) {
            if (userCar.length() < Constant.MIN_CAR_NAME_SIZE) {
                throw new IllegalArgumentException("한 글자 이상의 자동차 이름을 입력해주세요. 연속된 ','를 입력할 수 없습니다.");
            }
        }
    }

    public static void carNameDuplicateException(Map<String, Integer> carPositionTable, List<String> carNames) {
        if (new HashSet<>(carNames).size() != carNames.size()) {
            if (carPositionTable.size() != carNames.size()) {
                throw new IllegalArgumentException("중복된 이름의 차량이 존재합니다.");
            }
        }
    }

    public static void stringBlankException(String carName) {
        if (carName.replaceAll("\\s", "").length() != carName.length()) {
            throw new IllegalArgumentException("공백을 제외한 문자열을 입력해주세요.");
        }
    }

    public static void tryCountLengthException(String tryCount) {
        if (tryCount.length() > Constant.MAX_TRY_COUNT_SIZE) {
            throw new IllegalArgumentException("한 자리의 숫자만 입력해주세요.");
        }
    }

    public static void tryCountNotIntException(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외에 다른 문자는 사용할 수 없습니다.");
        }
    }

    public static void specialCharactersException(String carName) {
        String checkSpecialChar = carName.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9,]", "");
        if (!checkSpecialChar.equals(carName)) {
            throw new IllegalArgumentException("한글, 영어, 숫자 외에 다른 특수 문자는 허용하지 않습니다.");
        }
    }

    public static void checkIsNotDuplicated(List<String> cars) {
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 차량이 존재합니다.");
        }
    }
}

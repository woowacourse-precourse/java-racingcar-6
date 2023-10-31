package racingcar.util;

import java.util.Arrays;
import java.util.List;

/**
 * 입력값 검증
 */
public class Verifier {
    /**
     * 차량 이름들 검증
     *
     * @param carNamesString 차량 이름 입력된 문자열
     */
    public static void verifyCarNamesString(String carNamesString) {
        if (carNamesString.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }
        if (carNamesString.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
        if (carNamesString.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름에 연속된 쉼표가 포함될 수 없습니다.");
        }
    }

    /**
     * 차량 이름 중복 검증
     *
     * @param carNames 차량 이름 배열
     */
    public static void verifyCarNameDuplication(String[] carNames) {
        List<String> uniqueCarNames = Arrays.stream(carNames)
                .distinct()
                .toList();
        if (uniqueCarNames.size() != carNames.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }


    /**
     * 차량 이름 검증
     *
     * @param carName 차량 이름
     */
    public static void verifyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}

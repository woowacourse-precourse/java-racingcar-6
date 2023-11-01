package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int CAR_MAX_LENGTH = 5;

    public static void checkDuplicateCarNames(String[] carNames) {
        List<String> carList = Arrays.asList(carNames);

        long duplicateCarCnt = carList.stream().distinct().count();

        if (duplicateCarCnt != carNames.length) {
            System.out.println("중복");
            throw new IllegalArgumentException("이름이 중복될 수 없습니다.");
        }
    }

    public static void checkInputCarNames(String carName) {
        checkCarNamesLength(carName);
        checkCarNamesEmpty(carName);
    }

    public static void checkInputNumberPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("숫자가 0보다 커야 합니다.");
        }
    }

    private static void checkCarNamesLength(String carName) {
        if (carName.length() > CAR_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5보다 크면 실행시킬 수 없습니다.");
        }
    }

    private static void checkCarNamesEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 실행시킬 수 있습니다.");
        }
    }
}

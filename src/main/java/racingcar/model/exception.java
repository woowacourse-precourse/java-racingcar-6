package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class exception {
    private static final String INPUT_SIZE_NAME_ERROR = "예외발생 : 자동차 이름은 1자이상 5자이하만 가능합니다.";
    private static final String INPUT_BLANK_NAME_ERROR = "예외발생 : 자동차 이름에 공백은 사용이 불가능합니다.";
    private static final String INPUT_DUPLICATE_NAME_ERROR = "예외발생 : 자동차 이름은 중복이 불가능합니다.";
    private static final String INPUT_NEED_ALL_CARS_ERROR = "예외발생 : 마지막 자동차 이름을 입력하지 않았습니다.";
    private static final String MIN_RACER_ERROR = "예외발생 : 자동차경주는 2명이상부터 가능합니다.";
    private static final String INPUT_ATTEMPT_INTEGER_ERROR = "예외발생 : 시도 횟수는 숫자여야 합니다.";
    private static final String INPUT_ATTEMPT_IS_POSSITIVE_ERROR = "예외발생 : 시도 횟수는 1이상의 양수여야 합니다.";
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_RACER = 2;
    private static final int MIN_ATTEMPT = 1;

    // #1. (자동차 이름 사이즈) 예외처리
    private static boolean isValidNameSize(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < MIN_NAME_SIZE || carName.length() > MAX_NAME_SIZE) {
                throw new IllegalArgumentException(INPUT_SIZE_NAME_ERROR);
            }
        }
        return true;
    }

    // #2. (자동차 이름 공백) 예외처리
    private static boolean isBlankCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException(INPUT_BLANK_NAME_ERROR);
            }
        }
        return false;
    }

    // #3. (자동차 이름 중복) 예외처리
    private static boolean isDuplicateName(String[] carNames) {
        Set<String> names = new HashSet<>(Arrays.asList(carNames));
        if (names.size() != carNames.length) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_NAME_ERROR);
        }
        return false;
    }

    // #4. (마지막 자동차 입력) 예외처리
    private static void isLastInput(String carNames) {
        if (',' == carNames.charAt(carNames.length() - 1)) {
            throw new IllegalArgumentException(INPUT_NEED_ALL_CARS_ERROR);
        }
    }

    // #5. (최소 레이싱 인원) 예외처리
    private static boolean isMinimumRacer(String[] cars) {
        if (cars.length < MIN_RACER) {
            throw new IllegalArgumentException(MIN_RACER_ERROR);
        }
        return true;
    }

    // # (올바른 자동차 이름인지) 예외처리
    public static String[] isValidCarNames(String inputCarNames) {

        isLastInput(inputCarNames);
        String[] carNames = inputCarNames.split(",");
        if (!isBlankCarName(carNames) && isValidNameSize(carNames) && !isDuplicateName(carNames)
                && isMinimumRacer(carNames)) {
            return carNames;
        }
        throw new IllegalArgumentException();
    }

    public static int isValidAttempt(String input) {
        int trial = isIntegerAttempt(input);
        if (isPossitiveNumber(trial)) {
            return trial;
        }
        throw new IllegalArgumentException();
    }

    // # 정수형의 시도 횟수인지 검사
    private static int isIntegerAttempt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ATTEMPT_INTEGER_ERROR);
        }
    }

    // # 양수의 시도 횟수인지 검사
    private static boolean isPossitiveNumber(int trial) {
        if (trial < MIN_ATTEMPT) {
            throw new IllegalArgumentException(INPUT_ATTEMPT_IS_POSSITIVE_ERROR);
        }
        return true;
    }
}

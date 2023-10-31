package racingcar.util;

import java.util.HashSet;
import java.util.List;

import static racingcar.util.Parser.parseCarNames;
import static racingcar.util.Parser.parseStringToInt;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int POSITIVE_NUMBER_MIN = 1;


    public void validateCarNames(String carNames){
        List<String> parsedCarNames = parseCarNames(carNames);
        validateCarNamesLength(parsedCarNames);
        validateCarNamesNotDuplication(parsedCarNames);
    }

    public void validateAttemptNumber(String attemptNumber) {
        validateInteger(attemptNumber);
        validatePositiveNumber(attemptNumber);
    }


    private void validateCarNamesLength(List<String> carNames) {
        if(carNames.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH ))
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 5이하여야 합니다.");
        if(carNames.stream().anyMatch(carName -> carName.length() < CAR_NAME_MIN_LENGTH))
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1이상여야 합니다.");

    }

    private void validateCarNamesNotDuplication(List<String> carNames) {
        HashSet<String> Set = new HashSet<>(carNames);
        if (Set.size() < carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복 되면 안됩니다.");
        }
    }

    private void validateInteger(String attemptNumber) {
        try {
            parseStringToInt(attemptNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 시도횟수는 정수여야합니다.");
        }
    }

    private void validatePositiveNumber(String attemptNumber) {
        if(parseStringToInt(attemptNumber) < POSITIVE_NUMBER_MIN)
            throw new IllegalArgumentException("[ERROR] 시도횟수는 양수여야합니다.");
    }
}

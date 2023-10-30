package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;


    public void validateCarNames(List<String> carNames){
        validateCarNamesLength(carNames);
        validateCarNamesNotNull(carNames);
        validateCarNamesNotDuplication(carNames);

    }

    public void validateAttemptNumber(String attemptNumber) {
        validateInteger(attemptNumber);
        validatePositiveNumber(attemptNumber);
    }

    private void validateCarNamesLength(List<String> carNames) {
        if(carNames.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH))
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 넘어갔습니다.");
    }

    private void validateCarNamesNotNull(List<String> carNames) {
        if(carNames.stream().anyMatch(Objects::isNull))
            throw new IllegalArgumentException("자동차의 이름이 null 입니다.");
    }

    private void validateCarNamesNotDuplication(List<String> carNames) {
        HashSet<String> Set = new HashSet<>(carNames);
        if (Set.size() < carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }

    private void validateInteger(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositiveNumber(String attemptNumber) {
        if(Integer.parseInt(attemptNumber) < 1)
            throw new IllegalArgumentException("시도횟수가 양수가 아닙니다.");
    }
}

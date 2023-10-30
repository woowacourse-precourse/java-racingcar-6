package racingcar.exception;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarException {
    private static final String NUMBER_PATTERN = "\\d";

    public void validateCarNameLength(String carName) {
        if(carName.length()>5) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateName(List<String> carNames) {
        int distinctCarNames = carNames.stream().distinct().collect(Collectors.toList()).size();
        if(carNames.size() != distinctCarNames) {
            throw new IllegalArgumentException();
        }
    }
    public void validateEmptyName(String carName) {
        if(carName.isBlank() || carName==null) {
            throw new IllegalArgumentException();
        }
    }
    public void validateNull(String answer) {
        if(answer==null) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePositiveNumber(String tryTime) {
        int tryTimeNumber = Integer.parseInt(tryTime);
        if(tryTimeNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }
    public void validateTryTime(String tryTime) {
        if(tryTime==null || !tryTime.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

}

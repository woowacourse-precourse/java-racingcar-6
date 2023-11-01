package racingcar.controller.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    private final StringParser stringParser = new StringParser();
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;

    public void validateCarNameInput(String input) throws IllegalArgumentException {
        checkIsEmpty(input);
        List<String> carNames = stringParser.splitCarNames(input);
        checkIsValidCarNameLength(carNames);
        checkHasOverlap(carNames);
    }

    public void checkIsEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력하세요");
        }
    }

    public void checkIsValidCarNameLength(List<String> carNames){
        for (String carName : carNames){
            throwExceptionIfTooLongLength(carName);
            throwExceptionIfTooShortLength(carName);
        }
    }

    public void throwExceptionIfTooShortLength(String carName) {
        if (CAR_NAME_MIN_LENGTH > carName.length()){
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상이어야 합니다.");
        }
    }

    public void throwExceptionIfTooLongLength(String carName) {
        if (CAR_NAME_MAX_LENGTH < carName.length()){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    public void checkHasOverlap(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
        }
    }

}

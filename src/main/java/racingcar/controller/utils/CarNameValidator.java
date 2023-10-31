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

    private void checkIsEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력하세요");
        }
    }

    private void checkIsValidCarNameLength(List<String> carNames){
        for (String carName : carNames){
            if (CAR_NAME_MAX_LENGTH < carName.length()){
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
            }
            if (CAR_NAME_MIN_LENGTH > carName.length()){
                throw new IllegalArgumentException("자동차의 이름은 1글자 이상이어야 합니다.");
            }
        }
    }

    private void checkHasOverlap(List<String> carNames) {
        Set<String> UniqueNames = new HashSet<>();
        for (String carName : carNames) {
            if (!UniqueNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
            }
        }
    }

}

package racingcar.manager;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static final int MAXIMUM_CAR_NAME = 5;
    public static final String BLANK = " ";

    public int validateGameRound(String input) throws IllegalArgumentException {
        return Integer.parseInt(input);
    }

    public void validateCarName(String carName) {
        validateCarNameLength(carName);
        throwErrorIfCarNameHasBlank(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAXIMUM_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름의 길이 5보다 큽니다.");
        }
    }

    private void throwErrorIfCarNameHasBlank(String carName){
        if (isCarNameContainsBlank(carName)){
            throw new IllegalArgumentException("자동차 이름에 공백이 존재합니다.");
        }
    }

    private boolean isCarNameContainsBlank(String carName) {
        return carName.contains(BLANK);
    }

    public void validateCarNamesDuplicated(String[] cars) {
        Set<String> uniqueCars = new HashSet<>();
        for (String car: cars){
            if (isCarNameExist(car, uniqueCars)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다: " + car);
            }
        }
    }

    private boolean isCarNameExist(String car, Set<String> uniqueCars) {
        return !uniqueCars.add(car);
    }
}
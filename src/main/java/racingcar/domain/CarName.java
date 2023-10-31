package racingcar.domain;

import racingcar.validator.Validator;

/*
 *   자동차의 이름 정보를 담당
 * */

public class CarName {
    
    public static final int MIN_NAME_SIZE = 1;
    public static final int MAX_NAME_SIZE = 5;
    public static final String NAME_REGEX = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";

    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        Validator.commandLengthInRange(name, MIN_NAME_SIZE, MAX_NAME_SIZE);
        Validator.commandFollowRegex(name, NAME_REGEX);
    }

    public String getValue() {
        return name;
    }
}

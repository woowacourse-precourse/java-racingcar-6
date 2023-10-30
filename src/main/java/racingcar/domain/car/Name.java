package racingcar.domain.car;

import racingcar.exception.ErrorMessage;

public class Name {
    private final static int MAX_NAME_SIZE = 5;
    private final static int MIN_NAME_SIZE = 0;
    private final String  value;

    public Name(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MAX_LENGTH);
        }
        if(name.length() == MIN_NAME_SIZE){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MIN_LENGTH);
        }
        this.value = name;
    }

    public String getValue() {
        return value;
    }

}

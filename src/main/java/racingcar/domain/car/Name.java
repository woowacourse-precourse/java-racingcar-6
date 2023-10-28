package racingcar.domain.car;

import racingcar.exception.ErrorMessage;

public class Name {
    private final static int NAME_SIZE = 5;
    private final String  value;

    public Name(String name) {
        if (name.length() > NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MAX_LENGTH);
        }
        if(name.length() == 0){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MIN_LENGTH);
        }
        this.value = name;
    }

    public String getValue() {
        return value;
    }

}

package racingcar.model;

import static racingcar.view.ExceptionMessage.NOT_NULL;
import static racingcar.view.ExceptionMessage.NOT_OVER_FIVE;
import static racingcar.view.ExceptionMessage.NOT_KOREAN_OR_ENGLISH;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_LENGTH = 1;
    private String name;
    private int location = 0;

    // TODO validate 분리
    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NOT_NULL.getMessage());
        }
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(NOT_OVER_FIVE.getMessage());
        }
        if (!name.matches("^[a-zA-Z가-힣]*$")) {
            throw new IllegalArgumentException(NOT_KOREAN_OR_ENGLISH.getMessage());
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goOrStop(int i) {
        if(i>3) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}

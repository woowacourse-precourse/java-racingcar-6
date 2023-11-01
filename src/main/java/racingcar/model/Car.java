package racingcar.model;

import static racingcar.view.ExceptionMessage.NOT_NULL;
import static racingcar.view.ExceptionMessage.NOT_OVER_FIVE;
import static racingcar.view.ExceptionMessage.NOT_KOREAN_OR_ENGLISH;
import static racingcar.view.OutputView.LOCATION_AND_NAME_DELIMITER;

import racingcar.view.ExceptionMessage;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_LENGTH = 1;
    private String name;
    private int location = 0;
    public static final String LOCATION = "-";

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        String result = name + LOCATION_AND_NAME_DELIMITER;
        for (int i = 0; i < location; i++) {
            result += LOCATION;
        }
        return result;
    }

    private static void validateName(String name) {
        checkConditionAndThrow(name == null, NOT_NULL);
        checkConditionAndThrow(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH, NOT_OVER_FIVE);
        checkConditionAndThrow(!name.matches("^[a-zA-Z가-힣]*$"), NOT_KOREAN_OR_ENGLISH);
    }

    private static void checkConditionAndThrow(boolean condition, ExceptionMessage message) {
        if (condition) {
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void goOrStop(int i) {
        if (i > 3) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}

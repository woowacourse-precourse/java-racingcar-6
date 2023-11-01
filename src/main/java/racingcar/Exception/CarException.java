package racingcar.Exception;

import static racingcar.Message.ExceptionMessage.NULL_ERROR;

import java.util.*;
import racingcar.Message.ExceptionMessage;

public class CarException {
    private Set<String> nameSet;
    private final StringBuilder carNames = new StringBuilder();

    public String checkExceptionCar(String names) {
        if (names == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
        nameSet = new HashSet<>();
        String[] cars = checkNameCount(names);
        for (String car : cars) {
            if (validateName(car)) {
                checkFiveWords(car);
                checkSpaceWords(car);
                isSameName(car);
            }
            carNames.append(car).append(",");
        }
        return carNames.toString();
    }

    public String[] checkNameCount(String names) {
        if (Arrays.stream(names.split(",")).count() <= 1) {
            throw new IllegalArgumentException(ExceptionMessage.ONE_CAR_ERROR);
        }
        return names.split(",", -1);
    }

    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.NOTHING_ERROR);
        }
        return true;
    }

    public void checkFiveWords(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.FIVE_LENGTH_ERROR);
        }
    }

    public void checkSpaceWords(String name) {
        if (name.contains(" ") || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessage.IS_SPACE_ERROR);
        }
    }

    public void isSameName(String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(ExceptionMessage.SAME_NAME_ERROR);
        }
    }

}

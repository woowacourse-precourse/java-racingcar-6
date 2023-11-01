package racingcar.exception;

import static racingcar.util.ErrorMessage.ERROR_NOT_EMPTY;
import static racingcar.util.ErrorMessage.ERROR_WRONG_CARS_NAME;
import static racingcar.util.ErrorMessage.ERROR_WRONG_CAR_NAME;
import static racingcar.util.ErrorMessage.ERROR_WRONG_NUMBER_OF_RACE;

public class ExceptionManager {

    public static final int MAX_NUM_OF_CAR_NAME = 5;
    public static final String RIGHT_NUM_OF_RACE = "[1-9]\\d*";

    public void checkCarsNameException(String namesOfCars) {
        isEmpty(namesOfCars);
        isEndWithComma(namesOfCars);
    }

    public void checkCarNameException(String[] arrayOfCarName) {
        for (String eachName : arrayOfCarName) {
            isEmpty(eachName);
            isRightSize(eachName);
        }
    }

    public void checkNumberOfRace(String numberOfRace) {
        isEmpty(numberOfRace);
        isRightNumber(numberOfRace);
    }

    private void isEmpty(String inputValue) {
        if (inputValue.equals("")) {
            throw new IllegalArgumentException(ERROR_NOT_EMPTY);
        }
    }

    private void isEndWithComma(String namesOfCars) {
        if (namesOfCars.charAt(namesOfCars.length() - 1) == ',') {
            throw new IllegalArgumentException(ERROR_WRONG_CARS_NAME);
        }
    }

    private void isRightSize(String eachName) {
        if (eachName.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_WRONG_CAR_NAME);
        }
    }

    private void isRightNumber(String numberOfRace) {
        if (!numberOfRace.matches(RIGHT_NUM_OF_RACE)) {
            throw new IllegalArgumentException(ERROR_WRONG_NUMBER_OF_RACE);
        }
    }
}
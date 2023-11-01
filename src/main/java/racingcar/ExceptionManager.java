package racingcar;

import static racingcar.ErrorMessage.ERROR_NOT_EMPTY;
import static racingcar.ErrorMessage.ERROR_WRONG_CARS_NAME;
import static racingcar.ErrorMessage.ERROR_WRONG_CAR_NAME;
import static racingcar.ErrorMessage.ERROR_WRONG_NUMBER_OF_RACE;

public class ExceptionManager {

    public static final int MAX_NUM_OF_CAR_NAME = 5;
    public static final String RIGHT_NUM_OF_RACE = "[1-9]\\d*";

    public void checkCarsNameException(String carsName) {
        isEmpty(carsName);
        isEndWithComma(carsName);
    }

    public void checkCarNameException(String[] carName) {
        for (String eachName : carName) {
            isEmpty(eachName);
            isRightSize(eachName);
        }
    }

    public void checkNumberOfRace(String st) {
        isEmpty(st);
        isRightNumber(st);
    }

    private void isEmpty(String eachName) {
        if (eachName.equals("")) {
            throw new IllegalArgumentException(ERROR_NOT_EMPTY);
        }
    }

    private void isEndWithComma(String carsName) {
        if (carsName.charAt(carsName.length() - 1) == ',') {
            throw new IllegalArgumentException(ERROR_WRONG_CARS_NAME);
        }
    }

    private void isRightSize(String eachName) {
        if (eachName.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_WRONG_CAR_NAME);
        }
    }

    private void isRightNumber(String st) {
        if (!st.matches(RIGHT_NUM_OF_RACE)) {
            throw new IllegalArgumentException(ERROR_WRONG_NUMBER_OF_RACE);
        }
    }
}
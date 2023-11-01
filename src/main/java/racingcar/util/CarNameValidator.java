package racingcar.util;

import static racingcar.exception.ExceptionMessage.CAR_NAME_IS_BLANK;
import static racingcar.exception.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.exception.ExceptionMessage.EMPTY_CARS;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.WRONG_CARS_NAME;

import java.util.ArrayList;

public class CarNameValidator {
    public final ArrayList<String> NAMES;
    public static final int NAME_SIZE = 5;

    public CarNameValidator(String namesString) {
        this.NAMES = Util.toArrayList(namesString);
        validate();
    }

    public void validate() {
        isNotDuplicate();
        isBlank();
        isRightNameSize();
        isNotRightName();
    }

    public void isNotDuplicate() {
        long duplicateSize = NAMES.stream()
                .distinct()
                .count();
        if (NAMES.size() != duplicateSize) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public void isBlank() {
        for (String name : NAMES) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(EMPTY_CARS.getMessage());
            }
        }
    }

    public void isRightNameSize() {
        for (String name : NAMES) {
            if (name.length() > NAME_SIZE) {
                throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
            }
            if (name.length() == 0) {
                throw new IllegalArgumentException(CAR_NAME_IS_BLANK.getMessage());
            }
        }
    }

    public void isNotRightName() {
        for (String name : NAMES) {
            if (name.matches("[-+]?\\d*\\.?\\d+")) {
                throw new IllegalArgumentException(WRONG_CARS_NAME.getMessage());
            }
        }
    }

}

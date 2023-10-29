package racingcar.domain.wrapper;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.handler.ConstantsHandler.VALID_CAR_NAMES_LENGTH;
import static racingcar.handler.ErrorHandler.*;

public class CarName {

    private final String carName;
    private static final Set<String> createdNames = new HashSet<>();

    private CarName(final String carName) {
        validateCarName(carName);
        validateDuplicate(carName);
        validateLength(carName);

        this.carName = carName;
    }

    public static CarName create(final String carName) {
        return new CarName(carName);
    }

    public void validateCarName(String carName) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]+$";

        if (!Pattern.matches(regex, carName)) {
            throw INVALID_ENGLISH_KOREAN.getException();
        }
    }

    public void validateDuplicate(String carName) {
        if (createdNames.contains(carName)) {
            throw DUPLICATE_NUMBER.getException();
        }

        createdNames.add(carName);
    }

    public void validateLength(String carName) {
        if (carName.length() > VALID_CAR_NAMES_LENGTH) {
            throw INVALID_LENGTH.getException();
        }
    }

    public String getCarName() {
        return carName;
    }
}

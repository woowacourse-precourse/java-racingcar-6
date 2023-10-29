package racingcar.domain.wrapper;

import java.util.regex.Pattern;

import static racingcar.handler.ConstantsHandler.VALID_CAR_NAMES_LENGTH;
import static racingcar.handler.ErrorHandler.INVALID_ENGLISH_KOREAN;
import static racingcar.handler.ErrorHandler.INVALID_LENGTH;

public class CarName {

    private final String carName;

    private CarName(final String carName) {
        validateCarName(carName);
        validateLength(carName);

        this.carName = carName;
    }

    public static CarName create(final String carName) {
        return new CarName(carName);
    }

    private void validateCarName(String carName) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]+$";

        if (!Pattern.matches(regex, carName)) {
            throw INVALID_ENGLISH_KOREAN.getException();
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > VALID_CAR_NAMES_LENGTH) {
            throw INVALID_LENGTH.getException();
        }
    }

    public String getCarName() {
        return carName;
    }
}

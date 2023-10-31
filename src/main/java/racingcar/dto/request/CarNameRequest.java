package racingcar.dto.request;

import racingcar.exception.UserInputException;

import static racingcar.config.GameConfig.MAX_CAR_NAME_LENGTH;
import static racingcar.exception.errorcode.UserInputErrorCode.INVALID_CAR_NAME_LENGTH;

public class CarNameRequest {
    private final String name;

    public CarNameRequest(final String name) {
        validateNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validateNameSize(final String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new UserInputException(INVALID_CAR_NAME_LENGTH);
        }
    }
}

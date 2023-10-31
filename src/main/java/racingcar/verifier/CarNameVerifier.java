package racingcar.verifier;

import racingcar.system.ExceptionMessage;
import racingcar.system.SystemConstant;

import java.util.Arrays;
import java.util.List;

public class CarNameVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(input.split(","));
        checkCarNameLength(carNames);
    }

    private void checkCarNameLength(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.length() > SystemConstant.MAX_CAR_NAME_LENGTH)
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME);
        });
    }
}

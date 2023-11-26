package racingcar.verifier;

import racingcar.system.ExceptionMessage;
import racingcar.system.SystemConstant;

import java.util.Arrays;
import java.util.List;

public class CarNameVerifier implements Verifier<String> {
    @Override
    public void validate(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNameLength(carNames);
    }

    private void validateCarNameLength(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.isEmpty() || carName.length() > SystemConstant.MAX_CAR_NAME_LENGTH) {
                Verifier.throwIllegalArgumentError(ExceptionMessage.INVALID_CAR_NAME);
            }
        });
    }
}

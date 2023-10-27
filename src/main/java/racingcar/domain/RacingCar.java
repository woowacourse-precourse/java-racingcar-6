package racingcar.domain;

import java.util.List;
import java.util.regex.Pattern;

import static racingcar.handler.ErrorHandler.INVALID_ENGLISH_KOREAN;

public class RacingCar {

    private final List<String> carNames;

    public RacingCar(List<String> carNames) {
        validateCarName(carNames);

        this.carNames = carNames;
    }

    public void validateCarName(List<String> carNames) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]+$";

        for (String carName : carNames) {
            if (!Pattern.matches(regex, carName)) {
                throw INVALID_ENGLISH_KOREAN.getException();
            }
        }
    }
}

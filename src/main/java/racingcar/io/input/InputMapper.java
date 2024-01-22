package racingcar.io.input;

import org.springframework.stereotype.Component;
import racingcar.model.Cars;

@Component
public class InputMapper {

    public Cars toCars(String carNames) {
        return new Cars(carNames);
    }

    public int toInt(String attemptCount) {
        return Integer.parseInt(attemptCount);
    }
}

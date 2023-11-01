package racingcar.view;
import static racingcar.domain.Verification.checkEqualsAndThrowException;
import static racingcar.domain.Verification.throwCarNameLengthException;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
public class Output {

    public static List<String> carName(String input) {
        List<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            carNames.add(name);
            throwCarNameLengthException(name);
            checkEqualsAndThrowException(carNames);
        }
        return carNames;
    }

    
}

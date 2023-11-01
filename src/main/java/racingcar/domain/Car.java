package racingcar.domain;

import static racingcar.domain.Verification.checkEqualsAndThrowException;
import static racingcar.domain.Verification.throwCarNameLengthException;

import java.util.ArrayList;
import java.util.List;

public class Car {

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

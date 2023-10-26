package racingcar.util;

import racingcar.domain.Car;

public class Parser {
    public static Car parseStringToCar(String input) {
        return Car.nameOf(input);
    }

}

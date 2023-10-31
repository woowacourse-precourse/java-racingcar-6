package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.enums.Separator;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> generateParticipationCarList(String input) {
        return Arrays.stream(input.split(Separator.COMMA.toString()))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}

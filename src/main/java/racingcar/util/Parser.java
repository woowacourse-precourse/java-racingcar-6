package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;


public class Parser {
    public static List<Car> parseStringToCars(String input) {
        List<String> carNames = Separator.separateByDelimeter(input);
        return carNames.stream()
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(name -> new Car(new CarName(name), new CarPosition(0)))
                .collect(Collectors.toList());
    }

}

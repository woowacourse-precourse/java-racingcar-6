package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Attempts;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;


public class Parser {
    public static Cars parseStringToCars(String input) {
        List<String> carNames = Separator.separateByDelimeter(input);
        List<Car> cars = carNames.stream()
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(name -> new Car(new CarName(name), new CarPosition(0)))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public static Attempts parseStringToAttempts(String input) {
        try {
            return new Attempts(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

}

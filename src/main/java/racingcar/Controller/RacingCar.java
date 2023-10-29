package racingcar.Controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.View.InputView;

public class RacingCar {
    public static void run() {

        List<String> carNames = InputView.readCarNames();
        List<Car> cars = initializeCars(carNames);

    }

    public static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return cars;
    }

}

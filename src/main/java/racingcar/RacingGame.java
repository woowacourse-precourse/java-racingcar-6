package racingcar;

import racingcar.Car.Car;
import racingcar.Car.CarFactory;
import racingcar.User.User;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public static void run() {
        List<Car> cars = createCarsByInput();

    }

    private static List<Car> createCarsByInput() {
        List<String> carNames = Arrays.asList(User.carNameInput().split(","));
        return CarFactory.createByNames(carNames);
    }

}

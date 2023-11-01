package racingcar;

import racingcar.Car.Car;
import racingcar.Car.CarFactory;
import racingcar.User.User;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public static void run() {
        List<Car> cars = createCarsByInput();

        int turnCount = turnCountByInput();

    }

    private static List<Car> createCarsByInput() {
        List<String> carNames = Arrays.asList(User.carNameByUserInput().split(","));
        return CarFactory.createByNames(carNames);
    }

    private static int turnCountByInput() {
        int turnCount = User.turnCountByUserInput();
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car.Car;
import racingcar.Car.CarFactory;
import racingcar.User.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static void run() {
        List<Car> cars = createCarsByInput();

        int turnCount = turnCountByInput();
        for (; turnCount > 0; turnCount--) {
            play(cars);
        }
    }

    private static List<Car> createCarsByInput() {
        List<String> carNames = Arrays.asList(User.carNameByUserInput().split(","));
        return CarFactory.createByNames(carNames);
    }

    private static int turnCountByInput() {
        int turnCount = User.turnCountByUserInput();
    }

    private static List<Car> play(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.moveByRandomNumber(Randoms.pickNumberInRange(0, 9));
                    return car;
                })
                .collect(Collectors.toList());
    }

    private static void printTurnResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveDistance()));
        }
        System.out.println();
    }

    private static void printFinalResult(List<Car> cars) {
        int maxDistance = cars.stream()
                .map(Car::getMoveDistance)
                .max(Comparator.naturalOrder())
                .orElse(0);

        String result = cars.stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println("최종 우승자 : " + result);
    }
}

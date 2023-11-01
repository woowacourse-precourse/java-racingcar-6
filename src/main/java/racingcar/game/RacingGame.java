package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.Car.Car;
import racingcar.game.Car.CarFactory;
import racingcar.User.User;
import racingcar.view.View;

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
        return turnCount;
    }

    private static List<Car> play(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.moveByRandomNumber(Randoms.pickNumberInRange(0, 9));
                    return car;
                })
                .collect(Collectors.toList());
    }

    private static View printTurnResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(car.getMoveDistance()));
            stringBuilder.append("\n");
        }
        return new View(stringBuilder.toString());
    }

    private static View printFinalResultView(List<Car> cars) {
        int maxDistance = cars.stream()
                .map(Car::getMoveDistance)
                .max(Comparator.naturalOrder())
                .orElse(0);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종우승자");

        cars.stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                        .forEach(car -> stringBuilder.append(car.getName()));

        return new View(stringBuilder.toString());
    }
}

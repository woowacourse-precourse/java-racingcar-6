package racingcar.domain.cars;

import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;

public class Winners {

    private static final String ERROR_MESSAGE_CANNOT_FIND_WINNER = "우승자를 찾을 수 없습니다.";
    private static final String WINNERS_MESSAGE_FORMAT = "최종 우승자 : %s";

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners judge(Players players) {
        List<Car> cars = players.cars();

        Car winner = findWinner(cars);

        List<Car> winningCars = cars.stream()
            .filter(car -> car.isSameDistance(winner))
            .toList();

        return new Winners(winningCars);
    }

    private static Car findWinner(List<Car> cars) {
        return cars.stream()
            .max(Comparator.comparing(Car::movement))
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_CANNOT_FIND_WINNER));
    }

    @Override
    public String toString() {
        List<String> carsName = cars.stream()
            .map(Car::name)
            .toList();
        String winnersName = String.join(", ", carsName);
        return String.format(WINNERS_MESSAGE_FORMAT, winnersName);
    }
}

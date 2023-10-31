package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.domain.car.Car;

public class Winners {
    private static final String NO_CAR_EXCEPTION_MESSAGE = "Error: 경주에 참여한 자동차가 없습니다.";

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners create(List<Car> racingCars) {
        return new Winners(findWinners(racingCars));
    }

    private static List<Car> findWinners(List<Car> racingCars) {
        Car winner = findWinner(racingCars);

        return racingCars.stream()
                .filter(winner::isSamePosition)
                .toList();
    }

    private static Car findWinner(List<Car> racingCars) {
        return racingCars.stream()
                .max(Car.COMPARATOR_BY_POSITION)
                .orElseThrow(() -> new IllegalArgumentException(NO_CAR_EXCEPTION_MESSAGE));
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}

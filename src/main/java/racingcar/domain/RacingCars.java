package racingcar.domain;

import java.util.List;
import racingcar.views.OutputView;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void MovingCars() {
        for (Car car : racingCars) {
            car.tryAddMove();
        }
    }

    public void racingCarResultPrint() {
        for (Car car : racingCars) {
            OutputView.racingCarResultPrint(car.getName(), car.getMovePosition());
        }
        OutputView.println();
    }

    public String[] getRacingWinners() {
        int maxDistance = getMaxDistance();

        return racingCars.stream()
                .filter(car -> car.carEqualsMaxDistance(maxDistance))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .orElseGet(() -> 0);
    }
}

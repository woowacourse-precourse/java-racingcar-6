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
}

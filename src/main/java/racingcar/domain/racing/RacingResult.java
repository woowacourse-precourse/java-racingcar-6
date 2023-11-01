package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

public class RacingResult {

    private RacingCars cars;

    public RacingResult(RacingCars cars) {
        this.cars = cars;
    }

    public List<String> getFinalWinnerList() {
        int maxPosition = cars.getMaxPosition();

        return cars
                .getCars()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .toList();
    }
}

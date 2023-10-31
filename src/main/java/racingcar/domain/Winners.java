package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int FOR_LAST_INDEX_CHECK = 1;
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners of(Cars cars) {
        return new Winners(
                cars.getCarList().stream()
                .filter(car -> (car.getAdvanceCount() == AdvanceCount.maxCount))
                .collect(Collectors.toList())
        );
    }

    public boolean isLastCar(Car car) {
        if ((winners.indexOf(car) + FOR_LAST_INDEX_CHECK) == this.winners.size()) {
            return true;
        }
        return false;
    }

    public List<Car> getWinners() {
        return this.winners;
    }
}

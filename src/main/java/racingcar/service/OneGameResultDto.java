package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OneGameResultDto {
    private final List<String> names;
    private final List<Long> totalMoveCounts;

    public OneGameResultDto(final List<Car> cars) {
        this.names = mappingToNames(cars);
        this.totalMoveCounts = mappingToMoveCounts(cars);
    }

    private List<String> mappingToNames(List<Car> endCars) {
        List<String> names = new ArrayList<>();
        for (Car endCar : endCars) {
            names.add(endCar.getName());
        }
        return names;
    }

    private List<Long> mappingToMoveCounts(List<Car> endCars) {
        List<Long> moveCounts = new ArrayList<>();
        for (Car endCar : endCars) {
            moveCounts.add(endCar.getTotalMoveCount());
        }
        return moveCounts;
    }
}

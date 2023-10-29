package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OneGameResultDto {
    private final List<String> names;

    public OneGameResultDto(final List<Car> cars) {
        this.names = mappingToNames(cars);
    }

    private List<String> mappingToNames(List<Car> endCars) {
        List<String> names = new ArrayList<>();
        for (Car endCar : endCars) {
            names.add(endCar.getName());
        }
        return names;
    }
}

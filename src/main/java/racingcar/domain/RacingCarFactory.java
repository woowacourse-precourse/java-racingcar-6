package racingcar.domain;

import racingcar.domain.interfaces.Car;
import racingcar.domain.interfaces.CarFactory;

import java.util.List;

public class RacingCarFactory implements CarFactory {
    @Override
    public List<Car> createCars(int count) {
        return null;
    }
}

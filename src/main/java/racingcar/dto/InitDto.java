package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class InitDto {
    private final List<Car> cars;
    private final int times;

    public InitDto(List<Car> cars, int times) {
        this.cars = cars;
        this.times = times;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }

}

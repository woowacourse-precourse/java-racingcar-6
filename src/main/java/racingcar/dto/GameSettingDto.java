package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class GameSettingDto {
    private final List<Car> cars;
    private final int times;

    public GameSettingDto(List<Car> cars, int times) {
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

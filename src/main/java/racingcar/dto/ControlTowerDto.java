package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public class ControlTowerDto {
    private final List<Car> cars;
    private final int roundNumber;

    public ControlTowerDto(List<Car> cars, int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}

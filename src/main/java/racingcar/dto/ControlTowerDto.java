package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.ControlTower;

public class ControlTowerDto {
    private List<Car> cars;
    private int roundNumber;

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

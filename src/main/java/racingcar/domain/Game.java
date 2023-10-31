package racingcar.domain;

import java.util.List;
import racingcar.dto.CarsDTO;

public class Game {

    private List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public CarsDTO getCarsDTO() {
        return new CarsDTO(cars);
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

}

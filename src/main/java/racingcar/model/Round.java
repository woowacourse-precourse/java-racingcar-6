package racingcar.model;

import racingcar.DTO.CarDTO;

import java.util.List;

public class Round {
    private List<CarDTO> roundResult;

    protected void startRace(List<Car> cars) {
        cars.forEach(Car::startEngine);
    }
}

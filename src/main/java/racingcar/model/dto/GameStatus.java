package racingcar.model.dto;

import racingcar.model.Car;

public record GameStatus(String name, Long position) {

    public static GameStatus fromCar(Car car) {
        return new GameStatus(car.getName(), car.getPosition());
    }
}

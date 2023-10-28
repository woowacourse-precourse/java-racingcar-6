package racingcar.model.dto;

import java.util.Map;
import racingcar.model.Car;

public record GameStatus(Map<String, Long> positions) {

    public static GameStatus fromCar(Car car) {
        return new GameStatus(Map.of(car.getName(), car.getPosition()));
    }
}

package racingcar.dto;

import racingcar.model.Car;

public class CarInfo {

    private final String name;
    private final Integer moveCount;

    private CarInfo(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public static CarInfo from(Car car) {
        return new CarInfo(car.getName(), car.getMoveCount());
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}

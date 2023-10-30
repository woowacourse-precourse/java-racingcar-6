package racingcar.dto;

import racingcar.domain.car.Car;

public class PrintCarDetailsDto {

    private String name;
    private int moveCount;

    public PrintCarDetailsDto(Car car) {
        name = car.getName();
        moveCount = car.getMoveCount();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}

package controller.dto;

import model.Car;

public record MoveResult(String carName, int moveCount) {

    public static MoveResult from(final Car car) {
        return new MoveResult(car.getNameValue(), car.getMoveCountValue());
    }
}

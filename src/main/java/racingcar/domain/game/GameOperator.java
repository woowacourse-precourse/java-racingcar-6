package racingcar.domain.game;


import racingcar.domain.car.Cars;

public interface GameOperator {
    Cars generateCars();

    int setTrial();

    void print(String msg);
}

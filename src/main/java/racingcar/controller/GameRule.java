package racingcar.controller;

import racingcar.model.Car;

public interface GameRule {
    void playRound();

    void progressCar(Car car, int randomNumber);

    String calculateWinner();
}

package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RaceGameService {

    Car startGame(List<String> input);
    void race(Car car);
    List<Integer> findWinner(Car car);
}

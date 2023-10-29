package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RaceGameService {

    public Car startGame(List<String> input);
    public void carMoveCheckAndGo(Car car);
    public List<Integer> findWinner(Car car);
}

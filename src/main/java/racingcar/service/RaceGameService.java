package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RaceGameService {

    public void carMoveCheckAndGo(Car car);
    public List<Integer> findWinner(Car car);
}

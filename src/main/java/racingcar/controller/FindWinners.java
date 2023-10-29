package racingcar.controller;

import racingcar.model.Car;

import java.util.List;

public interface FindWinners {

    public List<String> getWinner(List<Car> cars);

}

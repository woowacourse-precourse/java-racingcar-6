package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public class RaceGameServiceImpl implements RaceGameService{


    @Override
    public Car startGame(List<String> input) {
        Car car = new Car();
        car.initCar(input);
        return car;
    }

    @Override
    public void race(Car car) {
        car.move();
    }

    @Override
    public List<String> findWinners(Car car, int MaxPosition) {
        return car.findWinner(MaxPosition);
    }
}

package racingcar.game.impl;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarPark;
import racingcar.factory.Factory;
import racingcar.game.Game;
import racingcar.vo.Car;

public class RacingGame implements Game {

    private final Factory factory;

    public RacingGame(Factory factory) {
        this.factory = factory;
    }

    public void playGame(CarPark carPark) {
        List<Car> carList = carPark.getPark();
        List<Car> newCarList = carList.stream()
                .map(factory::makeTuningCar)
                .collect(Collectors.toList());
        carPark.UpdateCarParkState(newCarList);
    }
}

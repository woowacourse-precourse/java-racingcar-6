package racingcar.game.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarPark;
import racingcar.game.Game;
import racingcar.service.RacingService;
import racingcar.vo.Car;

public class RacingGame implements Game {

    private final RacingService racingService;

    public RacingGame(RacingService racingService) {
        this.racingService = racingService;
    }

    public void playGame(CarPark carPark) {
        List<Car> carList = carPark.getPark();
        List<Car> newCarList = carList.stream()
                .filter(car -> racingService.isCanGoOneSpace())
                .map(Car::makeNewCar)
                .collect(Collectors.toList());
        carPark.UpdateCarParkState(newCarList);
    }
}

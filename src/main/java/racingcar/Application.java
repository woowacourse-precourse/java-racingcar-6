package racingcar;


import racingcar.domain.Car;
import racingcar.service.RaceService;
import racingcar.view.Input;

import java.util.List;

public class  Application {
    public static void main(String[] args) {
        String[] carNames = Input.inputCarName();
        int tryCount = Input.inputTryNumber();
        RaceService raceService = new RaceService();
        List<Car> cars = raceService.createCars(carNames);
        raceService.playGame(cars, tryCount);
        raceService.printWinners(cars);

    }
}

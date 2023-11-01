package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private final CarService carService = new CarService();
    private final RacingGameService racingGameService = new RacingGameService();

    public void racingGame(){
        RacingGame racingGame = gameInitialize();
        racingGameService.play(racingGame);
        racingGameService.printWinner(racingGame);
    }
    private RacingGame gameInitialize(){
        List<String> nameList = racingGameService.getCarNameList();
        List<Car> carList = carService.createCars(nameList);
        int playCount = racingGameService.getPlayCount();

        return racingGameService.raceSetting(carList, playCount);
    }
}

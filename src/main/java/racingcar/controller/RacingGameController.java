package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private final CarService carService = new CarService();
    private final RacingGameService racingGameService = new RacingGameService();

    public void racingGame() {
        RacingGame racingGame = gameInitialize();
        racingGameService.play(racingGame);
        racingGameService.printWinner(racingGame);
    }

    private RacingGame gameInitialize() {
        List<String> nameList = getCarNameListWithRetry();
        List<Car> carList = null;
        while (true) {
            try {
                carList = carService.createCars(nameList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                nameList = getCarNameListWithRetry();
            }
        }

        int playCount = getPlayCountWithRetry();

        return racingGameService.raceSetting(carList, playCount);
    }

    private List<String> getCarNameListWithRetry() {
        while (true) {
            try {
                return racingGameService.getCarNameList();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getPlayCountWithRetry() {
        while (true) {
            try {
                return racingGameService.getPlayCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

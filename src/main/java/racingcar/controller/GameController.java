package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarGameService;
import racingcar.utils.RandomNumberCreator;
import racingcar.view.RacingCarView;

public class GameController {

    private final CarGameService carGameService;

    public GameController(CarGameService carGameService) {
        this.carGameService = carGameService;
    }

    public void gameRun() {
        String[] carNames = RacingCarView.inputCarNames();
        int numOfCars = carNames.length;
        int gameCount = RacingCarView.inputGameCount();

        carGameService.makeAndStoreCar(carNames);
        for (int i = 0; i < gameCount; i++) {
            List<Integer> randomNumbers = RandomNumberCreator.makeRandomNumbers(numOfCars);
            List<Car> playingCars = gameStart(randomNumbers);
            if (i == 0) {
                System.out.println("\n실행 결과");
            }
            RacingCarView.outputRaceResult(playingCars);
        }

        List<Car> finalPlayingCars = carGameService.getDuplicatedCars();

        RacingCarView.outputWinners(finalPlayingCars);
    }

    private List<Car> gameStart(List<Integer> randomNumbers) {
        carGameService.updateCar(randomNumbers);
        return carGameService.getDuplicatedCars();
    }
}

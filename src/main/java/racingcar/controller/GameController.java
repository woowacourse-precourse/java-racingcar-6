package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarGameService;
import racingcar.view.CarView;

public class GameController {

    private final CarView carView;
    private final CarGameService carGameService;

    public GameController(CarView carView, CarGameService carGameService) {
        this.carView = carView;
        this.carGameService = carGameService;
    }

    public void gameRun() {
        String[] carNames = carView.inputCarNames();
        int gameCount = carView.inputGameCount();

        carGameService.makeAndStoreCar(carNames);
        for (int i = 0; i < gameCount; i++) {
            List<Car> playingCars = gameStart();
            if (i == 0) {
                System.out.println("\n실행 결과");
            }
            carView.outputRaceResult(playingCars);
        }

        List<Car> finalPlayingCars = carGameService.getDuplicatedCars();

        carView.outputWinners(finalPlayingCars);
    }

    private List<Car> gameStart() {
        List<Integer> randomNumbers = carGameService.makeRandomNumbers();
        carGameService.updateCar(randomNumbers);
        return carGameService.getDuplicatedCars();
    }
}

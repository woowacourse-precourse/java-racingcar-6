package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarStorage;
import racingcar.service.CarGameService;
import racingcar.service.RacingCarGameService;
import racingcar.utils.RandomNumberCreator;
import racingcar.view.RacingCarView;

public class GameController {

    public void gameRun() {
        List<Car> cars = makeCars();
        CarStorage storage = new CarStorage(cars);

        int gameCount = RacingCarView.inputGameCount();

        CarGameService carGameService = new RacingCarGameService(storage);

        for (int i = 0; i < gameCount; i++) {
            List<Integer> randomNumbers = RandomNumberCreator.makeRandomNumbers(cars.size());
            List<Car> playingCars = gameStart(randomNumbers, carGameService);
            if (i == 0) {
                System.out.println("\n실행 결과");
            }
            RacingCarView.outputRaceResult(playingCars);
        }

        List<Car> finalPlayingCars = carGameService.getDuplicatedCars();

        RacingCarView.outputWinners(finalPlayingCars);
    }

    private List<Car> makeCars() {
        String[] carNames = RacingCarView.inputCarNames();
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    private List<Car> gameStart(List<Integer> randomNumbers, CarGameService carGameService) {
        carGameService.updateCar(randomNumbers);
        return carGameService.getDuplicatedCars();
    }
}

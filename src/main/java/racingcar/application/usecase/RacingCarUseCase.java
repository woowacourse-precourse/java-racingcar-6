package racingcar.application.usecase;

import racingcar.port.output.RacingCarOutputPort;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceResult;
import racingcar.application.service.CarService;
import racingcar.application.service.RacingCarGameService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarUseCase {
    private final CarService carService;
    private final RacingCarGameService gameService;
    private final RacingCarView racingCarView;
    private final RacingCarOutputPort racingCarOutputPort;

    public RacingCarUseCase(
            CarService carService,
            RacingCarGameService gameService,
            RacingCarView racingCarView,
            RacingCarOutputPort racingCarOutputPort
    ) {
        this.carService = carService;
        this.gameService = gameService;
        this.racingCarView = racingCarView;
        this.racingCarOutputPort = racingCarOutputPort;
    }

    public RaceResult play() {
        List<Car> cars = createCars();
        int tryCount = getTryCount();

        playGame(cars, tryCount);

        return gameService.checkWinner(cars);
    }

    public void printWinnerMessage(RaceResult raceResult) {
        racingCarView.printWinnerMessage(raceResult);
    }

    private List<Car> createCars() {
        List<String> carNames = racingCarOutputPort.getCarNames();

        return carService.createCars(carNames);
    }

    private int getTryCount() {
        return racingCarOutputPort.getTryCount();
    }

    private void playGame(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; ++i) {
            gameService.play(cars);
            racingCarView.printResultMessage(cars);
        }
    }
}

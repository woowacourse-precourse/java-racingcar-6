package racingcar.usecase;

import racingcar.port.in.RacingCarInputPort;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceResult;
import racingcar.service.CarService;
import racingcar.service.RacingCarGameService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarUseCase {
    private final CarService carService;
    private final RacingCarGameService gameService;
    private final RacingCarView racingCarView;
    private final RacingCarInputPort racingCarInputPort;

    public RacingCarUseCase(
            CarService carService,
            RacingCarGameService gameService,
            RacingCarView racingCarView,
            RacingCarInputPort racingCarInputPort
    ) {
        this.carService = carService;
        this.gameService = gameService;
        this.racingCarView = racingCarView;
        this.racingCarInputPort = racingCarInputPort;
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
        List<String> carNames = racingCarInputPort.getCarNames();

        return carService.createCars(carNames);
    }

    private int getTryCount() {
        return racingCarInputPort.getTryCount();
    }

    private void playGame(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; ++i) {
            gameService.play(cars);
            racingCarView.printResultMessage(cars);
        }
    }
}

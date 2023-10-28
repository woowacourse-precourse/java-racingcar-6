package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarDto;
import racingcar.utils.CarToDtoConverter;
import racingcar.utils.Converter;
import racingcar.utils.StringToCarListConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = initializeRacingGame();

        play(racingGame);
        showWinners(racingGame);
    }

    private RacingGame initializeRacingGame() {
        List<Car> cars = convertToCarList(inputView.inputCarNames());
        int raceCount = inputView.inputRaceCount();

        return new RacingGame(cars, raceCount);
    }

    private List<Car> convertToCarList(String carNames) {
        Converter<String, List<Car>> converter = new StringToCarListConverter();
        return converter.convert(carNames);
    }

    private void play(RacingGame racingGame) {
        outputView.printResultMessage();

        while (canRace(racingGame)) {
            racingGame.race(new RandomNumberGenerator());

            List<CarDto> cars = toCarDto(racingGame.getCars());
            outputView.printRaceResult(cars);
        }
    }

    private boolean canRace(RacingGame racingGame) {
        return !racingGame.isGameEnd();
    }

    private List<CarDto> toCarDto(List<Car> cars) {
        Converter<List<Car>, List<CarDto>> converter = new CarToDtoConverter();
        return converter.convert(cars);
    }

    private void showWinners(RacingGame racingGame) {
        outputView.printWinners(racingGame.findWinners());
    }
}

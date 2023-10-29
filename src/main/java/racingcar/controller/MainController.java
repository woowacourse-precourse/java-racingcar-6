package racingcar.controller;

import racingcar.converter.CarToDtoConverter;
import racingcar.converter.Converter;
import racingcar.converter.StringToCarListConverter;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarDto;
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

        start(racingGame);
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

    private void start(RacingGame racingGame) {
        outputView.printResultMessage();

        race(racingGame, new RandomNumberGenerator());
    }

    private void race(RacingGame racingGame, NumberGenerator numberGenerator) {
        while (canRace(racingGame)) {
            racingGame.race(numberGenerator);

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

package racingcar.controller;


import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.GameWinnerDto;
import racingcar.domain.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCarsFromInput();
        int raceCount = getRaceCountFromInput();
        playRacingGame(cars, raceCount);
    }

    private Cars getCarsFromInput() {
        inputView.displayCarNamePrompt();
        RandomGenerator randomGenerator = new RandomGenerator();
        return new Cars(inputView.getCarNames(), randomGenerator);
    }

    private int getRaceCountFromInput() {
        inputView.displayRaceCountPrompt();
        return inputView.getRaceCount();
    }

    private void playRacingGame(Cars cars, int raceCount) {
        outputView.displayGameResult();
        IntStream.range(0, raceCount)
                .mapToObj(i -> cars.moveCarsAndCollectResults())
                .forEach(outputView::displayEachGameResult);
        displayWinners(cars);

    }

    private void displayWinners(Cars cars) {
        List<GameWinnerDto> gameWinnerDto = cars.findWinnersDto();
        outputView.displayGameWinner(gameWinnerDto);
    }
}

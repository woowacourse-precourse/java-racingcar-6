package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.utils.generator.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final GameConfig gameConfig;
    private NumberGenerator generator;
    private InputView inputView;
    private OutputView outputView;
    private Cars cars;
    private int roundNumber;

    public RacingCarGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void run() {
        setGame();
        readUserInput();
        playAllRound();
        endGame();
    }

    private void setGame() {
        generator = gameConfig.numberGenerator();
        inputView = gameConfig.inputView();
        outputView = gameConfig.outputView();
    }

    private void readUserInput() {
        cars = generateCars(readCarNamesFromUser());
        roundNumber = readGameRoundFromUser();
    }

    private String readCarNamesFromUser() {
        outputView.printRequestCarNames();
        return inputView.readCarNames();
    }

    private Cars generateCars(String names) {
        return new Cars(names);
    }

    private int readGameRoundFromUser() {
        outputView.printRequestGameRound();
        return inputView.readGameRound();
    }

    private void playAllRound() {
        outputView.printResultMessage();
        raceByRoundNumber();
        judgeWinner();
    }

    private void raceByRoundNumber() {
        for (int i = 0; i < roundNumber; i++) {
            List<Integer> numbers = generateRandomNumbers(cars.size());
            Round round = generateRound(numbers, cars);
            round.race();
            outputView.printRoundResult(round.getResult());
        }
    }

    private List<Integer> generateRandomNumbers(int size) {
        return generator.generateNumbers(size);
    }

    private Round generateRound(List<Integer> numbers, Cars cars) {
        return new Round(numbers, cars);
    }

    private void judgeWinner() {
        Winner winner = new Winner(cars);
        outputView.printGameWinner(winner.toString());
    }

    private void endGame() {
        inputView.close();
    }
}

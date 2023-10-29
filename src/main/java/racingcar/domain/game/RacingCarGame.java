package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.car.Cars;
import racingcar.utils.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final GameConfig gameConfig;
    private NumberGenerator generator;
    private InputView inputView;
    private OutputView outputView;

    public RacingCarGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        init();
    }

    public void run() {
        String names = readCarNamesFromUser();
        Cars cars = generateCars(names);
        int roundNumber = readGameRoundFromUser();
        outputView.printResultMessage();
        raceByRoundNumber(roundNumber, cars);
        judgeWinner(cars);
    }

    private void init() {
        generator = gameConfig.numberGenerator();
        inputView = gameConfig.inputView();
        outputView = gameConfig.outputView();
    }

    private String readCarNamesFromUser() {
        outputView.printRequestCarNames();
        return inputView.readCarNames();
    }

    private int readGameRoundFromUser() {
        outputView.printRequestGameRound();
        return inputView.readGameRound();
    }

    private Cars generateCars(String names) {
        return new Cars(names);
    }

    private void raceByRoundNumber(int roundNumber, Cars cars) {
        for (int i = 0; i < roundNumber; i++) {
            List<Integer> numbers = generateNumbers(cars.size());
            Round round = generateRound(numbers, cars);
            round.race();
            outputView.printRoundResult(round.getResult());
        }
    }

    private List<Integer> generateNumbers(int size) {
        return IntStream.generate(() -> generator.generate())
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
    }

    private Round generateRound(List<Integer> numbers, Cars cars) {
        return new Round(numbers, cars);
    }

    private void judgeWinner(Cars cars) {
        Winner winner = new Winner(cars);
        outputView.printGameWinner(winner.toString());
    }
}

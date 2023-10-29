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

    public void init() {
        generator = gameConfig.numberGenerator();
        inputView = gameConfig.inputView();
        outputView = gameConfig.outputView();
    }

    public void play() {
        String names = readCarNamesFromUser();
        int roundNumber = readGameRoundFromUser();
        Cars cars = generateCars(names);

        for (int i = 0; i < roundNumber; i++) {
            List<Integer> numbers = generateNumbers(cars.size());
            generateRound(numbers, cars);
        }
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

    private List<Integer> generateNumbers(int size) {
        return IntStream.generate(() -> generator.generate())
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
    }

    private void generateRound(List<Integer> numbers, Cars cars) {
        Round round = new Round(numbers, cars);
    }
}

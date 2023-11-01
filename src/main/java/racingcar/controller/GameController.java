package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> InitializeCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName))
                .toList();
    }

    public void runGame() {
        List<String> carNames =inputView.inputCarNames();
        int trialNumber = inputView.inputTrialNumber();
        Game game = new Game(carNames);

        outputView.printResultPhrase();
        playMultipleTimes(game, trialNumber);
        outputView.printWinner(game.pickWinner());
    }

    private void playMultipleTimes(Game game, int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            game.playOnce(randomNumberGenerator);
            outputView.printGameProgress(game);
            outputView.wrapLine();
        }
    }
}

package racingcar.view;

import racingcar.model.RacingGame;
import racingcar.utils.RandomGenerator;

public class OutputView {
    private final InputView inputView;
    private final RandomGenerator randomGenerator;

    private static final String RACING_RESULT = "실행 결과";

    public OutputView(InputView inputView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
    }

    public void start() {
        String carNames = inputView.getCarNames();
        int tryNumber = inputView.getTryNumber();
        RacingGame racingGame = RacingGame.of(carNames, tryNumber);
        run(racingGame);

    }

    private void run(RacingGame racingGame) {
        inputView.print(RACING_RESULT);
        while (!racingGame.isEnd()) {
            racingGame = racingGame.race(randomGenerator);
            inputView.print(racingGame.ongoingCar());
            inputView.println();
        }
        inputView.printWinner(racingGame.winners());
    }
}

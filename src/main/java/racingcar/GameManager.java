package racingcar;

import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

import java.util.List;

import static racingcar.constant.NumberConstant.*;

public class GameManager {

    private static int END_ATTEMPT_COUNT;

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void startGame() {
        List<RacingCar> racingCars = prepareGame();
        playGame(racingCars);
        endGame(racingCars);
    }

    private List<RacingCar> prepareGame() {
        messagePrinter.printCarNameInputMessage();
        String[] carNames = messageReceiver.receiveCarNames();
        List<RacingCar> racingCars = RacingCar.createRacingCars(carNames);
        messagePrinter.printAttemptCountInputMessage();
        END_ATTEMPT_COUNT = messageReceiver.receiveAttemptCount();

        return racingCars;
    }

    private void playGame(final List<RacingCar> racingCars) {
        messagePrinter.printExecutionResultMessage();

        for (int i = START_ATTEMPT_COUNT; i < END_ATTEMPT_COUNT; i++) {
            racingCars.forEach(RacingCar::move);
            messagePrinter.printExecutionResult(racingCars);
        }
    }

    private void endGame(final List<RacingCar> racingCars) {
        messagePrinter.printWinnerMessage();
        List<RacingCar> winners = RacingCar.findWinners(racingCars);
        messagePrinter.printWinners(winners);
    }
}

package racingcar;

import racingcar.domain.RacingCarRace;
import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

import java.util.List;

import static racingcar.constant.NumberConstant.*;

public class GameManager {

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void startGame() {
        RacingCarRace racingCarRace = prepareGame();
        playGame(racingCarRace);
        endGame(racingCarRace);
    }

    private RacingCarRace prepareGame() {
        messagePrinter.printCarNameInputMessage();
        List<String> carNames = messageReceiver.receiveCarNames();
        messagePrinter.printAttemptCountInputMessage();
        int attemptCount = messageReceiver.receiveAttemptCount();

        return RacingCarRace.createRacingCarRace(carNames, attemptCount);
    }

    private void playGame(final RacingCarRace racingCarRace) {
        messagePrinter.printExecutionResultMessage();
        int endAttemptCount = racingCarRace.getAttemptCount();

        for (int i = START_ATTEMPT_COUNT; i < endAttemptCount; i++) {
            racingCarRace.runRace();
            messagePrinter.printExecutionResult(racingCarRace);
        }
    }

    private void endGame(final RacingCarRace racingCarRace) {
        messagePrinter.printWinnerMessage();
        messagePrinter.printWinners(racingCarRace);
    }
}

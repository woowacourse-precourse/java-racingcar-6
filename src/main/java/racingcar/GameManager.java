package racingcar;

import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

import java.util.List;

public class GameManager {

    private static int attemptCount;

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void startGame() {
        List<RacingCar> racingCars = prepareGame();
        playGame(racingCars);
    }

    private List<RacingCar> prepareGame() {
        messagePrinter.printCarNameInputMessage();
        String[] carNames = messageReceiver.receiveCarNames();
        List<RacingCar> racingCars = RacingCar.createRacingCars(carNames);
        messagePrinter.printAttemptCountInputMessage();
        attemptCount = messageReceiver.receiveAttemptCount();

        return racingCars;
    }

    private void playGame(final List<RacingCar> racingCars) {
        messagePrinter.printExecutionResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            racingCars.forEach(RacingCar::move);
            messagePrinter.printExecutionResult(racingCars);
        }
    }
}

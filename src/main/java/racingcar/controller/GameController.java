package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        List<Car> cars = receiveCars();
        Attempt attempt = receiveAttempt();

        Game game = new Game(cars);
        List<List<CarDistanceMessage>> carDistanceMessages = simulate(attempt, game);

        sendCarDistanceMessages(carDistanceMessages);
        sendWinners(game);

    }

    private List<Car> receiveCars() {
        outputView.printGetCarNamesMessage();
        return inputView.getCars();
    }

    private Attempt receiveAttempt() {
        outputView.printGetAttemptMessage();
        return inputView.getAttempt();
    }

    private List<List<CarDistanceMessage>> simulate(Attempt attempt, Game game) {
        List<List<CarDistanceMessage>> carDistanceMessages = new ArrayList<>();
        while (attempt.isExist()) {
            attempt.decrease();
            carDistanceMessages.add(game.simulate());
        }
        return carDistanceMessages;
    }

    private void sendCarDistanceMessages(List<List<CarDistanceMessage>> results) {
        outputView.printResultMessage();
        for (List<CarDistanceMessage> messages : results) {
            outputView.printCarDistanceMessages(messages);
        }
    }

    private void sendWinners(Game game) {
        WinnersMessage winnersMessage = game.getWinnersMessage();
        outputView.printWinnersMessage(winnersMessage);
    }

}

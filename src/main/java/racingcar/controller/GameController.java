package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        simulate(attempt, game);

        sendResult(game);

    }

    private List<Car> receiveCars() {
        outputView.printGetCarNamesMessage();
        return inputView.getCars();
    }

    private Attempt receiveAttempt() {
        outputView.printGetAttemptMessage();
        return inputView.getAttempt();
    }

    private void simulate(Attempt attempt, Game game) {
        outputView.printResultMessage();
        while (attempt.isExist()) {
            attempt.decrease();
            List<CarDistanceMessage> carDistanceMessages = game.forwardCars();
            outputView.printCarDistanceMessages(carDistanceMessages);
        }
    }

    private void sendResult(Game game) {
        WinnersMessage winnersMessage = game.getWinnersMessage();
        outputView.printWinnersMessage(winnersMessage);
    }

}

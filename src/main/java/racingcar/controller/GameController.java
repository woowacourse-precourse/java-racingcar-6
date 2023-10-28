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

        List<Car> cars = getCars();
        Attempt attempt = getAttempt();

        Game game = new Game(cars);
        simulate(attempt, game);

        printResult(game);

    }

    private List<Car> getCars() {
        outputView.printGetCarNamesMessage();
        return inputView.getCars();
    }

    private Attempt getAttempt() {
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

    private void printResult(Game game) {
        WinnersMessage winnersMessage = game.getWinnersMessage();
        outputView.printWinnersMessage(winnersMessage);
    }

}

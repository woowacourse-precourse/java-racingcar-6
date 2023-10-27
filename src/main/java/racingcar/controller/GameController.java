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

        outputView.printGetCarNamesMessage();
        List<Car> cars = inputView.getCars();

        outputView.printGetAttemptMessage();
        Attempt attempt = inputView.getAttempt();

        Game game = new Game(cars);

        outputView.printResultMessage();
        while (attempt.isExist()) {
            attempt.decrease();
            List<CarDistanceMessage> carDistanceMessages = game.forwardCars();
            outputView.printCarDistanceMessages(carDistanceMessages);
        }

        WinnersMessage winnersMessage = game.getWinnersMessage();
        outputView.printWinnersMessage(winnersMessage);

    }

}
